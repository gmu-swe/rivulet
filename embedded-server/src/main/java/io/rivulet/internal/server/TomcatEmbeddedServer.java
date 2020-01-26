package io.rivulet.internal.server;

import org.apache.catalina.LifecycleState;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.commons.io.FileUtils;
import org.apache.coyote.http11.Http11NioProtocol;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class TomcatEmbeddedServer extends EmbeddedServer {

	private Tomcat tomcat;

	protected TomcatEmbeddedServer(String[] args) {
		super(args);
	}


	@Override
	protected int getPort() {
		return tomcat.getConnector().getLocalPort();
	}

	public void addWebApp(String warFilePath, String shortName) throws IOException {
		if (addedWebApps.add(shortName)) {
			unzipWar(warFilePath, shortName);
			tomcat.addWebapp("/" + shortName, new File(webAppsBaseDir, shortName).getCanonicalPath());
		}
	}

	/* Adds the webapp with the specified name if has not already been added to the embedded server. */
	public void addWebApp(String name) throws Exception {
		if (addedWebApps.add(name)) {
			String warFile = webAppsWarDir + "/" + name + ".war";
			unzipWar(warFile, name);
			tomcat.addWebapp("/" + name, new File(webAppsBaseDir, name).getCanonicalPath());
			System.out.println("Deployed: /" + name);
		}
	}

	@Override
	protected void startWebServer() {
		try {
			// Setup the embedded server
			tomcat = new Tomcat();
			tomcat.setBaseDir(tomcatBaseDir);
			tomcat.getHost().setAppBase(tomcatBaseDir);
			String protocol = Http11NioProtocol.class.getName();
			Connector connector = new Connector(protocol);
			// Listen on localhost
			connector.setAttribute("address", InetAddress.getByName("localhost").getHostAddress());
			// Use a random free port
			connector.setPort(tomcatPort);
			connector.setProperty("relaxedPathChars", "<>`");
			connector.setProperty("relaxedQueryChars", "<>`");
			connector.setProperty("maxThreads", "20");
			tomcat.getService().addConnector(connector);
			tomcat.setConnector(connector);
			tomcat.getHost().setDeployOnStartup(true);
			tomcat.getHost().setAutoDeploy(true);

			// Reduce logging
			if (!Boolean.getBoolean("DEBUG")) {
				tomcat.setSilent(true);
				System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
				replaceRootLoggerHandlers();
			}
			tomcat.enableNaming();
			tomcat.init();
			tomcat.start();
			// Add the shutdown hook to stop the embedded server
			Runnable shutdown = new Runnable() {
				@Override
				public void run() {
					try {
						try {
							// Stop and destroy the server
							if (tomcat.getServer() != null && tomcat.getServer().getState() != LifecycleState.DESTROYED) {
								if (tomcat.getServer().getState() != LifecycleState.STOPPED) {
									tomcat.stop();
								}
								tomcat.destroy();
								tomcat = null;
							}
						} finally {
							// Delete tomcat's temporary working directory
							FileUtils.deleteDirectory(new File(tomcatBaseDir));
						}
					} catch (Throwable t) {
						t.printStackTrace();
					}
				}
			};
			Runtime.getRuntime().addShutdownHook(new Thread(shutdown));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
