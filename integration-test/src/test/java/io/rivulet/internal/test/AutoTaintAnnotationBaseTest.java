package io.rivulet.internal.test;

import edu.columbia.cs.psl.phosphor.BasicSourceSinkManager;

import java.util.*;

import static org.junit.Assert.assertEquals;

/* Provides arbitrary methods which can be specified as auto-taint methods in subclass test classes. */
public abstract class AutoTaintAnnotationBaseTest {

    // List containing the bytecode signatures of the methods of this class. */
    private static final List<String> methodSignatures = Arrays.asList(
            "io/rivulet/test/RivuletAnnotationBaseTest.<init>()V",
            "io/rivulet/test/RivuletAnnotationBaseTest.checkAutoMethods(Ljava/util/Set;Ledu/columbia/cs/psl/phosphor/BasicSourceSinkManager$AutoTaint;)V",
            "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/Object;)Ljava/lang/Object;",
            "io/rivulet/test/RivuletAnnotationBaseTest.source(I)I",
            "io/rivulet/test/RivuletAnnotationBaseTest.source(Ljava/lang/String;)Ljava/lang/String;",
            "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/Object;)Ljava/lang/Object;",
            "io/rivulet/test/RivuletAnnotationBaseTest.sink(I)I",
            "io/rivulet/test/RivuletAnnotationBaseTest.sink(Ljava/lang/String;)Ljava/lang/String;",
            "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/Object;)Ljava/lang/Object;",
            "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(I)I",
            "io/rivulet/test/RivuletAnnotationBaseTest.taintThrough(Ljava/lang/String;)Ljava/lang/String;"
    );

    /* Checked that the set of methods for this class that are considered to be the specified auto-taint type is exactly
     * the specified set formed from the specified collection. */
    public static void checkAutoMethods(Collection<String> expected, BasicSourceSinkManager.AutoTaint autoTaint) {
        HashSet<String> expectedSet = new HashSet<>(expected);
        Set<String> actualSet = new HashSet<>();
        for(String methodSignature : methodSignatures) {
            switch(autoTaint) {
                case SOURCE:
                    if(BasicSourceSinkManager.getInstance().isSource(methodSignature)) {
                        actualSet.add(methodSignature);
                    }
                    break;
                case SINK:
                    if(BasicSourceSinkManager.getInstance().isSink(methodSignature)) {
                        actualSet.add(methodSignature);
                    }
                    break;
                case TAINT_THROUGH:
                    if(BasicSourceSinkManager.getInstance().isTaintThrough(methodSignature)) {
                        actualSet.add(methodSignature);
                    }
                    break;
            }
        }
        assertEquals(expectedSet, actualSet);
    }

    @SuppressWarnings("unused")
    public Object source(Object obj) {
        return obj;
    }

    @SuppressWarnings("unused")
    public int source(int i) {
        return i;
    }

    @SuppressWarnings("unused")
    public String source(String s) {
        return s;
    }

    @SuppressWarnings("unused")
    public Object sink(Object obj) {
        return obj;
    }

    @SuppressWarnings("unused")
    public int sink(int i) {
        return i;
    }

    @SuppressWarnings("unused")
    public String sink(String s) {
       return s;
    }

    @SuppressWarnings("unused")
    public Object taintThrough(Object obj) {
        return obj;
    }

    @SuppressWarnings("unused")
    public int taintThrough(int i) {
        return i;
    }

    @SuppressWarnings("unused")
    public String taintThrough(String s) {
        return s;
    }
}
