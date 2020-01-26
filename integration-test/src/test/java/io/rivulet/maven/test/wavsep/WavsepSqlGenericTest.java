package io.rivulet.maven.test.wavsep;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Sink(method = "java/sql/Statement.executeQuery(Ljava/lang/String;)Ljava/sql/ResultSet;")
@Sink(method = "java/sql/Statement.executeUpdate(Ljava/lang/String;)I")
@Sink(method = "java/sql/Connection.prepareStatement(Ljava/lang/String;)Ljava/sql/PreparedStatement;")
public abstract class WavsepSqlGenericTest extends WavsepSqlBaseTest {

    private final WavsepPath error200;
    private final WavsepPath errorExperimental200;
    private final WavsepPath identical200;
    private final WavsepPath valid200;
    private final WavsepPath error500;
    private final boolean post;

    public WavsepSqlGenericTest(WavsepPath error200, WavsepPath errorExperimental200, WavsepPath identical200, WavsepPath valid200, WavsepPath error500, boolean post) {
        this.error200 = error200;
        this.errorExperimental200 = errorExperimental200;
        this.identical200 = identical200;
        this.valid200 = valid200;
        this.error500 = error500;
        this.post = post;
    }

    /* Makes a request at the specified SQL injection page with the specified name-value pair query
     * parameters. Checks that the resulting response's status was the expected value and that a violation was
     * reported. */
    private void testBasicPage(WavsepPath path, String pageName, int expectedStatusCode, NameValuePair... params) throws Exception {
        NameValuePair[] paramsWithSubmit = new NameValuePair[params.length + 1];
        paramsWithSubmit[0] = new BasicNameValuePair("submit", "submit");
        System.arraycopy(params, 0, paramsWithSubmit, 1, params.length);
        if (post) {
            testPostPath(path, pageName, expectedStatusCode, true, paramsWithSubmit);
        } else {
            testGetPath(path, pageName, expectedStatusCode, true, paramsWithSubmit);
        }
    }

