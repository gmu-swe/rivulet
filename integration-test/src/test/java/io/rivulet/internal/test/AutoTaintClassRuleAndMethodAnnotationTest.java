package io.rivulet.internal.test;

import io.rivulet.fuzz.RivuletTestRule;
import org.junit.ClassRule;

/* Tests the behavior of method-level Sink, Source, and TaintThrough annotations with the class-level and
 * method-level rules. */
public class AutoTaintClassRuleAndMethodAnnotationTest extends AutoTaintMethodAnnotationTest {

    @ClassRule
    public static RivuletTestRule classTaintRule = new RivuletTestRule();
}
