package io.rivulet.internal.rerun.test;

import edu.columbia.cs.psl.phosphor.runtime.Taint;
import io.rivulet.converter.*;
import io.rivulet.internal.*;
import io.rivulet.internal.rerun.Replacement;
import io.rivulet.internal.rerun.ReplacementImpl;
import io.rivulet.internal.rerun.ReplacementImplBuilder;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.*;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/* Tests the behavior of ReplacementImplBuilder. */
public class ReplacementImplBuilderTest {

    /* Checks that a non-payload builder generates only a single replacement. */
    @Test
    public void testBuildNonPayloadReplacements() {
        ReplacementImplBuilder builder = new ReplacementImplBuilder()
                .value("value")
                .baseSource(ViolationTestUtils.SAMPLE_BASE_SOURCE1)
                .isPayload(false);
        LinkedHashSet<Replacement> replacements = builder.build(ViolationTestUtils.sampleViolation2);
        assertEquals(1, replacements.size());
        Replacement r = (new LinkedList<>(replacements)).pop();
        assertTrue(r.isApplicable(String.class, ViolationTestUtils.SAMPLE_LABEL1));
        assertFalse(r.isApplicable(String.class, ViolationTestUtils.SAMPLE_LABEL2));
    }

    /* Check that a payload builder generates one replacement per applicable label. */
    @Test
    public void testBuildPayloadReplacements() {
        ReplacementImplBuilder builder = new ReplacementImplBuilder()
                .value("value")
                .isPayload(true);
        LinkedHashSet<Replacement> replacements = builder.build(ViolationTestUtils.sampleViolation3);
        assertEquals(3, replacements.size());
        // Check that all of the labels of ViolationTestUtils.sampleViolation3 are covered by the generated reruns
        for(TaintedSinkValue val : ViolationTestUtils.sampleViolation3.getTaintedValues()) {
            for(SourceInfoTaintLabel label : val.getTaintSources()) {
                boolean matched = false;
                for(Replacement r : replacements) {
                    if(r.isApplicable(label.getSourceValueClass(), label)) {
                        matched = true;
                    }
                }
                assertTrue(matched);
            }
        }
    }

    /* Checks that when a violation contains a label with indexInfo index-sensitive replacements are built for a payload
     * replacement builder. */
    @Test
    public void testIndexSensitiveReplacements() {
        ProcessedSourceInfoTaintLabel label = new ProcessedSourceInfoTaintLabel(ViolationTestUtils.SAMPLE_LABEL1);
        label.addIndexInfo(new InvocationRanges(5, new int[]{0, 10, 15, 20}));
        TaintedSinkValueImpl taintedValue = new TaintedSinkValueImpl("test", String.class, 0, new Taint<>(label));
        Violation violation = ViolationTestUtils.sampleViolation1.copyWithTaintedValues(new HashSet<>());
        violation.addTaintedValue(taintedValue);
        ReplacementImplBuilder builder = new ReplacementImplBuilder().value("value").isPayload(true);
        LinkedHashSet<Replacement> replacements = builder.build(violation);
        LinkedHashSet<ForcedTypeConverter> actual = new LinkedHashSet<>();
        for(Replacement r : replacements) {
            actual.add(r.getConverter(label.getSourceValueClass(), label));
        }
        assertThat(actual, containsInAnyOrder(null, new SubstringConverter(0, 10), new SubstringConverter(15, 20)));
    }

