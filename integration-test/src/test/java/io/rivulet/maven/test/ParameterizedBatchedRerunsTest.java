package io.rivulet.maven.test;

import io.rivulet.ExpectsRivuletRerun;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizedBatchedRerunsTest extends ViolationCheckingBaseTest {

    private String value;

    public ParameterizedBatchedRerunsTest(String value) {
        this.value = value;
    }

    @Parameterized.Parameters
    public static Collection values() {
        return Arrays.asList(new Object[][] {
                {"lion"},
                {"tiger"},
                {"bear"}
        });
    }

    @Test
    @ExpectsRivuletRerun(numReruns = 2, numCriticalViolations = 2)
    public void testViolations() throws Exception {
        this.value = TestUtils.objSource(value);
        new DummySqlStatement().executeQuery(String.format("SELECT * FROM animal WHERE name = '%s'", value));
        Runtime.getRuntime().exec("echo " + value);
        checkViolationsIncreased(2);
    }
}

