package io.rivulet.internal.test;

import edu.columbia.cs.psl.phosphor.BasicSourceSinkManager;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import io.rivulet.fuzz.TaintThrough;
import io.rivulet.fuzz.RivuletTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/* Tests the behavior of multiple class-level Sink, Source, and TaintThrough annotations with the class-level test rule when there
 * is no method level test rule. */
@Source(method = "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/Object;)Ljava/lang/Object;")
@Source(method = "io/rivulet/test/RivuletAnnotationBaseTest.source(I)I")
@Sink(method = "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/Object;)Ljava/lang/Object;")
@Sink(method = "io/rivulet/test/RivuletAnnotationBaseTest.sink(I)I")
@TaintThrough(method = "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/Object;)Ljava/lang/Object;")
@TaintThrough(method = "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(I)I")
public class AutoTaintMultipleClassAnnotationTest extends AutoTaintAnnotationBaseTest {

    @ClassRule
    public static RivuletTestRule classTaintRule = new RivuletTestRule();

    /* Checks that only the methods specified at the class level are considered to be auto-taint methods regardless of any
     * method-level auto-taint annotations. */
    @Test
    @Source(method = "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/String;)Ljava/lang/String;")
    @Sink(method = "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/String;)Ljava/lang/String;")
    @TaintThrough(method = "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/String;)Ljava/lang/String;")
    public void testOnlyClassLevelAnnotationsUsed() {
        List<String> expectedSources = Arrays.asList(
                "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/Object;)Ljava/lang/Object;",
                "io/rivulet/test/RivuletAnnotationBaseTest.source(I)I"
        );
        List<String> expectedSinks= Arrays.asList(
                "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/Object;)Ljava/lang/Object;",
                "io/rivulet/test/RivuletAnnotationBaseTest.sink(I)I"
        );
        List<String> expectedTaintThroughs= Arrays.asList(
                "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/Object;)Ljava/lang/Object;",
                "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(I)I"
        );
        checkAutoMethods(expectedSources, BasicSourceSinkManager.AutoTaint.SOURCE);
        checkAutoMethods(expectedSinks, BasicSourceSinkManager.AutoTaint.SINK);
        checkAutoMethods(expectedTaintThroughs, BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
    }
}


