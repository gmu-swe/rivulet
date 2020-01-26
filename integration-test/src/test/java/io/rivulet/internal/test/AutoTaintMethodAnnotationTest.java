package io.rivulet.internal.test;

import edu.columbia.cs.psl.phosphor.BasicSourceSinkManager;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import io.rivulet.fuzz.TaintThrough;
import io.rivulet.fuzz.RivuletTestRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* Tests the behavior of method-level Sink, Source, and TaintThrough annotations with the method-level test rule when there
 * is no class level test rule. */
public class AutoTaintMethodAnnotationTest extends AutoTaintAnnotationBaseTest {

    @Rule
    public RivuletTestRule methodTaintRule = new RivuletTestRule();

    /* Checks that during the execution of a test method with a single Source annotation only the method specified in
     * that Source annotation is considered to be a source. */
    @Test
    @Source(method = "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/Object;)Ljava/lang/Object;")
    public void testSingleSource() {
        checkAutoMethods(Collections.singleton("io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/Object;)Ljava/lang/Object;"), BasicSourceSinkManager.AutoTaint.SOURCE);
        // Check that none of RivuletAnnotationBaseTest's methods are considered to be sink or taintThrough methods
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.SINK);
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
    }

    /* Checks that during the execution of a test method with a single Sink annotation only the method specified in that
     * Sink annotation is considered to be a sink method. */
    @Test
    @Sink(method = "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/Object;)Ljava/lang/Object;")
    public void testSingleSink() {
        checkAutoMethods(Collections.singleton("io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/Object;)Ljava/lang/Object;"), BasicSourceSinkManager.AutoTaint.SINK);
        // Check that none of RivuletAnnotationBaseTest's methods are considered to be source or taintThrough methods
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.SOURCE);
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
    }

    /* Checks that during the execution of a test method with a single TaintThrough annotation only the method specified
     * in that TaintThrough annotation is considered to be a taintThrough method. */
    @Test
    @TaintThrough(method = "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/Object;)Ljava/lang/Object;")
    public void testSingleTaintThrough() {
        checkAutoMethods(Collections.singleton("io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/Object;)Ljava/lang/Object;"), BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
        // Check that none of RivuletAnnotationBaseTest's methods are considered to be source or sink methods
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.SOURCE);
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.SINK);
    }

    /* Checks that during the execution of a test method with multiple Source annotations only the methods specified in
     * those annotations are considered to be source methods. */
    @Test
    @Source(method = "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/Object;)Ljava/lang/Object;")
    @Source(method = "io/rivulet/test/RivuletAnnotationBaseTest.source(I)I")
    @Source(method = "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/String;)Ljava/lang/String;")
    public void testMultipleSource() {
        List<String> expected = Arrays.asList(
                "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/Object;)Ljava/lang/Object;",
                "io/rivulet/test/RivuletAnnotationBaseTest.source(I)I",
                "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/String;)Ljava/lang/String;"
        );
        checkAutoMethods(expected, BasicSourceSinkManager.AutoTaint.SOURCE);
        // Check that none of RivuletAnnotationBaseTest's methods are considered to be sink or taintThrough methods
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.SINK);
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
    }

    /* Checks that during the execution of a test method with multiple Sink annotations only the methods specified in
     * those annotations are considered to be sink methods. */
    @Test
    @Sink(method = "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/Object;)Ljava/lang/Object;")
    @Sink(method = "io/rivulet/test/RivuletAnnotationBaseTest.sink(I)I")
    @Sink(method = "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/String;)Ljava/lang/String;")
    public void testMultipleSink() {
        List<String> expected = Arrays.asList(
                "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/Object;)Ljava/lang/Object;",
                "io/rivulet/test/RivuletAnnotationBaseTest.sink(I)I",
                "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/String;)Ljava/lang/String;"
        );
        checkAutoMethods(expected, BasicSourceSinkManager.AutoTaint.SINK);
        // Check that none of RivuletAnnotationBaseTest's methods are considered to be source or taintThrough methods
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.SOURCE);
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
    }

    /* Checks that during the execution of a test method with multiple TaintThrough annotations only the methods specified in
     * those annotations are considered to be taintThrough methods. */
    @Test
    @TaintThrough(method = "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/Object;)Ljava/lang/Object;")
    @TaintThrough(method = "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(I)I")
    @TaintThrough(method = "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/String;)Ljava/lang/String;")
    public void testMultipleTaintThrough() {
        List<String> expected = Arrays.asList(
                "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/Object;)Ljava/lang/Object;",
                "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(I)I",
                "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/String;)Ljava/lang/String;"
        );
        checkAutoMethods(expected, BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
        // Check that none of RivuletAnnotationBaseTest's methods are considered to be source or sink methods
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.SOURCE);
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.SINK);
    }

    /* Checks that during the execution of a test method with a mix of auto-taint annotations only the methods specified in
     * those annotations are considered to be auto-taint methods. */
    @Test
    @Source(method = "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/Object;)Ljava/lang/Object;")
    @Source(method = "io/rivulet/test/RivuletAnnotationBaseTest.source(I)I")
    @Sink(method = "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/String;)Ljava/lang/String;")
    public void testMixedAnnotations() {
        List<String> expectedSources = Arrays.asList(
                "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/Object;)Ljava/lang/Object;",
                "io/rivulet/test/RivuletAnnotationBaseTest.source(I)I"
        );
        checkAutoMethods(expectedSources, BasicSourceSinkManager.AutoTaint.SOURCE);
        checkAutoMethods(Collections.singleton("io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/String;)Ljava/lang/String;"), BasicSourceSinkManager.AutoTaint.SINK);
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
    }

    /* Checks that the default auto-taint methods are used when no auto-taint annotations are specified. */
    @Test
    public void testNoAnnotations() {
        // Check that none of RivuletAnnotationBaseTest's methods are considered to be source, sink or taintThrough methods
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.SOURCE);
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.SINK);
        checkAutoMethods(new LinkedList<>(), BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
    }
}


