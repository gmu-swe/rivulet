package io.rivulet.maven.test.struts;

import io.rivulet.maven.test.TomcatBaseTest;
import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.junit.Ignore;
import org.junit.Test;

@Sink(method = "org/apache/struts2/rest/handler/ContentTypeHandler.toObject(Ljava/io/Reader;Ljava/lang/Object;)V")
public class StrutsXStreamTest extends TomcatBaseTest {

    /* Tests that the vulnerability from CVE-2017-9805 is reproduced and verified by a generator. Ignored because payload
     * is only compatible with some Java versions. */
    @Ignore
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getEntityBody()Ljava/lang/String;")
    public void testRestOrdersContentTypeHandler() throws Exception {
        addWebApp("struts2-rest-showcase-2_3_20_1");
        URIBuilder builder = getBaseURIBuilder().setPath("struts2-rest-showcase-2_3_20_1/orders/3");
        builder.addParameter("_method", "put");
        builder.addParameter("clientName", "Titus");
        builder.addParameter("amount", "42");
        HttpPost post = new HttpPost(builder.build());
        String form = "test";
        StringEntity entity = new StringEntity(form, ContentType.APPLICATION_FORM_URLENCODED);
        post.setEntity(entity);
        makeRequest(post, 200);
        // Check that a violation occurred if this was an original test run
        checkViolationsIncreased();
    }
}


