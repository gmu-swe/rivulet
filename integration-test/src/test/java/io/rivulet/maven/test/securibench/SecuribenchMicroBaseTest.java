package io.rivulet.maven.test.securibench;

import io.rivulet.maven.test.TomcatBaseTest;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.junit.Rule;
import org.junit.rules.ExternalResource;

import java.net.URI;

public abstract class SecuribenchMicroBaseTest extends TomcatBaseTest {

    @Rule
    public final ExternalResource webAppResource = new ExternalResource() {
        @Override
        protected void before() throws Exception {
            addWebApp("securibench-micro");
        }
    };

    /* Makes a GET request at the specified page in securibench-micro. Checks that the response has the expected status
     * code and that a violation was reported only is one was expected. */
    public void testPath(String page, int statusCode, boolean violationExpected) throws Exception {
        URIBuilder builder = getBaseURIBuilder().setPath("securibench-micro/" + page);
        builder.addParameter("name", "test");
        builder.addParameter("submit", "submit");
        HttpGetWithEntity  get = new HttpGetWithEntity(builder.build());
        get.addHeader("Cookie", "name=value");
        get.addHeader("Accept-Language", "en-US");
        StringEntity entity = new StringEntity("body", ContentType.APPLICATION_FORM_URLENCODED);
        get.setEntity(entity);
        makeRequest(get, statusCode);
        if(violationExpected) {
            checkViolationsIncreased();
        } else {
            checkViolationsIncreased(0);
        }
    }

    /* Makes a GET request at the specified page in securibench-micro. Returns the response's body. */
    public String getResponseBodyForPage(String page) throws Exception {
        URIBuilder builder = getBaseURIBuilder().setPath("securibench-micro/" + page);
        builder.addParameter("name", "test");
        builder.addParameter("submit", "submit");
        HttpGetWithEntity  get = new HttpGetWithEntity(builder.build());
        get.addHeader("Cookie", "name=value");
        get.addHeader("Accept-Language", "en-US");
        StringEntity entity = new StringEntity("body", ContentType.APPLICATION_FORM_URLENCODED);
        get.setEntity(entity);
        return makeRequest(get);
    }

    private static class HttpGetWithEntity extends HttpPost {

        public final static String METHOD_NAME = "GET";

        public HttpGetWithEntity(URI url) {
            super(url);
        }

        public HttpGetWithEntity(String url) {
            super(url);
        }

        @Override
        public String getMethod() {
            return METHOD_NAME;
        }
    }
}
