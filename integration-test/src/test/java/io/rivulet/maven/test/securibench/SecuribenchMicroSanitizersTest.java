package io.rivulet.maven.test.securibench;

import io.rivulet.ExpectsRivuletRerun;
import org.junit.Test;

/* Unsafe redirect tests, Sanitizers3 and Sanitizers5, are omitted. */
public class SecuribenchMicroSanitizersTest extends SecuribenchMicroBaseTest {
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSanitizers1() throws Exception {
        testPath("Sanitizers1", 200, true);
    }

    /* No critical violation - the sanitizer will prevent the attack. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE)
    public void testSanitizers2() throws Exception {
        testPath("Sanitizers2", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSanitizers4() throws Exception {
        testPath("Sanitizers4", 200, true);
    }

    /* No critical violation - the sanitizer will prevent the attack. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE)
    public void testSanitizers6() throws Exception {
        testPath("Sanitizers6", 200, true);
    }
}

