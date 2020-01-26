package io.rivulet.maven.test;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Source;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

import javax.servlet.ServletException;

import static org.junit.Assert.fail;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
public class ELGeneratorTest extends TomcatBaseTest {
	@Rule
	public final ExternalResource myWebApp = new ExternalResource() {
		@Override
		protected void before() throws Throwable {
			try {
				addWebApp("JavaServerFaces");
			} catch (ServletException e) {
				e.printStackTrace();
				fail();
			}
		}
	};

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testELValueExpression() throws Exception{
			URIBuilder builder = getBaseURIBuilder().setPath("JavaServerFaces/welcome.xhtml");
			builder.addParameter("name", "Roberta");
			makeRequest(new HttpGet(builder.build()), 200);
			checkViolationsIncreased();
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testELValueExpressionFalsePositive() throws Exception{
		URIBuilder builder = getBaseURIBuilder().setPath("JavaServerFaces/welcome.xhtml");
		builder.addParameter("safe", "Roberta");
		makeRequest(new HttpGet(builder.build()), 200);
		checkViolationsIncreased();
	}
}

