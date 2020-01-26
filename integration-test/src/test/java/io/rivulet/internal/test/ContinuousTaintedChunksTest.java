package io.rivulet.internal.test;

import edu.columbia.cs.psl.phosphor.runtime.Taint;
import edu.columbia.cs.psl.phosphor.runtime.TaintSourceWrapper;
import edu.columbia.cs.psl.phosphor.struct.SinglyLinkedList;
import io.rivulet.PhosphorHttpRequestSource;
import io.rivulet.internal.*;
import io.rivulet.internal.rerun.test.ViolationTestUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertArrayEquals;

public class ContinuousTaintedChunksTest {

    // The invocation number of the labels being examined
    private static final int TARGET_INVOCATION_ID = 0;
    // Used to taint Strings
    private TaintSourceWrapper autoTainter;
    @Rule
    public final ExternalResource autoTainterResource = new ExternalResource() {
        @Override
        protected void before() {
            autoTainter = new RivuletAutoTaintWrapper();
        }
    };

    /* Taints the specified String and its characters. */
    private String taintString(String s) {
        return (String) autoTainter.autoTaint(s, ViolationTestUtils.SAMPLE_BASE_SOURCE1,
                ViolationTestUtils.SAMPLE_BASE_SOURCE1, 0);
    }

    /* Taints the specified String and its characters with a label for the specified source. */
    private String taintString(String s, PhosphorHttpRequestSource source) {
        return (String) autoTainter.autoTaint(s, source.getSignature(),
                source.getSignature(), 0);
    }

    /* Converts all instances of the specified source String in the specified String s to the target String. Sets the
     * taint tag/s for the replaced section after replacement to be the combined tags of the replaced portion before
     * replacement that match up with the specified offsets into the replacement. */
    @SuppressWarnings("unchecked")
    private static String convertWithPartialTags(String s, String source, String target, int...offsets) {
        TaintedStringBuilder builder = new TaintedStringBuilder();
        while(s.contains(source)) {
            int i = s.indexOf(source);
            if(i != 0) {
                builder.append(s.substring(0, i));
            }
            Taint[] taints = TaintSourceWrapper.getStringValueTaints(s.substring(i, i+source.length()));
            Taint merged = new Taint<>();
            if(taints != null) {
                for(int offset : offsets) {
                    merged.addDependency(taints[offset]);
                }
            }
            builder.append(TaintedStringBuilder.taintChars(new String(target), merged));
            s = s.substring(i+source.length());
        }
        builder.append(s);
        return builder.toString();
    }

    /* Returns the merges labels of taint tags on the specified chunks. */
    private static HashSet<ProcessedSourceInfoTaintLabel> getProcessLabels(SinglyLinkedList<TaintedSinkValueImpl> chunks) {
        Violation violation = ViolationTestUtils.sampleViolation1.copyWithTaintedValues(Arrays.asList(chunks.toArray(new TaintedSinkValueImpl[0])));
        violation = TaintedSinkValueSet.processViolation(violation);
        HashSet<ProcessedSourceInfoTaintLabel> labels = new HashSet<>();
        for(TaintedSinkValue sinkVal : violation.getTaintedValues()) {
            for(SourceInfoTaintLabel label : sinkVal.getTaintSources()) {
                if(label instanceof ProcessedSourceInfoTaintLabel) {
                    labels.add((ProcessedSourceInfoTaintLabel) label);
                }
            }
        }
        return labels;
    }

    /* Checks that the process tainted chunks for the specified String come for one source and cover the specified ranges
     * in that source.*/
    private static void checkProcessedRange(String s, int[] expectedRanges) {
        SinglyLinkedList<TaintedSinkValueImpl> chunks = TaintedSinkValue.getContinuousTaintedChunks(TaintSourceWrapper.getStringValueTag(s), 0);
        HashSet<ProcessedSourceInfoTaintLabel> processedLabels = getProcessLabels(chunks);
        assertEquals(1, processedLabels.size());
        ProcessedSourceInfoTaintLabel label = new LinkedList<>(processedLabels).peek();
        assertNotNull(label);
        InvocationRanges ranges = label.getIndexInfoMap().get(TARGET_INVOCATION_ID);
        assertArrayEquals(expectedRanges, ranges.getRangesCopy());
    }

    /* Checks that indexing gaps due to partial tag loss from HTML named entity unescaping are filled. */
    @Test
    public void testHtmlUnescapeNamedEntityPartialIndexLoss() {
        String originalString = taintString("&amp;Lorem ipsum dolor &amp;&amp; sit amet, consectetur adipiscing eli &amp;");
        String replacedString = convertWithPartialTags(originalString, "&amp;", "&", 1, 2, 3);
        checkProcessedRange(replacedString, new int[]{0, originalString.length()});
    }

