package io.rivulet.maven.test.owasp;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.junit.Test;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getUncommonHeaders()Ljava/util/Map;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getAcceptHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getAcceptCharsetHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getAcceptLanguageHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getAcceptRangesHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getAgeHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getAllowHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getAuthorizationHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getCacheControlHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getConnectionHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getContentLanguageHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getContentLocationHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getContentMd5Header()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getContentRangeHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getContentTypeHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getCookieHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getDateHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getDavHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getDepthHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getDestinationHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getETagHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getExpectHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getExpiresHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getFromHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getHostHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getIfHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getIfMatchHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getIfModifiedSinceHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getIfNoneMatchHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getIfRangeHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getIfUnmodifiedSinceHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getLastModifiedHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getLocationHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getLockTokenHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getMaxForwardsHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getOverwriteHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getPragmaHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getProxyAuthenticateHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getProxyAuthorizationHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getRangeHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getRefererHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getRetryAfterHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getServerHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getStatusUriHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getTeHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getTimeoutHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getTrailerHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getTransferEncodingHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getUpgradeHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getUpgradeInsecureRequestsHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getUserAgentHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getVaryHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getViaHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getWarningHeader()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getWWWAuthenticateHeader()Ljava/lang/String")
@Source(method = "io/rivulet/PhosphorHttpRequest.getMethod()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getScheme()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getFragment()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getUserInfo()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getHost()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getPort()I")
@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedPath()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Source(method = "io/rivulet/PhosphorHttpRequest.getProtocolVersion()Ljava/lang/String;")
@Sink(method = "java/sql/Connection.prepareCall(Ljava/lang/String;)Ljava/sql/CallableStatement;")
@Sink(method = "java/sql/Connection.prepareCall(Ljava/lang/String;II)Ljava/sql/CallableStatement;")
@Sink(method = "java/sql/Connection.prepareCall(Ljava/lang/String;III)Ljava/sql/CallableStatement;")
@Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;)Ljava/sql/PreparedStatement;")
@Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;I)Ljava/sql/PreparedStatement;")
@Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;II)Ljava/sql/PreparedStatement;")
@Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;III)Ljava/sql/PreparedStatement;")
@Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;[I)Ljava/sql/PreparedStatement;")
@Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;[Ljava/lang/String;)Ljava/sql/PreparedStatement;")
@Sink(method = "java/sql/Connection.nativeSQL(Ljava/lang/String;)Ljava/lang/String;")
@Sink(method = "java/sql/Statement.addBatch(Ljava/lang/String;)V")
@Sink(method = "java/sql/Statement.execute(Ljava/lang/String;)Z")
@Sink(method = "java/sql/Statement.execute(Ljava/lang/String;I)Z")
@Sink(method = "java/sql/Statement.execute(Ljava/lang/String;[I)Z")
@Sink(method = "java/sql/Statement.execute(Ljava/lang/String;[Ljava/lang/String;)Z")
@Sink(method = "java/sql/Statement.executeLargeUpdate(Ljava/lang/String;)J")
@Sink(method = "java/sql/Statement.executeLargeUpdate(Ljava/lang/String;I)J")
@Sink(method = "java/sql/Statement.executeLargeUpdate(Ljava/lang/String;[I)J")
@Sink(method = "java/sql/Statement.executeLargeUpdate(Ljava/lang/String;[Ljava/lang/String;)J")
@Sink(method = "java/sql/Statement.executeQuery(Ljava/lang/String;)Ljava/sql/ResultSet;")
@Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;)I")
@Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;I)I")
@Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;[I)I")
@Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;[Ljava/lang/String;)I")
public class OWASPSQLITest extends OWASPBaseTest {

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00008() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00008", "POST", "answer", "Hello", "BenchmarkTest00008", "verifyUserPassword('foo','bar')", "BenchmarkTest00008Area", "Hello", "annoyingAJAX", "BenchmarkTest00008");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00018() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00018", "POST", "answer", "Hello", "BenchmarkTest00018", "bar", "BenchmarkTest00018Area", "Hello", "annoyingAJAX", "BenchmarkTest00018");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00024() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00024", "POST", "BenchmarkTest00024", "bar", "BenchmarkTest00024", "Movies", "BenchmarkTest00024", "Writing", "BenchmarkTest00024", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00025() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00025", "POST", "BenchmarkTest00025", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00026() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00026", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00026", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00027() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00027", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00027", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00032() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00032", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00032", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00033() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00033", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00033", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00034() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00034", "POST", "BenchmarkTest00034", "bar", "BenchmarkTest00034", "Movies", "BenchmarkTest00034", "Writing", "BenchmarkTest00034", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00037() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00037", "POST", "answer", "Hello", "BenchmarkTest00037", "bar", "BenchmarkTest00037Area", "Hello", "annoyingAJAX", "BenchmarkTest00037");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00038() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00038", "POST", "answer", "Hello", "BenchmarkTest00038", "bar", "BenchmarkTest00038Area", "Hello", "annoyingAJAX", "BenchmarkTest00038");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00039() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00039", "POST", "answer", "Hello", "BenchmarkTest00039", "bar", "BenchmarkTest00039Area", "Hello", "annoyingAJAX", "BenchmarkTest00039");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00043() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00043", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00043", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00052() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00052", "POST", "BenchmarkTest00052", "verifyUserPassword('foo','bar')", "BenchmarkTest00052", "Movies", "BenchmarkTest00052", "Writing", "BenchmarkTest00052", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00100() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00100", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00101() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00101", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00102() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00102", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00103() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00103", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00104() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00104", "POST");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00105() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00105", "POST");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00106() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00106", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00107() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00107", "POST");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00108() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00108", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00109() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00109", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00110() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00110", "POST");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00111() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00111", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00112() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00112", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00113() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00113", "POST");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00114() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00114", "POST");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00115() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00115", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00190() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00190", "POST", "answer", "Hello", "BenchmarkTest00190", "verifyUserPassword('foo','bar')", "BenchmarkTest00190Area", "Hello", "annoyingAJAX", "BenchmarkTest00190");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00191() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00191", "POST", "answer", "Hello", "BenchmarkTest00191", "verifyUserPassword('foo','bar')", "BenchmarkTest00191Area", "Hello", "annoyingAJAX", "BenchmarkTest00191");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00192() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00192", "POST", "answer", "Hello", "BenchmarkTest00192", "bar", "BenchmarkTest00192Area", "Hello", "annoyingAJAX", "BenchmarkTest00192");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00193() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00193", "POST", "answer", "Hello", "BenchmarkTest00193", "bar", "BenchmarkTest00193Area", "Hello", "annoyingAJAX", "BenchmarkTest00193");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00194() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00194", "POST", "answer", "Hello", "BenchmarkTest00194", "bar", "BenchmarkTest00194Area", "Hello", "annoyingAJAX", "BenchmarkTest00194");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00195() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00195", "POST", "answer", "Hello", "BenchmarkTest00195", "bar", "BenchmarkTest00195Area", "Hello", "annoyingAJAX", "BenchmarkTest00195");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00196() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00196", "POST", "answer", "Hello", "BenchmarkTest00196", "bar", "BenchmarkTest00196Area", "Hello", "annoyingAJAX", "BenchmarkTest00196");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00197() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00197", "POST", "answer", "Hello", "BenchmarkTest00197", "bar", "BenchmarkTest00197Area", "Hello", "annoyingAJAX", "BenchmarkTest00197");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00198() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00198", "POST", "answer", "Hello", "BenchmarkTest00198", "bar", "BenchmarkTest00198Area", "Hello", "annoyingAJAX", "BenchmarkTest00198");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00199() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00199", "POST", "answer", "Hello", "BenchmarkTest00199", "bar", "BenchmarkTest00199Area", "Hello", "annoyingAJAX", "BenchmarkTest00199");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00200() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00200", "POST", "answer", "Hello", "BenchmarkTest00200", "bar", "BenchmarkTest00200Area", "Hello", "annoyingAJAX", "BenchmarkTest00200");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00201() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00201", "POST", "answer", "Hello", "BenchmarkTest00201", "bar", "BenchmarkTest00201Area", "Hello", "annoyingAJAX", "BenchmarkTest00201");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00202() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00202", "POST", "answer", "Hello", "BenchmarkTest00202", "bar", "BenchmarkTest00202Area", "Hello", "annoyingAJAX", "BenchmarkTest00202");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00203() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00203", "POST", "answer", "Hello", "BenchmarkTest00203", "bar", "BenchmarkTest00203Area", "Hello", "annoyingAJAX", "BenchmarkTest00203");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00204() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00204", "POST", "answer", "Hello", "BenchmarkTest00204", "bar", "BenchmarkTest00204Area", "Hello", "annoyingAJAX", "BenchmarkTest00204");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00205() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00205", "POST", "answer", "Hello", "BenchmarkTest00205", "bar", "BenchmarkTest00205Area", "Hello", "annoyingAJAX", "BenchmarkTest00205");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00206() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00206", "POST", "answer", "Hello", "BenchmarkTest00206", "bar", "BenchmarkTest00206Area", "Hello", "annoyingAJAX", "BenchmarkTest00206");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00328() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00328", "POST", "answer", "Hello", "BenchmarkTest00328", "verifyUserPassword('foo','bar')", "BenchmarkTest00328Area", "Hello", "annoyingAJAX", "BenchmarkTest00328");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00329() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00329", "POST", "answer", "Hello", "BenchmarkTest00329", "verifyUserPassword('foo','bar')", "BenchmarkTest00329Area", "Hello", "annoyingAJAX", "BenchmarkTest00329");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00330() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00330", "POST", "answer", "Hello", "BenchmarkTest00330", "verifyUserPassword('foo','bar')", "BenchmarkTest00330Area", "Hello", "annoyingAJAX", "BenchmarkTest00330");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00331() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00331", "POST", "answer", "Hello", "BenchmarkTest00331", "bar", "BenchmarkTest00331Area", "Hello", "annoyingAJAX", "BenchmarkTest00331");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00332() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00332", "POST", "answer", "Hello", "BenchmarkTest00332", "bar", "BenchmarkTest00332Area", "Hello", "annoyingAJAX", "BenchmarkTest00332");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00333() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00333", "POST", "answer", "Hello", "BenchmarkTest00333", "bar", "BenchmarkTest00333Area", "Hello", "annoyingAJAX", "BenchmarkTest00333");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00334() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00334", "POST", "answer", "Hello", "BenchmarkTest00334", "bar", "BenchmarkTest00334Area", "Hello", "annoyingAJAX", "BenchmarkTest00334");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00335() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00335", "POST", "answer", "Hello", "BenchmarkTest00335", "bar", "BenchmarkTest00335Area", "Hello", "annoyingAJAX", "BenchmarkTest00335");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00336() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00336", "POST", "answer", "Hello", "BenchmarkTest00336", "bar", "BenchmarkTest00336Area", "Hello", "annoyingAJAX", "BenchmarkTest00336");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00337() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00337", "POST", "answer", "Hello", "BenchmarkTest00337", "bar", "BenchmarkTest00337Area", "Hello", "annoyingAJAX", "BenchmarkTest00337");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00338() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00338", "POST", "answer", "Hello", "BenchmarkTest00338", "bar", "BenchmarkTest00338Area", "Hello", "annoyingAJAX", "BenchmarkTest00338");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00339() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00339", "POST", "answer", "Hello", "BenchmarkTest00339", "bar", "BenchmarkTest00339Area", "Hello", "annoyingAJAX", "BenchmarkTest00339");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00340() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00340", "POST", "answer", "Hello", "BenchmarkTest00340", "bar", "BenchmarkTest00340Area", "Hello", "annoyingAJAX", "BenchmarkTest00340");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00341() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00341", "POST", "answer", "Hello", "BenchmarkTest00341", "bar", "BenchmarkTest00341Area", "Hello", "annoyingAJAX", "BenchmarkTest00341");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00342() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00342", "POST", "answer", "Hello", "BenchmarkTest00342", "bar", "BenchmarkTest00342Area", "Hello", "annoyingAJAX", "BenchmarkTest00342");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00343() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00343", "POST", "answer", "Hello", "BenchmarkTest00343", "bar", "BenchmarkTest00343Area", "Hello", "annoyingAJAX", "BenchmarkTest00343");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00344() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00344", "POST", "answer", "Hello", "BenchmarkTest00344", "bar", "BenchmarkTest00344Area", "Hello", "annoyingAJAX", "BenchmarkTest00344");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00428() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00428", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00428", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00429() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00429", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00429", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00430() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00430", "POST", "BenchmarkTest00430", "bar", "BenchmarkTest00430", "Movies", "BenchmarkTest00430", "Writing", "BenchmarkTest00430", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00431() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00431", "POST", "BenchmarkTest00431", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00432() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00432", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00432", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00433() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00433", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00433", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00434() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00434", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00434", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00435() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00435", "POST", "BenchmarkTest00435", "bar", "BenchmarkTest00435", "Movies", "BenchmarkTest00435", "Writing", "BenchmarkTest00435", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00436() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00436", "POST", "BenchmarkTest00436", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00437() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00437", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00437", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00438() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00438", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00438", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00439() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00439", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00439", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00440() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00440", "POST", "BenchmarkTest00440", "bar", "BenchmarkTest00440", "Movies", "BenchmarkTest00440", "Writing", "BenchmarkTest00440", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00441() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00441", "POST", "BenchmarkTest00441", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00509() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00509", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00509", "verifyUserPassword('foo','bar')");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00510() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-00/BenchmarkTest00510", "POST", "BenchmarkTest00510", "verifyUserPassword('foo','bar')", "BenchmarkTest00510", "Movies", "BenchmarkTest00510", "Writing", "BenchmarkTest00510", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00511() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00511", "POST", "BenchmarkTest00511", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00512() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00512", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00512", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00513() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00513", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00513", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00514() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00514", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00514", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00515() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00515", "POST", "BenchmarkTest00515", "bar", "BenchmarkTest00515", "Movies", "BenchmarkTest00515", "Writing", "BenchmarkTest00515", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00516() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00516", "POST", "BenchmarkTest00516", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00517() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00517", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00517", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00518() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00518", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00518", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00519() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00519", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00519", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00589() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00589", "POST", "answer", "Hello", "BenchmarkTest00589", "verifyUserPassword('foo','bar')", "BenchmarkTest00589Area", "Hello", "annoyingAJAX", "BenchmarkTest00589");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00590() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00590", "POST", "answer", "Hello", "BenchmarkTest00590", "verifyUserPassword('foo','bar')", "BenchmarkTest00590Area", "Hello", "annoyingAJAX", "BenchmarkTest00590");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00591() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00591", "POST", "answer", "Hello", "BenchmarkTest00591", "bar", "BenchmarkTest00591Area", "Hello", "annoyingAJAX", "BenchmarkTest00591");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00592() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00592", "POST", "answer", "Hello", "BenchmarkTest00592", "bar", "BenchmarkTest00592Area", "Hello", "annoyingAJAX", "BenchmarkTest00592");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00593() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00593", "POST", "answer", "Hello", "BenchmarkTest00593", "bar", "BenchmarkTest00593Area", "Hello", "annoyingAJAX", "BenchmarkTest00593");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00594() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00594", "POST", "answer", "Hello", "BenchmarkTest00594", "bar", "BenchmarkTest00594Area", "Hello", "annoyingAJAX", "BenchmarkTest00594");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00595() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00595", "POST", "answer", "Hello", "BenchmarkTest00595", "bar", "BenchmarkTest00595Area", "Hello", "annoyingAJAX", "BenchmarkTest00595");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00596() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00596", "POST", "answer", "Hello", "BenchmarkTest00596", "bar", "BenchmarkTest00596Area", "Hello", "annoyingAJAX", "BenchmarkTest00596");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00597() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00597", "POST", "answer", "Hello", "BenchmarkTest00597", "bar", "BenchmarkTest00597Area", "Hello", "annoyingAJAX", "BenchmarkTest00597");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00598() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00598", "POST", "answer", "Hello", "BenchmarkTest00598", "bar", "BenchmarkTest00598Area", "Hello", "annoyingAJAX", "BenchmarkTest00598");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00599() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00599", "POST", "answer", "Hello", "BenchmarkTest00599", "bar", "BenchmarkTest00599Area", "Hello", "annoyingAJAX", "BenchmarkTest00599");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00600() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00600", "POST", "answer", "Hello", "BenchmarkTest00600", "bar", "BenchmarkTest00600Area", "Hello", "annoyingAJAX", "BenchmarkTest00600");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00601() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00601", "POST", "answer", "Hello", "BenchmarkTest00601", "bar", "BenchmarkTest00601Area", "Hello", "annoyingAJAX", "BenchmarkTest00601");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00602() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00602", "POST", "answer", "Hello", "BenchmarkTest00602", "bar", "BenchmarkTest00602Area", "Hello", "annoyingAJAX", "BenchmarkTest00602");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00603() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00603", "POST", "answer", "Hello", "BenchmarkTest00603", "bar", "BenchmarkTest00603Area", "Hello", "annoyingAJAX", "BenchmarkTest00603");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00604() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00604", "POST", "answer", "Hello", "BenchmarkTest00604", "bar", "BenchmarkTest00604Area", "Hello", "annoyingAJAX", "BenchmarkTest00604");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00605() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00605", "POST", "answer", "Hello", "BenchmarkTest00605", "bar", "BenchmarkTest00605Area", "Hello", "annoyingAJAX", "BenchmarkTest00605");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00606() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00606", "POST", "answer", "Hello", "BenchmarkTest00606", "bar", "BenchmarkTest00606Area", "Hello", "annoyingAJAX", "BenchmarkTest00606");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00672() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00672", "POST", "BenchmarkTest00672", "verifyUserPassword('foo','bar')", "BenchmarkTest00672", "Movies", "BenchmarkTest00672", "Writing", "BenchmarkTest00672", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00673() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00673", "POST", "BenchmarkTest00673", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00674() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00674", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00674", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00675() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00675", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00675", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00676() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00676", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00676", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00677() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00677", "POST", "BenchmarkTest00677", "bar", "BenchmarkTest00677", "Movies", "BenchmarkTest00677", "Writing", "BenchmarkTest00677", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00678() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00678", "POST", "BenchmarkTest00678", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00679() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00679", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00679", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00680() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00680", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00680", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00681() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00681", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00681", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00682() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00682", "POST", "BenchmarkTest00682", "bar", "BenchmarkTest00682", "Movies", "BenchmarkTest00682", "Writing", "BenchmarkTest00682", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00760() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00760", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00760", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00761() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00761", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00761", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00762() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00762", "POST", "BenchmarkTest00762", "verifyUserPassword('foo','bar')", "BenchmarkTest00762", "Movies", "BenchmarkTest00762", "Writing", "BenchmarkTest00762", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00763() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00763", "POST", "BenchmarkTest00763", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00764() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00764", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00764", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00765() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00765", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00765", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00766() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00766", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00766", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00767() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00767", "POST", "BenchmarkTest00767", "bar", "BenchmarkTest00767", "Movies", "BenchmarkTest00767", "Writing", "BenchmarkTest00767", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00768() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00768", "POST", "BenchmarkTest00768", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00769() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00769", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00769", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00770() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00770", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00770", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00771() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00771", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00771", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00772() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00772", "POST", "BenchmarkTest00772", "bar", "BenchmarkTest00772", "Movies", "BenchmarkTest00772", "Writing", "BenchmarkTest00772", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00773() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00773", "POST", "BenchmarkTest00773", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00774() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00774", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00774", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00837() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00837", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00837", "verifyUserPassword('foo','bar')");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00838() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00838", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00838", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00839() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00839", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00839", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00840() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00840", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00840", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00841() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00841", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00841", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00842() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00842", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00842", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00843() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00843", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00843", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00844() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00844", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00844", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00845() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00845", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00845", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00846() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00846", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00846", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00847() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00847", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00847", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00848() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00848", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00848", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00849() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00849", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00849", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00850() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00850", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00850", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00851() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00851", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00851", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00924() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00924", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00924", "verifyUserPassword('foo','bar')");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00925() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00925", "POST", "BenchmarkTest00925", "bar", "BenchmarkTest00925", "Movies", "BenchmarkTest00925", "Writing", "BenchmarkTest00925", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00926() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00926", "POST", "BenchmarkTest00926", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00927() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00927", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00927", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00928() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00928", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00928", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00929() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00929", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00929", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00930() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00930", "POST", "BenchmarkTest00930", "bar", "BenchmarkTest00930", "Movies", "BenchmarkTest00930", "Writing", "BenchmarkTest00930", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00931() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00931", "POST", "BenchmarkTest00931", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00932() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00932", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00932", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00933() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00933", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00933", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00934() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00934", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00934", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00935() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-01/BenchmarkTest00935", "POST", "BenchmarkTest00935", "bar", "BenchmarkTest00935", "Movies", "BenchmarkTest00935", "Writing", "BenchmarkTest00935", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00936() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest00936", "POST", "BenchmarkTest00936", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00937() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest00937", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00937", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00938() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest00938", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00938", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00939() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest00939", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00939", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00940() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest00940", "POST", "BenchmarkTest00940", "bar", "BenchmarkTest00940", "Movies", "BenchmarkTest00940", "Writing", "BenchmarkTest00940", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00996() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest00996", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00997() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest00997", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00998() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest00998", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00999() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest00999", "POST");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01000() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01000", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01001() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01001", "POST");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01002() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01002", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01003() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01003", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01004() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01004", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01005() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01005", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01006() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01006", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01007() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01007", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01008() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01008", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01009() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01009", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01010() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01010", "POST");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01011() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01011", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01012() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01012", "POST");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01083() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01083", "POST", "answer", "Hello", "BenchmarkTest01083", "bar", "BenchmarkTest01083Area", "Hello", "annoyingAJAX", "BenchmarkTest01083");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01084() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01084", "POST", "answer", "Hello", "BenchmarkTest01084", "bar", "BenchmarkTest01084Area", "Hello", "annoyingAJAX", "BenchmarkTest01084");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01085() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01085", "POST", "answer", "Hello", "BenchmarkTest01085", "bar", "BenchmarkTest01085Area", "Hello", "annoyingAJAX", "BenchmarkTest01085");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01086() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01086", "POST", "answer", "Hello", "BenchmarkTest01086", "bar", "BenchmarkTest01086Area", "Hello", "annoyingAJAX", "BenchmarkTest01086");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01087() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01087", "POST", "answer", "Hello", "BenchmarkTest01087", "bar", "BenchmarkTest01087Area", "Hello", "annoyingAJAX", "BenchmarkTest01087");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01088() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01088", "POST", "answer", "Hello", "BenchmarkTest01088", "bar", "BenchmarkTest01088Area", "Hello", "annoyingAJAX", "BenchmarkTest01088");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01089() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01089", "POST", "answer", "Hello", "BenchmarkTest01089", "bar", "BenchmarkTest01089Area", "Hello", "annoyingAJAX", "BenchmarkTest01089");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01090() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01090", "POST", "answer", "Hello", "BenchmarkTest01090", "bar", "BenchmarkTest01090Area", "Hello", "annoyingAJAX", "BenchmarkTest01090");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01091() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01091", "POST", "answer", "Hello", "BenchmarkTest01091", "bar", "BenchmarkTest01091Area", "Hello", "annoyingAJAX", "BenchmarkTest01091");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01092() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01092", "POST", "answer", "Hello", "BenchmarkTest01092", "bar", "BenchmarkTest01092Area", "Hello", "annoyingAJAX", "BenchmarkTest01092");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01093() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01093", "POST", "answer", "Hello", "BenchmarkTest01093", "bar", "BenchmarkTest01093Area", "Hello", "annoyingAJAX", "BenchmarkTest01093");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01094() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01094", "POST", "answer", "Hello", "BenchmarkTest01094", "bar", "BenchmarkTest01094Area", "Hello", "annoyingAJAX", "BenchmarkTest01094");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01095() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01095", "POST", "answer", "Hello", "BenchmarkTest01095", "bar", "BenchmarkTest01095Area", "Hello", "annoyingAJAX", "BenchmarkTest01095");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01096() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01096", "POST", "answer", "Hello", "BenchmarkTest01096", "bar", "BenchmarkTest01096Area", "Hello", "annoyingAJAX", "BenchmarkTest01096");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01097() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01097", "POST", "answer", "Hello", "BenchmarkTest01097", "bar", "BenchmarkTest01097Area", "Hello", "annoyingAJAX", "BenchmarkTest01097");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01098() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01098", "POST", "answer", "Hello", "BenchmarkTest01098", "bar", "BenchmarkTest01098Area", "Hello", "annoyingAJAX", "BenchmarkTest01098");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01208() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01208", "POST", "answer", "Hello", "BenchmarkTest01208", "verifyUserPassword('foo','bar')", "BenchmarkTest01208Area", "Hello", "annoyingAJAX", "BenchmarkTest01208");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01209() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01209", "POST", "answer", "Hello", "BenchmarkTest01209", "bar", "BenchmarkTest01209Area", "Hello", "annoyingAJAX", "BenchmarkTest01209");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01210() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01210", "POST", "answer", "Hello", "BenchmarkTest01210", "bar", "BenchmarkTest01210Area", "Hello", "annoyingAJAX", "BenchmarkTest01210");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01211() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01211", "POST", "answer", "Hello", "BenchmarkTest01211", "bar", "BenchmarkTest01211Area", "Hello", "annoyingAJAX", "BenchmarkTest01211");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01212() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01212", "POST", "answer", "Hello", "BenchmarkTest01212", "bar", "BenchmarkTest01212Area", "Hello", "annoyingAJAX", "BenchmarkTest01212");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01213() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01213", "POST", "answer", "Hello", "BenchmarkTest01213", "bar", "BenchmarkTest01213Area", "Hello", "annoyingAJAX", "BenchmarkTest01213");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01214() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01214", "POST", "answer", "Hello", "BenchmarkTest01214", "bar", "BenchmarkTest01214Area", "Hello", "annoyingAJAX", "BenchmarkTest01214");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01215() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01215", "POST", "answer", "Hello", "BenchmarkTest01215", "bar", "BenchmarkTest01215Area", "Hello", "annoyingAJAX", "BenchmarkTest01215");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01216() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01216", "POST", "answer", "Hello", "BenchmarkTest01216", "bar", "BenchmarkTest01216Area", "Hello", "annoyingAJAX", "BenchmarkTest01216");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01217() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01217", "POST", "answer", "Hello", "BenchmarkTest01217", "bar", "BenchmarkTest01217Area", "Hello", "annoyingAJAX", "BenchmarkTest01217");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01218() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01218", "POST", "answer", "Hello", "BenchmarkTest01218", "bar", "BenchmarkTest01218Area", "Hello", "annoyingAJAX", "BenchmarkTest01218");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01219() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01219", "POST", "answer", "Hello", "BenchmarkTest01219", "bar", "BenchmarkTest01219Area", "Hello", "annoyingAJAX", "BenchmarkTest01219");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01220() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01220", "POST", "answer", "Hello", "BenchmarkTest01220", "bar", "BenchmarkTest01220Area", "Hello", "annoyingAJAX", "BenchmarkTest01220");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01221() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01221", "POST", "answer", "Hello", "BenchmarkTest01221", "bar", "BenchmarkTest01221Area", "Hello", "annoyingAJAX", "BenchmarkTest01221");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01222() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01222", "POST", "answer", "Hello", "BenchmarkTest01222", "bar", "BenchmarkTest01222Area", "Hello", "annoyingAJAX", "BenchmarkTest01222");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01301() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01301", "POST", "BenchmarkTest01301", "verifyUserPassword('foo','bar')", "BenchmarkTest01301", "Movies", "BenchmarkTest01301", "Writing", "BenchmarkTest01301", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01302() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01302", "POST", "BenchmarkTest01302", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01303() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01303", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01303", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01304() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01304", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01304", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01305() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01305", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01305", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01306() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01306", "POST", "BenchmarkTest01306", "bar", "BenchmarkTest01306", "Movies", "BenchmarkTest01306", "Writing", "BenchmarkTest01306", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01307() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01307", "POST", "BenchmarkTest01307", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01308() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01308", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01308", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01309() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01309", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01309", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01310() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01310", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01310", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01311() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01311", "POST", "BenchmarkTest01311", "bar", "BenchmarkTest01311", "Movies", "BenchmarkTest01311", "Writing", "BenchmarkTest01311", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01312() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01312", "POST", "BenchmarkTest01312", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01313() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01313", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01313", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01314() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01314", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01314", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01315() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01315", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01315", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01378() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01378", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01378", "verifyUserPassword('foo','bar')");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01379() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01379", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01379", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01380() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01380", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01380", "verifyUserPassword('foo','bar')");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01381() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01381", "POST", "BenchmarkTest01381", "bar", "BenchmarkTest01381", "Movies", "BenchmarkTest01381", "Writing", "BenchmarkTest01381", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01382() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01382", "POST", "BenchmarkTest01382", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01383() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01383", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01383", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01384() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01384", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01384", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01385() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01385", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01385", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01386() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01386", "POST", "BenchmarkTest01386", "bar", "BenchmarkTest01386", "Movies", "BenchmarkTest01386", "Writing", "BenchmarkTest01386", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01387() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01387", "POST", "BenchmarkTest01387", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01388() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01388", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01388", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01389() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-02/BenchmarkTest01389", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01389", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01390() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01390", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01390", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01391() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01391", "POST", "BenchmarkTest01391", "bar", "BenchmarkTest01391", "Movies", "BenchmarkTest01391", "Writing", "BenchmarkTest01391", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01392() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01392", "POST", "BenchmarkTest01392", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01393() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01393", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01393", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01394() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01394", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01394", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01395() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01395", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01395", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01396() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01396", "POST", "BenchmarkTest01396", "bar", "BenchmarkTest01396", "Movies", "BenchmarkTest01396", "Writing", "BenchmarkTest01396", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01459() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01459", "POST", "answer", "Hello", "BenchmarkTest01459", "verifyUserPassword('foo','bar')", "BenchmarkTest01459Area", "Hello", "annoyingAJAX", "BenchmarkTest01459");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01460() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01460", "POST", "answer", "Hello", "BenchmarkTest01460", "verifyUserPassword('foo','bar')", "BenchmarkTest01460Area", "Hello", "annoyingAJAX", "BenchmarkTest01460");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01461() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01461", "POST", "answer", "Hello", "BenchmarkTest01461", "verifyUserPassword('foo','bar')", "BenchmarkTest01461Area", "Hello", "annoyingAJAX", "BenchmarkTest01461");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01462() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01462", "POST", "answer", "Hello", "BenchmarkTest01462", "verifyUserPassword('foo','bar')", "BenchmarkTest01462Area", "Hello", "annoyingAJAX", "BenchmarkTest01462");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01463() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01463", "POST", "answer", "Hello", "BenchmarkTest01463", "verifyUserPassword('foo','bar')", "BenchmarkTest01463Area", "Hello", "annoyingAJAX", "BenchmarkTest01463");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01464() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01464", "POST", "answer", "Hello", "BenchmarkTest01464", "bar", "BenchmarkTest01464Area", "Hello", "annoyingAJAX", "BenchmarkTest01464");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01465() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01465", "POST", "answer", "Hello", "BenchmarkTest01465", "bar", "BenchmarkTest01465Area", "Hello", "annoyingAJAX", "BenchmarkTest01465");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01466() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01466", "POST", "answer", "Hello", "BenchmarkTest01466", "bar", "BenchmarkTest01466Area", "Hello", "annoyingAJAX", "BenchmarkTest01466");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01467() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01467", "POST", "answer", "Hello", "BenchmarkTest01467", "bar", "BenchmarkTest01467Area", "Hello", "annoyingAJAX", "BenchmarkTest01467");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01468() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01468", "POST", "answer", "Hello", "BenchmarkTest01468", "bar", "BenchmarkTest01468Area", "Hello", "annoyingAJAX", "BenchmarkTest01468");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01469() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01469", "POST", "answer", "Hello", "BenchmarkTest01469", "bar", "BenchmarkTest01469Area", "Hello", "annoyingAJAX", "BenchmarkTest01469");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01470() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01470", "POST", "answer", "Hello", "BenchmarkTest01470", "bar", "BenchmarkTest01470Area", "Hello", "annoyingAJAX", "BenchmarkTest01470");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01471() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01471", "POST", "answer", "Hello", "BenchmarkTest01471", "bar", "BenchmarkTest01471Area", "Hello", "annoyingAJAX", "BenchmarkTest01471");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01472() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01472", "POST", "answer", "Hello", "BenchmarkTest01472", "bar", "BenchmarkTest01472Area", "Hello", "annoyingAJAX", "BenchmarkTest01472");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01473() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01473", "POST", "answer", "Hello", "BenchmarkTest01473", "bar", "BenchmarkTest01473Area", "Hello", "annoyingAJAX", "BenchmarkTest01473");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01474() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01474", "POST", "answer", "Hello", "BenchmarkTest01474", "bar", "BenchmarkTest01474Area", "Hello", "annoyingAJAX", "BenchmarkTest01474");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01475() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01475", "POST", "answer", "Hello", "BenchmarkTest01475", "bar", "BenchmarkTest01475Area", "Hello", "annoyingAJAX", "BenchmarkTest01475");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01476() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01476", "POST", "answer", "Hello", "BenchmarkTest01476", "bar", "BenchmarkTest01476Area", "Hello", "annoyingAJAX", "BenchmarkTest01476");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01477() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01477", "POST", "answer", "Hello", "BenchmarkTest01477", "bar", "BenchmarkTest01477Area", "Hello", "annoyingAJAX", "BenchmarkTest01477");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01552() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01552", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01552", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01553() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01553", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01553", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01554() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01554", "POST", "BenchmarkTest01554", "bar", "BenchmarkTest01554", "Movies", "BenchmarkTest01554", "Writing", "BenchmarkTest01554", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01555() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01555", "POST", "BenchmarkTest01555", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01556() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01556", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01556", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01557() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01557", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01557", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01558() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01558", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01558", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01559() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01559", "POST", "BenchmarkTest01559", "bar", "BenchmarkTest01559", "Movies", "BenchmarkTest01559", "Writing", "BenchmarkTest01559", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01560() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01560", "POST", "BenchmarkTest01560", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01620() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01620", "POST", "BenchmarkTest01620", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01621() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01621", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01621", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01622() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01622", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01622", "verifyUserPassword('foo','bar')");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01623() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01623", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01623", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01624() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01624", "POST", "BenchmarkTest01624", "bar", "BenchmarkTest01624", "Movies", "BenchmarkTest01624", "Writing", "BenchmarkTest01624", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01625() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01625", "POST", "BenchmarkTest01625", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01626() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01626", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01626", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01627() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01627", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01627", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01628() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01628", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01628", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01629() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01629", "POST", "BenchmarkTest01629", "bar", "BenchmarkTest01629", "Movies", "BenchmarkTest01629", "Writing", "BenchmarkTest01629", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01630() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01630", "POST", "BenchmarkTest01630", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01631() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01631", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01631", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01712() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01712", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01712", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01713() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01713", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01713", "verifyUserPassword('foo','bar')");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01714() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01714", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01714", "verifyUserPassword('foo','bar')");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01715() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01715", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01715", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01716() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01716", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01716", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01717() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01717", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01717", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01718() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01718", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01718", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01719() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01719", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01719", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01720() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01720", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01720", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01721() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01721", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01721", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01722() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01722", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01722", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01723() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01723", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01723", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01724() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01724", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01724", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01725() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01725", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01725", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01726() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01726", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01726", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01727() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01727", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01727", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01728() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01728", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01728", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01729() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01729", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01729", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01730() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01730", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01730", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01731() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01731", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01731", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01732() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01732", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01732", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01733() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01733", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01733", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01803() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01803", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01803", "verifyUserPassword('foo','bar')");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01804() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01804", "POST", "BenchmarkTest01804", "bar", "BenchmarkTest01804", "Movies", "BenchmarkTest01804", "Writing", "BenchmarkTest01804", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01805() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01805", "POST", "BenchmarkTest01805", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01806() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01806", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01806", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01807() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01807", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01807", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01808() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01808", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01808", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01809() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01809", "POST", "BenchmarkTest01809", "bar", "BenchmarkTest01809", "Movies", "BenchmarkTest01809", "Writing", "BenchmarkTest01809", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01810() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01810", "POST", "BenchmarkTest01810", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01811() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01811", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01811", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01812() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01812", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01812", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01813() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-03/BenchmarkTest01813", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01813", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01814() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01814", "POST", "BenchmarkTest01814", "bar", "BenchmarkTest01814", "Movies", "BenchmarkTest01814", "Writing", "BenchmarkTest01814", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01815() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01815", "POST", "BenchmarkTest01815", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01816() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01816", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01816", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01817() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01817", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01817", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01818() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01818", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01818", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01819() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01819", "POST", "BenchmarkTest01819", "bar", "BenchmarkTest01819", "Movies", "BenchmarkTest01819", "Writing", "BenchmarkTest01819", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01820() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01820", "POST", "BenchmarkTest01820", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01877() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01877", "POST");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01878() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01878", "POST");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01879() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01879", "POST");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01880() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01880", "POST");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01881() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01881", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01882() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01882", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01883() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01883", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01884() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01884", "POST");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01885() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01885", "POST");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01886() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01886", "POST");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01887() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01887", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01888() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01888", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01889() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01889", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01890() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01890", "POST");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01891() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01891", "POST");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01961() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01961", "POST", "answer", "Hello", "BenchmarkTest01961", "bar", "BenchmarkTest01961Area", "Hello", "annoyingAJAX", "BenchmarkTest01961");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01962() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01962", "POST", "answer", "Hello", "BenchmarkTest01962", "bar", "BenchmarkTest01962Area", "Hello", "annoyingAJAX", "BenchmarkTest01962");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01963() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01963", "POST", "answer", "Hello", "BenchmarkTest01963", "bar", "BenchmarkTest01963Area", "Hello", "annoyingAJAX", "BenchmarkTest01963");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01964() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01964", "POST", "answer", "Hello", "BenchmarkTest01964", "bar", "BenchmarkTest01964Area", "Hello", "annoyingAJAX", "BenchmarkTest01964");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01965() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01965", "POST", "answer", "Hello", "BenchmarkTest01965", "bar", "BenchmarkTest01965Area", "Hello", "annoyingAJAX", "BenchmarkTest01965");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01966() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01966", "POST", "answer", "Hello", "BenchmarkTest01966", "bar", "BenchmarkTest01966Area", "Hello", "annoyingAJAX", "BenchmarkTest01966");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01967() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01967", "POST", "answer", "Hello", "BenchmarkTest01967", "bar", "BenchmarkTest01967Area", "Hello", "annoyingAJAX", "BenchmarkTest01967");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01968() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01968", "POST", "answer", "Hello", "BenchmarkTest01968", "bar", "BenchmarkTest01968Area", "Hello", "annoyingAJAX", "BenchmarkTest01968");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01969() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01969", "POST", "answer", "Hello", "BenchmarkTest01969", "bar", "BenchmarkTest01969Area", "Hello", "annoyingAJAX", "BenchmarkTest01969");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01970() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01970", "POST", "answer", "Hello", "BenchmarkTest01970", "bar", "BenchmarkTest01970Area", "Hello", "annoyingAJAX", "BenchmarkTest01970");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01971() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01971", "POST", "answer", "Hello", "BenchmarkTest01971", "bar", "BenchmarkTest01971Area", "Hello", "annoyingAJAX", "BenchmarkTest01971");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01972() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01972", "POST", "answer", "Hello", "BenchmarkTest01972", "bar", "BenchmarkTest01972Area", "Hello", "annoyingAJAX", "BenchmarkTest01972");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01973() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest01973", "POST", "answer", "Hello", "BenchmarkTest01973", "bar", "BenchmarkTest01973Area", "Hello", "annoyingAJAX", "BenchmarkTest01973");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02087() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02087", "POST", "answer", "Hello", "BenchmarkTest02087", "bar", "BenchmarkTest02087Area", "Hello", "annoyingAJAX", "BenchmarkTest02087");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02088() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02088", "POST", "answer", "Hello", "BenchmarkTest02088", "bar", "BenchmarkTest02088Area", "Hello", "annoyingAJAX", "BenchmarkTest02088");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02089() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02089", "POST", "answer", "Hello", "BenchmarkTest02089", "bar", "BenchmarkTest02089Area", "Hello", "annoyingAJAX", "BenchmarkTest02089");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02090() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02090", "POST", "answer", "Hello", "BenchmarkTest02090", "bar", "BenchmarkTest02090Area", "Hello", "annoyingAJAX", "BenchmarkTest02090");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02091() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02091", "POST", "answer", "Hello", "BenchmarkTest02091", "bar", "BenchmarkTest02091Area", "Hello", "annoyingAJAX", "BenchmarkTest02091");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02092() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02092", "POST", "answer", "Hello", "BenchmarkTest02092", "bar", "BenchmarkTest02092Area", "Hello", "annoyingAJAX", "BenchmarkTest02092");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02093() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02093", "POST", "answer", "Hello", "BenchmarkTest02093", "bar", "BenchmarkTest02093Area", "Hello", "annoyingAJAX", "BenchmarkTest02093");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02094() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02094", "POST", "answer", "Hello", "BenchmarkTest02094", "bar", "BenchmarkTest02094Area", "Hello", "annoyingAJAX", "BenchmarkTest02094");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02095() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02095", "POST", "answer", "Hello", "BenchmarkTest02095", "bar", "BenchmarkTest02095Area", "Hello", "annoyingAJAX", "BenchmarkTest02095");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02096() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02096", "POST", "answer", "Hello", "BenchmarkTest02096", "bar", "BenchmarkTest02096Area", "Hello", "annoyingAJAX", "BenchmarkTest02096");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02097() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02097", "POST", "answer", "Hello", "BenchmarkTest02097", "bar", "BenchmarkTest02097Area", "Hello", "annoyingAJAX", "BenchmarkTest02097");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02098() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02098", "POST", "answer", "Hello", "BenchmarkTest02098", "bar", "BenchmarkTest02098Area", "Hello", "annoyingAJAX", "BenchmarkTest02098");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02099() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02099", "POST", "answer", "Hello", "BenchmarkTest02099", "bar", "BenchmarkTest02099Area", "Hello", "annoyingAJAX", "BenchmarkTest02099");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02169() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02169", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02169", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02170() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02170", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02170", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02171() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02171", "POST", "BenchmarkTest02171", "bar", "BenchmarkTest02171", "Movies", "BenchmarkTest02171", "Writing", "BenchmarkTest02171", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02172() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02172", "POST", "BenchmarkTest02172", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02173() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02173", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02173", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02174() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02174", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02174", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02175() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02175", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02175", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02176() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02176", "POST", "BenchmarkTest02176", "bar", "BenchmarkTest02176", "Movies", "BenchmarkTest02176", "Writing", "BenchmarkTest02176", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02177() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02177", "POST", "BenchmarkTest02177", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02178() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02178", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02178", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02179() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02179", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02179", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02180() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02180", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02180", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02181() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02181", "POST", "BenchmarkTest02181", "bar", "BenchmarkTest02181", "Movies", "BenchmarkTest02181", "Writing", "BenchmarkTest02181", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02182() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02182", "POST", "BenchmarkTest02182", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02183() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02183", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02183", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02184() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02184", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02184", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02185() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02185", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02185", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02186() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02186", "POST", "BenchmarkTest02186", "bar", "BenchmarkTest02186", "Movies", "BenchmarkTest02186", "Writing", "BenchmarkTest02186", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02187() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02187", "POST", "BenchmarkTest02187", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02188() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02188", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02188", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02264() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02264", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02264", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02265() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02265", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02265", "verifyUserPassword('foo','bar')");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02266() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02266", "POST", "BenchmarkTest02266", "verifyUserPassword('foo','bar')", "BenchmarkTest02266", "Movies", "BenchmarkTest02266", "Writing", "BenchmarkTest02266", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02267() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02267", "POST", "BenchmarkTest02267", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02268() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02268", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02268", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02269() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02269", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02269", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02270() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02270", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02270", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02271() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02271", "POST", "BenchmarkTest02271", "bar", "BenchmarkTest02271", "Movies", "BenchmarkTest02271", "Writing", "BenchmarkTest02271", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02272() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02272", "POST", "BenchmarkTest02272", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02273() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02273", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02273", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02274() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02274", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02274", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02275() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-04/BenchmarkTest02275", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02275", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02276() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02276", "POST", "BenchmarkTest02276", "bar", "BenchmarkTest02276", "Movies", "BenchmarkTest02276", "Writing", "BenchmarkTest02276", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02277() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02277", "POST", "BenchmarkTest02277", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02278() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02278", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02278", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02279() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02279", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02279", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02280() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02280", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02280", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02281() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02281", "POST", "BenchmarkTest02281", "bar", "BenchmarkTest02281", "Movies", "BenchmarkTest02281", "Writing", "BenchmarkTest02281", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02282() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02282", "POST", "BenchmarkTest02282", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02283() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02283", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02283", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02284() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02284", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02284", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02285() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02285", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02285", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02286() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02286", "POST", "BenchmarkTest02286", "bar", "BenchmarkTest02286", "Movies", "BenchmarkTest02286", "Writing", "BenchmarkTest02286", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02287() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02287", "POST", "BenchmarkTest02287", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02288() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02288", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02288", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02353() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02353", "POST", "answer", "Hello", "BenchmarkTest02353", "bar", "BenchmarkTest02353Area", "Hello", "annoyingAJAX", "BenchmarkTest02353");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02354() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02354", "POST", "answer", "Hello", "BenchmarkTest02354", "bar", "BenchmarkTest02354Area", "Hello", "annoyingAJAX", "BenchmarkTest02354");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02355() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02355", "POST", "answer", "Hello", "BenchmarkTest02355", "bar", "BenchmarkTest02355Area", "Hello", "annoyingAJAX", "BenchmarkTest02355");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02356() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02356", "POST", "answer", "Hello", "BenchmarkTest02356", "bar", "BenchmarkTest02356Area", "Hello", "annoyingAJAX", "BenchmarkTest02356");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02357() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02357", "POST", "answer", "Hello", "BenchmarkTest02357", "bar", "BenchmarkTest02357Area", "Hello", "annoyingAJAX", "BenchmarkTest02357");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02358() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02358", "POST", "answer", "Hello", "BenchmarkTest02358", "bar", "BenchmarkTest02358Area", "Hello", "annoyingAJAX", "BenchmarkTest02358");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02359() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02359", "POST", "answer", "Hello", "BenchmarkTest02359", "bar", "BenchmarkTest02359Area", "Hello", "annoyingAJAX", "BenchmarkTest02359");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02360() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02360", "POST", "answer", "Hello", "BenchmarkTest02360", "bar", "BenchmarkTest02360Area", "Hello", "annoyingAJAX", "BenchmarkTest02360");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02361() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02361", "POST", "answer", "Hello", "BenchmarkTest02361", "bar", "BenchmarkTest02361Area", "Hello", "annoyingAJAX", "BenchmarkTest02361");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02362() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02362", "POST", "answer", "Hello", "BenchmarkTest02362", "bar", "BenchmarkTest02362Area", "Hello", "annoyingAJAX", "BenchmarkTest02362");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02363() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02363", "POST", "answer", "Hello", "BenchmarkTest02363", "bar", "BenchmarkTest02363Area", "Hello", "annoyingAJAX", "BenchmarkTest02363");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02364() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02364", "POST", "answer", "Hello", "BenchmarkTest02364", "bar", "BenchmarkTest02364Area", "Hello", "annoyingAJAX", "BenchmarkTest02364");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02365() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02365", "POST", "answer", "Hello", "BenchmarkTest02365", "bar", "BenchmarkTest02365Area", "Hello", "annoyingAJAX", "BenchmarkTest02365");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02366() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02366", "POST", "answer", "Hello", "BenchmarkTest02366", "bar", "BenchmarkTest02366Area", "Hello", "annoyingAJAX", "BenchmarkTest02366");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02367() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02367", "POST", "answer", "Hello", "BenchmarkTest02367", "bar", "BenchmarkTest02367Area", "Hello", "annoyingAJAX", "BenchmarkTest02367");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02368() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02368", "POST", "answer", "Hello", "BenchmarkTest02368", "bar", "BenchmarkTest02368Area", "Hello", "annoyingAJAX", "BenchmarkTest02368");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02369() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02369", "POST", "answer", "Hello", "BenchmarkTest02369", "bar", "BenchmarkTest02369Area", "Hello", "annoyingAJAX", "BenchmarkTest02369");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02449() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02449", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02449", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02450() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02450", "POST", "BenchmarkTest02450", "bar", "BenchmarkTest02450", "Movies", "BenchmarkTest02450", "Writing", "BenchmarkTest02450", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02451() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02451", "POST", "BenchmarkTest02451", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02452() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02452", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02452", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02453() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02453", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02453", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02454() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02454", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02454", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02455() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02455", "POST", "BenchmarkTest02455", "bar", "BenchmarkTest02455", "Movies", "BenchmarkTest02455", "Writing", "BenchmarkTest02455", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02456() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02456", "POST", "BenchmarkTest02456", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02528() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02528", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02528", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02529() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02529", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02529", "verifyUserPassword('foo','bar')");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02530() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02530", "POST", "BenchmarkTest02530", "verifyUserPassword('foo','bar')", "BenchmarkTest02530", "Movies", "BenchmarkTest02530", "Writing", "BenchmarkTest02530", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02531() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02531", "POST", "BenchmarkTest02531", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02532() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02532", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02532", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02533() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02533", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02533", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02534() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02534", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02534", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02535() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02535", "POST", "BenchmarkTest02535", "bar", "BenchmarkTest02535", "Movies", "BenchmarkTest02535", "Writing", "BenchmarkTest02535", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02536() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02536", "POST", "BenchmarkTest02536", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02537() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02537", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02537", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02538() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02538", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02538", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02539() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02539", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02539", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02540() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02540", "POST", "BenchmarkTest02540", "bar", "BenchmarkTest02540", "Movies", "BenchmarkTest02540", "Writing", "BenchmarkTest02540", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02541() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02541", "POST", "BenchmarkTest02541", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02542() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02542", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02542", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02543() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02543", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02543", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02544() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02544", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02544", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02545() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02545", "POST", "BenchmarkTest02545", "bar", "BenchmarkTest02545", "Movies", "BenchmarkTest02545", "Writing", "BenchmarkTest02545", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02546() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02546", "POST", "BenchmarkTest02546", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02625() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02625", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02625", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02626() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02626", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02626", "verifyUserPassword('foo','bar')");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02627() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02627", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02627", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02628() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02628", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02628", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02629() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02629", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02629", "verifyUserPassword('foo','bar')");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02630() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02630", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02630", "verifyUserPassword('foo','bar')");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02631() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02631", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02631", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02632() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02632", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02632", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02633() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02633", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02633", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02634() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02634", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02634", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02635() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02635", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02635", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02636() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02636", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02636", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02637() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02637", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02637", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02638() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02638", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02638", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02639() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02639", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02639", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02640() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02640", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02640", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02641() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02641", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02641", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02642() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02642", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02642", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02643() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02643", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02643", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02644() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02644", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02644", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02645() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02645", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02645", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02646() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02646", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02646", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02647() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-05/BenchmarkTest02647", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02647", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02648() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02648", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02648", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02649() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02649", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02649", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02650() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02650", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02650", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02651() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02651", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02651", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02652() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02652", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02652", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02653() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02653", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02653", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02654() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02654", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02654", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02655() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02655", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02655", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02656() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02656", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02656", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02657() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02657", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02657", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02727() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02727", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02727", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02728() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02728", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02728", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02729() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02729", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02729", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02730() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02730", "POST", "BenchmarkTest02730", "bar", "BenchmarkTest02730", "Movies", "BenchmarkTest02730", "Writing", "BenchmarkTest02730", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02731() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02731", "POST", "BenchmarkTest02731", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02732() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02732", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02732", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02733() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02733", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02733", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02734() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02734", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02734", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02735() throws Exception {
		submitFormAnyResponse("/owasp-benchmark/sqli-06/BenchmarkTest02735", "POST", "BenchmarkTest02735", "bar", "BenchmarkTest02735", "Movies", "BenchmarkTest02735", "Writing", "BenchmarkTest02735", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02736() throws Exception {
		submitFormAnyResponse("/benchmark/sqli-06/BenchmarkTest02736","POST","BenchmarkTest02736","bar");
	}
	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02737() throws Exception {
		submitFormAnyResponse("/benchmark/sqli-06/BenchmarkTest02737","GET","username","Hello","password","Hello","BenchmarkTest02737","bar");
	}
	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02738() throws Exception {
		submitFormAnyResponse("/benchmark/sqli-06/BenchmarkTest02738","POST","email","Hello","password","Hello","BenchmarkTest02738","bar");
	}
	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02739() throws Exception {
		submitFormAnyResponse("/benchmark/sqli-06/BenchmarkTest02739","POST","secure","Hello","productID","Hello","foo","foo","BenchmarkTest02739","bar");
	}
	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02740() throws Exception {
		submitFormAnyResponse("/benchmark/sqli-06/BenchmarkTest02740","POST","BenchmarkTest02740","bar","BenchmarkTest02740","Movies","BenchmarkTest02740","Writing","BenchmarkTest02740","Singing","foo","bar");
	}
}


