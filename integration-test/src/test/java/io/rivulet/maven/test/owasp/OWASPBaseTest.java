package io.rivulet.maven.test.owasp;

import io.rivulet.maven.test.TomcatBaseTest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Rule;
import org.junit.rules.ExternalResource;

import javax.servlet.ServletException;

import static org.junit.Assert.fail;

public class OWASPBaseTest extends TomcatBaseTest {
	@Rule
	public final ExternalResource myWebApp = new ExternalResource() {
		@Override
		protected void before() throws Throwable {
			try {
				addWebApp("owasp-benchmark");
			} catch (ServletException e) {
				e.printStackTrace();
				fail();
			}
		}
	};

	protected HttpUriRequest decorateRequest(String page, HttpUriRequest req) {
		req.setHeader("Referer", "EvilCo");
		req.setHeader("User-Agent", "EvilCo");
		String benchmarkName = page.substring(page.lastIndexOf('/') + 1);
		req.setHeader(benchmarkName, benchmarkName);
		req.setHeader("Cookie",benchmarkName+"=ECHOO");
		return req;
	}

	protected final void submitForm(String page, String method, String... args) throws Exception {
		URIBuilder builder = getBaseURIBuilder().setPath(page);
		for (int i = 0; i < args.length; i += 2) {
			builder.addParameter(args[i], args[i + 1]);
		}
		String ret;
		if (method.equalsIgnoreCase("get"))
			ret = makeRequest(decorateRequest(page, new HttpGet(builder.build())), 200);
		else
			ret = makeRequest(decorateRequest(page, new HttpPost(builder.build())), 200);
	}
	protected final void submitFormAnyResponse(String page, String method, String... args) throws Exception {
		URIBuilder builder = getBaseURIBuilder().setPath(page);
		for (int i = 0; i < args.length; i += 2) {
			builder.addParameter(args[i], args[i + 1]);
		}
		String ret;
		if (method.equalsIgnoreCase("get"))
			ret = makeRequest(decorateRequest(page, new HttpGet(builder.build())), -1, false);
		else
			ret = makeRequest(decorateRequest(page, new HttpPost(builder.build())), -1, false);
	}
}
