package io.rivulet.internal.server;

import edu.columbia.cs.psl.phosphor.BasicSourceSinkManager;
import edu.columbia.cs.psl.phosphor.Configuration;
import edu.columbia.cs.psl.phosphor.Instrumenter;
import io.rivulet.fuzz.RerunProgress;
import io.rivulet.internal.RivuletAutoTaintWrapper;
import io.rivulet.internal.fuzz.generator.RerunGeneratorWrapper;
import io.rivulet.internal.rerun.TestRerunConfiguration;
import org.apache.http.Consts;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public abstract class EmbeddedServer {

	// Path of the base directory used by Tomcat
	protected static final String tomcatBaseDir = System.getProperty("tomcat.base.directory", "tomcat");
	// Path of the directory to which web application files are extracted
	protected static final String webAppsBaseDir = System.getProperty("webapps.base.directory", "webapps");
	// Path of the directory containing war files for the web applications
	protected static final String webAppsWarDir = ".." + File.separator + "experiments" + File.separator + "apache-tomcat-8.0.47" + File.separator + "webapps";
	// Set of names of the web applications already added to tomcat
	protected static final HashSet<String> addedWebApps = new HashSet<>();
	// The last generator that was used to provide a set of sink methods. A null value indicates that Instrumenter.sinksFile
	// was used to provide sinks, i.e. the same sinks that were used for the original run were used.
	private static RerunGeneratorWrapper sinksProvider = null;
	protected int tomcatPort;
	protected int socketPort;
	private Thread clientCommunicationHandlingThread;
	private ServerSocket receiverSocket;
	private ServerTaintTrackingTestListener taintTrackingTestListener;
	private RerunProgress rerunProgress = new RerunProgress();

	protected EmbeddedServer(String[] args) {
//		this.infoFile = args[0]; //first arg is file to write out port numbers to
		this.tomcatPort = Integer.valueOf(args[0]);
		this.socketPort = Integer.valueOf(args[1]);
	}
	protected void doneAddingWebApps() throws Exception{

	}

	public static void main(String[] args) {
		EmbeddedServer server = new TomcatEmbeddedServer(args);//JettyEmbeddedServer(args);
		server.start();
		if (args.length > 2) {
			try {
				server.addWebApp(args[2], args[3]);
				server.doneAddingWebApps();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/* Returns a newly created file handler with the specified logging level that logs to a file in the base tomcat directory. */
	private static Handler createFileHandler() throws IOException {
		// Ensure that the base directory exists
		File baseDirFile = new File(tomcatBaseDir);
		if (!baseDirFile.isDirectory() && !baseDirFile.mkdirs()) {
			System.err.println("Failed to make base directory for embedded tomcat.");
		}
		Handler fileHandler = new FileHandler(tomcatBaseDir + File.separator + "catalina.out", true);
		fileHandler.setFormatter(new SimpleFormatter());
		fileHandler.setLevel(Level.INFO);
		fileHandler.setEncoding("UTF-8");
		return fileHandler;
	}

	/* Removes any existing handlers for the specified logger and adds the specified handler. */
	protected static void replaceRootLoggerHandlers() throws IOException {
		Logger rootLogger = LogManager.getLogManager().getLogger("");
		rootLogger.setUseParentHandlers(false);
		// Change the level of any existing handlers to OFF
		for (Handler h : rootLogger.getHandlers()) {
			h.setLevel(Level.OFF);
		}
		// Add a file handler for INFO level logging
		rootLogger.addHandler(createFileHandler());
	}

	/* If the directory for the web-app with the specified name does not exists creates it by unzipping the war for the
	 * web-app. */
	protected static void unzipWar(String warFile, String name) throws IOException {
		File dir = new File(webAppsBaseDir, name);
		if (!dir.isDirectory()) {
			// Unzip war into the directory only if it does not already exists
			File webAppWar = new File(warFile);
			if (!webAppWar.isFile()) {
				throw new RuntimeException("Could not find war file for: " + name);
			}
			try (ZipFile zipFile = new ZipFile(webAppWar)) {
				Enumeration<? extends ZipEntry> entries = zipFile.entries();
				while (entries.hasMoreElements()) {
					ZipEntry entry = entries.nextElement();
					File entryDestination = new File(dir, entry.getName());
					if (entry.isDirectory()) {
						if (!entryDestination.isDirectory() && !entryDestination.mkdirs()) {
							throw new RuntimeException("Failed to make directory for: " + entryDestination);
						}
						//JON: DO NOT DO THIS GENERALLY, IT WILL KILL APPS THAT DEPEND ON NO FILE HERE
						// Add velocity.properties file
//						File velocityPropFile = new File(entryDestination, "velocity.properties");
//						try {
//							org.apache.commons.io.FileUtils.writeStringToFile(velocityPropFile,
//									"runtime.log.logsystem.class=org.apache.velocity.runtime.log.NullLogChute", Consts.UTF_8, false);
//						} catch (Exception e) {
//							//
//						}
					} else {
						if (!entryDestination.getParentFile().isDirectory() && !entryDestination.getParentFile().mkdirs()) {
							throw new RuntimeException("Failed to make directory for: " + entryDestination.getParentFile());
						}
//						if (entry.getName().endsWith("log4j.properties")) {
//							// Write different logging properties
//							writeLog4JProperties(entryDestination);
//						} else {
						InputStream in = zipFile.getInputStream(entry);
						OutputStream out = new FileOutputStream(entryDestination);
						IOUtils.copy(in, out);
						IOUtils.closeQuietly(in);
						out.close();
//						}
					}
				}
			}
		}
	}

	/* Writes log4j properties to disable logging to the specified file. */
	private static void writeLog4JProperties(File file) throws IOException {
		String content =
				"log4j.rootLogger=OFF, stdout\n" +
						"log4j.appender.stdout=org.apache.log4j.ConsoleAppender\n" +
						"log4j.appender.stdout.layout=org.apache.log4j.SimpleLayout\n";
		org.apache.commons.io.FileUtils.writeStringToFile(file,
				content, Consts.UTF_8, false);
	}

	public abstract void addWebApp(String warFilePath, String shortName) throws IOException;

	public abstract void addWebApp(String name) throws Exception;

	protected abstract void startWebServer();

	protected abstract int getPort();

	public void start() {
		try {
			startWebServer();
			receiverSocket = new ServerSocket(socketPort);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.clientCommunicationHandlingThread = new Thread(() -> {
			try {
//				FileWriter portWriter = new FileWriter(infoFile);
//				portWriter.write(receiverSocket.getLocalPort() + "\n");
//				portWriter.write(tomcat.getConnector().getLocalPort() + "\n");
				System.out.println("Control port: " + receiverSocket.getLocalPort());
				System.out.println("Tomcat port: " + getPort());
//				portWriter.close();
				while (true) {
					Socket channel = receiverSocket.accept();
					Thread clientThread = new Thread(() -> {
						try {
							try {
								DataInputStream is = new DataInputStream(new BufferedInputStream(channel.getInputStream()));
								DataOutputStream os = new DataOutputStream(new BufferedOutputStream(channel.getOutputStream()));
								PrintWriter outputPrinter = new PrintWriter(channel.getOutputStream());
								while (true) {
									EmbeddedMessageImpl message = EmbeddedMessageImpl.fromInput(is);
									message.apply(this, os);
								}
							} catch (EOFException ex) {
								return;
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							} finally {
								channel.close();
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					});
					clientThread.start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		this.clientCommunicationHandlingThread.setDaemon(true);
		this.clientCommunicationHandlingThread.start();
	}

	public ServerTaintTrackingTestListener getTaintTrackingTestListener() {
		return taintTrackingTestListener;
	}

	public void initListener(String rerunConfigsPath, String violationReportsPath, String criticalReproductionPath) {
		this.taintTrackingTestListener = new ServerTaintTrackingTestListener(this, rerunConfigsPath, violationReportsPath, criticalReproductionPath, new RerunProgress());
	}

	public void setRerunConfigAndResetAutoTaint(TestRerunConfiguration config) {
		RivuletAutoTaintWrapper.setCurrentRerunConfig(config);
		// Swap the taintSourceWrapper class and the sink methods
		if (config.getAutoTainterClass() != null) {
			try {
				Configuration.autoTainter = config.getAutoTainterClass().newInstance();
				if (Configuration.autoTainter instanceof RerunGeneratorWrapper) {
					RerunGeneratorWrapper generator = (RerunGeneratorWrapper) Configuration.autoTainter;
					// Check if the generator that supplied the current set of sinks is different
					if (!generator.equals(sinksProvider)) {
						if (generator.getTargetedBaseSinks() != null) {
							// Generator has custom sink set
							sinksProvider = generator;
							BasicSourceSinkManager.replaceAutoTaintMethods(generator.getTargetedBaseSinks(), BasicSourceSinkManager.AutoTaint.SINK);
						} else if (sinksProvider != null) {
							// Use default sink set
							sinksProvider = null;
							BasicSourceSinkManager.replaceAutoTaintMethods(Instrumenter.sinksFile, BasicSourceSinkManager.AutoTaint.SINK);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				Configuration.autoTainter = new RivuletAutoTaintWrapper();
				// Check if the generator that supplied the current set of sinks is different
				if (sinksProvider != null) {
					sinksProvider = null;
					BasicSourceSinkManager.replaceAutoTaintMethods(Instrumenter.sinksFile, BasicSourceSinkManager.AutoTaint.SINK);
				}
			}
		} else {
			Configuration.autoTainter = new RivuletAutoTaintWrapper();
			// Check if the generator that supplied the current set of sinks is different
			if (sinksProvider != null) {
				sinksProvider = null;
				BasicSourceSinkManager.replaceAutoTaintMethods(Instrumenter.sinksFile, BasicSourceSinkManager.AutoTaint.SINK);
			}
		}
	}
}
