package io.rivulet.maven.test.securibench;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.junit.Test;

/* Basic2 and Basic4 were omitted because they do not consistently demonstrate a violating flow - they are dependent on
 * a random value.
 *
 * Path traversal tests, Basic22 and Basic 23 were omitted.
 *
 * Unsafe redirect test, Basic24 was omitted.
 *
 * Basic35 was omitted because it is an infinite loop which causes an OutOfMemoryError. */
@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Sink(method = "java/nio/channels/SocketChannel.write(Ljava/nio/ByteBuffer;)I")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;II)J")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;)J")
public class SecuribenchMicroBasicTest extends SecuribenchMicroBaseTest {

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic1() throws Exception {
        testPath("Basic1", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic3() throws Exception {
        testPath("Basic3", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic5() throws Exception {
        testPath("Basic5", 200, true);
    }

    /* No violation - the String ":" is always written to the sink. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testBasic6() throws Exception {
        testPath("Basic6", 200, false);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic7() throws Exception {
        testPath("Basic7", 200, true);
    }

    /* No violation - the else branch containing the violating flow never executes. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testBasic8() throws Exception {
        testPath("Basic8", 200, false);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic9() throws Exception {
        testPath("Basic9", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic10() throws Exception {
        testPath("Basic10", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic11() throws Exception {
        testPath("Basic11", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic12() throws Exception {
        testPath("Basic12", 200, true);
    }

    /* No violation - init parameters are not usually user controlled. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testBasic13() throws Exception {
        testPath("Basic13", 200, false);
    }

    /* No violation - init parameters are not usually user controlled. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testBasic14() throws Exception {
        testPath("Basic14", 200, false);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic15() throws Exception {
        testPath("Basic15", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic16() throws Exception {
        testPath("Basic16", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic17() throws Exception {
        testPath("Basic17", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic18() throws Exception {
        testPath("Basic18", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;)Ljava/sql/PreparedStatement;")
    public void testBasic19() throws Exception {
        testPath("Basic19", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Sink(method = "java/sql/Statement.execute(Ljava/lang/String;)Z")
    public void testBasic20() throws Exception {
        testPath("Basic20", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Sink(method = "java/sql/Statement.executeQuery(Ljava/lang/String;)Ljava/sql/ResultSet;")
    @Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;)I")
    public void testBasic21() throws Exception {
        testPath("Basic21", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic25() throws Exception {
        testPath("Basic25", 200, true);
    }

    /* No violation - getParameterMap returns a map from Strings to arrays of Strings so the entry's value will be a
     * String array and what will be passed to the sink will be something like [Ljava.lang.String;@2e4e5f6b. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testBasic26() throws Exception {
        testPath("Basic26", 200, false);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic27() throws Exception {
        testPath("Basic27", 200, true);
    }

    /* No violation - neither of the branches containing violating flows ever execute. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testBasic28() throws Exception {
        testPath("Basic28", 200, false);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic29() throws Exception {
        testPath("Basic29", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic30() throws Exception {
        testPath("Basic30", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getCookieHeader()Ljava/lang/String;")
    public void testBasic31() throws Exception {
        testPath("Basic31", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getAcceptLanguageHeader()Ljava/lang/String;")
    public void testBasic32() throws Exception {
        testPath("Basic32", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getAcceptLanguageHeader()Ljava/lang/String;")
    public void testBasic33() throws Exception {
        testPath("Basic33", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getAcceptLanguageHeader()Ljava/lang/String;")
    public void testBasic34() throws Exception {
        testPath("Basic34", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getEntityBody()Ljava/lang/String;")
    public void testBasic36() throws Exception {
        testPath("Basic36", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic37() throws Exception {
        testPath("Basic37", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic38() throws Exception {
        testPath("Basic38", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic39() throws Exception {
        testPath("Basic39", 200, true);
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testBasic40() throws Exception {
        testPath("Basic30", 200, true);
    }

    /* No violation - init parameters are not usually user controlled. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testBasic41() throws Exception {
        testPath("Basic41", 200, false);
    }

    /* No violation - init parameters are not usually user controlled. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
    public void testBasic42() throws Exception {
        testPath("Basic42", 200, false);
    }
}


