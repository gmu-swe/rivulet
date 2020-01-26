package io.rivulet.internal;

import edu.columbia.cs.psl.phosphor.TaintUtils;
import edu.columbia.cs.psl.phosphor.runtime.Taint;
import edu.columbia.cs.psl.phosphor.struct.LazyArrayObjTags;
import edu.columbia.cs.psl.phosphor.struct.SinglyLinkedList;
import io.rivulet.PhosphorHttpRequestSource;
import org.jsoup.parser.Parser;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

/* Stores information about a tainted value or multiple tainted values that were passed as arguments to a sink method at
 * a particular argument index. */
public abstract class TaintedSinkValue implements Serializable {

    private static final long serialVersionUID = 3928801132093217804L;
    // The number of characters of a sink value that should be printed before truncating the value
    private static final int MAX_SINK_VALUE_LENGTH = 150;
    // The class of the tainted value when it reached the sink
    private final Class<?> sinkValueClass;
    // The index of the tainted value in the arguments of the sink method
    private final int sinkArgIndex;
    // Set of source labels that the tainted value was tainted with when it reached the sink
    private final LinkedHashSet<SourceInfoTaintLabel> taintSources;

    /* Constructs a new TaintedSinkValue whose taintSources set initially contains the labels of the specified taint. */
    public TaintedSinkValue(Class<?> sinkValueClass, int sinkArgIndex, Taint<SourceInfoTaintLabel> taint) {
        this(sinkValueClass, sinkArgIndex);
        this.taintSources.addAll(Arrays.asList(taint.getLabels(new SourceInfoTaintLabel[0])));
    }

    /* Constructs a new TaintedSinkValue with an initially empty set of taintSources. */
    public TaintedSinkValue(Class<?> sinkValueClass, int sinkArgIndex) {
        this.sinkValueClass = sinkValueClass;
        this.sinkArgIndex = sinkArgIndex;
        this.taintSources = new LinkedHashSet<>();
    }

    /* Getter for sinkValueClass. */
    public Class<?> getSinkValueClass() {
        return sinkValueClass;
    }

    /* Getter for sinkArgIndex. */
    public int getSinkArgIndex() {
        return sinkArgIndex;
    }

    /* Getter for taintSources. */
    public LinkedHashSet<SourceInfoTaintLabel> getTaintSources() {
        return taintSources;
    }

    /* Return a list of abbreviated versions of this instance's sinkValues. */
    public List<String> getFormattedSinkValues() {
        LinkedHashSet<String> result = new LinkedHashSet<>();
        for(String value : getSinkValues()) {
            String formattedValue = value.replaceAll("\n", "\\\\n");
            formattedValue = formattedValue.replaceAll("\t", "\\\\t");
            formattedValue = formattedValue.replaceAll("\r", "\\\\r");
            if(formattedValue.length() > MAX_SINK_VALUE_LENGTH) {
                formattedValue = formattedValue.substring(0, MAX_SINK_VALUE_LENGTH) + "...";
            }
            result.add(formattedValue);
        }
        return new LinkedList<>(result);
    }

    /* Returns a list of text representations of the tainted values for this instance. */
    protected abstract List<String> getSinkValues();

    /* Returns a text representation of this TaintedSinkValue. */
    @Override
    public String toString() {
        TreeSet<String> sources = new TreeSet<>();
        for(SourceInfoTaintLabel label : taintSources) {
            sources.add(label.getBaseSource());
        }
        return String.format("TaintedSinkValue{%s, sinkValueClass: %s, sinkArgIndex: %d, taintSources: %s}",
                getFormattedSinkValues(), sinkValueClass, sinkArgIndex, sources);
    }