    /* Checks that indexing gaps due to partial tag loss from HTML decimal character reference unescaping are filled. */
    @Test
    public void testHtmlUnescapeDecimalCharReferencePartialIndexLoss() {
        String originalString = taintString("&#00042;Lorem ipsum dolor &#00042;&#00042; sit amet, consectetur adipiscing eli &#00042;");
        String replacedString = convertWithPartialTags(originalString, "&#00042;", "*", 0, 2);
        checkProcessedRange(replacedString, new int[]{0, originalString.length()});
    }

    /* Checks that indexing gaps due to partial tag loss from HTML hex character reference unescaping are filled. */
    @Test
    public void testHtmlUnescapeHexCharReferencePartialIndexLoss() {
        String originalString = taintString("&#x00060;Lorem ipsum dolor &#x00060;&#x00060; sit amet, consectetur adipiscing eli &#x00060;");
        String replacedString = convertWithPartialTags(originalString, "&#x00060;", "`", 0, 1);
        checkProcessedRange(replacedString, new int[]{0, originalString.length()});
    }

    /* Checks that indexing gaps due to partial tag loss from URL decoding are filled. */
    @Test
    public void testUrlDecodePartialIndexLoss() {
        String originalString = taintString("%24Lorem ipsum dolor %24%24 sit amet, consectetur adipiscing eli %24");
        String replacedString = convertWithPartialTags(originalString, "%24", "$", 1, 2);
        checkProcessedRange(replacedString, new int[]{0, originalString.length()});
    }

    /* Checks that indexing gaps due to full tag loss from HTML entity escaping are filled if they are in the middle of
     * an otherwise continuously tainted String. */
    @Test
    public void testHtmlNamedEntityEscapeFullIndexLossMidChunk() {
        String originalString = taintString("Lorem ipsum dolor& sit amet,&& onsectetu&r adipiscing eli ");
        String replacedString = originalString.replaceAll("&", "&amp;");
        checkProcessedRange(replacedString, new int[]{0, originalString.length()});
    }

    /* Checks that indexing gaps due to full tag loss from HTML decimal character reference escaping are filled if they are in the middle of
     * an otherwise continuously tainted String. */
    @Test
    public void testHtmlDecimalCharReferenceEscapeFullIndexLossMidChunk() {
        String originalString = taintString("Lorem ipsum dolor* sit amet,** onsectetu*r adipiscing eli ");
        String replacedString = originalString.replaceAll("\\*", "&#00042;");
        checkProcessedRange(replacedString, new int[]{0, originalString.length()});
    }

    /* Checks that indexing gaps due to full tag loss from HTML hex character reference escaping are filled if they are in the middle of
     * an otherwise continuously tainted String. */
    @Test
    public void testHtmlHexCharReferenceEscapeFullIndexLossMidChunk() {
        String originalString = taintString("Lorem ipsum dolor` sit amet,`` onsectetu`r adipiscing eli ");
        String replacedString = originalString.replaceAll("`", "&#x00060;");
        checkProcessedRange(replacedString, new int[]{0, originalString.length()});
    }

    /* Checks that indexing gaps due to full tag loss from URL decoding are filled if they are in the middle of an
     * otherwise continuously tainted String. */
    @Test
    public void testUrlDecodeFullIndexLossMidChunk() {
        String originalString = taintString("Lorem ipsum dolor/ sit amet,// onsectetu/r adipiscing eli");
        String replacedString = originalString.replaceAll(" ", "+").replaceAll("/", "%2f");
        checkProcessedRange(replacedString, new int[]{0, originalString.length()});
    }

    /* Checks that index gaps that are not produced by valid encoding or decoding in the middle of an otherwise
     * continuously tainted String are not filled it. */
    @Test
    public void testNoEncodingMatchMidChunk() {
        String originalString = taintString("Lorem ipsum dolor sit");
        String replacedString = originalString.replaceAll(" ", "9");
        checkProcessedRange(replacedString, new int[]{0, 5, 6, 11, 12, 17, 18, 21});
    }

    /* Checks that indexing gaps due to full tag loss from URL decoding are filled if they are before a tainted
     * chunk from the source getEncodedQuery. */
    @Test
    public void testUrlDecodeFullIndexLossPreChunkEncodedQuerySource() {
        String taintedString = taintString("+%2ftest", PhosphorHttpRequestSource.ENCODED_QUERY);
        String originalString = String.format("name=%s&value=5", taintedString);
        String replacedString = originalString.replaceAll("\\+", " ").replaceAll("%2f", "/");
        checkProcessedRange(replacedString, new int[]{0, taintedString.length()});
    }

