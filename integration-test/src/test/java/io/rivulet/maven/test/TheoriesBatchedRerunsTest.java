package io.rivulet.maven.test;

import io.rivulet.ExpectsRivuletRerun;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoriesBatchedRerunsTest extends ViolationCheckingBaseTest {

    @DataPoints
    public static String[] values() {
        return new String[]{"lion","tiger", "bear"};
    }

    @DataPoint
    public static Boolean shouldTaint = true;

    @Theory
    @ExpectsRivuletRerun(numReruns = 2, numCriticalViolations = 2)
    public void testViolations(Boolean shouldTaint, String value) throws Exception {
        if(shouldTaint) {
            value = TestUtils.objSource(value);
        }
        new DummySqlStatement().executeQuery(String.format("SELECT * FROM animal WHERE name = '%s'", value));
        Runtime.getRuntime().exec("echo " + value);
        checkViolationsIncreased(shouldTaint ? 2 : 0);
    }
}

