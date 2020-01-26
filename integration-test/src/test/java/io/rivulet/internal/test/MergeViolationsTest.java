package io.rivulet.internal.test;

import edu.columbia.cs.psl.phosphor.runtime.Taint;
import io.rivulet.internal.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/* Tests post test run violation set processing and merging. */
public class MergeViolationsTest {

    /* Returns a list containing the taintedValues of the specified violation. */
    private LinkedList<TaintedSinkValue> getTaintedValues(Violation v) {
        return new LinkedList<>(v.getTaintedValues());
    }

    /* Checks that the indexInfos of matching IndexedSourceAutoTaintLabels are merged during post-processing. */
    @Test
    public void testIndexInfoMerge() {
        int[][] indices = new int[][]{
                {0, 1, 2, 3, 4, 5},
                {55, 66, 77, 4},
                {0, 1, 10, 11, 12, 13, 14, 15, 9}
        };
        int[] IDs = new int[]{1, 2, 3};
        Violation v = new Violation("Example.sink1([C)V", "Example.sink1([C)V");
        for(int i = 0; i < indices.length; i++) {
            TaintedSinkValueImpl impl = new TaintedSinkValueImpl("test", String.class, 0);
            for(int index : indices[i]) {
                impl.getTaintSources().add(new IndexedSourceInfoTaintLabel("Example.source1([C)V", "Example.source1([C)V",
                        0, char[].class, false, new InvocationRanges(IDs[i], index)));
            }
            v.addTaintedValue(impl);
        }
        v.setTestInfo("ExampleTestClass-1", "ExampleTestClass", "exampleTestMethod");
        LinkedList<TaintedSinkValue> sinkValues = getTaintedValues(new LinkedList<>(TaintedSinkValueSet.mergeViolations(Collections.singletonList(v)).keySet()).pop());
        assertEquals(1, sinkValues.size());
        assertTrue(sinkValues.peek() instanceof TaintedSinkValueSet);
        Set<SourceInfoTaintLabel> labels = sinkValues.pop().getTaintSources();
        assertEquals(1, labels.size());
        SourceInfoTaintLabel label = new LinkedList<>(labels).pop();
        assertTrue(label instanceof ProcessedSourceInfoTaintLabel);
        LinkedHashMap<Integer, InvocationRanges> actualMap = ((ProcessedSourceInfoTaintLabel)label).getIndexInfoMap();
        HashMap<Integer, InvocationRanges> expectedMap = new HashMap<>();
        expectedMap.put(IDs[0], new InvocationRanges(IDs[0], new int[]{0, 6}));
        expectedMap.put(IDs[1], new InvocationRanges(IDs[1], new int[]{4, 5, 55, 56, 66, 67, 77, 78}));
        expectedMap.put(IDs[2], new InvocationRanges(IDs[2], new int[]{0, 2, 9, 16}));
        assertEquals(expectedMap, actualMap);
    }

    /* Checks that the sinkValues of TaintedSinkValues are merged during post-processing and that Violations that are
     * identical except for their sinkValues are merges during post-processing. */
    @Test
    public void testSinkValueMerge() {

        SourceInfoTaintLabel label = new SourceInfoTaintLabel("Example.source1([C)V", "Example.source1([C)V",
                0, char[].class, false);
        Taint<SourceInfoTaintLabel> taint = new Taint<>(label);
        Violation[] violations = new Violation[3];
        for(int i = 0; i < violations.length; i++) {
            violations[i] = new Violation("Example.sink1([C)V", "Example.sink1([C)V");
            violations[i].setTestInfo("ExampleTestClass-1", "ExampleTestClass", "exampleTestMethod");
            TaintedSinkValueImpl impl1 = new TaintedSinkValueImpl("test", String.class, 0, taint);
            TaintedSinkValueImpl impl2 = new TaintedSinkValueImpl("value", String.class, i%2+1, taint);
            TaintedSinkValueImpl impl3 = new TaintedSinkValueImpl("value2", String.class, i%2+1, taint);
            violations[i].addTaintedValue(impl1);
            violations[i].addTaintedValue(impl2);
            violations[i].addTaintedValue(impl3);
        }
        Set<Violation> processedViolations = TaintedSinkValueSet.mergeViolations(Arrays.asList(violations)).keySet();
        assertEquals(2, processedViolations.size());
        for(Violation v : processedViolations) {
            LinkedList<TaintedSinkValue> taintedValues = getTaintedValues(v);
            assertEquals(2, taintedValues.size());
            for(TaintedSinkValue val : taintedValues) {
                assertTrue(val instanceof TaintedSinkValueSet);
                List<String> sinkValues = ((TaintedSinkValueSet)val).getSinkValues();
                if(sinkValues.size() == 1) {
                    assertTrue(sinkValues.contains("test"));
                } else {
                    assertEquals(2, sinkValues.size());
                    assertTrue(sinkValues.contains("value"));
                    assertTrue(sinkValues.contains("value2"));
                }
            }
        }
    }
}
