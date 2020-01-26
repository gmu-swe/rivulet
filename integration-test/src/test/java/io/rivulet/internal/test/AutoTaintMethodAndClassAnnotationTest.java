package io.rivulet.internal.test;

import edu.columbia.cs.psl.phosphor.BasicSourceSinkManager;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import io.rivulet.fuzz.TaintThrough;
import io.rivulet.fuzz.RivuletTestRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Tests the behavior of class-level and method-level Sink, Source, and TaintThrough annotations with the class-level and
 * method-level rules. */
@Source(method = "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/Object;)Ljava/lang/Object;")
@Sink(method = "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/Object;)Ljava/lang/Object;")
@TaintThrough(method = "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/Object;)Ljava/lang/Object;")
public class AutoTaintMethodAndClassAnnotationTest extends AutoTaintAnnotationBaseTest {

    @ClassRule
    public static RivuletTestRule classTaintRule = new RivuletTestRule();
    @Rule
    public RivuletTestRule methodTaintRule = new RivuletTestRule();

    /* Checks that if a method level annotation is used it replaces the class level annotation. */
    @Test
    @Source(method = "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/String;)Ljava/lang/String;")
    @Sink(method = "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/String;)Ljava/lang/String;")
    @TaintThrough(method = "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/String;)Ljava/lang/String;")
    public void testOnlyMethodLevelAnnotationsUsed() {
        checkAutoMethods(Collections.singleton("io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/String;)Ljava/lang/String;"), BasicSourceSinkManager.AutoTaint.SOURCE);
        checkAutoMethods(Collections.singleton("io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/String;)Ljava/lang/String;"), BasicSourceSinkManager.AutoTaint.SINK);
        checkAutoMethods(Collections.singleton("io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/String;)Ljava/lang/String;"), BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
    }

    /* Checks that if no method level annotation is used, the class level annotation is used. */
    @Test
    public void testNoMethodLevelAnnotations() {
        checkAutoMethods(Collections.singleton("io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/Object;)Ljava/lang/Object;"), BasicSourceSinkManager.AutoTaint.SOURCE);
        checkAutoMethods(Collections.singleton("io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/Object;)Ljava/lang/Object;"), BasicSourceSinkManager.AutoTaint.SINK);
        checkAutoMethods(Collections.singleton("io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/Object;)Ljava/lang/Object;"), BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
    }

    /* Checks that the auto-taint method set is as expected when a mix of class and method level annotations are used. */
    @Test
    @Source(method = "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/Object;)Ljava/lang/Object;")
    @Source(method = "io/rivulet/test/RivuletAnnotationBaseTest.source(I)I")
    @Sink(method = "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/String;)Ljava/lang/String;")
    public void testMethodAndClassLevelMixedAnnotations() {
        List<String> expectedSources = Arrays.asList(
                "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/Object;)Ljava/lang/Object;",
                "io/rivulet/test/RivuletAnnotationBaseTest.source(I)I"
        );
        checkAutoMethods(expectedSources, BasicSourceSinkManager.AutoTaint.SOURCE);
        checkAutoMethods(Collections.singleton("io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/String;)Ljava/lang/String;"), BasicSourceSinkManager.AutoTaint.SINK);
        checkAutoMethods(Collections.singleton("io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/Object;)Ljava/lang/Object;"), BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
    }
}

