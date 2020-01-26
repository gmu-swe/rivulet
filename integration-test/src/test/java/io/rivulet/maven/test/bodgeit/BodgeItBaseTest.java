package io.rivulet.maven.test.bodgeit;

import io.rivulet.maven.test.TomcatBaseTest;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;

public abstract class BodgeItBaseTest extends TomcatBaseTest {

    private Header cookieHeader = null;
    private static final String USERNAME = "test@thebodgeitstore.com";
    private static final String PASSWORD = "password";

    public static final ExternalResource webAppResource = new ExternalResource() {
        @Override
        protected void before() throws Exception {
            addWebApp("bodgeit");
        }
    };

    @ClassRule
    public static final RuleChain chain = RuleChain
            .outerRule(tomcatResource)
            .around(webAppResource);

    public void login() throws Exception {
        URIBuilder builder = getBaseURIBuilder()
                .setPath("bodgeit/login.jsp")
                .addParameter("username", USERNAME)
                .addParameter("password", PASSWORD);
        makeRequestWithCookieHeader(new HttpPost(builder.build()), 200);
    }

    public void logout() throws Exception {
        URIBuilder builder = getBaseURIBuilder().setPath("bodgeit/logout.jsp");
        HttpGet get = new HttpGet(builder.build());
        get.addHeader(cookieHeader);
        makeRequestWithCookieHeader(get, 200);
        cookieHeader = null;
    }

    public void addCookie(String key, String value) {
        String cookieVal;
        if(cookieHeader == null) {
            cookieVal = key + "=" + value;
        } else {
            cookieVal = cookieHeader.getValue() + "; " + key + "=" + value;
        }
        cookieHeader = new BasicHeader("Cookie", cookieVal);
    }

    public String makeRequestWithCookieHeader(HttpUriRequest request) throws Exception {
        return makeRequestWithCookieHeader(request, -1);
    }

    public String makeRequestWithCookieHeader(HttpUriRequest request, int statusCode) throws Exception {
        String body = null;
        if(cookieHeader != null) {
            request.addHeader(cookieHeader);
        }
        HttpResponse response = makeRequestAndGetResponse(request, statusCode, statusCode != -1);
        if(response != null) {
            Header setCookieHeader = response.getFirstHeader("Set-Cookie");
            if(setCookieHeader != null) {
                String cookieVal = setCookieHeader.getValue().contains(";") ?
                        setCookieHeader.getValue().substring(0, setCookieHeader.getValue().indexOf(';')) : setCookieHeader.getValue();
                cookieHeader = new BasicHeader("Cookie", cookieVal);
            } else {
                cookieHeader = null;
            }
            HttpEntity entity = response.getEntity();
            if(entity != null) {
                if(entity.getContentLength() != -1 || entity.isChunked()) {
                    body = EntityUtils.toString(entity);
                }
            }
            EntityUtils.consume(entity);
        }
        return body;
    }

    /* Extracts an encryption key from the specified HTTP response body. */
    public static String getKeyFromResponseBody(String body) {
        Document doc = Jsoup.parse(body);
        String key = "";
        for(Element el : doc.getElementsByTag("script")) {
            if(el.html().contains("encryption.js")) {
                key = el.html();
                int start = key.indexOf("var key = \"") + "var key = \"".length();
                key = key.substring(start);
                key = key.substring(0, key.indexOf("\""));
                break;
            }
        }
        return key;
    }

    /* Encrypts the specified value with the using AES and the specified key. */
    public static String encrypt(String key, String value) throws Exception {
        // Phosphor has issues with ScriptEngine so the value is not properly encoded
        //ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        //String scriptFile = String.join(File.separator, getBaseWebAppDir(), "bodgeit", "js", "encryption.js");
        //engine.eval(new FileReader(scriptFile));
        //Invocable invocable = (Invocable) engine;
        //Object result = engine.eval(String.format("Aes.Ctr.encrypt('%s', '%s', 128);", value.replaceAll("\n", "\\n"), key));
        StringBuilder builder = new StringBuilder(2 + value.length() * 2).append("0x");
        for(byte b : value.getBytes()) {
            builder.append(String.format("%02X", b & 255));
        }
        return builder.toString();
    }
}

