package io.rivulet.maven.test.bodgeit;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Sink(method = "java/sql/Statement.executeQuery(Ljava/lang/String;)Ljava/sql/ResultSet;")
@Sink(method = "java/sql/Statement.execute(Ljava/lang/String;)Z")
@Sink(method = "java/sql/Statement.execute(Ljava/lang/String;I)Z")
@Sink(method = "java/sql/Statement.execute(Ljava/lang/String;[I)Z")
@Sink(method = "java/sql/Statement.execute(Ljava/lang/String;[Ljava/lang/String;)Z")
@Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;)I")
@Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;I)I")
@Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;[I)I")
@Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;[Ljava/lang/String;)I")
@Sink(method = "java/sql/Statement.executeLargeUpdate(Ljava/lang/String;)J")
@Sink(method = "java/sql/Statement.executeLargeUpdate(Ljava/lang/String;I)J")
@Sink(method = "java/sql/Statement.executeLargeUpdate(Ljava/lang/String;[I)J")
@Sink(method = "java/sql/Statement.executeLargeUpdate(Ljava/lang/String;[Ljava/lang/String;)J")
@Sink(method = "java/sql/Statement.addBatch(Ljava/lang/String;)V")
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
public class BodgeItSqlTest extends BodgeItBaseTest {

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

	@Test
	@Source(method = "io/rivulet/PhosphorHttpRequest.getCookieHeader()Ljava/lang/String;")
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testBasket() throws Exception {
		login();
		URIBuilder builder = getBaseURIBuilder().setPath("bodgeit/basket.jsp");
		builder.addParameter("productid", "4");
		builder.addParameter("quantity", "1");
		HttpPost post = new HttpPost(builder.build());
		addCookie("b_id", "3");
		makeRequestWithCookieHeader(post);
		checkViolationsIncreased();
		logout();
	}

	/* This is a false positive because it is impossible to escape the quotes. */
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testSearch() throws Exception {
		URIBuilder builder = getBaseURIBuilder().setPath("bodgeit/search.jsp");
		builder.addParameter("q", "test");
		builder.addParameter("submit", "Search");
		makeRequest(new HttpGet(builder.build()), 200);
		// Check that a violation occurred if this was an original test run
		checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testLogin() throws Exception {
		URIBuilder builder = getBaseURIBuilder().setPath("bodgeit/login.jsp");
		builder.addParameter("username", "test");
		builder.addParameter("password", "test");
		builder.addParameter("submit", "Login");
		makeRequest(new HttpPost(builder.build()), 200);
		// Check that a violation occurred if this was an original test run
		checkViolationsIncreased();
	}
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testRegister() throws Exception {
		URIBuilder builder = getBaseURIBuilder().setPath("bodgeit/register.jsp");
		builder.addParameter("username", "test@gmail.com");
		builder.addParameter("password1", "test12");
		builder.addParameter("password2", "test12");
		builder.addParameter("submit", "Register");
		makeRequest(new HttpPost(builder.build()), 200);
		// Check that a violation occurred if this was an original test run
		checkViolationsIncreased();
	}
}


