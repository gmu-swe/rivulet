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
@Sink(method = "java/nio/channels/SocketChannel.write(Ljava/nio/ByteBuffer;)I")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;II)J")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;)J")
public class OWASPXSSTest extends OWASPBaseTest {
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00013() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00013", "POST", "answer", "Hello", "BenchmarkTest00013Area", "Hello", "annoyingAJAX", "BenchmarkTest00013");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00014() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00014", "POST", "answer", "Hello", "BenchmarkTest00014Area", "Hello", "annoyingAJAX", "BenchmarkTest00014");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00030() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00030", "POST", "BenchmarkTest00030", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00036() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00036", "POST", "answer", "Hello", "BenchmarkTest00036", "SafeText", "BenchmarkTest00036Area", "Hello", "annoyingAJAX", "BenchmarkTest00036");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00041() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00041", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00041", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00047() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00047", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00047", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00048() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00048", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00048", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00049() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00049", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00049", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00144() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00144", "POST", "answer", "Hello", "BenchmarkTest00144Area", "Hello", "annoyingAJAX", "BenchmarkTest00144");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00145() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00145", "POST", "answer", "Hello", "BenchmarkTest00145Area", "Hello", "annoyingAJAX", "BenchmarkTest00145");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00146() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00146", "POST", "answer", "Hello", "BenchmarkTest00146Area", "Hello", "annoyingAJAX", "BenchmarkTest00146");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00147() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00147", "POST", "answer", "Hello", "BenchmarkTest00147Area", "Hello", "annoyingAJAX", "BenchmarkTest00147");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00148() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00148", "POST", "answer", "Hello", "BenchmarkTest00148Area", "Hello", "annoyingAJAX", "BenchmarkTest00148");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00149() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00149", "POST", "answer", "Hello", "BenchmarkTest00149Area", "Hello", "annoyingAJAX", "BenchmarkTest00149");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00150() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00150", "POST", "answer", "Hello", "BenchmarkTest00150Area", "Hello", "annoyingAJAX", "BenchmarkTest00150");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00151() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00151", "POST", "answer", "Hello", "BenchmarkTest00151Area", "Hello", "annoyingAJAX", "BenchmarkTest00151");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00152() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00152", "POST", "answer", "Hello", "BenchmarkTest00152Area", "Hello", "annoyingAJAX", "BenchmarkTest00152");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00153() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00153", "POST", "answer", "Hello", "BenchmarkTest00153Area", "Hello", "annoyingAJAX", "BenchmarkTest00153");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00154() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00154", "POST", "answer", "Hello", "BenchmarkTest00154Area", "Hello", "annoyingAJAX", "BenchmarkTest00154");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00155() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00155", "POST", "answer", "Hello", "BenchmarkTest00155Area", "Hello", "annoyingAJAX", "BenchmarkTest00155");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00156() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00156", "POST", "answer", "Hello", "BenchmarkTest00156Area", "Hello", "annoyingAJAX", "BenchmarkTest00156");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00157() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00157", "POST", "answer", "Hello", "BenchmarkTest00157Area", "Hello", "annoyingAJAX", "BenchmarkTest00157");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00275() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00275", "POST", "answer", "Hello", "BenchmarkTest00275Area", "Hello", "annoyingAJAX", "BenchmarkTest00275");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00276() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00276", "POST", "answer", "Hello", "BenchmarkTest00276Area", "Hello", "annoyingAJAX", "BenchmarkTest00276");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00277() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00277", "POST", "answer", "Hello", "BenchmarkTest00277Area", "Hello", "annoyingAJAX", "BenchmarkTest00277");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00278() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00278", "POST", "answer", "Hello", "BenchmarkTest00278Area", "Hello", "annoyingAJAX", "BenchmarkTest00278");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00279() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00279", "POST", "answer", "Hello", "BenchmarkTest00279Area", "Hello", "annoyingAJAX", "BenchmarkTest00279");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00280() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00280", "POST", "answer", "Hello", "BenchmarkTest00280Area", "Hello", "annoyingAJAX", "BenchmarkTest00280");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00281() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00281", "POST", "answer", "Hello", "BenchmarkTest00281Area", "Hello", "annoyingAJAX", "BenchmarkTest00281");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00282() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00282", "POST", "answer", "Hello", "BenchmarkTest00282Area", "Hello", "annoyingAJAX", "BenchmarkTest00282");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00283() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00283", "POST", "answer", "Hello", "BenchmarkTest00283Area", "Hello", "annoyingAJAX", "BenchmarkTest00283");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00284() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00284", "POST", "answer", "Hello", "BenchmarkTest00284Area", "Hello", "annoyingAJAX", "BenchmarkTest00284");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00285() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00285", "POST", "answer", "Hello", "BenchmarkTest00285Area", "Hello", "annoyingAJAX", "BenchmarkTest00285");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00286() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00286", "POST", "answer", "Hello", "BenchmarkTest00286Area", "Hello", "annoyingAJAX", "BenchmarkTest00286");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00287() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00287", "POST", "answer", "Hello", "BenchmarkTest00287Area", "Hello", "annoyingAJAX", "BenchmarkTest00287");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00288() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00288", "POST", "answer", "Hello", "BenchmarkTest00288Area", "Hello", "annoyingAJAX", "BenchmarkTest00288");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00289() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00289", "POST", "answer", "Hello", "BenchmarkTest00289Area", "Hello", "annoyingAJAX", "BenchmarkTest00289");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00290() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00290", "POST", "answer", "Hello", "BenchmarkTest00290Area", "Hello", "annoyingAJAX", "BenchmarkTest00290");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00291() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00291", "POST", "answer", "Hello", "BenchmarkTest00291Area", "Hello", "annoyingAJAX", "BenchmarkTest00291");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00292() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00292", "POST", "answer", "Hello", "BenchmarkTest00292Area", "Hello", "annoyingAJAX", "BenchmarkTest00292");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00301() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00301", "POST", "answer", "Hello", "BenchmarkTest00301Area", "Hello", "annoyingAJAX", "BenchmarkTest00301");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00375() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00375", "POST", "BenchmarkTest00375", "SafeText", "BenchmarkTest00375", "Movies", "BenchmarkTest00375", "Writing", "BenchmarkTest00375", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00376() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00376", "POST", "BenchmarkTest00376", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00377() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00377", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00377", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00378() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00378", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00378", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00379() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00379", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00379", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00380() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00380", "POST", "BenchmarkTest00380", "SafeText", "BenchmarkTest00380", "Movies", "BenchmarkTest00380", "Writing", "BenchmarkTest00380", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00381() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00381", "POST", "BenchmarkTest00381", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00382() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00382", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00382", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00383() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00383", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00383", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00384() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00384", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00384", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00385() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00385", "POST", "BenchmarkTest00385", "SafeText", "BenchmarkTest00385", "Movies", "BenchmarkTest00385", "Writing", "BenchmarkTest00385", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00386() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00386", "POST", "BenchmarkTest00386", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00387() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00387", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00387", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00388() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00388", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00388", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00389() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00389", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00389", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00390() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00390", "POST", "BenchmarkTest00390", "SafeText", "BenchmarkTest00390", "Movies", "BenchmarkTest00390", "Writing", "BenchmarkTest00390", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00391() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00391", "POST", "BenchmarkTest00391", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00392() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00392", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00392", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00393() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00393", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00393", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00394() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00394", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00394", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00395() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00395", "POST", "BenchmarkTest00395", "SafeText", "BenchmarkTest00395", "Movies", "BenchmarkTest00395", "Writing", "BenchmarkTest00395", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00467() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00467", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00467", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00468() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00468", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00468", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00469() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00469", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00469", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00470() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00470", "POST", "BenchmarkTest00470", "SafeText", "BenchmarkTest00470", "Movies", "BenchmarkTest00470", "Writing", "BenchmarkTest00470", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00471() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00471", "POST", "BenchmarkTest00471", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00472() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00472", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00472", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00473() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00473", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00473", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00474() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00474", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00474", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00475() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00475", "POST", "BenchmarkTest00475", "SafeText", "BenchmarkTest00475", "Movies", "BenchmarkTest00475", "Writing", "BenchmarkTest00475", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00476() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00476", "POST", "BenchmarkTest00476", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00477() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00477", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00477", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00478() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00478", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00478", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00479() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00479", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00479", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00492() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00492", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00492", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00493() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00493", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00493", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00541() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00541", "POST", "answer", "Hello", "BenchmarkTest00541", "SafeText", "BenchmarkTest00541Area", "Hello", "annoyingAJAX", "BenchmarkTest00541");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00542() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00542", "POST", "answer", "Hello", "BenchmarkTest00542", "SafeText", "BenchmarkTest00542Area", "Hello", "annoyingAJAX", "BenchmarkTest00542");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00543() throws Exception {
		submitForm("/owasp-benchmark/xss-00/BenchmarkTest00543", "POST", "answer", "Hello", "BenchmarkTest00543", "SafeText", "BenchmarkTest00543Area", "Hello", "annoyingAJAX", "BenchmarkTest00543");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00544() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00544", "POST", "answer", "Hello", "BenchmarkTest00544", "SafeText", "BenchmarkTest00544Area", "Hello", "annoyingAJAX", "BenchmarkTest00544");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00545() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00545", "POST", "answer", "Hello", "BenchmarkTest00545", "SafeText", "BenchmarkTest00545Area", "Hello", "annoyingAJAX", "BenchmarkTest00545");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00546() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00546", "POST", "answer", "Hello", "BenchmarkTest00546", "SafeText", "BenchmarkTest00546Area", "Hello", "annoyingAJAX", "BenchmarkTest00546");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00547() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00547", "POST", "answer", "Hello", "BenchmarkTest00547", "SafeText", "BenchmarkTest00547Area", "Hello", "annoyingAJAX", "BenchmarkTest00547");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00548() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00548", "POST", "answer", "Hello", "BenchmarkTest00548", "SafeText", "BenchmarkTest00548Area", "Hello", "annoyingAJAX", "BenchmarkTest00548");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00549() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00549", "POST", "answer", "Hello", "BenchmarkTest00549", "SafeText", "BenchmarkTest00549Area", "Hello", "annoyingAJAX", "BenchmarkTest00549");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00550() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00550", "POST", "answer", "Hello", "BenchmarkTest00550", "SafeText", "BenchmarkTest00550Area", "Hello", "annoyingAJAX", "BenchmarkTest00550");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00551() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00551", "POST", "answer", "Hello", "BenchmarkTest00551", "SafeText", "BenchmarkTest00551Area", "Hello", "annoyingAJAX", "BenchmarkTest00551");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00552() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00552", "POST", "answer", "Hello", "BenchmarkTest00552", "SafeText", "BenchmarkTest00552Area", "Hello", "annoyingAJAX", "BenchmarkTest00552");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00553() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00553", "POST", "answer", "Hello", "BenchmarkTest00553", "SafeText", "BenchmarkTest00553Area", "Hello", "annoyingAJAX", "BenchmarkTest00553");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00554() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00554", "POST", "answer", "Hello", "BenchmarkTest00554", "SafeText", "BenchmarkTest00554Area", "Hello", "annoyingAJAX", "BenchmarkTest00554");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00555() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00555", "POST", "answer", "Hello", "BenchmarkTest00555", "SafeText", "BenchmarkTest00555Area", "Hello", "annoyingAJAX", "BenchmarkTest00555");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00556() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00556", "POST", "answer", "Hello", "BenchmarkTest00556", "SafeText", "BenchmarkTest00556Area", "Hello", "annoyingAJAX", "BenchmarkTest00556");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00557() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00557", "POST", "answer", "Hello", "BenchmarkTest00557", "SafeText", "BenchmarkTest00557Area", "Hello", "annoyingAJAX", "BenchmarkTest00557");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00642() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00642", "POST", "BenchmarkTest00642", "SafeText", "BenchmarkTest00642", "Movies", "BenchmarkTest00642", "Writing", "BenchmarkTest00642", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00643() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00643", "POST", "BenchmarkTest00643", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00644() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00644", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00644", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00645() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00645", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00645", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00646() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00646", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00646", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00647() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00647", "POST", "BenchmarkTest00647", "SafeText", "BenchmarkTest00647", "Movies", "BenchmarkTest00647", "Writing", "BenchmarkTest00647", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00648() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00648", "POST", "BenchmarkTest00648", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00649() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00649", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00649", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00650() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00650", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00650", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00651() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00651", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00651", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00656() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00656", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00656", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00711() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00711", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00711", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00712() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00712", "POST", "BenchmarkTest00712", "SafeText", "BenchmarkTest00712", "Movies", "BenchmarkTest00712", "Writing", "BenchmarkTest00712", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00713() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00713", "POST", "BenchmarkTest00713", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00714() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00714", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00714", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00715() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00715", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00715", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00716() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00716", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00716", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00717() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00717", "POST", "BenchmarkTest00717", "SafeText", "BenchmarkTest00717", "Movies", "BenchmarkTest00717", "Writing", "BenchmarkTest00717", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00718() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00718", "POST", "BenchmarkTest00718", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00719() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00719", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00719", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00720() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00720", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00720", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00721() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00721", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00721", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00722() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00722", "POST", "BenchmarkTest00722", "SafeText", "BenchmarkTest00722", "Movies", "BenchmarkTest00722", "Writing", "BenchmarkTest00722", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00723() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00723", "POST", "BenchmarkTest00723", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00724() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00724", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00724", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00725() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00725", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00725", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00726() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00726", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00726", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00727() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00727", "POST", "BenchmarkTest00727", "SafeText", "BenchmarkTest00727", "Movies", "BenchmarkTest00727", "Writing", "BenchmarkTest00727", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00728() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00728", "POST", "BenchmarkTest00728", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00729() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00729", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00729", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00730() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00730", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00730", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00737() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00737", "POST", "BenchmarkTest00737", "SafeText", "BenchmarkTest00737", "Movies", "BenchmarkTest00737", "Writing", "BenchmarkTest00737", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00799() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00799", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00799", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00800() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00800", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00800", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00801() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00801", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00801", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00802() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00802", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00802", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00803() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00803", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00803", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00804() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00804", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00804", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00805() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00805", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00805", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00806() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00806", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00806", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00807() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00807", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00807", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00808() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00808", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00808", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00809() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00809", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00809", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00810() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00810", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00810", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00811() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00811", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00811", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00812() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00812", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00812", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00813() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00813", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00813", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest00822() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00822", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00822", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00879() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00879", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00879", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00880() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00880", "POST", "BenchmarkTest00880", "SafeText", "BenchmarkTest00880", "Movies", "BenchmarkTest00880", "Writing", "BenchmarkTest00880", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00881() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00881", "POST", "BenchmarkTest00881", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00882() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00882", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00882", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00883() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00883", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00883", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00884() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00884", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00884", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00885() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00885", "POST", "BenchmarkTest00885", "SafeText", "BenchmarkTest00885", "Movies", "BenchmarkTest00885", "Writing", "BenchmarkTest00885", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00886() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00886", "POST", "BenchmarkTest00886", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00887() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00887", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00887", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00888() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00888", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00888", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00889() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00889", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00889", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00890() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00890", "POST", "BenchmarkTest00890", "SafeText", "BenchmarkTest00890", "Movies", "BenchmarkTest00890", "Writing", "BenchmarkTest00890", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00891() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00891", "POST", "BenchmarkTest00891", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00892() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00892", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest00892", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00893() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00893", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest00893", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest00894() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest00894", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest00894", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01046() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest01046", "POST", "answer", "Hello", "BenchmarkTest01046Area", "Hello", "annoyingAJAX", "BenchmarkTest01046");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01047() throws Exception {
		submitForm("/owasp-benchmark/xss-01/BenchmarkTest01047", "POST", "answer", "Hello", "BenchmarkTest01047Area", "Hello", "annoyingAJAX", "BenchmarkTest01047");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01048() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01048", "POST", "answer", "Hello", "BenchmarkTest01048Area", "Hello", "annoyingAJAX", "BenchmarkTest01048");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01049() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01049", "POST", "answer", "Hello", "BenchmarkTest01049Area", "Hello", "annoyingAJAX", "BenchmarkTest01049");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01050() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01050", "POST", "answer", "Hello", "BenchmarkTest01050Area", "Hello", "annoyingAJAX", "BenchmarkTest01050");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01051() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01051", "POST", "answer", "Hello", "BenchmarkTest01051Area", "Hello", "annoyingAJAX", "BenchmarkTest01051");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01052() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01052", "POST", "answer", "Hello", "BenchmarkTest01052Area", "Hello", "annoyingAJAX", "BenchmarkTest01052");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01053() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01053", "POST", "answer", "Hello", "BenchmarkTest01053Area", "Hello", "annoyingAJAX", "BenchmarkTest01053");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01054() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01054", "POST", "answer", "Hello", "BenchmarkTest01054Area", "Hello", "annoyingAJAX", "BenchmarkTest01054");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01055() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01055", "POST", "answer", "Hello", "BenchmarkTest01055Area", "Hello", "annoyingAJAX", "BenchmarkTest01055");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01056() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01056", "POST", "answer", "Hello", "BenchmarkTest01056Area", "Hello", "annoyingAJAX", "BenchmarkTest01056");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01057() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01057", "POST", "answer", "Hello", "BenchmarkTest01057Area", "Hello", "annoyingAJAX", "BenchmarkTest01057");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01063() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01063", "POST", "answer", "Hello", "BenchmarkTest01063Area", "Hello", "annoyingAJAX", "BenchmarkTest01063");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01171() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01171", "POST", "answer", "Hello", "BenchmarkTest01171Area", "Hello", "annoyingAJAX", "BenchmarkTest01171");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01172() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01172", "POST", "answer", "Hello", "BenchmarkTest01172Area", "Hello", "annoyingAJAX", "BenchmarkTest01172");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01173() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01173", "POST", "answer", "Hello", "BenchmarkTest01173Area", "Hello", "annoyingAJAX", "BenchmarkTest01173");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01174() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01174", "POST", "answer", "Hello", "BenchmarkTest01174Area", "Hello", "annoyingAJAX", "BenchmarkTest01174");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01175() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01175", "POST", "answer", "Hello", "BenchmarkTest01175Area", "Hello", "annoyingAJAX", "BenchmarkTest01175");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01176() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01176", "POST", "answer", "Hello", "BenchmarkTest01176Area", "Hello", "annoyingAJAX", "BenchmarkTest01176");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01177() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01177", "POST", "answer", "Hello", "BenchmarkTest01177Area", "Hello", "annoyingAJAX", "BenchmarkTest01177");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01178() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01178", "POST", "answer", "Hello", "BenchmarkTest01178Area", "Hello", "annoyingAJAX", "BenchmarkTest01178");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01179() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01179", "POST", "answer", "Hello", "BenchmarkTest01179Area", "Hello", "annoyingAJAX", "BenchmarkTest01179");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01180() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01180", "POST", "answer", "Hello", "BenchmarkTest01180Area", "Hello", "annoyingAJAX", "BenchmarkTest01180");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01181() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01181", "POST", "answer", "Hello", "BenchmarkTest01181Area", "Hello", "annoyingAJAX", "BenchmarkTest01181");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01188() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01188", "POST", "answer", "Hello", "BenchmarkTest01188Area", "Hello", "annoyingAJAX", "BenchmarkTest01188");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01251() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01251", "POST", "BenchmarkTest01251", "SafeText", "BenchmarkTest01251", "Movies", "BenchmarkTest01251", "Writing", "BenchmarkTest01251", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01252() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01252", "POST", "BenchmarkTest01252", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01253() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01253", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01253", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01254() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01254", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01254", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01255() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01255", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01255", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01256() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01256", "POST", "BenchmarkTest01256", "SafeText", "BenchmarkTest01256", "Movies", "BenchmarkTest01256", "Writing", "BenchmarkTest01256", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01257() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01257", "POST", "BenchmarkTest01257", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01258() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01258", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01258", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01259() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01259", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01259", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01260() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01260", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01260", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01261() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01261", "POST", "BenchmarkTest01261", "SafeText", "BenchmarkTest01261", "Movies", "BenchmarkTest01261", "Writing", "BenchmarkTest01261", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01262() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01262", "POST", "BenchmarkTest01262", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01263() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01263", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01263", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01264() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01264", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01264", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01265() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01265", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01265", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01266() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01266", "POST", "BenchmarkTest01266", "SafeText", "BenchmarkTest01266", "Movies", "BenchmarkTest01266", "Writing", "BenchmarkTest01266", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01267() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01267", "POST", "BenchmarkTest01267", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01268() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01268", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01268", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01284() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01284", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01284", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01335() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01335", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01335", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01336() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01336", "POST", "BenchmarkTest01336", "SafeText", "BenchmarkTest01336", "Movies", "BenchmarkTest01336", "Writing", "BenchmarkTest01336", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01337() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01337", "POST", "BenchmarkTest01337", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01338() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01338", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01338", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01339() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01339", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01339", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01340() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01340", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01340", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01341() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01341", "POST", "BenchmarkTest01341", "SafeText", "BenchmarkTest01341", "Movies", "BenchmarkTest01341", "Writing", "BenchmarkTest01341", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01342() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01342", "POST", "BenchmarkTest01342", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01343() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01343", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01343", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01344() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01344", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01344", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01345() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01345", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01345", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01346() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01346", "POST", "BenchmarkTest01346", "SafeText", "BenchmarkTest01346", "Movies", "BenchmarkTest01346", "Writing", "BenchmarkTest01346", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01347() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01347", "POST", "BenchmarkTest01347", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01348() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01348", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01348", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01349() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01349", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01349", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01350() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01350", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01350", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01351() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01351", "POST", "BenchmarkTest01351", "SafeText", "BenchmarkTest01351", "Movies", "BenchmarkTest01351", "Writing", "BenchmarkTest01351", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01352() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01352", "POST", "BenchmarkTest01352", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01417() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01417", "POST", "answer", "Hello", "BenchmarkTest01417", "SafeText", "BenchmarkTest01417Area", "Hello", "annoyingAJAX", "BenchmarkTest01417");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01418() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01418", "POST", "answer", "Hello", "BenchmarkTest01418", "SafeText", "BenchmarkTest01418Area", "Hello", "annoyingAJAX", "BenchmarkTest01418");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01419() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01419", "POST", "answer", "Hello", "BenchmarkTest01419", "SafeText", "BenchmarkTest01419Area", "Hello", "annoyingAJAX", "BenchmarkTest01419");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01420() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01420", "POST", "answer", "Hello", "BenchmarkTest01420", "SafeText", "BenchmarkTest01420Area", "Hello", "annoyingAJAX", "BenchmarkTest01420");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01421() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01421", "POST", "answer", "Hello", "BenchmarkTest01421", "SafeText", "BenchmarkTest01421Area", "Hello", "annoyingAJAX", "BenchmarkTest01421");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01422() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01422", "POST", "answer", "Hello", "BenchmarkTest01422", "SafeText", "BenchmarkTest01422Area", "Hello", "annoyingAJAX", "BenchmarkTest01422");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01423() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01423", "POST", "answer", "Hello", "BenchmarkTest01423", "SafeText", "BenchmarkTest01423Area", "Hello", "annoyingAJAX", "BenchmarkTest01423");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01424() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01424", "POST", "answer", "Hello", "BenchmarkTest01424", "SafeText", "BenchmarkTest01424Area", "Hello", "annoyingAJAX", "BenchmarkTest01424");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01425() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01425", "POST", "answer", "Hello", "BenchmarkTest01425", "SafeText", "BenchmarkTest01425Area", "Hello", "annoyingAJAX", "BenchmarkTest01425");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01426() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01426", "POST", "answer", "Hello", "BenchmarkTest01426", "SafeText", "BenchmarkTest01426Area", "Hello", "annoyingAJAX", "BenchmarkTest01426");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01427() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01427", "POST", "answer", "Hello", "BenchmarkTest01427", "SafeText", "BenchmarkTest01427Area", "Hello", "annoyingAJAX", "BenchmarkTest01427");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01428() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01428", "POST", "answer", "Hello", "BenchmarkTest01428", "SafeText", "BenchmarkTest01428Area", "Hello", "annoyingAJAX", "BenchmarkTest01428");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01429() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01429", "POST", "answer", "Hello", "BenchmarkTest01429", "SafeText", "BenchmarkTest01429Area", "Hello", "annoyingAJAX", "BenchmarkTest01429");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01437() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01437", "POST", "answer", "Hello", "BenchmarkTest01437", "SafeText", "BenchmarkTest01437Area", "Hello", "annoyingAJAX", "BenchmarkTest01437");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01438() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01438", "POST", "answer", "Hello", "BenchmarkTest01438", "SafeText", "BenchmarkTest01438Area", "Hello", "annoyingAJAX", "BenchmarkTest01438");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01439() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01439", "POST", "answer", "Hello", "BenchmarkTest01439", "SafeText", "BenchmarkTest01439Area", "Hello", "annoyingAJAX", "BenchmarkTest01439");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01505() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01505", "POST", "BenchmarkTest01505", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01506() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01506", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01506", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01507() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01507", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01507", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01508() throws Exception {
		submitForm("/owasp-benchmark/xss-02/BenchmarkTest01508", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01508", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01509() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01509", "POST", "BenchmarkTest01509", "SafeText", "BenchmarkTest01509", "Movies", "BenchmarkTest01509", "Writing", "BenchmarkTest01509", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01510() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01510", "POST", "BenchmarkTest01510", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01511() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01511", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01511", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01512() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01512", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01512", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01513() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01513", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01513", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01514() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01514", "POST", "BenchmarkTest01514", "SafeText", "BenchmarkTest01514", "Movies", "BenchmarkTest01514", "Writing", "BenchmarkTest01514", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01515() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01515", "POST", "BenchmarkTest01515", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01525() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01525", "POST", "BenchmarkTest01525", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01583() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01583", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01583", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01584() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01584", "POST", "BenchmarkTest01584", "SafeText", "BenchmarkTest01584", "Movies", "BenchmarkTest01584", "Writing", "BenchmarkTest01584", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01585() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01585", "POST", "BenchmarkTest01585", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01586() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01586", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01586", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01587() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01587", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01587", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01588() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01588", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01588", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01589() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01589", "POST", "BenchmarkTest01589", "SafeText", "BenchmarkTest01589", "Movies", "BenchmarkTest01589", "Writing", "BenchmarkTest01589", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01590() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01590", "POST", "BenchmarkTest01590", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01591() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01591", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01591", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01592() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01592", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01592", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01593() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01593", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01593", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01594() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01594", "POST", "BenchmarkTest01594", "SafeText", "BenchmarkTest01594", "Movies", "BenchmarkTest01594", "Writing", "BenchmarkTest01594", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01595() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01595", "POST", "BenchmarkTest01595", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01596() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01596", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01596", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01597() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01597", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01597", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01598() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01598", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01598", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01599() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01599", "POST", "BenchmarkTest01599", "SafeText", "BenchmarkTest01599", "Movies", "BenchmarkTest01599", "Writing", "BenchmarkTest01599", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01657() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01657", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01657", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01658() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01658", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01658", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01659() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01659", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01659", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01660() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01660", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01660", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01661() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01661", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01661", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01662() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01662", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01662", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01663() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01663", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01663", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01664() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01664", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01664", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01665() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01665", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01665", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01666() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01666", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01666", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01667() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01667", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01667", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01668() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01668", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01668", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01669() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01669", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01669", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01670() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01670", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01670", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01671() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01671", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01671", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01767() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01767", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01767", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01768() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01768", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01768", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01769() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01769", "POST", "BenchmarkTest01769", "SafeText", "BenchmarkTest01769", "Movies", "BenchmarkTest01769", "Writing", "BenchmarkTest01769", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01770() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01770", "POST", "BenchmarkTest01770", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01771() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01771", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01771", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01772() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01772", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01772", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01773() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01773", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest01773", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01774() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01774", "POST", "BenchmarkTest01774", "SafeText", "BenchmarkTest01774", "Movies", "BenchmarkTest01774", "Writing", "BenchmarkTest01774", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01775() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01775", "POST", "BenchmarkTest01775", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01776() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01776", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest01776", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01777() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01777", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest01777", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01790() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01790", "POST", "BenchmarkTest01790", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01914() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01914", "POST", "answer", "Hello", "BenchmarkTest01914Area", "Hello", "annoyingAJAX", "BenchmarkTest01914");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01915() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01915", "POST", "answer", "Hello", "BenchmarkTest01915Area", "Hello", "annoyingAJAX", "BenchmarkTest01915");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01916() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01916", "POST", "answer", "Hello", "BenchmarkTest01916Area", "Hello", "annoyingAJAX", "BenchmarkTest01916");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01917() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01917", "POST", "answer", "Hello", "BenchmarkTest01917Area", "Hello", "annoyingAJAX", "BenchmarkTest01917");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01918() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01918", "POST", "answer", "Hello", "BenchmarkTest01918Area", "Hello", "annoyingAJAX", "BenchmarkTest01918");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01919() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01919", "POST", "answer", "Hello", "BenchmarkTest01919Area", "Hello", "annoyingAJAX", "BenchmarkTest01919");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01920() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01920", "POST", "answer", "Hello", "BenchmarkTest01920Area", "Hello", "annoyingAJAX", "BenchmarkTest01920");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01921() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01921", "POST", "answer", "Hello", "BenchmarkTest01921Area", "Hello", "annoyingAJAX", "BenchmarkTest01921");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01922() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01922", "POST", "answer", "Hello", "BenchmarkTest01922Area", "Hello", "annoyingAJAX", "BenchmarkTest01922");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01923() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01923", "POST", "answer", "Hello", "BenchmarkTest01923Area", "Hello", "annoyingAJAX", "BenchmarkTest01923");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest01924() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01924", "POST", "answer", "Hello", "BenchmarkTest01924Area", "Hello", "annoyingAJAX", "BenchmarkTest01924");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01925() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01925", "POST", "answer", "Hello", "BenchmarkTest01925Area", "Hello", "annoyingAJAX", "BenchmarkTest01925");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01926() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01926", "POST", "answer", "Hello", "BenchmarkTest01926Area", "Hello", "annoyingAJAX", "BenchmarkTest01926");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest01927() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest01927", "POST", "answer", "Hello", "BenchmarkTest01927Area", "Hello", "annoyingAJAX", "BenchmarkTest01927");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02045() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest02045", "POST", "answer", "Hello", "BenchmarkTest02045Area", "Hello", "annoyingAJAX", "BenchmarkTest02045");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02046() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest02046", "POST", "answer", "Hello", "BenchmarkTest02046Area", "Hello", "annoyingAJAX", "BenchmarkTest02046");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02047() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest02047", "POST", "answer", "Hello", "BenchmarkTest02047Area", "Hello", "annoyingAJAX", "BenchmarkTest02047");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02048() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest02048", "POST", "answer", "Hello", "BenchmarkTest02048Area", "Hello", "annoyingAJAX", "BenchmarkTest02048");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02049() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest02049", "POST", "answer", "Hello", "BenchmarkTest02049Area", "Hello", "annoyingAJAX", "BenchmarkTest02049");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02050() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest02050", "POST", "answer", "Hello", "BenchmarkTest02050Area", "Hello", "annoyingAJAX", "BenchmarkTest02050");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02051() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest02051", "POST", "answer", "Hello", "BenchmarkTest02051Area", "Hello", "annoyingAJAX", "BenchmarkTest02051");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02052() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest02052", "POST", "answer", "Hello", "BenchmarkTest02052Area", "Hello", "annoyingAJAX", "BenchmarkTest02052");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02053() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest02053", "POST", "answer", "Hello", "BenchmarkTest02053Area", "Hello", "annoyingAJAX", "BenchmarkTest02053");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02054() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest02054", "POST", "answer", "Hello", "BenchmarkTest02054Area", "Hello", "annoyingAJAX", "BenchmarkTest02054");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02055() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest02055", "POST", "answer", "Hello", "BenchmarkTest02055Area", "Hello", "annoyingAJAX", "BenchmarkTest02055");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02056() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest02056", "POST", "answer", "Hello", "BenchmarkTest02056Area", "Hello", "annoyingAJAX", "BenchmarkTest02056");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02057() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest02057", "POST", "answer", "Hello", "BenchmarkTest02057Area", "Hello", "annoyingAJAX", "BenchmarkTest02057");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02122() throws Exception {
		submitForm("/owasp-benchmark/xss-03/BenchmarkTest02122", "POST", "BenchmarkTest02122", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02123() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02123", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02123", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02124() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02124", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02124", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02125() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02125", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02125", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02126() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02126", "POST", "BenchmarkTest02126", "SafeText", "BenchmarkTest02126", "Movies", "BenchmarkTest02126", "Writing", "BenchmarkTest02126", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02127() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02127", "POST", "BenchmarkTest02127", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02128() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02128", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02128", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02129() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02129", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02129", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02130() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02130", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02130", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02131() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02131", "POST", "BenchmarkTest02131", "SafeText", "BenchmarkTest02131", "Movies", "BenchmarkTest02131", "Writing", "BenchmarkTest02131", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02132() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02132", "POST", "BenchmarkTest02132", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02133() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02133", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02133", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02134() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02134", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02134", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02135() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02135", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02135", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02136() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02136", "POST", "BenchmarkTest02136", "SafeText", "BenchmarkTest02136", "Movies", "BenchmarkTest02136", "Writing", "BenchmarkTest02136", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02145() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02145", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02145", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02221() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02221", "POST", "BenchmarkTest02221", "SafeText", "BenchmarkTest02221", "Movies", "BenchmarkTest02221", "Writing", "BenchmarkTest02221", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02222() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02222", "POST", "BenchmarkTest02222", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02223() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02223", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02223", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02224() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02224", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02224", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02225() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02225", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02225", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02226() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02226", "POST", "BenchmarkTest02226", "SafeText", "BenchmarkTest02226", "Movies", "BenchmarkTest02226", "Writing", "BenchmarkTest02226", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02227() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02227", "POST", "BenchmarkTest02227", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02228() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02228", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02228", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02229() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02229", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02229", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02230() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02230", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02230", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02231() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02231", "POST", "BenchmarkTest02231", "SafeText", "BenchmarkTest02231", "Movies", "BenchmarkTest02231", "Writing", "BenchmarkTest02231", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02232() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02232", "POST", "BenchmarkTest02232", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02233() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02233", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02233", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02234() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02234", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02234", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02235() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02235", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02235", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02236() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02236", "POST", "BenchmarkTest02236", "SafeText", "BenchmarkTest02236", "Movies", "BenchmarkTest02236", "Writing", "BenchmarkTest02236", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02237() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02237", "POST", "BenchmarkTest02237", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02238() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02238", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02238", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02239() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02239", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02239", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02240() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02240", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02240", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02241() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02241", "POST", "BenchmarkTest02241", "SafeText", "BenchmarkTest02241", "Movies", "BenchmarkTest02241", "Writing", "BenchmarkTest02241", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02313() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02313", "POST", "answer", "Hello", "BenchmarkTest02313", "SafeText", "BenchmarkTest02313Area", "Hello", "annoyingAJAX", "BenchmarkTest02313");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02314() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02314", "POST", "answer", "Hello", "BenchmarkTest02314", "SafeText", "BenchmarkTest02314Area", "Hello", "annoyingAJAX", "BenchmarkTest02314");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02315() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02315", "POST", "answer", "Hello", "BenchmarkTest02315", "SafeText", "BenchmarkTest02315Area", "Hello", "annoyingAJAX", "BenchmarkTest02315");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02316() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02316", "POST", "answer", "Hello", "BenchmarkTest02316", "SafeText", "BenchmarkTest02316Area", "Hello", "annoyingAJAX", "BenchmarkTest02316");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02317() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02317", "POST", "answer", "Hello", "BenchmarkTest02317", "SafeText", "BenchmarkTest02317Area", "Hello", "annoyingAJAX", "BenchmarkTest02317");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02318() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02318", "POST", "answer", "Hello", "BenchmarkTest02318", "SafeText", "BenchmarkTest02318Area", "Hello", "annoyingAJAX", "BenchmarkTest02318");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02319() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02319", "POST", "answer", "Hello", "BenchmarkTest02319", "SafeText", "BenchmarkTest02319Area", "Hello", "annoyingAJAX", "BenchmarkTest02319");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02320() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02320", "POST", "answer", "Hello", "BenchmarkTest02320", "SafeText", "BenchmarkTest02320Area", "Hello", "annoyingAJAX", "BenchmarkTest02320");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02321() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02321", "POST", "answer", "Hello", "BenchmarkTest02321", "SafeText", "BenchmarkTest02321Area", "Hello", "annoyingAJAX", "BenchmarkTest02321");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02322() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02322", "POST", "answer", "Hello", "BenchmarkTest02322", "SafeText", "BenchmarkTest02322Area", "Hello", "annoyingAJAX", "BenchmarkTest02322");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02323() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02323", "POST", "answer", "Hello", "BenchmarkTest02323", "SafeText", "BenchmarkTest02323Area", "Hello", "annoyingAJAX", "BenchmarkTest02323");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02324() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02324", "POST", "answer", "Hello", "BenchmarkTest02324", "SafeText", "BenchmarkTest02324Area", "Hello", "annoyingAJAX", "BenchmarkTest02324");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02325() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02325", "POST", "answer", "Hello", "BenchmarkTest02325", "SafeText", "BenchmarkTest02325Area", "Hello", "annoyingAJAX", "BenchmarkTest02325");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02326() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02326", "POST", "answer", "Hello", "BenchmarkTest02326", "SafeText", "BenchmarkTest02326Area", "Hello", "annoyingAJAX", "BenchmarkTest02326");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02327() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02327", "POST", "answer", "Hello", "BenchmarkTest02327", "SafeText", "BenchmarkTest02327Area", "Hello", "annoyingAJAX", "BenchmarkTest02327");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02328() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02328", "POST", "answer", "Hello", "BenchmarkTest02328", "SafeText", "BenchmarkTest02328Area", "Hello", "annoyingAJAX", "BenchmarkTest02328");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02329() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02329", "POST", "answer", "Hello", "BenchmarkTest02329", "SafeText", "BenchmarkTest02329Area", "Hello", "annoyingAJAX", "BenchmarkTest02329");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02330() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02330", "POST", "answer", "Hello", "BenchmarkTest02330", "SafeText", "BenchmarkTest02330Area", "Hello", "annoyingAJAX", "BenchmarkTest02330");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02331() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02331", "POST", "answer", "Hello", "BenchmarkTest02331", "SafeText", "BenchmarkTest02331Area", "Hello", "annoyingAJAX", "BenchmarkTest02331");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02332() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02332", "POST", "answer", "Hello", "BenchmarkTest02332", "SafeText", "BenchmarkTest02332Area", "Hello", "annoyingAJAX", "BenchmarkTest02332");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02394() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02394", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02394", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02395() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02395", "POST", "BenchmarkTest02395", "SafeText", "BenchmarkTest02395", "Movies", "BenchmarkTest02395", "Writing", "BenchmarkTest02395", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02396() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02396", "POST", "BenchmarkTest02396", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02397() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02397", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02397", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02398() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02398", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02398", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02399() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02399", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02399", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02400() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02400", "POST", "BenchmarkTest02400", "SafeText", "BenchmarkTest02400", "Movies", "BenchmarkTest02400", "Writing", "BenchmarkTest02400", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02401() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02401", "POST", "BenchmarkTest02401", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02402() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02402", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02402", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02403() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02403", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02403", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02404() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02404", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02404", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02405() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02405", "POST", "BenchmarkTest02405", "SafeText", "BenchmarkTest02405", "Movies", "BenchmarkTest02405", "Writing", "BenchmarkTest02405", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02406() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02406", "POST", "BenchmarkTest02406", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02407() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02407", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02407", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02408() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02408", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02408", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02409() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02409", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02409", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02410() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02410", "POST", "BenchmarkTest02410", "SafeText", "BenchmarkTest02410", "Movies", "BenchmarkTest02410", "Writing", "BenchmarkTest02410", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02480() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02480", "POST", "BenchmarkTest02480", "SafeText", "BenchmarkTest02480", "Movies", "BenchmarkTest02480", "Writing", "BenchmarkTest02480", "Singing", "foo", "bar");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02481() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02481", "POST", "BenchmarkTest02481", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02482() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02482", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02482", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02483() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02483", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02483", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02484() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02484", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02484", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02485() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02485", "POST", "BenchmarkTest02485", "SafeText", "BenchmarkTest02485", "Movies", "BenchmarkTest02485", "Writing", "BenchmarkTest02485", "Singing", "foo", "bar");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02486() throws Exception {
		submitForm("/owasp-benchmark/xss-04/BenchmarkTest02486", "POST", "BenchmarkTest02486", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02487() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02487", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02487", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02488() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02488", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02488", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02489() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02489", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02489", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02490() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02490", "POST", "BenchmarkTest02490", "SafeText", "BenchmarkTest02490", "Movies", "BenchmarkTest02490", "Writing", "BenchmarkTest02490", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02491() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02491", "POST", "BenchmarkTest02491", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02492() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02492", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02492", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02493() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02493", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02493", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02494() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02494", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02494", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02495() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02495", "POST", "BenchmarkTest02495", "SafeText", "BenchmarkTest02495", "Movies", "BenchmarkTest02495", "Writing", "BenchmarkTest02495", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02509() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02509", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02509", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02578() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02578", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02578", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02579() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02579", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02579", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02580() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02580", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02580", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02581() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02581", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02581", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02582() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02582", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02582", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02583() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02583", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02583", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02584() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02584", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02584", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02585() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02585", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02585", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02586() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02586", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02586", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02587() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02587", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02587", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02588() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02588", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02588", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02589() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02589", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02589", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02590() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02590", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02590", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02591() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02591", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02591", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02592() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02592", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02592", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02593() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02593", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02593", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02594() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02594", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02594", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02595() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02595", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02595", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02596() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02596", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02596", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02597() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02597", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02597", "SafeText");
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02598() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02598", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02598", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02599() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02599", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02599", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02600() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02600", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02600", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02601() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02601", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02601", "SafeText");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBenchmarkTest02608() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02608", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02608", "SafeText");
		checkViolationsIncreased();
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02609() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02609", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02609", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02679() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02679", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02679", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02680() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02680", "POST", "BenchmarkTest02680", "SafeText", "BenchmarkTest02680", "Movies", "BenchmarkTest02680", "Writing", "BenchmarkTest02680", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02681() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02681", "POST", "BenchmarkTest02681", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02682() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02682", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02682", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02683() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02683", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02683", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02684() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02684", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02684", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02685() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02685", "POST", "BenchmarkTest02685", "SafeText", "BenchmarkTest02685", "Movies", "BenchmarkTest02685", "Writing", "BenchmarkTest02685", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02686() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02686", "POST", "BenchmarkTest02686", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02687() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02687", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02687", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02688() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02688", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02688", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02689() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02689", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02689", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02690() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02690", "POST", "BenchmarkTest02690", "SafeText", "BenchmarkTest02690", "Movies", "BenchmarkTest02690", "Writing", "BenchmarkTest02690", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02691() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02691", "POST", "BenchmarkTest02691", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02692() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02692", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02692", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02693() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02693", "POST", "email", "Hello", "password", "Hello", "BenchmarkTest02693", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02694() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02694", "POST", "secure", "Hello", "productID", "Hello", "foo", "foo", "BenchmarkTest02694", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02695() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02695", "POST", "BenchmarkTest02695", "SafeText", "BenchmarkTest02695", "Movies", "BenchmarkTest02695", "Writing", "BenchmarkTest02695", "Singing", "foo", "bar");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02696() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02696", "POST", "BenchmarkTest02696", "SafeText");
	}

	//This test is specified as a false positive in its OWASP config and should not have any violations.
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.ANY)
	public void testBenchmarkTest02712() throws Exception {
		submitForm("/owasp-benchmark/xss-05/BenchmarkTest02712", "GET", "username", "Hello", "password", "Hello", "BenchmarkTest02712", "SafeText");
	}
}


