package io.rivulet.maven.test.struts;

import io.rivulet.maven.test.TomcatBaseTest;
import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.junit.Test;

import java.io.File;

@Sink(method = "java/nio/channels/SocketChannel.write(Ljava/nio/ByteBuffer;)I")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;II)J")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;)J")
public class StrutsXssTest extends TomcatBaseTest {

    /* Tests that the vulnerability from CVE-2012-1007 for struts-cookbook-1_3_10/processSimple.do is reproduced and
     * verified by a generator. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
    public void testProcessSimple() throws Exception {
        addWebApp("struts-cookbook-1_3_10");
        URIBuilder builder = getBaseURIBuilder().setPath("struts-cookbook-1_3_10/processSimple.do");
        builder.addParameter("name", "Steve");
        builder.addParameter("secret", "tomato");
        builder.addParameter("color", "red");
        builder.addParameter("confirm", "on");
        builder.addParameter("rating", "4");
        builder.addParameter("message", "hello!");
        builder.addParameter("hidden", "ssh! It's a secret. Nobody knows I'm here.");
        HttpPost post = new HttpPost(builder.build());
        makeRequest(post, 200);
        // Check that a violation occurred if this was an original test run
        checkViolationsIncreased();
    }

    /* Tests that the vulnerability from CVE-2012-1007 for struts-cookbook-1_3_10/processDyna.do is reproduced and
     * verified by a generator. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
    public void testProcessDyna() throws Exception {
        addWebApp("struts-cookbook-1_3_10");
        URIBuilder builder = getBaseURIBuilder().setPath("struts-cookbook-1_3_10/processDyna.do");
        builder.addParameter("name", "Steve");
        builder.addParameter("secret", "tomato");
        builder.addParameter("color", "red");
        builder.addParameter("message", "hello!");
        builder.addParameter("hidden", "ssh! It's a secret. Nobody knows I'm here.");
        HttpPost post = new HttpPost(builder.build());
        makeRequest(post, 200);
        // Check that a violation occurred if this was an original test run
        checkViolationsIncreased();
    }

    /* Tests that the vulnerability from CVE-2012-1007 for struts-examples-1_3_10/upload/upload-submit.do is reproduced and
     * verified by a generator. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getEntityBody()Ljava/lang/String;")
    public void testUploadSubmit() throws Exception {
        addWebApp("struts-examples-1_3_10");
        URIBuilder builder = getBaseURIBuilder().setPath("struts-examples-1_3_10/upload/upload-submit.do");
        builder.addParameter("queryParam", "Successful");
        HttpPost post = new HttpPost(builder.build());
        HttpEntity entity = MultipartEntityBuilder
                .create()
                .addTextBody("theText", "sample text")
                .addTextBody("filePath", "")
                .addBinaryBody("theFile", new File(".gitignore"), ContentType.create("application/octet-stream"), "filename")
                .build();
        post.setEntity(entity);
        makeRequest(post, 200);
        // Check that a violation occurred if this was an original test run
        checkViolationsIncreased();
    }

    /* Tests that the vulnerability from CVE-2013-6348 for actionNames.action is reproduced and verified by a generator. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
    public void testActionNames() throws Exception {
        addWebApp("struts2-showcase-2_3_15_3");
        URIBuilder builder = getBaseURIBuilder().setPath("struts2-showcase-2_3_15_3/config-browser/actionNames.action");
        builder.addParameter("namespace", "/chat");
        HttpPost post = new HttpPost(builder.build());
        makeRequest(post, 200);
        // Check that a violation occurred if this was an original test run
        checkViolationsIncreased();
    }

    /* Tests that the vulnerability from CVE-2013-6348 for showConfig.action is reproduced and verified by a generator. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    @Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
    public void testShowConfig() throws Exception {
        addWebApp("struts2-showcase-2_3_15_3");
        URIBuilder builder = getBaseURIBuilder().setPath("struts2-showcase-2_3_15_3/config-browser/showConfig.action");
        builder.addParameter("namespace", "/chat");
        builder.addParameter("actionName", "main");
        HttpPost post = new HttpPost(builder.build());
        makeRequest(post, 200);
        // Check that a violation occurred if this was an original test run
        checkViolationsIncreased();
    }
}