    /* Checks that when a violation contains a label for source with a limit on the valid converters for it and with indexInfo
     * index-sensitive replacements ChainedConverters are built for a payload replacement builder. */
    @Test
    public void testIndexSensitiveQueryReplacements() {
        ProcessedSourceInfoTaintLabel label = new ProcessedSourceInfoTaintLabel(ViolationTestUtils.SAMPLE_QUERY_LABEL);
        label.addIndexInfo(new InvocationRanges(5, new int[]{3, 10, 13, 14}));
        TaintedSinkValueImpl taintedValue = new TaintedSinkValueImpl("test", String.class, 0, new Taint<>(label));
        Violation violation = ViolationTestUtils.sampleViolation1.copyWithTaintedValues(new HashSet<>());
        violation.addTaintedValue(taintedValue);
        ReplacementImplBuilder builder = new ReplacementImplBuilder().value("value").isPayload(true);
        LinkedHashSet<Replacement> replacements = builder.build(violation);
        LinkedHashSet<ForcedTypeConverter> actual = new LinkedHashSet<>();
        for(Replacement r : replacements) {
            actual.add(r.getConverter(label.getSourceValueClass(), label));
        }
        assertThat(actual, containsInAnyOrder(
                null,
                new SubstringConverter(3, 10),
                new SubstringConverter(13, 14),
                QueryConverter.getInstance(false, true),
                QueryEncodingConverter.getInstance(true),
                ChainedTypeConverter.getInstance(QueryEncodingConverter.getInstance(true), new SubstringConverter(3, 10)),
                ChainedTypeConverter.getInstance(QueryEncodingConverter.getInstance(true), new SubstringConverter(13, 14)),
                QueryEncodingConverter.getInstance(false),
                ChainedTypeConverter.getInstance(QueryEncodingConverter.getInstance(false), new SubstringConverter(3, 10)),
                ChainedTypeConverter.getInstance(QueryEncodingConverter.getInstance(false), new SubstringConverter(13, 14))
        ));
    }

    /* Checks that payload replacements that leverage invocation information are built when invocation information is
     * available. */
    @Test
    public void testInvocationSensitivePayloadReplacements() {
        ProcessedSourceInfoTaintLabel label = new ProcessedSourceInfoTaintLabel(ViolationTestUtils.SAMPLE_LABEL1);
        label.addIndexInfo(new InvocationRanges(5));
        label.addIndexInfo(new InvocationRanges(2));
        TaintedSinkValueImpl taintedValue = new TaintedSinkValueImpl("test", String.class, 0, new Taint<>(label));
        Violation violation = ViolationTestUtils.sampleViolation1.copyWithTaintedValues(new HashSet<>());
        violation.addTaintedValue(taintedValue);
        ReplacementImplBuilder builder = new ReplacementImplBuilder().value("value").isPayload(true);
        checkConvertersAndInvocationIDs(
                builder.build(violation),
                Collections.singletonList(null),
                new int[]{2},
                new int[]{5}
        );
    }

    /* Checks that non-payload replacements that leverage invocation information are built when invocation information
     * is available. */
    @Test
    public void testInvocationSensitiveNonPayloadReplacements() {
        ProcessedSourceInfoTaintLabel label = new ProcessedSourceInfoTaintLabel(ViolationTestUtils.SAMPLE_LABEL1);
        label.addIndexInfo(new InvocationRanges(0));
        label.addIndexInfo(new InvocationRanges(22));
        label.addIndexInfo(new InvocationRanges(8));
        Taint<SourceInfoTaintLabel> taint = new Taint<>(label);
        taint.addDependency(new Taint<>(ViolationTestUtils.SAMPLE_QUERY_LABEL));
        TaintedSinkValueImpl taintedValue = new TaintedSinkValueImpl("test", String.class, 0, taint);
        Violation violation = ViolationTestUtils.sampleViolation1.copyWithTaintedValues(new HashSet<>());
        violation.addTaintedValue(taintedValue);
        ReplacementImplBuilder builder = new ReplacementImplBuilder()
                .value("value")
                .isPayload(false)
                .baseSource(ViolationTestUtils.SAMPLE_BASE_SOURCE2);
        checkConvertersAndInvocationIDs(
                builder.build(violation),
                Collections.singletonList(null),
                null,
                new int[]{0},
                new int[]{8},
                new int[]{22}
        );
    }

