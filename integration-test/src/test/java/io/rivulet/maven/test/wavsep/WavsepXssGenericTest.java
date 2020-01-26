package io.rivulet.maven.test.wavsep;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Sink(method = "java/nio/channels/SocketChannel.write(Ljava/nio/ByteBuffer;)I")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;II)J")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;)J")
public abstract class WavsepXssGenericTest extends WavsepBaseTest {

    private final WavsepPath path;
    private final WavsepPath experimentalPath;
    private final boolean post;
    
    public WavsepXssGenericTest(WavsepPath path, WavsepPath experimentalPath, boolean post) {
        this.path = path;
        this.experimentalPath = experimentalPath;
        this.post = post;
    }
    
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss1() throws Exception {
        testXssPath(path, post, "Case01-Tag2HtmlPageScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss2() throws Exception {
        testXssPath(path, post, "Case02-Tag2TagScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss3() throws Exception {
        testXssPath(path, post, "Case03-Tag2TagStructure.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss4() throws Exception {
        testXssPath(path, post, "Case04-Tag2HtmlComment.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss5() throws Exception {
        testXssPath(path, post, "Case05-Tag2Frameset.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss6() throws Exception {
        testXssPath(path, post, "Case06-Event2TagScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss7() throws Exception {
        testXssPath(path, post, "Case07-Event2DoubleQuotePropertyScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss8() throws Exception {
        testXssPath(path, post, "Case08-Event2SingleQuotePropertyScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss9() throws Exception {
        testXssPath(path, post, "Case09-SrcProperty2TagStructure.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss10() throws Exception {
        testXssPath(path, post, "Case10-Js2DoubleQuoteJsEventScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss11() throws Exception {
        testXssPath(path, post, "Case11-Js2SingleQuoteJsEventScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss12() throws Exception {
        testXssPath(path, post, "Case12-Js2JsEventScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss13() throws Exception {
        testXssPath(path, post, "Case13-Vbs2DoubleQuoteVbsEventScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss14() throws Exception {
        testXssPath(path, post, "Case14-Vbs2SingleQuoteVbsEventScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss15() throws Exception {
        testXssPath(path, post, "Case15-Vbs2VbsEventScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss16() throws Exception {
        testXssPath(path, post, "Case16-Js2ScriptSupportingProperty.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss17() throws Exception {
        testXssPath(path, post, "Case17-Js2PropertyJsScopeDoubleQuoteDelimiter.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss18() throws Exception {
        testXssPath(path, post, "Case18-Js2PropertyJsScopeSingleQuoteDelimiter.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss19() throws Exception {
        testXssPath(path, post, "Case19-Js2PropertyJsScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss20() throws Exception {
        testXssPath(path, post, "Case20-Vbs2PropertyVbsScopeDoubleQuoteDelimiter.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss21() throws Exception {
        testXssPath(path, post, "Case21-Vbs2PropertyVbsScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss22() throws Exception {
        testXssPath(path, post, "Case22-Js2ScriptTagDoubleQuoteDelimiter.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss23() throws Exception {
        testXssPath(path, post, "Case23-Js2ScriptTagSingleQuoteDelimiter.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss24() throws Exception {
        testXssPath(path, post, "Case24-Js2ScriptTag.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss25() throws Exception {
        testXssPath(path, post, "Case25-Vbs2ScriptTagDoubleQuoteDelimiter.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss26() throws Exception {
        testXssPath(path, post, "Case26-Vbs2ScriptTag.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss27() throws Exception {
        testXssPath(path, post, "Case27-Js2ScriptTagOLCommentScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss28() throws Exception {
        testXssPath(path, post, "Case28-Js2ScriptTagMLCommentScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss29() throws Exception {
        testXssPath(path, post, "Case29-Vbs2ScriptTagOLCommentScope.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss30() throws Exception {
        testXssPath(path, post, "Case30-Tag2HtmlPageScopeMultipleVulnerabilities.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss31() throws Exception {
        testPostPath(WavsepPath.RXSS_POST, "Case31-Tag2HtmlPageScopeDuringException.jsp", 200, true,
                new BasicNameValuePair("userinput", "Look, it's a test"),
                new BasicNameValuePair("submit", "submit")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXss32() throws Exception {
        testPostPath(WavsepPath.RXSS_POST, "Case32-Tag2HtmlPageScopeValidViewstateRequired.jsp", 200, true,
                new BasicNameValuePair("userinput", "test"),
                new BasicNameValuePair("__VIEWSTATE", "/wEPDwUENTM4MWRkhsjF+62gWnhYUcEyuRwTHxGDVzA="),
                new BasicNameValuePair("submit", "submit")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXssExperimental1() throws Exception {
        testXssPath(experimentalPath, post, "Case01-Tag2HtmlPageScope-StripScriptTag.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXssExperimental2() throws Exception {
        testGetPath(WavsepPath.RXSS_POST_EXPERIMENTAL, "Case02-Tag2HtmlPageScope-SecretVectorGET.jsp", 200, true,
                new BasicNameValuePair("userinput", "test"),
                new BasicNameValuePair("submit", "submit")
        );
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXssExperimental3() throws Exception {
        URIBuilder builder = getBaseURIBuilder().setPath(WavsepPath.RXSS_POST_EXPERIMENTAL.getPagePath("Case03-Tag2HtmlPageScope-ConstantAntiCSRFToken.jsp"));
        builder.addParameter("userinput", "test");
        builder.addParameter("submit", "submit");
        testPathWithAntiCSRFToken(builder,"anticsrf");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXssExperimental4() throws Exception {
        URIBuilder builder = getBaseURIBuilder().setPath(WavsepPath.RXSS_POST_EXPERIMENTAL.getPagePath("Case04-Tag2HtmlPageScope-ChangingAntiCSRFToken.jsp"));
        builder.addParameter("userinput", "test");
        builder.addParameter("submit", "submit");
        testPathWithAntiCSRFToken(builder,"newAnticsrfToken");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXssExperimental5() throws Exception {
        testXssPath(experimentalPath, post, "Case05-ScriptlessInjectionInFormTagActionAttribute.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXssExperimental6() throws Exception {
        testXssPath(experimentalPath, post, "Case06-ScriptlessInjectionInBaseTagHrefAttribute.jsp");
    }

    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXssExperimental7() throws Exception {
        testXssPath(experimentalPath, post, "Case07-ScriptlessInjectionInScriptTagSrcAttribute.jsp");
    }

    /* This is a true false positive (injection is into the body of a CSS tag, and no <> are permitted. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXssExperimental8() throws Exception {
        testXssPath(experimentalPath, post, "Case08-InjectionInToCssSelector.jsp");
    }

    /* This is a true negative (injection is into the body of a CSS tag, and no <> are permitted. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXssExperimental9() throws Exception {
        testXssPath(experimentalPath, post, "Case09-InjectionInToCssSelectorAttributeName.jsp");
    }

    /* This is a true negative (injection is into the body of a CSS tag, and no <> are permitted. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXssExperimental10() throws Exception {
        testXssPath(experimentalPath, post, "Case10-InjectionInToCssProperty.jsp");
    }

    /* This is a true negative (injection is into the body of a CSS tag, and no <> are permitted. */
    @Test
    @ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
    public void testRXssExperimental11() throws Exception {
        testXssPath(experimentalPath, post, "Case11-InjectionInToCssPropertyValue.jsp");
    }
}


