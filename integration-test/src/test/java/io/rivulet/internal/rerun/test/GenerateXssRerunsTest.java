package io.rivulet.internal.rerun.test;

import io.rivulet.internal.fuzz.generator.XssGenerator;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static io.rivulet.internal.fuzz.generator.XssGenerator.EVENT_HANDLER_ATTRIBUTES;

@RunWith(Parameterized.class)
public class GenerateXssRerunsTest extends GenerateRerunsBaseTest {


    public GenerateXssRerunsTest(String template, String originalValue, Boolean canSanitizeAngleBrackets, Boolean canHtmlEscape, Boolean canSanitizeQuotes) {
        super(new XssGenerator(), template, originalValue, makeSanitizersList(originalValue, canSanitizeAngleBrackets, canHtmlEscape, canSanitizeQuotes));
    }

    /* Returns a list of sanitizer that should be used based of the specified preferences. */
    private static Sanitizer[] makeSanitizersList(String originalValue, Boolean canSanitizeAngleBrackets, Boolean canHtmlEscape,
                                                  Boolean canSanitizeQuotes) {
        List<Sanitizer> sanitizers = new LinkedList<>(Arrays.asList(
                input -> input.replaceAll("<script>", ""), // Bad script tag replacement featured in Juliet benchmarks
                input -> input.replaceAll("[=|,]", ""), // No equals or comma - tomcat cookies
                input -> Arrays.asList(EVENT_HANDLER_ATTRIBUTES).contains(input) ? "" : input, // No event handler attribute names
                input -> input.toLowerCase().contains("script") ? "" : input // No usages of script
        ));
        if(canHtmlEscape) {
            sanitizers.add(StringEscapeUtils::escapeHtml4); // HTML escape
        }
        if(canSanitizeAngleBrackets) {
            sanitizers.add(input -> input.replaceAll("[<>]", "")); // Remove angle brackets
        }
        if(canSanitizeQuotes) {
            sanitizers.add(input -> input.replaceAll("[\"'`]", "")); // No quoting
        }
        // Remove any sanitizers that would not have let the original value through
        Iterator<Sanitizer> it = sanitizers.iterator();
        while(it.hasNext()) {
            Sanitizer sanitizer = it.next();
            if(!originalValue.equals(sanitizer.sanitize(originalValue))) {
                it.remove();
            }
        }
        return sanitizers.toArray(new Sanitizer[0]);
    }

    /* HTML entity escapes every character in the specified string. */
    private static String htmlEscape(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        for(int i = 0; i < s.length(); i++) {
            builder.append("&#");
            builder.append(String.format("%d;", (int)s.charAt(i)));
        }
        return builder.toString();
    }

    /* HTML entity escapes the specified string except for any '%s's that appear in it. */
    private static String htmlEscapeTemplate(String template) {
        String[] parts = template.split("%s");
        for(int i = 0; i < parts.length; i++) {
            parts[i] =  htmlEscape(parts[i]);
        }
        return String.join("%s", parts);
    }

    private static String createImgTemplateEscapedSrc(String attributeValue) {
        return String.format("<body><img src=%s></body>", htmlEscapeTemplate(attributeValue));
    }

