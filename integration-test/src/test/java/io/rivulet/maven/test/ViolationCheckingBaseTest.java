package io.rivulet.maven.test;

import io.rivulet.fuzz.RivuletTestRule;
import io.rivulet.internal.RivuletAutoTaintWrapper;
import io.rivulet.internal.Violation;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class ViolationCheckingBaseTest {

    @ClassRule
    public static RivuletTestRule classTaintRule = new RivuletTestRule();

    @Rule
    public RivuletTestRule methodTaintRule = new RivuletTestRule();

    // The number of violations before the test was run
    private int previousViolations;

    /* Records the number of violations prior to a test starting */
    @Before
    public void recordPreviousViolations() {
        previousViolations = RivuletAutoTaintWrapper.getNumberOfViolations();
    }

    /* Checks that the number of violations increases by the expected amount if the current test is not an ifc generated rerun. */
    public void checkViolationsIncreased(int expected) {
        if(!methodTaintRule.isRivuletRerun()) {
            int actual = RivuletAutoTaintWrapper.getNumberOfViolations() - previousViolations;
            assertEquals(expected, actual);
        }
    }

    /* Checks that the number of violations increased by any amount if the current test is not an ifc generated rerun. */
    public void checkViolationsIncreased() {
        if(!methodTaintRule.isRivuletRerun()) {
            int actual = RivuletAutoTaintWrapper.getNumberOfViolations() - previousViolations;
            assertTrue("Expected the number of violations to be greater than 0.",actual > 0);
        }
    }

    /* Returns a shallow copy of the violations reported whose test run number matches the current one. */
    public LinkedList<Violation> getViolations() {
        return new LinkedList<>(RivuletAutoTaintWrapper.getViolations());
    }
}
