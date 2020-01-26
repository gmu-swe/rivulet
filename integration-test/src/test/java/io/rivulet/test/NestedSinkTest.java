package io.rivulet.test;

import io.rivulet.internal.RivuletAutoTaintWrapper;
import io.rivulet.maven.test.TestUtils;
import io.rivulet.maven.test.ViolationCheckingBaseTest;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import io.rivulet.internal.Violation;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@Source(method = "io/rivulet/maven/test/TestUtils.objSource(Ljava/lang/Object;)Ljava/lang/Object;")
@Source(method = "io/rivulet/maven/test/TestUtils.source()I")
@Sink(method = "io/rivulet/maven/test/TestUtils.exceptionThrowingSink2(Ljava/lang/Object;)V")
@Sink(method = "io/rivulet/maven/test/TestUtils.sink(Ljava/lang/Object;)V")
@Sink(method = "io/rivulet/test/NestedSinkTest.nestedSink(Ljava/lang/String;)V")
@Sink(method = "io/rivulet/test/NestedSinkTest.nestedSink(I)V")
@Sink(method = "io/rivulet/maven/test/TestUtils.exceptionRethrowingSink(Ljava/lang/Object;)I")
@Sink(method = "io/rivulet/maven/test/TestUtils.exceptionThrowingSink(Ljava/lang/Object;)V")
@Sink(method = "io/rivulet/test/NestedSinkTest.nestedSinkPassInnerSinkTaintedValue(I)V")
@Sink(method = "io/rivulet/maven/test/TestUtils.sink(I)V")
@Sink(method = "io/rivulet/test/NestedSinkTest.nestedWaitingSink(I)V")
public class NestedSinkTest extends ViolationCheckingBaseTest {

    // Used for ensuring a particular order between threads making nested calls
    private static CountDownLatch latch;

    // Used to provide unique values to sinks
    private static final AtomicInteger count = new AtomicInteger(0);

    public static void nestedSink(int i) {
        TestUtils.sink(i+count.getAndIncrement());
    }

    public static void nestedSink(String o) {
        TestUtils.sink(o+count.getAndIncrement());
    }

    public static void nestedWaitingSink(int i) {
        try {
            latch.countDown();
            latch.await();
            TestUtils.sink(i+count.getAndIncrement());
        } catch (InterruptedException e) {
            fail("Unexpected interruption.");
        }
    }

    /* A sink method that always passes the sink method it calls a tainted value */
    public static void nestedSinkPassInnerSinkTaintedValue(int i) {
        TestUtils.sink(TestUtils.source()+count.getAndIncrement());
    }

    /* A non-sink method that always passes the sink method it calls a tainted value. */
    public static void nestedSinkPassInnerSinkTaintedValue() {
        TestUtils.sink(TestUtils.source()+count.getAndIncrement());
    }

    /* Tests that passing a sink method a tainted value that calls another sink method with that same tainted value results
     * in a violation being reported for only the "outermost" sink. */
    @Test
    public void testNestedSink() {
        int taintedInt = TestUtils.source();
        nestedSink(taintedInt);
        checkViolationsIncreased(1);
        assertTrue("Expected only outermost sink to report violation.", getViolations().getLast().getBaseSink().contains("nestedSink"));
    }

    /* Tests that passing a sink method a tainted object value that calls another sink method with that same tainted value results
     * in a violation being reported for only the "outermost" sink. */
    @Test
    public void testNestedObjectSink() {
        String taintedStr = TestUtils.objSource(new String("Test String")) ;
        nestedSink(taintedStr);
        checkViolationsIncreased(1);
        assertTrue("Expected only outermost sink to report violation.", getViolations().getLast().getBaseSink().contains("nestedSink"));
    }

    /* Tests that only the "outermost" tainted sink is reported for multiple threads. */
    @Test
    public void testMultipleThreadsNestedSink() throws Exception {
        int taintedInt = TestUtils.source();
        Thread[] threads = new Thread[2];
        latch = new CountDownLatch(threads.length);
        for(int i = 0; i < threads.length; i++) {
            final int temp = i;
            threads[i] = new Thread(() -> {
                nestedWaitingSink(taintedInt+temp);
            });
            threads[i].start();
        }
        for(Thread t : threads) {
            t.join();
        }
        checkViolationsIncreased();
        for(Violation v : getViolations()) {
            assertTrue("Expected only outermost sinks to report violations.", v.getBaseSink().contains("nestedWaitingSink"));
        }
    }

    /* Tests that multiple calls to the same method where on the first call the outer sink and inner sink are passed tainted
     * values and on the second one only the inner sink is passed the tainted value results in only the first outer sink
     * and the second inner sink reporting violations */
    @Test
    public void testMultipleCallsToSameMethod() {
        int taintedInt = TestUtils.source();
        nestedSinkPassInnerSinkTaintedValue(taintedInt);
        nestedSinkPassInnerSinkTaintedValue(20);
        checkViolationsIncreased(2);
        assertTrue("Expected inner sink to report violation.", getViolations().getLast().getBaseSink().contains("sink"));
    }

    /* Tests that an overloaded non-sink method does not get mistaken for a sink method that reported a violation. */
    @Test
    public void testCallsToOverloadedNonSink() {
        int taintedInt = TestUtils.source();
        nestedSinkPassInnerSinkTaintedValue(taintedInt);
        nestedSinkPassInnerSinkTaintedValue();
        checkViolationsIncreased(2);
        if(RivuletAutoTaintWrapper.getViolations().size() >= 1) {
            assertTrue("Expected inner sink to report violation.", getViolations().getLast().getBaseSink().contains("sink"));
        }
    }

    /* Tests that throwing an exception in a sink and catching it does not cause future sinks to think that they are
     * nested. This exception is not from an explicit call no throw. */
    @Test
    public void testImplicitExceptionInSink() {
        String taintedStr = TestUtils.objSource(new String("Test String2"));
        try {
            TestUtils.exceptionThrowingSink(taintedStr);
            fail("Expected an exception to still be thrown.");
        } catch(Throwable t) {
            assertTrue("Expected an ArrayIndexOutOfBoundsException to be thrown.", t instanceof ArrayIndexOutOfBoundsException);
        }
        TestUtils.sink(taintedStr);
        checkViolationsIncreased(2);
    }

    /* Tests that throwing an exception in a sink and catching it does not cause future sinks to think that they are
     * nested. This exception is from an explicit call to throw. */
    @Test
    public void testExplicitExceptionInSink() {
        String taintedStr = TestUtils.objSource(new String("Test String2"));
        try {
            TestUtils.exceptionThrowingSink2(taintedStr);
            fail("Expected an exception to still be thrown.");
        } catch(Throwable t) {
            assertTrue("Expected a RuntimeException to be thrown.", t instanceof RuntimeException);
        }
        TestUtils.sink(taintedStr);
        checkViolationsIncreased(2);
    }

    @Test
    public void testExceptionHandlingInSink() {
        String taintedStr = TestUtils.objSource(new String("Test String3"));
        try {
            TestUtils.exceptionRethrowingSink(taintedStr);
            fail("Expected an exception to still be thrown.");
        } catch(Throwable t) {
            assertTrue("Expected an ArrayIndexOutOfBoundsException to be thrown.", t instanceof ArrayIndexOutOfBoundsException);
        }
        TestUtils.sink(taintedStr);
        checkViolationsIncreased(2);
    }
}