    @Parameterized.Parameters
    public static Collection html() {
        return Arrays.asList(new Object[][] {
                /* Tainted content */
                {"<body><!-- %s --></body>", "hello", false, false, true, true}, // Tainted element in an html comment
                {"<body>%s</body>", "hello", false, false, true, true}, // Tainted element in body's content
                {"<textarea>%s</textarea>", "hello", false, false, true, true}, // Tainted element in a text area's content
                {"<textarea><!-- %s --></textarea>", "hello", false, false, true, true}, // Tainted element in comment text in a text area's content
                {"<title>%s</title>", "hello", false, false, true, true}, // Tainted element in a title's content
                {"<title><!-- %s --></title>", "hello", false, false, true, true}, // Tainted element in a titles's comment
                {"<style>%s</style>", "hello", false, false, true, true}, // Tainted element in a style's content
                {"<style><!-- %s --></style>", "hello", false, false, true, true}, // Tainted element in a style's comment
                {"<body><frameset>%s <frame src=frame1.htm></frameset></body>", "<frame src=frame2.htm>", false, false, true, true}, // Tainted element in a frameset's content
                {"<body><frameset><!-- %s --><frame src=frame1.htm></frameset></body>", "hello", false, false, true, true}, // Tainted element in a frameset's comment
                /* Tainted script content */
                {"<body><script>var x = %s</script></body>", "hello", true, false, true, true}, // Tainted element in a script's content unquoted
                {"<body><script>var x = '%s';</script></body>", "hello", true, false, true, true}, // Tainted element in a script's content single quoted
                {"<body><script>var x = \"%s\";</script></body>", "hello", true, false, true, true}, // Tainted element in a script's content double quoted
                {"<body><script>var x = `%s`;</script></body>", "hello", true, false, true, true}, // Tainted element in a script's content backtick quoted
                {"<body><script>var x = 2; // %s</script></body>", "hello", true, false, true, true}, // Tainted element in a script's content single line commented
                {"<body><script>var x = 2; /* %s */</script></body>", "hello", true, false, true, true},// Tainted element in a script's content multiline commented
                /* Tainted tag names */
                {"<body><%s>text</p></body>", "p", true, true, true}, // Tainted tag name
                {"<body><%s></body>", "img", true, true, true}, // Tainted img tag name no attributes
                {"<body><%s src='sample.jpg'></body>", "img", true, true, true}, // Tainted img tag name src attribute
                {"<body><%s>alert('not-tainted');</script></body>", "script", true, true, true},  // Tainted script tag name no attributes
                {"<body><%s src='sample.js'></script></body>", "script", true, true, true}, // Tainted script tag src attribute
                {"<body><%s></object></body>", "object", true, true, true},  // Tainted object tag no attributes
                {"<body><%s data='helloworld.swf'></object></body>", "object", true, true, true}, // Tainted object tag data attribute
                /* Tainted attribute keys */
                {"<body><div %s=example>TEXT</div></body>", "id", true, true, true}, // Tainted non-targeted attribute key
                {"<body><img %s=sample.jpg></body>", "src", true, true, true}, // Tainted img src key
                {"<body><script %s=sample.js></script>", "src", true, true, true}, // Tainted script src key
                {"<body><object %s=sample.js></object", "data", true, true, true}, // Tainted object data key
                {"<body><div %s='var x = 5;'>TEXT</div></body>", "onclick", true, true, true}, // Tainted event handler key
                /* Tainted non-vulnerable attribute values */
                {"<body><div id=%s>TEXT</div></body>", "hello", true, true, true}, // Tainted non-targeted entire attribute value unquoted
                {"<body><div id='%s'>TEXT</div></body>", "hello", true, false, false}, // Tainted non-targeted entire attribute value single quoted
                {"<body><div id=\"%s\">TEXT</div></body>", "hello", true, false, false}, // Tainted non-targeted entire attribute value double quoted
                {"<body><div id=%sworld>TEXT</div></body>", "hello", true, true, true}, // Tainted non-targeted start of attribute value unquoted
                {"<body><div id='%s world'>TEXT</div></body>", "hello", true, false, false}, // Tainted non-targeted start of attribute value single quoted
                {"<body><div id=\"%s world\">TEXT</div></body>", "hello", true, false, false}, // Tainted non-targeted start of attribute value double quoted
                {"<body><div id=hi%s>TEXT</div></body>", "hello", true, true, true}, // Tainted non-targeted end of attribute value unquoted
                {"<body><div id='hi %s'>TEXT</div></body>", "hello", true, false, false}, // Tainted non-targeted end of attribute value single quoted
                {"<body><div id=\"hi %s\">TEXT</div></body>", "hello", true, false, false}, // Tainted non-targeted end of attribute value double quoted
                /* Tainted attribute value vulnerable to script injection after javascript: or vbscript: */
                {"<body><img src=%s></body>", "sample.jpg", true, true, true}, // Tainted img src entire attribute value
                {"<body><img src=%s.test></body>", "sample.jpg", true, true, true},// Tainted img src start of attribute value unquoted
                {"<body><img src='%s.test'></body>", "sample.jpg", true, true, true},// Tainted img src start of attribute value single quoted
                {"<body><img src=\"%s.test\"></body>", "sample.jpg", true, true, true},// Tainted img src start of attribute value double quoted
                {"<body><img src='javascript:var x = %s;'></body>", "2", true, true, true}, // Tainted img src after javascript: unquoted and uncommented
                {"<body><img src='javascript:var x = 2; --%s'></body>", "hello", true, true, true}, // Tainted img src after javascript: single line commented
                {"<body><img src='javascript:var x = 2; /* %s */ var y = 7;'></body>", "hello", true, true, true}, // Tainted img src after javascript: multiline commented
                {"<body><img src=\"javascript:var x = '%s';\"></body>", "2", true, true, true}, // Tainted img src after javascript: single quoted
                {"<body><img src='javascript:var x = \"%s\";'></body>", "2", true, true, true}, // Tainted img src after javascript: double quoted
                {"<body><img src='javascript:var x = `%s`;'></body>", "2", true, true, true}, // Tainted img src after javascript: backtick quoted
                {"<body><img src='vbscript:%s'></body>", "dim var1", true, true, true}, // Tainted img src after vbscript: unquoted and uncommented
                {"<body><img src=\"vbscript: dim var1 ' %s \n var1 = 2\"></body>", "hello", true, true, true},// Tainted img src after vbscript: ' commented
                {"<body><img src='vbscript:msgbox(\"text\") REM %s \n msgbox(\"text\")'></body>", "hello", true, true, true},// Tainted img src after vbscript: REM commented
                {"<body><img src='vbscript:msgbox(\"%s\")'></body>", "hello", true, true, true}, // Tainted img src after vbscript: double quoted
                /* Tainted attribute value vulnerable to script injection after HTML encoded javascript: or vbscript: */
                {createImgTemplateEscapedSrc("javascript:var x = %s;"), htmlEscape("1"), true, true, true}, // Tainted img src after javascript: unquoted and uncommented, html escaped
                {createImgTemplateEscapedSrc("javascript:var x = '%s';"), "hello", true, true, true}, // Tainted img src after javascript: single quoted, html escaped
                {createImgTemplateEscapedSrc("javascript:var x = \"%s\";"), "hello", true, true, true}, // Tainted img src after javascript: double quoted, html escaped
                {createImgTemplateEscapedSrc("javascript:var x = `%s`;"), "hello", true, true, true}, // Tainted img src after javascript: backtick quoted, html escaped
                /* Tainted attribute value vulnerable to url injection */
                {"<body><script src=%s></script></body>", "sample.js", true, true, true}, // Tainted script src entire attribute value
                {"<body><script src=%s.test></script></body>", "sample.js", true, true, true}, // Tainted script src start of attribute value unquoted
                {"<body><script src='%s.test'></script></body>", "sample.js", true, false, false}, // Tainted script src start of attribute value single quoted
                {"<body><script src=\"%s.test\"></script></body>", "sample.js", true, false, false}, // Tainted script src start of attribute value double quoted
                /* Tainted event handler attribute value */
                {"<div onclick='%s'>TEXT</div>", "var x = 7;", true, true, true}, // Tainted event handler entire attribute value
                {"<div onclick='var x = %s; var y = 11;'>TEXT</div>", "7", true, true, true}, // Tainted event handler unquoted and uncommented
                {"<div onclick='var x = 22; // %s \n var y = 11;'>TEXT</div>", "hello", true, true, true}, // Tainted event handler single line commented
                {"<div onclick='var x = 22; /* %s */ var y = 11;'>TEXT</div>", "hello", true, true, true}, // Tainted event handler multiline commented
                {"<div onclick=\"var x = '%s'; var y = 11;\">TEXT</div>", "hello", true, true, true}, // Tainted event handler single quoted
                {"<div onclick='var x = \"%s\"; var y = 11;'>TEXT</div>", "hello", true, true, true}, // Tainted event handler double quoted
                {"<div onclick='var x = `%s`; var y = 11;'>TEXT</div>", "hello", true, true, true}, // Tainted event handler backtick quoted
                /* Tainted event handler attribute value with named character references */
                {"<div onclick='var x = 22; &sol;&sol; %s &NewLine; var y = 11;'>TEXT</div>", "hello", true, true, true}, // Tainted event handler named character references single line commented
                {"<div onclick='var x = 22; &sol;&ast; %s &ast;&sol; var y = 11;'>TEXT</div>", "hello", true, true, true}, // Tainted event handler named character references multiline commented
                {"<div onclick=\"var x = &apos;%s&apos;; var y = 11;\">TEXT</div>", "hello", true, true, true}, // Tainted event handler named character references single quoted
                {"<div onclick='var x = &quot;%s&quot;; var y = 11;'>TEXT</div>", "hello", true, true, true}, // Tainted event handler named character references double quoted
                {"<div onclick='var x = &grave;%s&grave;; var y = 11;'>TEXT</div>", "hello", true, true, true}, // Tainted event handler named character references backtick quoted
                /* Tainted event handler attribute value with decimal character references */
                {"<div onclick='var x = 22; &#47&#47 %s &#10 var y = 11;'>TEXT</div>", "hello", true, true, true}, // Tainted event handler decimal character references single line commented
                {"<div onclick='var x = 22; &#47&#42 %s &#42&#47 var y = 11;'>TEXT</div>", "hello", true, true, true}, // Tainted event handler decimal character references multiline commented
                {"<div onclick=\"var x = &#39%s&#39; var y = 11;\">TEXT</div>", "hello", true, true, true}, // Tainted event handler decimal character references single quoted
                {"<div onclick='var x = &#34%s&#34; var y = 11;'>TEXT</div>", "hello", true, true, true}, // Tainted event handler decimal character references double quoted
                {"<div onclick='var x = &#96%s&#96; var y = 11;'>TEXT</div>", "hello", true, true, true}, // Tainted event handler decimal character references backtick quoted
                /* Tainted event handler attribute value with hex character references */
                {"<div onclick='var x = 22; &#x0002F;&#x0002F; %s &#x0000A; var y = 11;'>TEXT</div>", "hello", true, true, true}, // Tainted event handler hex character references single line commented
                {"<div onclick='var x = 22; &#x0002F;&#x0002A; %s &#x0002A;&#x0002F; var y = 11;'>TEXT</div>", "hello", true, true, true}, // Tainted event handler hex character references multiline commented
                {"<div onclick=\"var x = &#x00027%s&#x00027; var y = 11;\">TEXT</div>", "hello", true, true, true}, // Tainted event handler hex character references single quoted
                {"<div onclick='var x = &#x00022;%s&#x00022; var y = 11;'>TEXT</div>", "hello", true, true, true}, // Tainted event handler hex character references double quoted
                {"<div onclick='var x = &#x00060;%s&#x00060; var y = 11;'>TEXT</div>", "hello", true, true, true}// Tainted event handler hex character references backtick quoted
        });
    }
}
