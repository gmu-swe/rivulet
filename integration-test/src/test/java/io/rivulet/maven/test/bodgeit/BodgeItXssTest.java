package io.rivulet.maven.test.bodgeit;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;

import io.rivulet.internal.RivuletAutoTaintWrapper;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Sink(method = "java/nio/channels/SocketChannel.write(Ljava/nio/ByteBuffer;)I")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;II)J")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;)J")
public class BodgeItXssTest extends BodgeItBaseTest {

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testAdmin() throws Exception {
        URIBuilder builder = getBaseURIBuilder().setPath("bodgeit/register.jsp");
        builder.addParameter("username", "tom@example.com");
        builder.addParameter("password1", "test12");
        builder.addParameter("password2", "test12");
        builder.addParameter("submit", "Register");
        makeRequest(new HttpPost(builder.build()), 200);
        // Clear the configs and violations to ensure that the flow in org.apache.jsp.admin_jsp.java is detected and not
        // the one in org.apache.jsp.register_jsp.java
        RivuletAutoTaintWrapper.getAndClearViolationConfigsMap();
        builder = getBaseURIBuilder().setPath("bodgeit/admin.jsp");
        makeRequest(new HttpPost(builder.build()), 200);
        checkViolationsIncreased();
    }

	/* False negative: tags are lost when values are decrypted. */
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE)
	public void testAdvanced() throws Exception {
		URIBuilder builder = getBaseURIBuilder().setPath("bodgeit/advanced.jsp");
		String body = makeRequestWithCookieHeader(new HttpGet(builder.build()));
		builder = getBaseURIBuilder().setPath("bodgeit/advanced.jsp");
		String form = "product:apple\ndescription:red\ntype:fruit\nprice:8";
		builder.addParameter("q", encrypt(getKeyFromResponseBody(body), form));
		makeRequestWithCookieHeader(new HttpPost(builder.build()));
	}

	/* False negative: SQL injection vulnerability hides XSS one by causing an exception. */
	@Test
	@Source(method = "io/rivulet/PhosphorHttpRequest.getCookieHeader()Ljava/lang/String;")
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE)
	public void testBasket() throws Exception {
		login();
		URIBuilder builder = getBaseURIBuilder().setPath("bodgeit/basket.jsp");
		builder.addParameter("debug", "true");
		builder.addParameter("productid", "4");
		builder.addParameter("quantity", "1");
		HttpPost post = new HttpPost(builder.build());
		addCookie("b_id", "3");
		makeRequestWithCookieHeader(post);
		checkViolationsIncreased();
		logout();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testContact() throws Exception {
		URIBuilder builder = getBaseURIBuilder().setPath("bodgeit/contact.jsp");
		builder.addParameter("comments", "Thanks for making such a useful generic anticsrf defeat tool!");
		builder.addParameter("submit", "Submit");
		testPathWithAntiCSRFToken(builder,"anticsrf");
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testSearch() throws Exception {
		URIBuilder builder = getBaseURIBuilder().setPath("bodgeit/search.jsp");
		builder.addParameter("q", "test");
		builder.addParameter("submit", "Search");
		makeRequest(new HttpGet(builder.build()), 200);
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testRegister() throws Exception {
		URIBuilder builder = getBaseURIBuilder().setPath("bodgeit/register.jsp");
		builder.addParameter("username", "tom@gmail.com");
		builder.addParameter("password1", "test12");
		builder.addParameter("password2", "test12");
		builder.addParameter("submit", "Register");
		makeRequest(new HttpPost(builder.build()), 200);
		checkViolationsIncreased();
	}
}


