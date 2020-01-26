package io.rivulet.internal.test;

import edu.columbia.cs.psl.phosphor.runtime.Taint;
import edu.columbia.cs.psl.phosphor.runtime.TaintSourceWrapper;
import io.rivulet.internal.IndexedSourceInfoTaintLabel;
import io.rivulet.internal.InvocationRanges;
import io.rivulet.internal.ParseUtils;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class ParseUtilsTest {

    /* Returns the InvocationsRanges for the labels of each char in the specified String. */
    private InvocationRanges[] getRangesForEachChar(String s) {
        @SuppressWarnings("unchecked")
        Taint<IndexedSourceInfoTaintLabel>[] tags = TaintSourceWrapper.getStringValueTaints(s);
        InvocationRanges[] ranges = new InvocationRanges[s.length()];
        if(tags != null) {
            for(int i = 0; i < ranges.length; i++) {
                if(tags[i] != null && !tags[i].isEmpty()) {
                    ranges[i] = new InvocationRanges(ParseUtils.DUMMY_INVOCATION_ID);
                    for(IndexedSourceInfoTaintLabel label : tags[i].getLabels(new IndexedSourceInfoTaintLabel[0])) {
                        ranges[i].merge(label.getIndexInfoCopy());
                    }
                }
            }
        }
        return ranges;
    }

    /* Checks that the tags from ascii percent-encoded characters are propagated to their decoded values when a URL
     * is decoded. */
    @Test
    public void testDecodePercentEncodedAsciiUrlEnsuringTags() {
        String encoded = ParseUtils.taintCharsWithPosition("name=George%20Washington%20&value=%20%20number%20%20%201" +
                "%20");
        String decoded = ParseUtils.decodeUrlEnsuringTags(encoded);
        InvocationRanges[] ranges = getRangesForEachChar(decoded);
        int start = 0;
        for(int i = 0; i < decoded.length(); i++) {
            if(decoded.charAt(i) == ' ') {
                assertEquals(new InvocationRanges(ParseUtils.DUMMY_INVOCATION_ID, new int[]{start, start+=3}), ranges[i]);
            } else {
                assertEquals(new InvocationRanges(ParseUtils.DUMMY_INVOCATION_ID, new int[]{start, start+=1}), ranges[i]);
            }
        }
    }

    /* Checks that the tags from non-ascii percent-encoded characters are propagated to their decoded values when a URL
     * is decoded. */
    @Test
    public void testDecodePercentEncodedNonAsciiUrlEnsuringTags() {
        String encoded = ParseUtils.taintCharsWithPosition("name=G%CB%9C%E2%80%A2eorge%E2%80%A2%20%E2%80%A2Washin%CB" +
                "%9Cgton%20%E2%80%A2&value=%20%20number%20%20%20%CB%9C1%CB%9C%20");
        String decoded = ParseUtils.decodeUrlEnsuringTags(encoded);
        InvocationRanges[] ranges = getRangesForEachChar(decoded);
        int start = 0;
        for(int i = 0; i < decoded.length(); i++) {
            int width;
            switch(decoded.charAt(i)) {
                case '\u2022':
                    width = 9;
                    break;
                case '\u02dc':
                    width = 6;
                    break;
                case ' ':
                    width = 3;
                    break;
                default:
                    width = 1;
            }
            assertEquals(new InvocationRanges(ParseUtils.DUMMY_INVOCATION_ID, new int[]{start, start+=width}), ranges[i]);
        }
    }

    /* Checks that the tags from spaces encoded as '+'s are propagated to their decoded values when a URL is decoded. */
    @Test
    public void testDecodePlusUrlEnsuringTags() {
        String encoded = ParseUtils.taintCharsWithPosition("name=George+Washington&value=+number+++1+");
        String decoded = ParseUtils.decodeUrlEnsuringTags(encoded);
        // Assert that each char in the decoded String contains only the label with index information matching its index
        // in the decoded String */
        InvocationRanges[] ranges = getRangesForEachChar(decoded);
        for(int i = 0; i < decoded.length(); i++) {
            assertEquals(new InvocationRanges(ParseUtils.DUMMY_INVOCATION_ID, i), ranges[i]);
        }
    }

    /* Checks that attributes of an HTML tag with attribute values containing angle brackets are parsed correctly. */
    @Test
    public void testParseAttributesWithAngleBrackets() {
        String htmlFragment = "<div class=\"top-div\" id=\"div<1>\" style=\"color:green\" title='<My Div>'>" +
                "<h1 id=\"header<1>\">'TEXT' and \"TEXT\"</h1>" +
                "<p>TEXT</p>" +
                "</div>" +
                "</body>" +
                "</html>";
        List<String[]> attributes = ParseUtils.parseAttributesFromStartOfHtmlOpeningTag(htmlFragment);
        String[][] expectedAttributes = new String[][] {
                new String[]{"class", "\"top-div\""},
                new String[]{"id","\"div<1>\"" },
                new String[]{"style", "\"color:green\""},
                new String[]{"title", "'<My Div>'"}
        };
        assertArrayEquals(expectedAttributes, attributes.toArray(new String[0][0]));
    }

    /* Checks that attributes of an HTML tag with an unquoted attribute value are parsed correctly. */
    @Test
    public void testParseAttributeUnquotedValue() {
        String htmlFragment = "<div onclick=" +
                "&#0000097&#0000108&#0000101&#0000114&#0000116&#0000040&#0000039&#0000088&#0000083&#0000083&#0000039&#0000041>" +
                "hello</div><script>\";</script></body>";

                List<String[]> attributes = ParseUtils.parseAttributesFromStartOfHtmlOpeningTag(htmlFragment);
        String[][] expectedAttributes = new String[][] {
                new String[]{"onclick", "&#0000097&#0000108&#0000101&#0000114&#0000116&#0000040&#0000039&#0000088" +
                        "&#0000083&#0000083&#0000039&#0000041"}
        };
        assertArrayEquals(expectedAttributes, attributes.toArray(new String[0][0]));
    }
}