    /* Checks that index gaps that are not produced by valid encoding or decoding that are before a tainted
     * chunk from the source getEncodedQuery are not filled in. */
    @Test
    public void testNoEncodingMatchPreChunkEncodedQuerySource() {
        String taintedString = taintString("+%2ftest", PhosphorHttpRequestSource.ENCODED_QUERY);
        String originalString = String.format("name=%s&value=5", taintedString);
        String replacedString = originalString.replaceAll("\\+", "9").replaceAll("%2f", "4");
        checkProcessedRange(replacedString, new int[]{4, taintedString.length()});
    }

    /* Checks that index gaps that are before a tainted chunk from the source getEncodedQuery are not filled in if
     * doing so would cross an '='. */
    @Test
    public void testBreakRespectedPreChunkEncodedQuerySource() {
        String taintedString = taintString("=test", PhosphorHttpRequestSource.ENCODED_QUERY);
        String originalString = String.format("name%s&value=5", taintedString);
        String replacedString = originalString.replaceAll("=", "%3D");
        checkProcessedRange(replacedString, new int[]{1, taintedString.length()});
    }

    /* Checks that indexing gaps due to full tag loss from URL decoding are filled if they are after a tainted
     * chunk from the source getEncodedQuery. */
    @Test
    public void testUrlDecodeFullIndexLossPostChunkEncodedQuerySource() {
        String taintedString = taintString("test+%2f", PhosphorHttpRequestSource.ENCODED_QUERY);
        String originalString = String.format("name=%s&value=5", taintedString);
        String replacedString = originalString.replaceAll("\\+", " ").replaceAll("%2f", "/");
        checkProcessedRange(replacedString, new int[]{0, taintedString.length()});
    }

    /* Checks that index gaps that are not produced by valid encoding or decoding that are after a tainted
     * chunk from the source getEncodedQuery are not filled in. */
    @Test
    public void testNoEncodingMatchPostChunkEncodedQuerySource() {
        String taintedString = taintString("test+%2f", PhosphorHttpRequestSource.ENCODED_QUERY);
        String originalString = String.format("name=%s&value=5", taintedString);
        String replacedString = originalString.replaceAll("\\+", "9").replaceAll("%2f", "4");
        checkProcessedRange(replacedString, new int[]{0, taintedString.length() - 4});
    }

    /* Checks that index gaps that are after a tainted chunk from the source getEncodedQuery are not filled in if
     * doing so would cross an '&'. */
    @Test
    public void testBreakRespectedPostChunkEncodedQuerySource() {
        String taintedString = taintString("test&", PhosphorHttpRequestSource.ENCODED_QUERY);
        String originalString = String.format("name=%svalue=5", taintedString);
        String replacedString = originalString.replaceAll("&", "%26");
        checkProcessedRange(replacedString, new int[]{0, taintedString.length() - 1});
    }

    /* Checks that indexing gaps due to full tag loss from URL decoding are filled if they are before a tainted
     * chunk from the source getEncodedPath. */
    @Test
    public void testUrlDecodeFullIndexLossPreChunkEncodedPathSource() {
        String taintedString = taintString("+%2ftest", PhosphorHttpRequestSource.ENCODED_PATH);
        String originalString = String.format("/%s/example", taintedString);
        String replacedString = originalString.replaceAll("\\+", " ").replaceAll("%2f", "/");
        checkProcessedRange(replacedString, new int[]{0, taintedString.length()});
    }

    /* Checks that index gaps that are not produced by valid encoding or decoding that are before a tainted
     * chunk from the source getEncodedPath are not filled in. */
    @Test
    public void testNoEncodingMatchPreChunkEncodedPathSource() {
        String taintedString = taintString("+%2ftest", PhosphorHttpRequestSource.ENCODED_PATH);
        String originalString = String.format("/%s/example", taintedString);
        String replacedString = originalString.replaceAll("\\+", "9").replaceAll("%2f", "4");
        checkProcessedRange(replacedString, new int[]{4, taintedString.length()});
    }

    /* Checks that index gaps that are before a tainted chunk from the source getEncodedPath are not filled in if
     * doing so would cross a '/'. */
    @Test
    public void testBreakRespectedPreChunkEncodedPathSource() {
        String taintedString = taintString("/test", PhosphorHttpRequestSource.ENCODED_PATH);
        String replacedString  = String.format("%s/example", taintedString.replaceAll("/", "%2f"));
        checkProcessedRange(replacedString, new int[]{1, taintedString.length()});
    }

