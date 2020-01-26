package io.rivulet.maven.test;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

public class PuzzleMallTest extends TomcatBaseTest {

	@Rule
	public final ExternalResource myWebApp = new ExternalResource() {
		@Override
		protected void before() throws Exception {
			addWebApp("puzzlemall");
			//Set up the database
			URIBuilder builder = getBaseURIBuilder().setPath("puzzlemall/install/initialize.jsp");
			makeRequest(new HttpGet(builder.build()), 200);
		}
	};

	@Test
	public void testShowsAnyTestCanRun(){
		System.out.println("If this test runs, then puzzlemall was successfully initialized");
	}
}
