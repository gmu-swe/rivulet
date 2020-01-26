package io.rivulet.internal.rerun.test;

/* Tests the behavior of ReplacementSetBuilder. */

import io.rivulet.internal.rerun.Replacement;
import io.rivulet.internal.rerun.ReplacementImplBuilder;
import io.rivulet.internal.rerun.ReplacementSet;
import io.rivulet.internal.rerun.ReplacementSetBuilder;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ReplacementSetBuilderTest {

    /* Checks that if at least one the builder's add to the ReplacementSetBuilder generates required replacements then the
     * generated replacement sets are considered to be required. */
    @Test
    public void testRequiredReplacementSet() {
        ReplacementImplBuilder builder1 = new ReplacementImplBuilder()
                .value("value1")
                .required(false)
                .isPayload(true);
        ReplacementImplBuilder builder2 = new ReplacementImplBuilder()
                .value("value2")
                .isPayload(true)
                .required(true);
        ReplacementImplBuilder builder3 = new ReplacementImplBuilder()
                .value("value3")
                .required(false)
                .baseSource(ViolationTestUtils.SAMPLE_BASE_SOURCE1);
        ReplacementSetBuilder setBuilder = new ReplacementSetBuilder()
                .addBuilder(builder1)
                .addBuilder(builder2)
                .addBuilder(builder3);
        LinkedHashSet<Replacement> replacements = setBuilder.build(ViolationTestUtils.sampleViolation1);
        for(Replacement r : replacements) {
            assertTrue(r.isRequired());
        }
    }

    /* Check that a ReplacementSetBuilder with a builders list that fails the generation check generates an empty set. */
    @Test
    public void testGenerationCheckFailure() {
        ReplacementImplBuilder builder1 = new ReplacementImplBuilder()
                .value("value1")
                .required(false)
                .isPayload(true)
                .baseSource(ViolationTestUtils.SAMPLE_BASE_SOURCE1);
        ReplacementImplBuilder builder2 = new ReplacementImplBuilder()
                .value("value2")
                .isPayload(true)
                .required(true)
                .baseSource(ViolationTestUtils.SAMPLE_BASE_SOURCE1);
        ReplacementImplBuilder builder3 = new ReplacementImplBuilder()
                .value("value3")
                .required(false)
                .baseSource(ViolationTestUtils.SAMPLE_BASE_SOURCE1);
        ReplacementSetBuilder setBuilder = new ReplacementSetBuilder()
                .addBuilder(builder1)
                .addBuilder(builder2)
                .addBuilder(builder3);
        LinkedHashSet<Replacement> replacements = setBuilder.build(ViolationTestUtils.sampleViolation2);
        assertTrue(replacements.isEmpty());
    }

    /* Checks that that payload builders of a ReplacementSetBuilder that can be bound to a label are and those that can't
     * are removed if they do not have a baseSource set. */
    @Test
    public void testUnboundPayloadBuilders() {
        ReplacementImplBuilder builder1 = new ReplacementImplBuilder()
                .value("value1")
                .required(false)
                .isPayload(true)
                .baseSource(ViolationTestUtils.SAMPLE_BASE_SOURCE1);
        ReplacementImplBuilder builder2 = new ReplacementImplBuilder()
                .value("value2")
                .isPayload(true)
                .required(true)
                .baseSource(ViolationTestUtils.SAMPLE_BASE_SOURCE1)
                .sourceArgIndex(0);
        ReplacementImplBuilder builder3 = new ReplacementImplBuilder()
                .value("value3")
                .required(false)
                .isPayload(true)
                .sourceArgIndex(0);
        ReplacementSetBuilder setBuilder = new ReplacementSetBuilder()
                .addBuilder(builder1)
                .addBuilder(builder2)
                .addBuilder(builder3);
        LinkedHashSet<Replacement> replacements = setBuilder.build(ViolationTestUtils.sampleViolation1);
        assertEquals(1, replacements.size());
        Replacement r = (new LinkedList<>(replacements)).pop();
        assertTrue(r.isApplicable(ViolationTestUtils.SAMPLE_LABEL1.getSourceValueClass(), ViolationTestUtils.SAMPLE_LABEL1));
        assertTrue(r.isApplicable(ViolationTestUtils.SAMPLE_LABEL3.getSourceValueClass(), ViolationTestUtils.SAMPLE_LABEL3));
    }

    /* Checks that a ReplacementSetBuilder generates a set containing all combinations of its builders' sets. */
    @Test
    public void testBuilderCombos() {
        ReplacementImplBuilder builder1 = new ReplacementImplBuilder()
                .value("value")
                .isPayload(true);
        ReplacementImplBuilder builder2 = new ReplacementImplBuilder()
                .value("value")
                .baseSource(ViolationTestUtils.SAMPLE_BASE_SOURCE1)
                .isPayload(false);
        ReplacementSetBuilder setBuilder = new ReplacementSetBuilder()
                .addBuilder(builder1)
                .addBuilder(builder2);
        LinkedHashSet<Replacement> replacements = setBuilder.build(ViolationTestUtils.sampleViolation3);
        LinkedHashSet<Replacement> builder1Replacements = builder1.build(ViolationTestUtils.sampleViolation3);
        LinkedHashSet<Replacement> builder2Replacements = builder2.build(ViolationTestUtils.sampleViolation3);
        HashSet<HashSet<Replacement>> expected = new HashSet<>();
        for(Replacement r1 : builder1Replacements) {
            for(Replacement r2 : builder2Replacements) {
                HashSet<Replacement> pair = new HashSet<>();
                pair.add(r1);
                pair.add(r2);
                expected.add(pair);
            }
        }
        HashSet<HashSet<Replacement>> actual = new HashSet<>();
        for(Replacement replacement : replacements) {
            assertTrue(replacement instanceof ReplacementSet);
            actual.add(new HashSet<>(((ReplacementSet)replacement).getSortedReplacementsCopy()));
        }
        assertEquals(expected, actual);
    }
}
