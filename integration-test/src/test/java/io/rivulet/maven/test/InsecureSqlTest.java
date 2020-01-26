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
@Sink(method = "java/sql/Statement.executeQuery(Ljava/lang/String;)Ljava/sql/ResultSet;")
public class InsecureSqlTest extends TomcatBaseTest {

	@Rule
	public final ExternalResource myWebApp = new ExternalResource() {
		@Override
		protected void before() throws Throwable {
			addWebApp("insecure");
		}
	};

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testProductSearch() throws Exception {
		URIBuilder builder = getBaseURIBuilder().setPath("insecure/public/productListing.jsp");
		builder.addParameter("productSearch", "test");
		builder.addParameter("button", "Search");
		makeRequest(new HttpPost(builder.build()), 200);
		// Check that a violation occurred if this was an original test run
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testLogin() throws Exception {
		URIBuilder builder = getBaseURIBuilder().setPath("insecure/public/Login.jsp");
		builder.addParameter("login", "test");
		builder.addParameter("pass", "test");
		builder.addParameter("submit", "Login");
		HttpPost request = new HttpPost(builder.build());
		request.setHeader("Cookie", "JSESSIONID=1234");
		makeRequest(request, 200);
		// Check that a violation occurred if this was an original test run
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testForgotLogin() throws Exception {
		URIBuilder builder = getBaseURIBuilder().setPath("insecure/public/ForgotLogin.jsp");
		builder.addParameter("email", "test");
		builder.addParameter("submit", "Reset Password");
		makeRequest(new HttpPost(builder.build()), 200);
		// Check that a violation occurred if this was an original test run
		checkViolationsIncreased();
	}
}