    /* Checks that payload replacements that leverage both index and invocation information are built when both index and invocation
     * information is available. */
    @Test
    public void testInvocationAndIndexSensitivePayloadReplacements() {
        ProcessedSourceInfoTaintLabel label = new ProcessedSourceInfoTaintLabel(ViolationTestUtils.SAMPLE_LABEL1);
        label.addIndexInfo(new InvocationRanges(5, new int[]{3, 10, 13, 14}));
        label.addIndexInfo(new InvocationRanges(2, new int[0]));
        TaintedSinkValueImpl taintedValue = new TaintedSinkValueImpl("test", String.class, 0, new Taint<>(label));
        Violation violation = ViolationTestUtils.sampleViolation1.copyWithTaintedValues(new HashSet<>());
        violation.addTaintedValue(taintedValue);
        ReplacementImplBuilder builder = new ReplacementImplBuilder().value("value").isPayload(true);
        Map<ForcedTypeConverter, LinkedList<int[]>> map = makeConverterInvocationIDsMap(builder.build(violation));
        assertThat(map.get(null), containsInAnyOrder(new int[]{2}, new int[]{5}));
        assertThat(map.get(new SubstringConverter(3, 10)), containsInAnyOrder(new int[]{5}));
        assertThat(map.get(new SubstringConverter(13, 14)), containsInAnyOrder(new int[]{5}));
    }

    /* Checks that non-payload replacements that leverage only invocation information are built when both index and invocation
     * information is available. */
    @Test
    public void testInvocationAndIndexSensitiveNonPayloadReplacements() {
        ProcessedSourceInfoTaintLabel label = new ProcessedSourceInfoTaintLabel(ViolationTestUtils.SAMPLE_LABEL1);
        label.addIndexInfo(new InvocationRanges(0, 9));
        label.addIndexInfo(new InvocationRanges(22, new int[]{22, 33}));
        label.addIndexInfo(new InvocationRanges(8));
        Taint<SourceInfoTaintLabel> taint = new Taint<>(label);
        taint.addDependency(new Taint<>(ViolationTestUtils.SAMPLE_QUERY_LABEL));
        TaintedSinkValueImpl taintedValue = new TaintedSinkValueImpl("test", String.class, 0, taint);
        Violation violation = ViolationTestUtils.sampleViolation1.copyWithTaintedValues(new HashSet<>());
        violation.addTaintedValue(taintedValue);
        ReplacementImplBuilder builder = new ReplacementImplBuilder()
                .value("value")
                .isPayload(false)
                .baseSource(ViolationTestUtils.SAMPLE_BASE_SOURCE2);
        checkConvertersAndInvocationIDs(
                builder.build(violation),
                Collections.singletonList(null),
                null,
                new int[]{0},
                new int[]{8},
                new int[]{22}
        );
    }

    /* Checks that their is at least one replacement in the specified set for each combination of expected converter and
     * expected invocationIDs. */
    private void checkConvertersAndInvocationIDs(Set<? extends Replacement> replacements, Iterable<? extends ForcedTypeConverter> expectedConverters,
                                                 int[]...expectedInvocationIDs) {
        Map<ForcedTypeConverter, LinkedList<int[]>> map = makeConverterInvocationIDsMap(replacements);
        for(ForcedTypeConverter converter : expectedConverters) {
            assertTrue(map.containsKey(converter));
            assertThat(map.get(converter), containsInAnyOrder(expectedInvocationIDs));
        }
    }

    /* Returns a map from the converters of the specified replacements to the invocation ids of replacements that use that converter. */
    private Map<ForcedTypeConverter, LinkedList<int[]>> makeConverterInvocationIDsMap(Set<? extends Replacement> replacements) {
        HashMap<ForcedTypeConverter, LinkedList<int[]>> map = new HashMap<>();
        for(Replacement replacement : replacements) {
            if(replacement instanceof ReplacementImpl) {
                ForcedTypeConverter key = replacement.getConverter(null, null);
                map.putIfAbsent(key, new LinkedList<>());
                map.get(key).add(((ReplacementImpl) replacement).getTargetedInvocationIDs());
            }
        }
        return map;
    }
}
