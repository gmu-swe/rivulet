package io.rivulet.internal.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.io.IOException;

public class JettyEmbeddedServer extends EmbeddedServer {

	static HandlerCollection handlerCollection;
	private static Server server;

	protected JettyEmbeddedServer(String[] args) {
		super(args);
	}

	protected void doneAddingWebApps() throws Exception {
		server.start();

	}


	public void addWebApp(String name) throws Exception {
		if (addedWebApps.add(name)) {
			WebAppContext webapp = new WebAppContext();
			webapp.setContextPath("/" + name + "/");
			File webAppWar = new File(webAppsWarDir, name + ".war");
			webapp.setWar(webAppWar.getAbsolutePath());
			webapp.setExtractWAR(true);
			handlerCollection.addHandler(webapp);
		}
	}

	@Override
	public void addWebApp(String warFilePath, String shortName) throws IOException {
		if (addedWebApps.add(shortName)) {
			WebAppContext webapp = new WebAppContext();
			webapp.setContextPath("/" + shortName + "/");
			File webAppWar = new File(warFilePath);
			webapp.setWar(webAppWar.getAbsolutePath());
			webapp.setExtractWAR(true);
			handlerCollection.addHandler(webapp);
		}
	}


	@Override
	protected void startWebServer() {
		if (server == null) {
			try {
//					StdErrLog logger = new StdErrLog();
//					logger.setDebugEnabled(true);
//					Log.setLog(logger);

				server = new Server(tomcatPort);
				// Add annotation scanning (for WebAppContexts)
				Configuration.ClassList classlist = Configuration.ClassList
						.setServerDefault( server );
				classlist.addBefore(
						"org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
						"org.eclipse.jetty.annotations.AnnotationConfiguration" );

				handlerCollection = new HandlerCollection();
				server.setHandler(handlerCollection);
			} catch (Throwable t) {
				t.printStackTrace();
				throw t;
			}
		}
	}

	@Override
	protected int getPort() {
		return ((ServerConnector) server.getConnectors()[0]).getLocalPort();
	}

}
