package io.rivulet.maven.test.securibench;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;

@Ignore
@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Sink(method = "java/nio/channels/SocketChannel.write(Ljava/nio/ByteBuffer;)I")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;II)J")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;)J")
public class SecuribenchMicroFlakyTest extends SecuribenchMicroBaseTest {

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic2() throws Exception {
        testPathUntilDifferentResponsesSeen("Basic2", true, 2);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic4() throws Exception {
        testPathUntilDifferentResponsesSeen("Basic4", true, 2);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testPred2() throws Exception {
        testPathUntilDifferentResponsesSeen("Pred2", true, 2);
    }

    /* Tests the specified path until the specified number of different responses is seen. */
    private void testPathUntilDifferentResponsesSeen(String page, boolean violationExpected, int numDiffResponses) throws Exception {
        HashSet<String> bodies = new HashSet<>();
        while(bodies.size() < numDiffResponses) {
            bodies.add(getResponseBodyForPage(page));
        }
        if(violationExpected) {
            checkViolationsIncreased();
        } else {
            checkViolationsIncreased(0);
        }
    }
}


