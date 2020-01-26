package io.rivulet.maven.test.securibench;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.junit.Test;

/* Pred2 was omitted because it does not consistently demonstrate a violating flow - it is dependent on
 * a random value. */
@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Sink(method = "java/nio/channels/SocketChannel.write(Ljava/nio/ByteBuffer;)I")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;II)J")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;)J")
public class SecuribenchMicroPredTest extends SecuribenchMicroBaseTest {

    /* No violation - branch containing violating flow is never executed. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testPred1() throws Exception {
        testPath("Pred1", 200, false);
    }

    /* No violation - branch containing violating flow is never executed. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testPred3() throws Exception {
        testPath("Pred3", 200, false);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testPred4() throws Exception {
        testPath("Pred4", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testPred5() throws Exception {
        testPath("Pred5", 200, true);
    }

    /* No violation - branch containing violating flow is never executed. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testPred6() throws Exception {
        testPath("Pred6", 200, false);
    }

    /* No violation - branch containing violating flow is never executed. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testPred7() throws Exception {
        testPath("Pred7", 200, false);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testPred8() throws Exception {
        testPath("Pred8", 200, true);
    }

    /* No violation - the String "abc" is always written to the sink. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testPred9() throws Exception {
        testPath("Pred9", 200, false);
    }
}


