package io.rivulet.internal.test;

import edu.columbia.cs.psl.phosphor.runtime.MultiTainter;
import edu.columbia.cs.psl.phosphor.runtime.Taint;
import io.rivulet.internal.Violation;
import io.rivulet.internal.fuzz.generator.XssGenerator;
import io.rivulet.internal.rerun.test.ViolationTestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckHtmlStringTest {

    // Cross-site scripting generator used to check Strings for critical violations.
    private static final XssGenerator generator = new XssGenerator();

    /* Passes the specified String to the XssGenerator and checks that the generator determines that the String demonstrates
     * a critical violation only if critical is true. */
    private void testHtml(String html, boolean critical) {
        // Have the XSS generator check the String
        Violation violation =  new Violation(ViolationTestUtils.SAMPLE_BASE_SOURCE1, ViolationTestUtils.SAMPLE_BASE_SOURCE1);
        generator.checkTaint(html, 0, violation);
        // Check if a critical violation would have been reported
        assertEquals(critical, !violation.getTaintedValues().isEmpty());
    }

    /* Checks that a critical violation is reported for "script" tags with a tainted "src" attribute that is malicious. */
    @Test
    public void testUntrustedSrcScriptTags() {
        String payload = XssGenerator.MALICIOUS_URL;
        MultiTainter.taintedObject(payload, new Taint<>(ViolationTestUtils.SAMPLE_LABEL1));
        testHtml(String.format("<script src=%s></script>", payload), true);
    }

    /* Checks that a critical violation is not reported for "script" tags with a tainted "src" attribute that is not
     * necessarily malicious. */
    @Test
    public void testPotentiallyTrustedSrcScriptTags() {
        String payload = "http://www.sample.com/trusted.js";
        MultiTainter.taintedObject(payload, new Taint<>(ViolationTestUtils.SAMPLE_LABEL1));
        testHtml(String.format("<script src=%s></script>", payload), false);
    }

    /* Checks that a critical violation is not reported for "script" tags with an escaped, quoted tainted string in its
     * content. */
    @Test
    public void testQuotedEscapedScriptContent() {
        String payload = "alert";
        MultiTainter.taintedObject(payload, new Taint<>(ViolationTestUtils.SAMPLE_LABEL1));
        testHtml(String.format("<script>alert('\"\"``%s\"')</script>", payload), false);
    }

    /* Checks that escaped quotes in a "script" tag's content do not end the quoted portion of the content. */
    @Test
    public void testEscapedQuotationInQuotedScriptContent() {
        String payload = "alert";
        MultiTainter.taintedObject(payload, new Taint<>(ViolationTestUtils.SAMPLE_LABEL1));
        testHtml(String.format("<script>alert('Hello, I\\'m %s')</script>", payload), false);
    }

    /* Checks that a critical violation is reported for "script" tags with an unquoted tainted string in its content. */
    @Test
    public void testUnquotedScriptContent() {
        String payload = "alert('XSS')";
        MultiTainter.taintedObject(payload, new Taint<>(ViolationTestUtils.SAMPLE_LABEL1));
        testHtml(String.format("<script>%s</script>", payload), true);
    }


    /* Checks that a critical violation is reported for an "img" tag with a "src" attribute with tainted javascript value. */
    @Test
    public void testSrcTaintedJavascript() {
        String payload = "javascript:alert('XSS')";
        MultiTainter.taintedObject(payload, new Taint<>(ViolationTestUtils.SAMPLE_LABEL1));
        testHtml(String.format("<img src=%s>", payload), true);
    }

    /* Checks that a critical violation is not reported for an "img" tag with a "src" attribute with invalid tainted
     * attribute value. */
    @Test
    public void testSrcTaintedJavascriptBackticks() {
        String payload = "`javascript:alert(\"XSS\")`";
        MultiTainter.taintedObject(payload, new Taint<>(ViolationTestUtils.SAMPLE_LABEL1));
        testHtml(String.format("<img src =   %s>", payload), false);
    }

    /* Checks that a critical violation is reported for an "img" tag with a "src" attribute with tainted javascript value
     * inside single quotes. */
    @Test
    public void testSrcTaintedJavascriptSingleQuotes() {
        String payload = "'javascript:alert(\"XSS\")'";
        MultiTainter.taintedObject(payload, new Taint<>(ViolationTestUtils.SAMPLE_LABEL1));
        testHtml(String.format("<img src=%s>", payload), true);
    }

    /* Checks that a critical violation is reported for an "img" tag with a "src" attribute with tainted javascript value
     * inside double quotes. */
    @Test
    public void testSrcTaintedJavascriptDoubleQuotes() {
        String payload = "\"javascript:alert('XSS')\"";
        MultiTainter.taintedObject(payload, new Taint<>(ViolationTestUtils.SAMPLE_LABEL1));
        testHtml(String.format("<img src=%s>", payload), true);
    }

    /* Checks that a critical violation is not reported for an "img" tag with a "src" attribute with a tainted, potentially
     * trusted url value. */
    @Test
    public void testSrcTaintedPotentiallyTrustedURL() {
        String payload = "http://www.sample.com/trusted.js";
        MultiTainter.taintedObject(payload, new Taint<>(ViolationTestUtils.SAMPLE_LABEL1));
        testHtml(String.format("<IMG SRC=%s>", payload), false);
    }
}