    /* Returns a nicely-formatted text representation of this TaintedSinkValue indented by the specified amount. */
    public String toString(int indent) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < indent; i++) {
            builder.append("\t");
        }
        String indentStr = builder.toString();
        builder = new StringBuilder();
        List<String> sinkValues = getFormattedSinkValues();
        builder.append(indentStr).append("{\n");
        if(sinkValues.size() == 1) {
            builder.append(indentStr).append("\tsinkValue: ").append(sinkValues.get(0)).append("\n");
        } else {
            builder.append(indentStr).append("\tsinkValues: [\n");
            for(String sinkValue : sinkValues) {
                builder.append(indentStr).append("\t\t").append(sinkValue).append("\n");
            }
            builder.append(indentStr).append("\t]\n");
        }
        builder.append(indentStr).append("\tsinkValueClass: ").append(sinkValueClass).append("\n");
        builder.append(indentStr).append("\tsinkArgIndex: ").append(sinkArgIndex).append("\n");
        TreeSet<String> sources = new TreeSet<>();
        for(SourceInfoTaintLabel label : taintSources) {
            sources.add(label.getBaseSource());
        }
        if(sources.size() == 1) {
            builder.append(indentStr).append("\ttaintSource: ").append(new LinkedList<>(sources).get(0)).append("\n");
        } else {
            builder.append(indentStr).append("\ttaintSources: [\n");
            for(String source : sources) {
                builder.append(indentStr).append("\t\t").append(source).append('\n');
            }
            builder.append(indentStr).append("\t]\n");
        }
        return builder.append(indentStr).append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o == null || getClass() != o.getClass()) {
            return false;
        }
        TaintedSinkValue that = (TaintedSinkValue) o;
        if(sinkArgIndex != that.sinkArgIndex || !sinkValueClass.equals(that.sinkValueClass)) {
            return false;
        } else {
            return this.taintSources.equals(that.taintSources);
        }
    }

    @Override
    public int hashCode() {
        int result = sinkValueClass.hashCode();
        result = 31 * result + sinkArgIndex;
        result = 31 * result + taintSources.hashCode();
        return result;
    }

    /* Returns a TaintedSinkValueImpl for the specified range of elements in the specified LazyArrayObjTags. */
    private static TaintedSinkValueImpl getContinuousTaintedChunk(LazyArrayObjTags srcTags, Class<?> arrayType, int start, int len, int argIndex) {
        Object chunk = Array.newInstance(arrayType.getComponentType(), len);
        if(chunk instanceof LazyArrayObjTags) {
            System.arraycopy(srcTags.getVal(), start, ((LazyArrayObjTags) chunk).getVal(), 0, len);
        }
        @SuppressWarnings("unchecked")
        Taint<SourceInfoTaintLabel>[] chunkTaints = (Taint<SourceInfoTaintLabel>[])new Taint[len];
        System.arraycopy(srcTags.taints, start, chunkTaints, 0, len);
        Taint<SourceInfoTaintLabel> chunkCombinedTaint = Taint.combineTaintArray(chunkTaints);
        return new TaintedSinkValueImpl(TaintedStringBuilder.formatTaintedValue(chunk), arrayType, argIndex, chunkCombinedTaint);
    }

    /* Returns a list of TaintedSinkValueImpl that contains an element for each continuously tainted section of the specified
     * LazyArrayObjTags instance. */
    public static SinglyLinkedList<TaintedSinkValueImpl> getContinuousTaintedChunks(LazyArrayObjTags tags, int argIndex) {
        @SuppressWarnings("unchecked")
        Taint<SourceInfoTaintLabel>[] taints = (Taint<SourceInfoTaintLabel>[])tags.taints;
        Object sinkArray = tags.getVal();
        if(taints == null || sinkArray == null) {
            return new SinglyLinkedList<>();
        } else if(sinkArray instanceof char[]) {
            try {
                fillInGaps(taints, (char[])sinkArray);
            } catch(Exception e) {
                // Failed best effort to fill in gaps in taint tags
            }
        }
        InvocationRanges taintedInvocationRanges = new InvocationRanges(0);
        for(int i = 0; i < taints.length; i++) {
            if(taints[i] != null && !taints[i].isEmpty()) {
                taintedInvocationRanges.addInt(i);
            }
        }
        Class<?> clazz = TaintUtils.getUnwrappedClass(tags.getClass());
        SinglyLinkedList<TaintedSinkValueImpl> taintedChunks = new SinglyLinkedList<>();
        int[] taintedRanges = taintedInvocationRanges.getRangesCopy();
        for(int i = 0; i < taintedRanges.length; i+=2) {
            taintedChunks.enqueue(getContinuousTaintedChunk(tags, clazz, taintedRanges[i], taintedRanges[i+1] - taintedRanges[i], argIndex));
        }
        return taintedChunks;
    }

    /* Attempts to fill in gaps in the invocation indices covered by labels for a particular base source that were likely
     * the result of characters being url-decoded, url-encoded, html-escaped or html-unescaped. */
    private static void fillInGaps(Taint<SourceInfoTaintLabel>[] taints, char[] sinkArray) {
        // Fix issues with encoded characters in the source whose decoded value in the sink lost part of the indices
        // in the original range
        fillInSingleCharSourceGaps(taints, sinkArray);
        // Fix gaps between two sections tainted with the base label
        LinkedHashMap<IndexedSourceInfoTaintLabel, InvocationRanges> sinkIndicesMap = createSinkIndicesMap(taints);
        for(IndexedSourceInfoTaintLabel baseLabel : sinkIndicesMap.keySet()) {
            int[] taintedRanges = sinkIndicesMap.get(baseLabel).getRangesCopy();
            Object originalArray = baseLabel.getOriginalArrayCopy();
            if(originalArray instanceof char[] && taintedRanges.length >= 2) {
                fillInGapsBetweenTaintedChunks(taints, sinkArray, baseLabel, taintedRanges, (char[]) originalArray);
            }
        }
        // Fix tag loss before and after tainted sections
        sinkIndicesMap = createSinkIndicesMap(taints);
        LinkedHashMap<IndexedSourceInfoTaintLabel, InvocationRanges> sourceIndicesMap = createSourceIndicesMap(taints, 0, taints.length);
        for(IndexedSourceInfoTaintLabel baseLabel : sinkIndicesMap.keySet()) {
            int[] taintedRanges = sinkIndicesMap.get(baseLabel).getRangesCopy();
            Object originalArray = baseLabel.getOriginalArrayCopy();
            if(originalArray instanceof char[] && taintedRanges.length >= 2 && sourceIndicesMap.containsKey(baseLabel)) {
                char[] breaks = getBreaks(baseLabel);
                int[] sourceRanges = sourceIndicesMap.get(baseLabel).getRangesCopy();
                if(breaks != null && sourceRanges.length >= 2) {
                    fillInGapsBeforeTaintedChunks(taints, sinkArray, baseLabel, taintedRanges[0], (char[]) originalArray, breaks, sourceRanges[0]);
                    fillInGapsAfterTaintedChunks(taints, sinkArray, baseLabel, taintedRanges[taintedRanges.length-1],
                            (char[]) originalArray, breaks, sourceRanges[sourceRanges.length - 1]);
                }
            }
        }
    }

    /* Returns the standard chars used to break up the structure of text at the specified label's base source or null if
     * no such standard characters exist. */
    private static char[] getBreaks(SourceInfoTaintLabel label) {
        if(PhosphorHttpRequestSource.ENCODED_QUERY.matchesSignature(label.getBaseSource())) {
            return new char[]{'=', '&'};
        } else if(PhosphorHttpRequestSource.ENCODED_PATH.matchesSignature(label.getBaseSource())) {
            return new char[]{':', '?', '/', '#', '@', '[', ']'};
        } else if(PhosphorHttpRequestSource.COOKIE_HEADER.matchesSignature(label.getBaseSource())) {
            return new char[]{'=', ';'};
        } else {
            return null;
        }
    }

    /* Fix issues with sink array elements before tainted ranges completely missing labels likely due to tag loss
     * during encoding or decoding. */
    private static void fillInGapsBeforeTaintedChunks(Taint<SourceInfoTaintLabel>[] taints, char[] sinkArray, IndexedSourceInfoTaintLabel baseLabel,
                                                      int sinkRangeEnd, char[] sourceArray, char[] breaks, int sourceRangeEnd) {
        if(sinkRangeEnd <= 0 || sourceRangeEnd <= 0) {
            return;
        }
        int sourceRangeStart;
        for(sourceRangeStart = sourceRangeEnd - 1; sourceRangeStart >= 0; sourceRangeStart--) {
            // Move the start back until you hit a break character or the beginning of the array
            if(containsChar(breaks, sourceArray[sourceRangeStart])) {
                break;
            }
        }
        sourceRangeStart++;
        if(sourceRangeEnd > sourceRangeStart) {
            String sourceString = new String(sourceArray, sourceRangeStart, sourceRangeEnd - sourceRangeStart);
            String sinkString = new String(sinkArray, 0, sinkRangeEnd);
            // Determine the largest suffix of the sinkString that could have been derived from some suffix of the
            // sourceString
            int[] overlap = largestEdgeOverlapWithDecodingOrUnescaping(sourceString, sinkString, true);
            if(overlap != null) {
                fillInSinkGap(sinkRangeEnd-overlap[0], sinkRangeEnd, taints, baseLabel, sourceRangeEnd-overlap[1], sourceRangeEnd);
            }
        }
    }

    /* Determines if some starting (or ending if fromEnd is true) portion of the specified source String matches with
     * some starting portion of the specified sink String possibly after apply URL decoding or HTML unescaping to either
     * or both Strings. If such a matching exists, returns the number of chars in the sink String followed by the number
     * of chars in the source String that make up the largest possible matching. Otherwise, returns null. */
    private static int[] largestEdgeOverlapWithDecodingOrUnescaping(String sourceString, String sinkString, boolean fromEnd) {
        String longestSourceOverlap = "";
        String longestSinkOverlap = "";
        LinkedHashSet<String> sourceSet = new LinkedHashSet<>();
        LinkedHashSet<String> sinkSet = new LinkedHashSet<>();
        // Add originals
        sourceSet.add(ParseUtils.taintCharsWithPosition(sourceString));
        sinkSet.add(ParseUtils.taintCharsWithPosition(sinkString));
        // Add URL decoded versions
        sourceSet.add(ParseUtils.decodeUrlEnsuringTags(ParseUtils.taintCharsWithPosition(sourceString)));
        sinkSet.add(ParseUtils.decodeUrlEnsuringTags(ParseUtils.taintCharsWithPosition(sinkString)));
        // Add HTML unescaped versions
        sourceSet.add(ParseUtils.unescapeHtmlReferencesEnsuringTags(ParseUtils.taintCharsWithPosition(sourceString)));
        sinkSet.add(ParseUtils.unescapeHtmlReferencesEnsuringTags(ParseUtils.taintCharsWithPosition(sinkString)));
        for(String x : sourceSet) {
            for(String y : sinkSet) {
                int numOverlapping = calculateOverlappingChars(x, y, fromEnd);
                if(numOverlapping > longestSourceOverlap.length()) {
                    longestSourceOverlap = fromEnd ? x.substring(x.length() - numOverlapping) : x.substring(0, numOverlapping);
                    longestSinkOverlap = fromEnd ? y.substring(y.length() - numOverlapping) : y.substring(0, numOverlapping);
                }
            }
        }
        if(longestSourceOverlap.length() > 0) {
            int[] sourceRanges = ParseUtils.getMergedRangesFromTaints(longestSourceOverlap).getRangesCopy();
            int[] sinkRanges = ParseUtils.getMergedRangesFromTaints(longestSinkOverlap).getRangesCopy();
            if(sourceRanges.length >= 2 && sinkRanges.length >= 2) {
                return new int[]{sinkRanges[sinkRanges.length - 1] - sinkRanges[0], sourceRanges[sourceRanges.length - 1] - sourceRanges[0]};
            }
        }
        return null;
    }

    /* Attempts to fix issues with sink array elements after tainted ranges completely missing labels likely due to tag
     * loss during encoding or decoding. */
    private static void fillInGapsAfterTaintedChunks(Taint<SourceInfoTaintLabel>[] taints, char[] sinkArray, IndexedSourceInfoTaintLabel baseLabel,
                                                     int sinkRangeStart, char[] sourceArray, char[] breaks, int sourceRangeStart) {
        if(sinkRangeStart >= sinkArray.length || sourceRangeStart >= sourceArray.length) {
            return;
        }
        int sourceRangeEnd;
        for(sourceRangeEnd = sourceRangeStart + 1; sourceRangeEnd < sourceArray.length; sourceRangeEnd++) {
            // Move the end forward until you hit a break character or the end of the array
            if(containsChar(breaks, sourceArray[sourceRangeEnd])) {
                break;
            }
        }
        if(containsChar(breaks, sourceArray[sourceRangeEnd - 1])) {
            sourceRangeEnd--;
        }
        if(sourceRangeEnd > sourceRangeStart) {
            String sourceString = new String(sourceArray, sourceRangeStart, sourceRangeEnd - sourceRangeStart);
            String sinkString = new String(sinkArray, sinkRangeStart, sinkArray.length - sinkRangeStart);
            // Determine the largest prefix of the sinkString that could have been derived from some prefix of the
            // sourceString
            int[] overlap = largestEdgeOverlapWithDecodingOrUnescaping(sourceString, sinkString, false);
            if(overlap != null) {
                fillInSinkGap(sinkRangeStart, sinkRangeStart+overlap[0], taints, baseLabel, sourceRangeStart,
                        sourceRangeStart + overlap[1]);
            }
        }
    }

    /* Returns whether the specified array contains the specified target character. */
    private static boolean containsChar(char[] array, char target) {
        for(char c : array) {
            if(target == c) {
                return true;
            }
        }
        return false;
    }

    /* Attempts to fix issues with sink array elements in otherwise continuously tainted ranges completely missing labels
     * likely due to tag loss during encoding or decoding. */
    private static void fillInGapsBetweenTaintedChunks(Taint<SourceInfoTaintLabel>[] taints, char[] sinkArray, IndexedSourceInfoTaintLabel baseLabel,
                                                       int[] taintedRanges, char[] sourceArray) {
        if(taintedRanges.length > 2) {
            for(int i = 2; i < taintedRanges.length; i+=2) {
                int gapStart = taintedRanges[i-1];
                int gapEnd = taintedRanges[i];
                String sinkGapString = new String(sinkArray, gapStart, gapEnd - gapStart);
                int[] sourceGapRange = getSourceGapRange(taints, baseLabel, gapStart, gapEnd);
                if(sourceGapRange != null) {
                    int sourceGapStart = sourceGapRange[0];
                    int sourceGapEnd = sourceGapRange[1];
                    String sourceGapString = new String(sourceArray, sourceGapStart, sourceGapEnd - sourceGapStart);
                    if(matchesWithDecodingOrUnescaping(sinkGapString, sourceGapString)) {
                        fillInSinkGap(gapStart, gapEnd, taints, baseLabel, sourceGapStart, sourceGapEnd);
                    }
                }

            }
        }
    }

    /* Places taint tag elements into the specified array of taints in the specified sink gap range to fill in the
     * specified source gap for the specified base label. */
    private static void fillInSinkGap(int sinkGapStart, int sinkGapEnd, Taint<SourceInfoTaintLabel>[] taints,
                                      IndexedSourceInfoTaintLabel baseLabel, int sourceGapStart, int sourceGapEnd) {
        if(sinkGapEnd <= sinkGapStart || sinkGapEnd > taints.length || sinkGapStart < 0 || sourceGapEnd <= sourceGapStart ||
                sourceGapStart < 0) {
            // Invalid ranges
            return;
        }
        Taint<SourceInfoTaintLabel> rangeTaint = new Taint<>();
        for(int i = sourceGapStart; i < sourceGapEnd; i++) {
            rangeTaint.addDependency(new Taint<>(new IndexedSourceInfoTaintLabel(baseLabel, i)));
        }
        for(int i = sinkGapStart; i < sinkGapEnd; i++) {
            taints[i] = rangeTaint.copy();
        }
    }

    /* Tries to maps the specified taint gap in the sink String back to a portion in an original Source String. If the
     * original source portion can be determined, returns its range. Otherwise returns null. */
    private static int[] getSourceGapRange(Taint<SourceInfoTaintLabel>[] taints, IndexedSourceInfoTaintLabel baseLabel,
                                           int gapStart, int gapEnd) {
        InvocationRanges preGapSourceInvocationRanges = createSourceIndicesMap(taints, gapStart-1, gapStart).get(baseLabel);
        InvocationRanges postGapSourceInvocationRanges = createSourceIndicesMap(taints, gapEnd, gapEnd+1).get(baseLabel);
        if(preGapSourceInvocationRanges != null && postGapSourceInvocationRanges != null) {
            int[] preGapSourceRanges = preGapSourceInvocationRanges.getRangesCopy();
            int[] postGapSourceRanges = postGapSourceInvocationRanges.getRangesCopy();
            if(preGapSourceRanges.length > 0 && postGapSourceRanges.length > 0) {
                int sourceGapStart = preGapSourceRanges[postGapSourceRanges.length - 1];
                int sourceGapEnd = postGapSourceRanges[0];
                if(sourceGapEnd > sourceGapStart) {
                    return new int[]{sourceGapStart, sourceGapEnd};
                }
            }
        }
        return null;
    }

    /* Attempts to fix partial source invocation index loss due for decoding multiple source characters into a single
     * character. */
    private static void fillInSingleCharSourceGaps(Taint<SourceInfoTaintLabel>[] taints, char[] sinkArray) {
        // Find characters with more than one label from the same source and invocation, but with a different indices
        for(int i = 0; i < taints.length; i++) {
            LinkedHashMap<IndexedSourceInfoTaintLabel, InvocationRanges> sourceIndicesMap = createSourceIndicesMap(taints, i, i+1);
            for(IndexedSourceInfoTaintLabel baseLabel : sourceIndicesMap.keySet()) {
                int[] presentRanges = sourceIndicesMap.get(baseLabel).getRangesCopy();
                int len = presentRanges.length;
                Object originalArray = baseLabel.getOriginalArrayCopy();
                if(len >= 2 && presentRanges[len-1] > presentRanges[0]+1 && originalArray instanceof char[]) {
                    // More than one index is present, makes sure all appropriate indices are present
                    fillInSingleCharSourceGap(taints[i], baseLabel, sinkArray[i], (char[]) originalArray, presentRanges[0], presentRanges[len-1]);
                }
            }
        }
    }

    /* Determines whether the a source invocation index was lost a result of converting some range which the specified
     * [start, end) range is a proper subset of in the specified source array to the specified sink char. If index loss
     * is discovered, add appropriate labels to the specified taint instance. */
    private static void fillInSingleCharSourceGap(Taint<SourceInfoTaintLabel> taint, IndexedSourceInfoTaintLabel baseLabel,
                                                  char sinkChar, char[] sourceArray, int start, int end) {
        // Check for indices partially lost from a URL encoded char, e.g. %20
        int[] result = findOverlappingURLEncodedCharMatch(start, end, sourceArray, sinkChar);
        if(result == null) {
            // Check for indices partially lost from a HTML character reference, e.g. &colon; or &#x0003A; or &#58;
            result = findOverlappingHtmlEscapedCharMatch(start, end, sourceArray, sinkChar);
        }
        if(result != null) {
            for(int i = result[0]; i < result[1]; i++) {
                taint.addDependency(new Taint<>(new IndexedSourceInfoTaintLabel(baseLabel, i)));
            }
        }
    }

    /* Tries to find a URL encoded value of the specified char in the specified array in some range that is a proper
     * superset of the specified [start, end) range. If such a String is present returns its start (inclusive) and end
     * (exclusive) indices in an array, otherwise returns null. */
    private static int[] findOverlappingURLEncodedCharMatch(int start, int end, char[] sourceArray, char target) {
        if(end - start == 2 && Character.isDigit(sourceArray[end-1])) {
            String encoded;
            if(sourceArray[start] == '%' && end < sourceArray.length && Character.isDigit(sourceArray[end])) {
                encoded = new String(sourceArray, start, 3);
                return ParseUtils.decodeUrl(encoded).equals(""+target) ? new int[]{start, end + 1} : null;
            } else if(Character.isDigit(sourceArray[start]) && start > 0 && sourceArray[start-1] == '%') {
                encoded = new String(sourceArray, start-1, 3);
                return ParseUtils.decodeUrl(encoded).equals(""+target) ? new int[]{start - 1, end} : null;
            }
        }
        return null;
    }

    /* Tries to find a HTML escaped value of the specified char in the specified array in some range that is a proper
     * superset of the specified [start, end) range. If such a String is present returns its start (inclusive) and end
     * (exclusive) indices in an array, otherwise returns null. */
    private static int[] findOverlappingHtmlEscapedCharMatch(int start, int end, char[] sourceArray, char target) {
        int escapeStart = start;
        int escapeEnd;
        for(; escapeStart >= 0; escapeStart--) {
            if(sourceArray[escapeStart] == '&') {
                break;
            }
        }
        if(escapeStart < 0 || escapeStart + 2 >= sourceArray.length) {
            // No '&' found or not enough characters after the '&' to form a reference
            return null;
        } else if(sourceArray[escapeStart + 1] == '#') {
            // Numeric reference
            if(sourceArray[escapeStart + 2] == 'x' || sourceArray[escapeStart + 2] == 'X') {
                escapeEnd = Math.max(end, escapeStart + 3);
                // Hex character reference stop at first non hex digit
                while(escapeEnd < sourceArray.length) {
                    if(!isHexDigit(sourceArray[escapeEnd++])) {
                        break;
                    }
                }
            } else {
                escapeEnd = Math.max(end, escapeStart + 2);
                // Decimal character reference stop at first non decimal digit
                while(escapeEnd < sourceArray.length) {
                    if(!Character.isDigit(sourceArray[escapeEnd++])) {
                        break;
                    }
                }
            }
        } else {
            // Named entity stop at first semicolon
            escapeEnd = Math.max(end, escapeStart + 1);
            while(escapeEnd < sourceArray.length) {
                if(sourceArray[escapeEnd++] == ';') {
                    break;
                }
            }
        }
        try {
            if(Parser.unescapeEntities(new String(sourceArray, escapeStart, escapeEnd - escapeStart), false).equals(""+target)) {
                return new int[]{escapeStart, escapeEnd};
            }  else {
                return null;
            }
        } catch(Exception e) {
            return null;
        }
    }

    /* Returns whether the specified character is a hex digit. */
    private static boolean isHexDigit(char c) {
        return Character.isDigit(c) ||('a' <= c && c <= 'f') || ('A' <= c && c <= 'F');
    }

    /* Returns a mapping from "base" labels, i.e. labels with their index information removed, for labels index
     * information and whose original array was a char array to ranges of indices present where the label is present in
     * the specified taint array. */
    public static LinkedHashMap<IndexedSourceInfoTaintLabel, InvocationRanges> createSinkIndicesMap(Taint<SourceInfoTaintLabel>[] taints) {
        LinkedHashMap<IndexedSourceInfoTaintLabel, InvocationRanges> map = new LinkedHashMap<>();
        if(taints != null) {
            for(int i = 0; i < taints.length; i++) {
                if(taints[i] != null) {
                    SourceInfoTaintLabel[] labels = taints[i].getLabels(new SourceInfoTaintLabel[0]);
                    for(SourceInfoTaintLabel label : labels) {
                        if(label instanceof IndexedSourceInfoTaintLabel) {
                            IndexedSourceInfoTaintLabel indexedLabel = (IndexedSourceInfoTaintLabel) label;
                            if(indexedLabel.getIndexInfoCopy() != null && indexedLabel.getOriginalArrayCopy() instanceof char[]) {
                                InvocationRanges invocationRanges = indexedLabel.getIndexInfoCopy();
                                if(invocationRanges.getRangesCopy().length > 0) {
                                    IndexedSourceInfoTaintLabel baseLabel = new IndexedSourceInfoTaintLabel(indexedLabel, -1);
                                    map.putIfAbsent(baseLabel, new InvocationRanges(invocationRanges.getInvocationID()));
                                    map.get(baseLabel).addInt(i);
                                }
                            }
                        }
                    }
                }
            }
        }
        return map;
    }

    /* Returns a mapping from "base" labels, i.e. labels with their index information removed, to ranges of indices
     * present in some label with index information and whose original array was a char array. Considers all of the
     * labels of each taint instance in the specified array between the specified start index inclusive and the specified
     * end index exclusive. */
    private static LinkedHashMap<IndexedSourceInfoTaintLabel, InvocationRanges> createSourceIndicesMap(Taint<SourceInfoTaintLabel>[] taints, int start, int end) {
        LinkedHashMap<IndexedSourceInfoTaintLabel, InvocationRanges> map = new LinkedHashMap<>();
        if(taints != null) {
            for(int i = start; i < end; i++) {
                if(taints[i] != null) {
                    SourceInfoTaintLabel[] labels = taints[i].getLabels(new SourceInfoTaintLabel[0]);
                    for(SourceInfoTaintLabel label : labels) {
                        if(label instanceof IndexedSourceInfoTaintLabel) {
                            IndexedSourceInfoTaintLabel indexedLabel = (IndexedSourceInfoTaintLabel) label;
                            if(indexedLabel.getIndexInfoCopy() != null && indexedLabel.getOriginalArrayCopy() instanceof char[]) {
                                InvocationRanges invocationRanges = indexedLabel.getIndexInfoCopy();
                                if(invocationRanges.getRangesCopy().length > 0) {
                                    IndexedSourceInfoTaintLabel baseLabel = new IndexedSourceInfoTaintLabel(indexedLabel, -1);
                                    map.putIfAbsent(baseLabel, new InvocationRanges(invocationRanges.getInvocationID()));
                                    map.get(baseLabel).merge(indexedLabel.getIndexInfoCopy());
                                }
                            }
                        }
                    }
                }
            }
        }
        return map;
    }

    /* Returns whether the two specified strings are equal ignoring case or are equal ignoring case after applying URL
     * decoding or HTML unescaping to either or both of them. */
    private static boolean matchesWithDecodingOrUnescaping(String s1, String s2) {
        LinkedHashSet<String> set1 = new LinkedHashSet<>();
        LinkedHashSet<String> set2 = new LinkedHashSet<>();
        // Add originals
        set1.add(s1);
        set2.add(s2);
        // Add URL decoded versions
        set1.add(ParseUtils.decodeUrl(s1));
        set2.add(ParseUtils.decodeUrl(s2));
        // Add HTML unescaped versions
        set1.add(Parser.unescapeEntities(s1, false));
        set2.add(Parser.unescapeEntities(s2, false));
        for(String x : set1) {
            for(String y : set2) {
                if(x.equalsIgnoreCase(y)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* Returns the number of characters that are the same between the two specified Strings. Starts from the end of the
     * Strings if fromEnd is true. */
    private static int calculateOverlappingChars(String s1, String s2, boolean fromEnd) {
        int count = 0;
        StringCharacterIterator it1 = new StringCharacterIterator(s1);
        StringCharacterIterator it2 = new StringCharacterIterator(s2);
        if(fromEnd) {
            for(char c1 = it1.last(), c2 = it2.last(); c1 != CharacterIterator.DONE && c2 != CharacterIterator.DONE;
                c1 = it1.previous(), c2 = it2.previous(), count++) {
                if(c1 != c2) {
                    return count;
                }
            }
        } else {
            for(char c1 = it1.first(), c2 = it2.first(); c1 != CharacterIterator.DONE && c2 != CharacterIterator.DONE;
                c1 = it1.next(), c2 = it2.next(), count++) {
                if(c1 != c2) {
                    return count;
                }
            }
        }
        return count;
    }
}
