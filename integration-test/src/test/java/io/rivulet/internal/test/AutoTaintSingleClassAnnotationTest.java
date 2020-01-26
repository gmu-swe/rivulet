package io.rivulet.internal.test;

import edu.columbia.cs.psl.phosphor.BasicSourceSinkManager;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import io.rivulet.fuzz.TaintThrough;
import io.rivulet.fuzz.RivuletTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.Collections;

/* Tests the behavior of single class-level Sink, Source, and TaintThrough annotations with the class-level test rule when there
 * is no method level test rule. */
@Source(method = "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/Object;)Ljava/lang/Object;")
@Sink(method = "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/Object;)Ljava/lang/Object;")
@TaintThrough(method = "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/Object;)Ljava/lang/Object;")
public class AutoTaintSingleClassAnnotationTest extends AutoTaintAnnotationBaseTest {

    @ClassRule
    public static RivuletTestRule classTaintRule = new RivuletTestRule();

    /* Checks that only the methods specified at the class-level are the only ones considered to be auto-taint methods
     * regardless of any method-level auto-taint annotations. */
    @Test
    @Source(method = "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/String;)Ljava/lang/String;")
    @Sink(method = "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/String;)Ljava/lang/String;")
    @TaintThrough(method = "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/String;)Ljava/lang/String;")
    public void testOnlyClassLevelAnnotationsUsed() {
        checkAutoMethods(Collections.singleton("io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/Object;)Ljava/lang/Object;"), BasicSourceSinkManager.AutoTaint.SOURCE);
        checkAutoMethods(Collections.singleton("io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/Object;)Ljava/lang/Object;"), BasicSourceSinkManager.AutoTaint.SINK);
        checkAutoMethods(Collections.singleton("io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/Object;)Ljava/lang/Object;"), BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
    }
}


