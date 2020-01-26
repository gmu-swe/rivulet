package io.rivulet.maven.test.wavsep;

import io.rivulet.maven.test.TomcatBaseTest;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;

import java.util.Arrays;

public abstract class WavsepBaseTest extends TomcatBaseTest {

    public static final ExternalResource webAppResource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            addWebApp("wavsep");
        }
    };

    @ClassRule
    public static final RuleChain chain = RuleChain
            .outerRule(tomcatResource)
            .around(webAppResource);

    /* Makes a POST request at the specified page at the specified path with the specified name-value pair query parameters.
     * Checks that the resulting response's status was the specified expected value. Checks that violation was reported
     * only if one was expected. */
    protected void testPostPath(WavsepPath path, String pageName, int expectedStatusCode, boolean violationExpected,
                                NameValuePair... params) throws Exception {
        testPostPath(path, pageName, expectedStatusCode, violationExpected, null, params);
    }

    /* Makes a POST request at the specified page at the specified path with the specified name-value pair query
     * parameters and the specified header. Checks that the resulting response's status was the specified expected value.
     * Checks that violation was reported only if one was expected. */
    protected void testPostPath(WavsepPath path, String pageName, int expectedStatusCode, boolean violationExpected,
                                Header header, NameValuePair... params) throws Exception {
        URIBuilder builder = getBaseURIBuilder().setPath(path.getPagePath(pageName));
        builder.addParameters(Arrays.asList(params));
        HttpPost post = new HttpPost(builder.build());
        if(header != null) {
            post.addHeader(header);
        }
        makeRequest(post,  expectedStatusCode);
        if(violationExpected) {
            checkViolationsIncreased();
        } else {
            checkViolationsIncreased(0);
        }
    }

    /* Makes a GET request at the specified page at the specified path with the specified name-value pair query parameters.
     * Checks that the resulting response's status was the specified expected value. Checks that violation was reported
     * only if one was expected. */
    protected void testGetPath(WavsepPath path, String pageName, int expectedStatusCode, boolean violationExpected,
                               NameValuePair... params) throws Exception {
        URIBuilder builder = getBaseURIBuilder().setPath(path.getPagePath(pageName));
        builder.addParameters(Arrays.asList(params));
        makeRequest(new HttpGet(builder.build()),  expectedStatusCode);
        if(violationExpected) {
            checkViolationsIncreased();
        } else {
            checkViolationsIncreased(0);
        }
    }

    /* Make a  request at the specified page at the specified path. Checks that the resulting response's status was
     * 200 and that a violation was reported. */
    public void testXssPath(WavsepPath path, boolean post, String pageName) throws Exception {
        if(post) {
            testPostPath(path, pageName, 200, true,
                    new BasicNameValuePair("userinput", "test"),
                    new BasicNameValuePair("submit", "submit")
            );
        } else {
            testGetPath(path, pageName, 200, true,
                    new BasicNameValuePair("userinput", "test"),
                    new BasicNameValuePair("submit", "submit")
            );
        }
    }
}
