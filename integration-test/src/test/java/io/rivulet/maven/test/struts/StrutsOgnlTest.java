package io.rivulet.maven.test.struts;

import io.rivulet.maven.test.TomcatBaseTest;
import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.junit.Test;

@Sink(method = "ognl/Ognl.parseExpression(Ljava/lang/String;)Ljava/lang/Object;")
@Sink(method = "ognl/Ognl.getValue(Ljava/lang/Object;Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;")
public class StrutsOgnlTest extends TomcatBaseTest {

    /* Tests that the vulnerability from CVE-2007-4556 is reproduced and verified by a generator. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getEntityBody()Ljava/lang/String;")
    public void testNewPerson() throws Exception {
        addWebApp("struts2-showcase-2.0.5");
        URIBuilder builder = getBaseURIBuilder().setPath("struts2-showcase-2.0.5/person/newPerson.action");
        HttpPost post = new HttpPost(builder.build());
        String form = "person.name=John&person.lastName=Smith";
        StringEntity entity = new StringEntity(form, ContentType.APPLICATION_FORM_URLENCODED);
        post.setEntity(entity);
        makeRequest(post, 200);
        checkViolationsIncreased();
    }

    /* Tests that the vulnerability from CVE-2013-2251 is reproduced and verified by a generator. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
    public void testActionPrefix() throws Exception {
        addWebApp("struts2-showcase-2_2_1");
        URIBuilder builder = getBaseURIBuilder().setPath("struts2-showcase-2_2_1/showcase.action");
        builder.setParameter("redirect:3", null);
        makeRequest(new HttpGet(builder.build()), 200);
        checkViolationsIncreased();
    }

    /* Tests that the vulnerability from CVE-2016-4438 is reproduced and verified by a generator. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedPath()Ljava/lang/String;")
    public void testRestEditOrders() throws Exception {
        addWebApp("struts2-rest-showcase-2_3_20_1");
        URIBuilder builder = getBaseURIBuilder().setPath("struts2-rest-showcase-2_3_20_1/orders/3");
        builder.addParameter("_method", "put");
        builder.addParameter("clientName", "Titus");
        builder.addParameter("amount", "42");
        makeRequest(new HttpPost(builder.build()), 200);
        checkViolationsIncreased();
    }

    /* Tests that the vulnerability from CVE-2017-5638 is reproduced and verified by a generator. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getContentTypeHeader()Ljava/lang/String;")
    public void testRestOrdersContentError() throws Exception {
        addWebApp("struts2-rest-showcase-2_3_20_1");
        URIBuilder builder = getBaseURIBuilder().setPath("struts2-rest-showcase-2_3_20_1/orders/3");
        builder.addParameter("_method", "put");
        builder.addParameter("clientName", "Titus");
        builder.addParameter("amount", "42");
        HttpPost post = new HttpPost(builder.build());
        // Intentionally causes an error due to expecting multipart/form-data or multipart/mixed stream content.
        post.addHeader("content-type", "multipart/form-data");
        makeRequest(post);
        checkViolationsIncreased();
    }

    /* Tests that the vulnerability from CVE-2017-9791 is reproduced and verified by a generator. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
    public void testSaveGangster() throws Exception {
        addWebApp("struts2-showcase-2_3_10");
        URIBuilder builder = getBaseURIBuilder().setPath("struts2-showcase-2_3_10/integration/saveGangster.action");
        builder.addParameter("name", "Capone");
        builder.addParameter("age", "30");
        builder.addParameter("__checkbox_bustedBefore", "true");
        builder.addParameter("description", "Public Enemy No. 1");
        makeRequest(new HttpPost(builder.build()), 200);
        checkViolationsIncreased();
    }
}

