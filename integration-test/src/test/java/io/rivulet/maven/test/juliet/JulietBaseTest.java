package io.rivulet.maven.test.juliet;

import io.rivulet.maven.test.TomcatBaseTest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;

public class JulietBaseTest extends TomcatBaseTest {

	protected String runJulietTest(String path, boolean beVulnerable, int status) throws Exception {
//		path = path + "?id=foo";
		URIBuilder builder = getBaseURIBuilder().setPath(path);
		builder.addParameter("beVulnerable", (beVulnerable ? "true" : "false"));
		builder.addParameter("name","Foo");
		builder.addParameter("id","Foo");
		String ret =  makeRequest(decorateRequest(path, new HttpGet(builder.build())), status);
//		System.out.println(ret);
		return ret; }

	protected String runJulietTest(String path, boolean beVulnerable) throws Exception {
		return runJulietTest(path, beVulnerable, 200);
	}

	private HttpUriRequest decorateRequest(String path, HttpGet req) {
		req.setHeader("Referer", "EvilCo");
		req.setHeader("User-Agent", "EvilCo");
		req.setHeader("Cookie","CookieName=ECHOO; otherCookie=stuff");
		return req;
	}
}
