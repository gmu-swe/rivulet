package io.rivulet.maven.test.wavsep;

import io.rivulet.fuzz.Sink;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Source;

import static io.rivulet.maven.test.wavsep.WavsepPath.*;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Sink(method = "java/nio/channels/SocketChannel.write(Ljava/nio/ByteBuffer;)I")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;II)J")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;)J")
public class WavsepXssFalsePositiveTest extends WavsepBaseTest {

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testRXssFalsePositive1() throws Exception {
		testXssPath(RXSS_FALSE_POSITIVES, true, "Case01-DoubleQuotesAndCrLfEncodingInProperty.jsp");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testRXssFalsePositive2() throws Exception {
		testXssPath(RXSS_FALSE_POSITIVES, true, "Case02-SingleQuotesAndCrLfEncodingInProperty.jsp");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testRXssFalsePositive3() throws Exception {
		testXssPath(RXSS_FALSE_POSITIVES, true, "Case03-DoubleQuotesEqualityAndBracketsEncodingInProperty.jsp");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testRXssFalsePositive4() throws Exception {
		testXssPath(RXSS_FALSE_POSITIVES, true, "Case04-SingleQuotesEqualityAndBracketsEncodingInProperty.jsp");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testRXssFalsePositive5() throws Exception {
		testPostPath(RXSS_FALSE_POSITIVES, "Case05-CrlfRemovalInHttpHeader.jsp", 200, false,
				new BasicNameValuePair("userinput", "test"),
				new BasicNameValuePair("submit", "submit")
		);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testRXssFalsePositive6() throws Exception {
		testXssPath(RXSS_FALSE_POSITIVES, true, "Case06-QuotesBracketsAndCrLfEncodingInTextProperty.jsp");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testRXssFalsePositive7() throws Exception {
		testXssPath(RXSS_FALSE_POSITIVES, true, "Case07-AngleBracketsEncodingInBody.jsp");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	@Source(method = "io/rivulet/PhosphorHttpRequest.getCookieHeader()Ljava/lang/String;")
	public void testRXssCookieExperimental1() throws Exception {
		testPostPath(RXSS_COOKIE, "Case01-Tag2HtmlPageScope.jsp", 200, true,
				new BasicHeader("Cookie","userinput=\"test\""),
				new BasicNameValuePair("userinput", "test2")
		);
	}
}