    /* Makes a request at the specified SQL injection post 200 identical page with the specified name-value pair query
     * parameters. Checks that the resulting response's status was 200 and that a violation was reported. */
    private void test200IdenticalPage(String pageName, NameValuePair... params) throws Exception {
        NameValuePair[] paramsWithSubmit = new NameValuePair[params.length + 1];
        paramsWithSubmit[0] = new BasicNameValuePair("submit", "submit");
        System.arraycopy(params, 0, paramsWithSubmit, 1, params.length);
        if(post) {
            testPostPath(identical200, pageName, 200, true, paramsWithSubmit);
        } else {
            testGetPath(identical200, pageName, 200, true, paramsWithSubmit);
        }
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid1() throws Exception {
        testBasicPage(valid200, "Case01-InjectionInLogin-String-LoginBypass-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("username", "test"),
                new BasicNameValuePair("password", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid2() throws Exception {
        testBasicPage(valid200, "Case02-InjectionInSearch-String-UnionExploit-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("msg", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid3() throws Exception {
        testBasicPage(valid200, "Case03-InjectionInCalc-String-BooleanExploit-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("username", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid4() throws Exception {
        testBasicPage(valid200, "Case04-InjectionInUpdate-String-CommandInjection-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("msg", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid5() throws Exception {
        testBasicPage(valid200, "Case05-InjectionInSearchOrderBy-String-BinaryDeliberateRuntimeError-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("orderby", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid6() throws Exception {
        testBasicPage(valid200, "Case06-InjectionInView-Numeric-PermissionBypass-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("transactionId", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid7() throws Exception {
        testBasicPage(valid200, "Case07-InjectionInSearch-Numeric-UnionExploit-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("msgId", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid8() throws Exception {
        testBasicPage(valid200, "Case08-InjectionInCalc-Numeric-BooleanExploit-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("minBalanace", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid9() throws Exception {
        testBasicPage(valid200, "Case09-InjectionInUpdate-Numeric-CommandInjection-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("msgid", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid10() throws Exception {
        testBasicPage(valid200, "Case10-InjectionInSearchOrderBy-Numeric-BinaryDeliberateRuntimeError-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("orderby", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid11() throws Exception {
        testBasicPage(valid200, "Case11-InjectionInView-Date-PermissionBypass-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("transactionDate", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid12() throws Exception {
        testBasicPage(valid200, "Case12-InjectionInSearch-Date-UnionExploit-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("transactionDate", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid13() throws Exception {
        testBasicPage(valid200, "Case13-InjectionInCalc-Date-BooleanExploit-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("transactionDate", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid14() throws Exception {
        testBasicPage(valid200, "Case14-InjectionInUpdate-Date-CommandInjection-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("transactionDate", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid15() throws Exception {
        testBasicPage(valid200, "Case15-InjectionInSearch-DateWithoutQuotes-UnionExploit-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("transactionDate", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid16() throws Exception {
        testBasicPage(valid200, "Case16-InjectionInView-NumericWithoutQuotes-PermissionBypass-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("transactionId", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid17() throws Exception {
        testBasicPage(valid200, "Case17-InjectionInSearch-NumericWithoutQuotes-UnionExploit-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("msgId", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid18() throws Exception {
        testBasicPage(valid200, "Case18-InjectionInCalc-NumericWithoutQuotes-BooleanExploit-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("minBalanace", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Valid19() throws Exception {
        testBasicPage(valid200, "Case19-InjectionInUpdate-NumericWithoutQuotes-CommandInjection-WithDifferent200Responses.jsp",
                200, new BasicNameValuePair("msgid", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Identical1() throws Exception {
        test200IdenticalPage("Case01-InjectionInView-Numeric-Blind-200ValidResponseWithDefaultOnException.jsp",
                new BasicNameValuePair("transactionId", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Identical2() throws Exception {
        test200IdenticalPage("Case02-InjectionInView-String-Blind-200ValidResponseWithDefaultOnException.jsp",
                new BasicNameValuePair("username", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Identical3() throws Exception {
        test200IdenticalPage("Case03-InjectionInView-Date-Blind-200ValidResponseWithDefaultOnException.jsp",
                new BasicNameValuePair("transactionDate", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Identical4() throws Exception {
        test200IdenticalPage("Case04-InjectionInUpdate-Numeric-TimeDelayExploit-200Identical.jsp",
                new BasicNameValuePair("transactionId", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Identical5() throws Exception {
        test200IdenticalPage("Case05-InjectionInUpdate-String-TimeDelayExploit-200Identical.jsp",
                new BasicNameValuePair("description", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Identical6() throws Exception {
        test200IdenticalPage("Case06-InjectionInUpdate-Date-TimeDelayExploit-200Identical.jsp",
                new BasicNameValuePair("transactionDate", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Identical7() throws Exception {
        test200IdenticalPage("Case07-InjectionInUpdate-NumericWithoutQuotes-TimeDelayExploit-200Identical.jsp",
                new BasicNameValuePair("transactionId", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Identical8() throws Exception {
        test200IdenticalPage("Case08-InjectionInUpdate-DateWithoutQuotes-TimeDelayExploit-200Identical.jsp",
                new BasicNameValuePair("transactionDate", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200ErrorExperimental1() throws Exception {
        String pageName = "Case01-InjectionInInsertValues-String-BinaryDeliberateRuntimeError-With200Errors.jsp";
        if (post) {
            testPostPath(errorExperimental200, pageName, 200, true,
                    new BasicNameValuePair("msg", "test"),
                    new BasicNameValuePair("target", "example@temp.com"),
                    new BasicNameValuePair("submit", "submit")
            );
        } else {
            testGetPath(errorExperimental200, pageName, 200, true,
                    new BasicNameValuePair("msg", "test"),
                    new BasicNameValuePair("target", "example@temp.com"),
                    new BasicNameValuePair("submit", "submit")
            );
        }
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error1() throws Exception {
        testBasicPage(error200, "Case01-InjectionInLogin-String-LoginBypass-With200Errors.jsp",
                200, new BasicNameValuePair("username", "test'"),
                new BasicNameValuePair("password", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error2() throws Exception {
        testBasicPage(error200, "Case02-InjectionInSearch-String-UnionExploit-With200Errors.jsp",
                200, new BasicNameValuePair("msg", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error3() throws Exception {
        testBasicPage(error200, "Case03-InjectionInCalc-String-BooleanExploit-With200Errors.jsp",
                200, new BasicNameValuePair("username", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error4() throws Exception {
        testBasicPage(error200, "Case04-InjectionInUpdate-String-CommandInjection-With200Errors.jsp",
                200, new BasicNameValuePair("msg", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error5() throws Exception {
        testBasicPage(error200, "Case05-InjectionInSearchOrderBy-String-BinaryDeliberateRuntimeError-With200Errors.jsp",
                200, new BasicNameValuePair("orderby", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error6() throws Exception {
        testBasicPage(error200, "Case06-InjectionInView-Numeric-PermissionBypass-With200Errors.jsp",
                200, new BasicNameValuePair("transactionId", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error7() throws Exception {
        testBasicPage(error200, "Case07-InjectionInSearch-Numeric-UnionExploit-With200Errors.jsp",
                200, new BasicNameValuePair("msgId", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error8() throws Exception {
        testBasicPage(error200, "Case08-InjectionInCalc-Numeric-BooleanExploit-With200Errors.jsp",
                200, new BasicNameValuePair("minBalanace", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error9() throws Exception {
        testBasicPage(error200, "Case09-InjectionInUpdate-Numeric-CommandInjection-With200Errors.jsp",
                200, new BasicNameValuePair("msgid", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error10() throws Exception {
        testBasicPage(error200, "Case10-InjectionInSearchOrderBy-Numeric-BinaryDeliberateRuntimeError-With200Errors.jsp",
                200, new BasicNameValuePair("orderby", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error11() throws Exception {
        testBasicPage(error200, "Case11-InjectionInView-Date-PermissionBypass-With200Errors.jsp",
                200, new BasicNameValuePair("transactionDate", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error12() throws Exception {
        testBasicPage(error200, "Case12-InjectionInSearch-Date-UnionExploit-With200Errors.jsp",
                200, new BasicNameValuePair("transactionDate", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error13() throws Exception {
        testBasicPage(error200, "Case13-InjectionInCalc-Date-BooleanExploit-With200Errors.jsp",
                200, new BasicNameValuePair("transactionDate", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error14() throws Exception {
        testBasicPage(error200, "Case14-InjectionInUpdate-Date-CommandInjection-With200Errors.jsp",
                200, new BasicNameValuePair("transactionDate", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error15() throws Exception {
        testBasicPage(error200, "Case15-InjectionInSearch-DateWithoutQuotes-UnionExploit-With200Errors.jsp",
                200, new BasicNameValuePair("transactionDate", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error16() throws Exception {
        testBasicPage(error200, "Case16-InjectionInView-NumericWithoutQuotes-PermissionBypass-With200Errors.jsp",
                200, new BasicNameValuePair("transactionId", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error17() throws Exception {
        testBasicPage(error200, "Case17-InjectionInSearch-NumericWithoutQuotes-UnionExploit-With200Errors.jsp",
                200, new BasicNameValuePair("msgId", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error18() throws Exception {
        testBasicPage(error200, "Case18-InjectionInCalc-NumericWithoutQuotes-BooleanExploit-With200Errors.jsp",
                200, new BasicNameValuePair("minBalanace", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection200Error19() throws Exception {
        testBasicPage(error200, "Case19-InjectionInUpdate-NumericWithoutQuotes-CommandInjection-With200Errors.jsp",
                200, new BasicNameValuePair("msgid", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error1() throws Exception {
        testBasicPage(error500, "Case01-InjectionInLogin-String-LoginBypass-WithErrors.jsp",
                500, new BasicNameValuePair("username", "test'"),
                new BasicNameValuePair("password", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error2() throws Exception {
        testBasicPage(error500, "Case02-InjectionInSearch-String-UnionExploit-WithErrors.jsp",
                500, new BasicNameValuePair("msg", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error3() throws Exception {
        testBasicPage(error500, "Case03-InjectionInCalc-String-BooleanExploit-WithErrors.jsp",
                500, new BasicNameValuePair("username", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error4() throws Exception {
        testBasicPage(error500, "Case04-InjectionInUpdate-String-CommandInjection-WithErrors.jsp",
                500, new BasicNameValuePair("msg", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error5() throws Exception {
        testBasicPage(error500, "Case05-InjectionInSearchOrderBy-String-BinaryDeliberateRuntimeError-WithErrors.jsp",
                500, new BasicNameValuePair("orderby", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error6() throws Exception {
        testBasicPage(error500, "Case06-InjectionInView-Numeric-PermissionBypass-WithErrors.jsp",
                500, new BasicNameValuePair("transactionId", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error7() throws Exception {
        testBasicPage(error500, "Case07-InjectionInSearch-Numeric-UnionExploit-WithErrors.jsp",
                500, new BasicNameValuePair("msgId", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error8() throws Exception {
        testBasicPage(error500, "Case08-InjectionInCalc-Numeric-BooleanExploit-WithErrors.jsp",
                500, new BasicNameValuePair("minBalanace", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error9() throws Exception {
        testBasicPage(error500, "Case09-InjectionInUpdate-Numeric-CommandInjection-WithErrors.jsp",
                500, new BasicNameValuePair("msgid", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error10() throws Exception {
        testBasicPage(error500, "Case10-InjectionInSearchOrderBy-Numeric-BinaryDeliberateRuntimeError-WithErrors.jsp",
                500, new BasicNameValuePair("orderby", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error11() throws Exception {
        testBasicPage(error500, "Case11-InjectionInView-Date-PermissionBypass-WithErrors.jsp",
                500, new BasicNameValuePair("transactionDate", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error12() throws Exception {
        testBasicPage(error500, "Case12-InjectionInSearch-Date-UnionExploit-WithErrors.jsp",
                500, new BasicNameValuePair("transactionDate", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error13() throws Exception {
        testBasicPage(error500, "Case13-InjectionInCalc-Date-BooleanExploit-WithErrors.jsp",
                500, new BasicNameValuePair("transactionDate", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error14() throws Exception {
        testBasicPage(error500, "Case14-InjectionInUpdate-Date-CommandInjection-WithErrors.jsp",
                500, new BasicNameValuePair("transactionDate", "test'")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error15() throws Exception {
        testBasicPage(error500, "Case15-InjectionInSearch-DateWithoutQuotes-UnionExploit-WithErrors.jsp",
                500, new BasicNameValuePair("transactionDate", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error16() throws Exception {
        testBasicPage(error500, "Case16-InjectionInView-NumericWithoutQuotes-PermissionBypass-WithErrors.jsp",
                500, new BasicNameValuePair("transactionId", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error17() throws Exception {
        testBasicPage(error500, "Case17-InjectionInSearch-NumericWithoutQuotes-UnionExploit-WithErrors.jsp",
                500, new BasicNameValuePair("msgId", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error18() throws Exception {
        testBasicPage(error500, "Case18-InjectionInCalc-NumericWithoutQuotes-BooleanExploit-WithErrors.jsp",
                500, new BasicNameValuePair("minBalanace", "test")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testSqlInjection500Error19() throws Exception {
        testBasicPage(error500, "Case19-InjectionInUpdate-NumericWithoutQuotes-CommandInjection-WithErrors.jsp",
                500, new BasicNameValuePair("msgid", "test")
        );
    }
}