    /* Checks that indexing gaps due to full tag loss from URL decoding are filled if they are after a tainted
     * chunk from the source getEncodedPath. */
    @Test
    public void testUrlDecodeFullIndexLossPostChunkEncodedPathSource() {
        String taintedString = taintString("test+%2f", PhosphorHttpRequestSource.ENCODED_PATH);
        String originalString = String.format("/%s/example", taintedString);
        String replacedString = originalString.replaceAll("\\+", " ").replaceAll("%2f", "/");
        checkProcessedRange(replacedString, new int[]{0, taintedString.length()});
    }

    /* Checks that index gaps that are not produced by valid encoding or decoding that are after a tainted
     * chunk from the source getEncodedPath are not filled in. */
    @Test
    public void testNoEncodingMatchPostChunkEncodedPathSource() {
        String taintedString = taintString("test+%2f", PhosphorHttpRequestSource.ENCODED_PATH);
        String originalString = String.format("/%s/example", taintedString);
        String replacedString = originalString.replaceAll("\\+", "9").replaceAll("%2f", "4");
        checkProcessedRange(replacedString, new int[]{0, taintedString.length() - 4});
    }

    /* Checks that index gaps that are after a tainted chunk from the source getEncodedPath are not filled in if
     * doing so would cross an '#'. */
    @Test
    public void testBreakRespectedPostChunkEncodedPathSource() {
        String taintedString = taintString("test#", PhosphorHttpRequestSource.ENCODED_PATH);
        String originalString = String.format("%sexample", taintedString);
        String replacedString = originalString.replaceAll("#", "%23");
        checkProcessedRange(replacedString, new int[]{0, taintedString.length() - 1});
    }

    /* Checks that indexing gaps due to full tag loss from HTML entity escaping are filled if they are before a tainted
     * chunk from the source getCookieHeader. */
    @Test
    public void testHtmlEscapeFullIndexLossPreChunkCookieHeaderSource() {
        String taintedString = taintString("&#94test", PhosphorHttpRequestSource.COOKIE_HEADER);
        String replacedString = String.format("name=%s; name2=value2;", taintedString.replaceAll("&#94", "^"));
        checkProcessedRange(replacedString, new int[]{0, taintedString.length()});
    }

    /* Checks that index gaps that are not produced by valid encoding or decoding that are before a tainted
     * chunk from the source getCookieHeader are not filled in. */
    @Test
    public void testNoEncodingMatchPreChunkCookieHeaderSource() {
        String taintedString = taintString("&#94test", PhosphorHttpRequestSource.COOKIE_HEADER);
        String replacedString = String.format("name=%s; name2=value2;", taintedString.replaceAll("&#94", "!"));
        checkProcessedRange(replacedString, new int[]{4, taintedString.length()});
    }

    /* Checks that index gaps that are before a tainted chunk from the source getCookieHeader are not filled in if
     * doing so would cross a '='. */
    @Test
    public void testBreakRespectedPreChunkCookieHeaderSource() {
        String taintedString = taintString("=test", PhosphorHttpRequestSource.COOKIE_HEADER);
        String replacedString = String.format("name%s; name2=value2;", taintedString.replaceAll("=", "&#61"));
        checkProcessedRange(replacedString, new int[]{1, taintedString.length()});
    }

    /* Checks that indexing gaps due to full tag loss from HTML entity escaping are filled if they are after a tainted
     * chunk from the source getCookieHeader. */
    @Test
    public void testHtmlEscapeFullIndexLossPostChunkCookieHeaderSource() {
        String taintedString = taintString("test&#94", PhosphorHttpRequestSource.COOKIE_HEADER);
        String replacedString = String.format("name=%s; name2=value2;", taintedString.replaceAll("&#94", "^"));
        checkProcessedRange(replacedString, new int[]{0, taintedString.length()});
    }

    /* Checks that index gaps that are not produced by valid encoding or decoding that are after a tainted
     * chunk from the source getCookieHeader are not filled in. */
    @Test
    public void testNoEncodingMatchPostChunkCookieHeaderSource() {
        String taintedString = taintString("test&#94", PhosphorHttpRequestSource.COOKIE_HEADER);
        String replacedString = String.format("name=%s; name2=value2;", taintedString.replaceAll("&#94", "!"));
        checkProcessedRange(replacedString, new int[]{0, taintedString.length() - 4});
    }

    /* Checks that index gaps that are after a tainted chunk from the source getCookieHeader are not filled in if
     * doing so would cross a ';'. */
    @Test
    public void testBreakRespectedPostChunkCookieHeaderSource() {
        String taintedString = taintString("test;", PhosphorHttpRequestSource.COOKIE_HEADER);
        String replacedString = String.format("name=%s name2=value2;", taintedString.replaceAll(";", "&#59"));
        checkProcessedRange(replacedString, new int[]{0, taintedString.length() - 1});
    }
}
