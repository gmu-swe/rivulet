package io.rivulet.test;

import io.rivulet.maven.test.TestUtils;
import io.rivulet.maven.test.ViolationCheckingBaseTest;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.junit.Test;

@Source(method = "io/rivulet/maven/test/TestUtils.source()I")
@Source(method = "io/rivulet/maven/test/TestUtils.objSource(Ljava/lang/Object;)Ljava/lang/Object;")
@Sink(method = "io/rivulet/maven/test/TestUtils.sink(Ljava/lang/Object;)V")
public class DeepSourceTest extends ViolationCheckingBaseTest {

    public static class DeepTaintHolder {
       public int x;
       public int[] intArr;
       public int[][] intDoubleArr;
       public String str;
       public String[] strArr;
       public String[][] strDoubleArr;
    }

    /* Tests that supplying an untainted object with a tainted integer field to a sink results in a violation. */
    @Test
    public void testTaintedPrimitiveField() {
        DeepTaintHolder untaintedObj = new DeepTaintHolder();
        untaintedObj.x = TestUtils.source();
        TestUtils.sink(untaintedObj);
        checkViolationsIncreased();
    }

    /* Tests that supplying an untainted object with a field that is an array of tainted primitives to a sink results
     * in a violation. */
    @Test
    public void testTaintedPrimitiveArrayField() {
        DeepTaintHolder untaintedObj = new DeepTaintHolder();
        untaintedObj.intArr = new int[]{TestUtils.source(), TestUtils.source()};
        TestUtils.sink(untaintedObj);
        checkViolationsIncreased();
    }

    /* Tests that supplying an untainted object with a field that is a 2D array of tainted primitives to a sink results
     * in a violation. */
    @Test
    public void testTaintedPrimitive2DArrayField() {
        DeepTaintHolder untaintedObj = new DeepTaintHolder();
        int[] temp = new int[]{TestUtils.source(), TestUtils.source()};
        untaintedObj.intDoubleArr = new int[][]{temp, temp};
        TestUtils.sink(untaintedObj);
        checkViolationsIncreased();
    }

    /* Tests that supplying an untainted object with a field that is a tainted Object to a sink results in a violation. */
    @Test
    public void testTaintedObjectField() {
        DeepTaintHolder untaintedObj = new DeepTaintHolder();
        String temp = new String("Example String");
        untaintedObj.str = TestUtils.objSource(temp);
        TestUtils.sink(untaintedObj);
        checkViolationsIncreased();
    }

    /* Tests that supplying an untainted object with a field that is an array of tainted Objects to a sink results in a
     * violation. */
    @Test
    public void testTaintedObjectArrayField() {
        DeepTaintHolder untaintedObj = new DeepTaintHolder();
        String[] temp = new String[]{new String("String 1"), new String("String 2")};
        untaintedObj.strArr = TestUtils.objSource(temp);
        TestUtils.sink(untaintedObj);
        checkViolationsIncreased();
    }

    /* Tests that supplying an untainted object with a field that is a 2D array of tainted Objects to a sink results in a
     * violation. */
    @Test
    public void testTaintedObject2DArrayField() {
        DeepTaintHolder untaintedObj = new DeepTaintHolder();
        String[] temp = new String[]{new String("String 1"), new String("String 2")};
        untaintedObj.strDoubleArr = new String[][]{TestUtils.objSource(temp), TestUtils.objSource(temp)};
        TestUtils.sink(untaintedObj);
        checkViolationsIncreased();
    }
}
