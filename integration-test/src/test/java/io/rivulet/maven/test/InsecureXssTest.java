package io.rivulet.maven.test;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Sink(method = "java/nio/channels/SocketChannel.write(Ljava/nio/ByteBuffer;)I")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;II)J")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;)J")
public class InsecureXssTest extends TomcatBaseTest {

	@Rule
	public final ExternalResource myWebApp = new ExternalResource() {
		@Override
		protected void before() throws Throwable {
			addWebApp("insecure");
		}
	};

	/* It is possible to get an XSS from this, but it's not the goal of the example, AND we find the SQL injection,
	 * so it's OK to not show the XSS. */
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testProductSearch() throws Exception {
		URIBuilder builder = getBaseURIBuilder().setPath("insecure/public/productListing.jsp");
		builder.addParameter("productSearch", "test");
		builder.addParameter("button", "Search");
		makeRequest(new HttpPost(builder.build()), 200);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testForgotLogin() throws Exception {
		URIBuilder builder = getBaseURIBuilder().setPath("insecure/public/ForgotLogin.jsp");
		builder.addParameter("email", "test");
		builder.addParameter("submit", "Reset Password");
		makeRequest(new HttpPost(builder.build()), 200);
		checkViolationsIncreased();
	}
}


