package io.rivulet.test;

import io.rivulet.maven.test.TestUtils;
import io.rivulet.maven.test.ViolationCheckingBaseTest;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.junit.Test;

@Sink(method = "io/rivulet/maven/test/TestUtils.sink(Ljava/lang/Object;)V")
@Source(method = "io/rivulet/maven/test/TestUtils.objSource(Ljava/lang/Object;)Ljava/lang/Object;")
public class RunIsolationTest extends ViolationCheckingBaseTest {

    @Test
    public void testRunIsolationTaintA() {
        String taintedStr = TestUtils.objSource("Test StringA");
        String nonTaintedStr = "Test StringB";
        TestUtils.sink(taintedStr);
        TestUtils.sink(nonTaintedStr);
        checkViolationsIncreased(1);
    }

    @Test
    public void testRunIsolationTaintB() {
        String taintedStr = TestUtils.objSource("Test StringB");
        String nonTaintedStr = "Test StringA";
        TestUtils.sink(taintedStr);
        TestUtils.sink(nonTaintedStr);
        checkViolationsIncreased(1);
    }
}
