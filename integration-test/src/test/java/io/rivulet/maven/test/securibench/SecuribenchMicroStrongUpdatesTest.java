package io.rivulet.maven.test.securibench;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.junit.Test;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Sink(method = "java/nio/channels/SocketChannel.write(Ljava/nio/ByteBuffer;)I")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;II)J")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;)J")
public class SecuribenchMicroStrongUpdatesTest extends SecuribenchMicroBaseTest {

    /* No violation - the String "abc" is always written to the sink. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testStrongUpdates1() throws Exception {
        testPath("StrongUpdates1", 200, false);
    }

    /* No violation - the String "abc" is always written to the sink. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testStrongUpdates2() throws Exception {
        testPath("StrongUpdates2", 200, false);
    }

    /* No violation - the String "abc" is always written to the sink. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testStrongUpdates3() throws Exception {
        testPath("StrongUpdates3", 200, false);
    }

    /* No violation - the String "abc" is always written to the sink. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testStrongUpdates4() throws Exception {
        testPath("StrongUpdates4", 200, false);
    }

    /* No violation - a NullPointerException is thrown before anything is written to the sink. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testStrongUpdates5() throws Exception {
        testPath("StrongUpdates5", 500, false);
    }
}

