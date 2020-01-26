package io.rivulet.internal.rerun.test;

import edu.columbia.cs.psl.phosphor.runtime.Taint;
import io.rivulet.PhosphorHttpRequestSource;
import io.rivulet.internal.SourceInfoTaintLabel;
import io.rivulet.internal.TaintedSinkValueImpl;
import io.rivulet.internal.Violation;

/* Provides violation and label resources. */
public final class ViolationTestUtils {

    // An example of a source method
    public static final String SAMPLE_BASE_SOURCE1 = "io/rivulet/maven/test/TestUtils.objSource(Ljava/lang/Object;)Ljava/lang/Object;";
    // An example of a label that could be generated at SAMPLE_BASE_SOURCE1
    public static final SourceInfoTaintLabel SAMPLE_LABEL1 =
            new SourceInfoTaintLabel(SAMPLE_BASE_SOURCE1, SAMPLE_BASE_SOURCE1, -1, String.class, true);
    // An example of a violation that could occur from a value tainted with SAMPLE_LABEL1 flowing into a sink
    public static final Violation sampleViolation1 = new Violation("io/rivulet/test/NestedSinkTest.nestedSink(I)V",
            "io/rivulet/test/NestedSinkTest.nestedSink(I)V");
    // An example of a source method
    public static final String SAMPLE_BASE_SOURCE2 = "io/rivulet/maven/test/TestUtils.source()Ljava/lang/String;";
    // An example of a label that could be generated at SAMPLE_BASE_SOURCE2
    public static final SourceInfoTaintLabel SAMPLE_LABEL2 =
            new SourceInfoTaintLabel(SAMPLE_BASE_SOURCE2, SAMPLE_BASE_SOURCE2, -1, String.class, true);
    // An example of a violation that could occur from a value tainted with SAMPLE_LABEL2 flowing into a sink
    public static final Violation sampleViolation2 = new Violation("io/rivulet/test/NestedSinkTest.nestedSink(I)V",
            "io/rivulet/test/NestedSinkTest.nestedSink(I)V");
    // An example of a label that could be generated at SAMPLE_BASE_SOURCE1
    public static final SourceInfoTaintLabel SAMPLE_LABEL3 =
            new SourceInfoTaintLabel(SAMPLE_BASE_SOURCE1, SAMPLE_BASE_SOURCE1, 0, char[].class, true);
    // An example of a violation that could occur from a value tainted with SAMPLE_LABEL1, SAMPLE_LABEL2, and SAMPLE_LABEL3
    // flowing into a sink
    public static final Violation sampleViolation3 = new Violation("io/rivulet/test/NestedSinkTest.nestedSink(I)V",
            "io/rivulet/test/NestedSinkTest.nestedSink(I)V");
    // The source method for getEncodedQuery
    public static final String QUERY_SOURCE = PhosphorHttpRequestSource.ENCODED_QUERY.getSignature();
    // An example of a label that could be generated at QUERY_SOURCE
    public static final SourceInfoTaintLabel SAMPLE_QUERY_LABEL = new SourceInfoTaintLabel(QUERY_SOURCE, QUERY_SOURCE,
            -1, String.class, true);

    static {
        // Set up sampleViolation1
        TaintedSinkValueImpl impl1 = new TaintedSinkValueImpl("test", String.class, 0, new Taint<>(SAMPLE_LABEL1));
        sampleViolation1.setTestInfo("ExampleTestClass-1", "ExampleTestClass", "exampleTestMethod");
        sampleViolation1.addTaintedValue(impl1);
        // Set up sampleViolation2
        TaintedSinkValueImpl impl2 = new TaintedSinkValueImpl("test", String.class, 0, new Taint<>(SAMPLE_LABEL2));
        sampleViolation2.setTestInfo("ExampleTestClass-2", "ExampleTestClass", "exampleTestMethod");
        sampleViolation2.addTaintedValue(impl2);
        // Set up sampleViolation3
        TaintedSinkValueImpl impl3 = new TaintedSinkValueImpl("test", String.class, 0, new Taint<>(SAMPLE_LABEL3));
        sampleViolation3.setTestInfo("ExampleTestClass-3", "ExampleTestClass", "exampleTestMethod");
        sampleViolation3.addTaintedValue(impl1);
        sampleViolation3.addTaintedValue(impl2);
        sampleViolation3.addTaintedValue(impl3);
    }
}
