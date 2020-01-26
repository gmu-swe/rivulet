package io.rivulet.maven.test.wavsep;

import io.rivulet.fuzz.Sink;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Source;

import static io.rivulet.maven.test.wavsep.WavsepPath.*;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Sink(method = "java/sql/Statement.executeQuery(Ljava/lang/String;)Ljava/sql/ResultSet;")
@Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;)I")
@Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;)Ljava/sql/PreparedStatement;")
public class WavsepSqlFalsePositiveTest extends WavsepSqlBaseTest {

	/* Makes a POST request at the specified SQL injection false positive page. Checks that the resulting response's
	 * status was matched the expected status and that a violation was not reported. */
	private void testFalsePositivesPage(String pageName, int expectedStatus) throws Exception {
		testPostPath(SQL_FALSE_POSITIVES, pageName, expectedStatus, false,
				new BasicNameValuePair("username", "test"),
				new BasicNameValuePair("password", "test"),
				new BasicNameValuePair("submit", "submit")
		);
	}

	/* Makes a POST request at the specified SQL injection false positive page with the specified name-value pair query
	 * parameters. Checks that the resulting response's status was matched the expected status and that a violation was
	 * not reported. */
	private void testFalsePositivesPageWithParams(String pageName, int expectedStatus, NameValuePair... params) throws Exception {
		NameValuePair[] paramsWithSubmit = new NameValuePair[params.length + 1];
		paramsWithSubmit[0] = new BasicNameValuePair("submit", "submit");
		System.arraycopy(params, 0, paramsWithSubmit, 1, params.length);
		testPostPath(SQL_FALSE_POSITIVES, pageName, expectedStatus, false, paramsWithSubmit);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testSqlInjectionFalsePositive1() throws Exception {
		testFalsePositivesPageWithParams("Case01-FalsePositiveInjectionInLogin-PsAndIv-500ErrorOnIvFailure.jsp", 500,
				new BasicNameValuePair("username", "test;"),
				new BasicNameValuePair("password", "test;")
		);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testSqlInjectionFalsePositive2() throws Exception {
		testFalsePositivesPageWithParams("Case02-FalsePositiveInjectionInLogin-PsAndIv-500SyntaxErrorOnIvFailure.jsp", 500,
				new BasicNameValuePair("username", "test;"),
				new BasicNameValuePair("password", "test;")
		);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testSqlInjectionFalsePositive3() throws Exception {
		testFalsePositivesPage("Case03-FalsePositiveInjectionInLogin-PsAndIv-200ErrorOnIvFailure.jsp", 200);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testSqlInjectionFalsePositive4() throws Exception {
		testFalsePositivesPage("Case04-FalsePositiveInjectionInLogin-PsAndIv-200SyntaxErrorOnIvFailure.jsp", 200);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testSqlInjectionFalsePositive5() throws Exception {
		testFalsePositivesPage("Case05-FalsePositiveInjectionInLogin-PsAndIv-Different200ValidOnIvFailure.jsp", 200);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testSqlInjectionFalsePositive6() throws Exception {
		testFalsePositivesPageWithParams("Case06-FalsePositiveInjectionInLogin-HoneyPotNoSQL-Fake500SyntaxErrorOnIvFailure.jsp", 500,
				new BasicNameValuePair("username", "test;"),
				new BasicNameValuePair("password", "test;")
		);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testSqlInjectionFalsePositive7() throws Exception {
		testFalsePositivesPage("Case07-FalsePositiveInjectionInLogin-PsAndIv-500ErrorOnUnrelatedSyntaxError.jsp", 500);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testSqlInjectionFalsePositive8() throws Exception {
		testFalsePositivesPage("Case08-FalsePositiveInjectionInLogin-PsAndIv-200ErrorOnUnrelatedSyntaxError.jsp", 200);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testSqlInjectionFalsePositive9() throws Exception {
		testFalsePositivesPage("Case09-FalsePositiveInjectionInUpdate-PsAndIv-Different200ValidOnIvFailure.jsp", 200);
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.NONE)
	public void testSqlInjectionFalsePositive10() throws Exception {
		testFalsePositivesPage("Case10-FalsePositiveInjectionInUpdate-PsAndIv-Identical200Response.jsp", 200);
	}
}


