package io.rivulet.maven;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.MavenExecutionException;
import org.apache.maven.artifact.repository.ArtifactRepositoryPolicy;
import org.apache.maven.artifact.repository.MavenArtifactRepository;
import org.apache.maven.artifact.repository.layout.DefaultRepositoryLayout;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.util.xml.Xpp3Dom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;

@Component(role = AbstractMavenLifecycleParticipant.class, hint = "phosphor-ext")
@SuppressWarnings("unused")
public class PhosphorLifecycleParticipant extends AbstractMavenLifecycleParticipant {

	// Suffix used for configuration files not yet read and processed by a TestRerunDirector
	public static final String RAW_CONFIG_SUFFIX = ".rawReruns";
	// Suffix used for configuration files read or processed by a TestRerunDirector
	public static final String PROCESSED_CONFIG_SUFFIX = ".reruns";
	static String PATH_TO_AGENT_BOOTPATH_JAR;
	static String PATH_TO_AGENT;
	static String SNAPSHOT_REPO = "https://oss.sonatype.org/content/repositories/snapshots/";

	static String PATH_TO_RIVULET_CORE_JAR;
	private static final String PHOSPHOR_VERSION = "0.0.4-SNAPSHOT";
	private static final String RIVULET_VERSION = "1.0.0";

	static {
		PATH_TO_AGENT_BOOTPATH_JAR = "/edu/gmu/swe/phosphor/Phosphor/" + PHOSPHOR_VERSION + "/Phosphor-" + PHOSPHOR_VERSION + ".jar";
		PATH_TO_RIVULET_CORE_JAR = "/io/rivulet/rivulet-core/" + RIVULET_VERSION + "/rivulet-core-" + RIVULET_VERSION + ".jar";
		PATH_TO_AGENT = PATH_TO_AGENT_BOOTPATH_JAR;
	}

	String instrumentedJVMDir;

	// Name of directory for violation reports from individual runs
	private static final String VIOLATION_REPORT_DIR = "phosphor-reports";
	// Name of the directory for rerun configurations
	private static final String RERUN_CONFIG_DIR = "phosphor-rerun-configs";
	// Name of the directory for files that help with reproducing critical violations
	private static final String CRITICAL_REPRODUCTION_DIR = "phosphor-critical-reproduction";

	MavenSession session;

	private String sourcesFile;
	private String sinksFile;
	private String taintThroughFile;
	private boolean isSkipTests;
	private boolean isSkipReruns;
	private boolean reportRerunFailures;
	private boolean stopRerunsWhenVerified;
	private boolean forceForkInTests;
	// If running reruns from a specific configuration file, the path to a file containing unprocessed reruns. Otherwise,
	// null.
	private String rerunsFilePath;
	private boolean disableViolationPrinting;

	public void afterSessionStart(MavenSession session) throws MavenExecutionException {
		// addExternalRepo(session.getCurrentProject());
		session.getRequest().getPluginArtifactRepositories().add(new MavenArtifactRepository("phosphor.snapshots", SNAPSHOT_REPO, new DefaultRepositoryLayout(), new ArtifactRepositoryPolicy(true, ArtifactRepositoryPolicy.UPDATE_POLICY_ALWAYS, ArtifactRepositoryPolicy.CHECKSUM_POLICY_IGNORE),
				new ArtifactRepositoryPolicy(true, ArtifactRepositoryPolicy.UPDATE_POLICY_DAILY, ArtifactRepositoryPolicy.CHECKSUM_POLICY_IGNORE)));
		super.afterSessionStart(session);
	}

	@Override
	public void afterProjectsRead(MavenSession session) throws MavenExecutionException {
		this.session = session;

		//Check for a phosphor.config property on the first project that we are invoked on
		//Users might specify this in their pom
		if (session.getProjects().get(0).getProperties().containsKey("phosphor.config")) {
			System.setProperty("phosphor.config", session.getProjects().get(0).getProperties().getProperty("phosphor.config"));
		}
		this.instrumentedJVMDir = System.getProperty("instrumentedJVMDir", System.getProperty("user.home") + File.separator + ".phosphor-jvm");
		this.sourcesFile = readAutoTaintFileProperty("sources", "phosphor.sources");
		this.sinksFile = readAutoTaintFileProperty("sinks", "phosphor.sinks");
		this.taintThroughFile = readAutoTaintFileProperty("taintThrough", "phosphor.taintThrough");
		this.isSkipReruns = Boolean.parseBoolean(session.getUserProperties().getProperty("ifc.skipReruns","false"));
		this.isSkipTests = Boolean.parseBoolean(session.getUserProperties().getProperty("ifc.skipTests","false"));
		this.reportRerunFailures = Boolean.parseBoolean(session.getUserProperties().getProperty("ifc.reportRerunFailures","false"));
		this.stopRerunsWhenVerified = Boolean.parseBoolean(session.getUserProperties().getProperty("ifc.stopRerunsWhenVerified","false"));
		this.forceForkInTests = Boolean.parseBoolean(session.getUserProperties().getProperty("ifc.isolation","false"));
		boolean createCriticalReproductionFiles = Boolean.parseBoolean(session.getUserProperties().getProperty("ifc.criticalReproductionFiles","false"));
		this.disableViolationPrinting = Boolean.parseBoolean(session.getUserProperties().getProperty("ifc.disableViolationPrinting","false"));
		this.rerunsFilePath = session.getUserProperties().getProperty("ifc.reruns");
		if(rerunsFilePath != null) {
			if(!rerunsFilePath.endsWith(RAW_CONFIG_SUFFIX) || !Files.isRegularFile(Paths.get(rerunsFilePath))) {
				String msg = String.format("Invalid value for property ifc.reruns: %s. Value must specify a" +
						"path to a file containing unprocessed reruns", rerunsFilePath);
				throw new RuntimeException(msg);
			} else {
				this.isSkipTests = true;
			}
		}

		for(MavenProject p : session.getProjects()) {
			String violationReportsPath = p.getBuild().getDirectory() + File.separator + VIOLATION_REPORT_DIR;
			String rerunConfigsPath = p.getBuild().getDirectory() + File.separator + RERUN_CONFIG_DIR;
			String criticalReproductionPath = null;
			if(!isSkipTests) {
				// Blow away raw rerun configurations ONLY if we are running the tests this time
				makeClearedDirectory(rerunConfigsPath, null, RAW_CONFIG_SUFFIX);
				makeClearedDirectory(violationReportsPath, "RUN-", null);
			}
			if(rerunsFilePath != null) {
				// Remove processed configurations with the same name as the reruns file in the same folder as the reruns
				// file
				File rerunsFile = new File(rerunsFilePath);
				String baseName = rerunsFile.getName().substring(0, rerunsFile.getName().length() - RAW_CONFIG_SUFFIX.length());
				makeClearedDirectory(rerunsFile.getParent(), baseName, PROCESSED_CONFIG_SUFFIX);
			} else if(!isSkipReruns) {
				// Blow away the processed rerun configurations info ONLY if we are doing reruns this time
				makeClearedDirectory(rerunConfigsPath, null, PROCESSED_CONFIG_SUFFIX);
				makeClearedDirectory(violationReportsPath, "RERUN-", null);
				if(createCriticalReproductionFiles || (session.getUserProperties().getProperty("ifc.criticalReproductionFiles") == null &&
						Boolean.parseBoolean(p.getProperties().getProperty("ifc.criticalReproductionFiles","false")))) {
					// Make a critical production file folder if the user property is true or the user property is not set
					// and the project property is true
					criticalReproductionPath = p.getBuild().getDirectory() + File.separator + CRITICAL_REPRODUCTION_DIR;
					makeDeepClearedDirectory(criticalReproductionPath);
				}
			}
			if(rerunsFilePath == null) {
				addPhosphorPlugin(p,violationReportsPath);
			}
			addPhosphorToSurefireOrFailsafe(p, false, violationReportsPath, rerunConfigsPath, criticalReproductionPath);
			addPhosphorToSurefireOrFailsafe(p, true, violationReportsPath, rerunConfigsPath, criticalReproductionPath);
		}
		super.afterProjectsRead(session);
	}

	/* Validates the value of an auto-taint file system property with the specified name and descriptions. Returns the
	 * value of the property. */
	private String readAutoTaintFileProperty(String autoTaintTypeDesc, String autoTaintPropertyName) {
		String autoTaintFile = System.getProperty(autoTaintPropertyName);
		if (autoTaintFile == null) {
			autoTaintFile = System.getProperty("phosphor.config", "eval");
			//extract the resource
			try {
				File tempFile = File.createTempFile("rivulet", autoTaintPropertyName);
				tempFile.deleteOnExit();
				InputStream input = PhosphorLifecycleParticipant.class.getResourceAsStream("/config-files/" + autoTaintFile + "/" + autoTaintTypeDesc);
				if (input == null) {
					String capitalizedDesc = autoTaintTypeDesc.substring(0, 1).toUpperCase() + autoTaintTypeDesc.substring(1);
					String msg = String.format("%s configuration resource %s does not exist! (If you are trying to specify a non-standard %s file, please use a full path)", capitalizedDesc, autoTaintFile, capitalizedDesc);
					throw new IllegalStateException(msg);
				}
				System.out.printf("[Phosphor]: Using %s config: %s\n", autoTaintTypeDesc, autoTaintFile);
				FileOutputStream out = new FileOutputStream(tempFile);
				byte[] buf = new byte[4096];
				int n;
				while ((n = input.read(buf)) > 0) {
					out.write(buf, 0, n);
				}
				input.close();
				out.close();
				autoTaintFile = tempFile.getAbsolutePath();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		} else {
			System.out.printf("[Phosphor]: Using %s file: %s\n", autoTaintTypeDesc, autoTaintFile);
		}
		if (!Files.exists(Paths.get(autoTaintFile))) {
			String capitalizedDesc = autoTaintTypeDesc.substring(0, 1).toUpperCase() + autoTaintTypeDesc.substring(1);
			String msg = String.format("%s file %s does not exist!", capitalizedDesc, autoTaintFile);
			throw new IllegalStateException(msg);
		}
		return autoTaintFile;
	}

	private void addPhosphorPlugin(MavenProject project, String violationReportsPath) {
		Plugin phosphorPlugin = new Plugin();
		phosphorPlugin.setArtifactId("rivulet-maven-plugin");
		phosphorPlugin.setGroupId("io.rivulet");
		phosphorPlugin.setVersion(RIVULET_VERSION);
		project.getBuild().addPlugin(phosphorPlugin);

		PluginExecution phosphorExec = new PluginExecution();
		phosphorExec.setId("phosphor-instrument");
		phosphorExec.setPhase("process-test-resources");
		phosphorExec.setGoals(Collections.singletonList("instrument"));
		Xpp3Dom phosphorMavenConfig = new Xpp3Dom("configuration");

		Xpp3Dom jvm = new Xpp3Dom("jvm");
		jvm.setValue(instrumentedJVMDir);
		phosphorMavenConfig.addChild(jvm);
		phosphorExec.setConfiguration(phosphorMavenConfig);
		phosphorPlugin.addExecution(phosphorExec);

		PluginExecution phosphorCleanExec = new PluginExecution();
		phosphorCleanExec.setId("phosphor-clean");
		phosphorCleanExec.setPhase("clean");
		phosphorCleanExec.setGoals(Collections.singletonList("clean"));
		phosphorPlugin.addExecution(phosphorCleanExec);

		// Add Plugin for building the full Phosphor violation report from individual test runs' reports
		PluginExecution phosphorReportExec = new PluginExecution();
		phosphorReportExec.setId("phosphor-report");
		phosphorReportExec.setPhase("test");
		phosphorReportExec.setGoals(Collections.singletonList("report"));
		// Add report directory path to config
		Xpp3Dom reportMavenConfig = new Xpp3Dom("configuration");
		Xpp3Dom violationReportsPathChild = new Xpp3Dom("violationReportDirPath");
		violationReportsPathChild.setValue(violationReportsPath);
		reportMavenConfig.addChild(violationReportsPathChild);
		// Add final report file to config
		String phosphorReportFilePath = project.getBuild().getDirectory() + File.separator + "phosphor-report.json";
		if(new File(phosphorReportFilePath).exists()) {
			if(!(new File(phosphorReportFilePath).delete())) {
				System.err.println("Failed to delete existing phosphor report file: " +  phosphorReportFilePath);
			}
		}
		Xpp3Dom phosphorReportFile = new Xpp3Dom("phosphorReportFile");
		phosphorReportFile.setValue(phosphorReportFilePath);
		reportMavenConfig.addChild(phosphorReportFile);
		phosphorReportExec.setConfiguration(reportMavenConfig);
		phosphorPlugin.addExecution(phosphorReportExec);
	}

	/* Tries to make the at directory at the specified path if it does not exist as a directory. Otherwise shallowly
	 * clears any files from the existing directory with the specified prefix and specified suffix. */
	private static void makeClearedDirectory(String dirName, String prefixToDelete, String suffixToDelete) {
		File dir = new File(dirName);
		if(dir.isDirectory()) {
			// Directory already exists; clear any files in it.
			try {
				File[] files = dir.listFiles();
				if(files != null) {
					for (File file : files) {
						if((suffixToDelete == null || file.getName().endsWith(suffixToDelete))
								&& (prefixToDelete == null || file.getName().startsWith(prefixToDelete))
								&& !file.delete()) {
							throw new IOException();
						}
					}
				}
			} catch(IOException e) {
				System.err.println("Failed to create or clear directory: " + dirName);
			}
		} else if(dir.exists()) {
			// File exists with the directory's name
			if(!dir.delete() || !dir.mkdirs()) {
				System.err.println("Failed to create or clear directory: " + dirName);
			}
		} else {
			// Nothing exists with the directory's name
			if(!dir.mkdirs()) {
				System.err.println("Failed to create or clear directory: " + dirName);
			}
		}
	}

	/* Tries to make the at directory at the specified path if it does not exist as a directory. Otherwise recursively
	 * clears any files from the existing directory. */
	private void makeDeepClearedDirectory(String dirName) {
		File targetDir = new File(dirName);
		if(targetDir.isDirectory()) {
			// Directory already exists; clear any files in it.
			try {
				FileVisitor<Path> deletingVisitor = new SimpleFileVisitor<Path>() {
					@Override
					public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
						if(!dir.equals(targetDir.toPath())) {
							Files.delete(dir);
						}
						return FileVisitResult.CONTINUE;
					}

					@Override
					public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
						Files.delete(file);
						return FileVisitResult.CONTINUE;
					}
				};
				Files.walkFileTree(new File(dirName).toPath(), deletingVisitor);
			} catch(IOException e) {
				e.printStackTrace();
			}
		} else if(targetDir.exists()) {
			// File exists with the directory's name
			if(!targetDir.delete() || !targetDir.mkdirs()) {
				System.err.println("Failed to create or clear directory: " + dirName);
			}
		} else {
			// Nothing exists with the directory's name
			if(!targetDir.mkdirs()) {
				System.err.println("Failed to create or clear directory: " + dirName);
			}
		}
	}

	private void addPhosphorToSurefireOrFailsafe(MavenProject project, boolean doFailsafe, String violationReportsPath,
												 String rerunConfigsPath, String criticalReproductionPath) {
		Plugin p = null;
		for(Plugin o : project.getBuildPlugins()) {
			if(!doFailsafe && o.getArtifactId().equals("maven-surefire-plugin") && o.getGroupId().equals("org.apache.maven.plugins")) {
				p = o;
			} else if(doFailsafe && o.getArtifactId().equals("maven-failsafe-plugin") && o.getGroupId().equals("org.apache.maven.plugins")) {
				p = o;
			}
		}
		if(p == null) {
			return;
		}
		p.setVersion("2.20.1");
		LinkedList<PluginExecution> newExecutions = new LinkedList<>();
		for(PluginExecution pe : p.getExecutions()) {
			Xpp3Dom config = (Xpp3Dom) pe.getConfiguration();
			if(config == null) {
				config = new Xpp3Dom("configuration");
			}
			Xpp3Dom config2 = new Xpp3Dom(config);

			boolean disableViolationPrintingExecution = disableViolationPrinting  || Boolean.parseBoolean(project.getProperties().getProperty("ifc.disableViolationPrinting","false"));
			injectConfig(project, config, violationReportsPath, rerunConfigsPath, null, forceForkInTests,
					isSkipTests, disableViolationPrintingExecution);
			p.setConfiguration(config);
			pe.setConfiguration(config);

			PluginExecution pe2 = new PluginExecution();

			pe2.getGoals().addAll(pe.getGoals());
			pe2.setPhase(pe.getPhase());
			pe2.setId(pe.getId() + "-reruntaints");

			// pe2.setPriority(Integer.MAX_VALUE);
			injectConfig(project, config2, violationReportsPath, rerunConfigsPath, criticalReproductionPath, forceForkInTests,
					isSkipReruns, disableViolationPrintingExecution);
			// Add isRuns property to config2
			Xpp3Dom prop = new Xpp3Dom("property");
			Xpp3Dom n = new Xpp3Dom("name");
			n.setValue("isReruns");
			Xpp3Dom v = new Xpp3Dom("value");
			v.setValue("true");
			prop.addChild(n);
			prop.addChild(v);
			config2.getChild("properties").addChild(prop);
			// Add reportRerunFailures property to config2 if the user or project property was set
			boolean projectReportRerunFailures = Boolean.parseBoolean(project.getProperties().getProperty("ifc.reportRerunFailures","false"));
			if(reportRerunFailures || projectReportRerunFailures) {
				Xpp3Dom prop2 = new Xpp3Dom("property");
				Xpp3Dom name2 = new Xpp3Dom("name");
				name2.setValue("reportRerunFailures");
				Xpp3Dom value2 = new Xpp3Dom("value");
				v.setValue("true");
				prop2.addChild(name2);
				prop2.addChild(value2);
				config2.getChild("properties").addChild(prop2);
				// Set maven.test.failure.ignore property to true for config2
				Xpp3Dom testFailureIgnore = config2.getChild("testFailureIgnore");
				if(testFailureIgnore == null) {
					testFailureIgnore = new Xpp3Dom("testFailureIgnore");
					config2.addChild(testFailureIgnore);
				}
				testFailureIgnore.setValue("true");
			}
			// Add stopRerunsWhenVerified property to config2 if the user or project property was set
			boolean projectStopRerunsWhenVerified = Boolean.parseBoolean(project.getProperties().getProperty("ifc.stopRerunsWhenVerified","false"));
			if(stopRerunsWhenVerified || projectStopRerunsWhenVerified) {
				Xpp3Dom prop2 = new Xpp3Dom("property");
				Xpp3Dom name2 = new Xpp3Dom("name");
				name2.setValue("stopRerunsWhenVerified");
				Xpp3Dom value2 = new Xpp3Dom("value");
				v.setValue("true");
				prop2.addChild(name2);
				prop2.addChild(value2);
				config2.getChild("properties").addChild(prop2);
			}
			// Set failIfNoTest property to false for config2
			Xpp3Dom failIfNoTests = config2.getChild("failIfNoTests");
			if(failIfNoTests == null) {
				failIfNoTests = new Xpp3Dom("failIfNoTests");
				config2.addChild(failIfNoTests);
			}
			failIfNoTests.setValue("false");
			pe2.setConfiguration(config2);
			newExecutions.add(pe);
			newExecutions.add(pe2);
		}
		p.setExecutions(newExecutions);
		p.getDependencies().clear();
		Dependency rivulet = new Dependency();
		rivulet.setArtifactId("rivulet-surefire-provider");
		rivulet.setGroupId("io.rivulet");
		rivulet.setVersion("2.20.1");
		p.addDependency(rivulet);
	}

	private void injectConfig(MavenProject project, Xpp3Dom config, String violationReportsPath, String rerunConfigsPath,
							  String criticalReproductionPath, boolean forceFork, boolean skipTests, boolean disableViolationPrintingExecution) {
		Xpp3Dom forkMode = config.getChild("forkMode");
		boolean isSetToFork = false;
		boolean isReuseForks = true;
		if(forkMode != null && forceFork) {
			forkMode.setValue("always");
			isReuseForks = false;
			isSetToFork = true;
		} else if(forkMode != null && (forkMode.getValue().equalsIgnoreCase("never") || forkMode.getValue().equalsIgnoreCase("perthread"))) {
			forkMode.setValue("once");
			isReuseForks = true;
			isSetToFork = true;
		}
		Xpp3Dom forkCount = config.getChild("forkCount");
		if(forkCount != null && !forkCount.getValue().equals("1")) {
			isSetToFork = true;
		}
		if(!isSetToFork) {
			forkCount = new Xpp3Dom("forkCount");
			forkCount.setValue("1");
			config.addChild(forkCount);
			if(forceFork) {
				Xpp3Dom reuseForks =new Xpp3Dom("reuseForks");
				reuseForks.setValue("false");
				config.addChild(reuseForks);
			}
		}
		if(session.getUserProperties().getProperty("maven.surefire.debug") != null) {
			forkCount.setValue("1");
		}
		Xpp3Dom reuseForksDom = config.getChild("reuseForks");
		if(reuseForksDom != null){
			isReuseForks = Boolean.valueOf(reuseForksDom.getValue());
		}
		Xpp3Dom skipTestsDom = config.getChild("skipTests");
		if(skipTestsDom == null) {
			skipTestsDom = new Xpp3Dom("skipTests");
			config.addChild(skipTestsDom);
		}
		skipTestsDom.setValue(skipTests?"true":"false");


		Xpp3Dom argLine = config.getChild("argLine");
		if(argLine == null) {
			argLine = new Xpp3Dom("argLine");
			argLine.setValue("");
			config.addChild(argLine);
		}
		argLine.setValue(argLine.getValue().replace("${surefireArgLine}", ""));
		if(argLine != null && argLine.getValue().equals("${argLine}"))
			argLine.setValue("");
		else if (argLine != null) {
			argLine.setValue(argLine.getValue().replace("@{argLine}", "").replace("${argLine}", "").replace("${test.opts.coverage}", ""));
		}

		if(!argLine.getValue().contains("-Xmx"))
			argLine.setValue(argLine.getValue() + " -Xmx2g");
		String taintFileConfig = "";
		if(sourcesFile != null)
			taintFileConfig += ",taintSources=" + sourcesFile;
		if(sinksFile != null)
			taintFileConfig += ",taintSinks=" + sinksFile;
		if(taintThroughFile != null)
			taintFileConfig += ",taintThrough=" + taintThroughFile;
		String cacheConfig = "-DphosphorCacheDirectory='"+ project.getBuild().getDirectory() + File.separatorChar + "cached-phosphor-${surefire.forkNumber}'";
		String jvmArgs = "-Xbootclasspath/p:" + session.getLocalRepository().getBasedir() + PATH_TO_AGENT_BOOTPATH_JAR + ":" + session.getLocalRepository().getBasedir() + PATH_TO_RIVULET_CORE_JAR + " -javaagent:" + session.getLocalRepository().getBasedir() + PATH_TO_AGENT
				+ "='taintSourceWrapper=io.rivulet.internal.RivuletAutoTaintWrapper,ignore=io/rivulet/internal/,arrayindex,priorClassVisitor=io.rivulet.internal.RivuletCV,ignoredMethod=org/mindrot/jbcrypt/BCrypt.encipher([II)V" + taintFileConfig + "'";

		//Old approach used both JAVA_TOOL_OPTIONS and argLine, sometimes
//		String toolOpts = System.getenv("JAVA_TOOL_OPTIONS");
//		if (toolOpts != null) {
//			toolOpts = toolOpts.replace("-XX:+TraceExceptions","");
//			toolOpts =toolOpts.trim();
//			if (!toolOpts.equals(jvmArgs))
//				throw new IllegalStateException("Expected JAVA_TOOL_OPTIONS to be null or '" + jvmArgs + "', but found: '" + toolOpts + "'");
//			argLine.setValue(cacheConfig + " " + argLine.getValue());
//		} else
//			argLine.setValue(jvmArgs + " " + cacheConfig + " " + argLine.getValue());

		//Hack to set JAVA_TOOL_OPTIONS environmental variable
		Map<String, String> env = System.getenv();
		try {
			Field field = env.getClass().getDeclaredField("m");
			field.setAccessible(true);
			((Map<String, String>) field.get(env)).put("JAVA_TOOL_OPTIONS", jvmArgs);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		argLine.setValue(cacheConfig + " " + argLine.getValue());



		Xpp3Dom parallel = config.getChild("parallel");
		if (parallel != null)
			parallel.setValue("none");
		Xpp3Dom jvm = config.getChild("jvm");
		if (jvm == null) {
			jvm = new Xpp3Dom("jvm");
			config.addChild(jvm);
		}
		jvm.setValue(instrumentedJVMDir + "/bin/java");

		Xpp3Dom properties = config.getChild("properties");
		if(properties == null) {
			properties = new Xpp3Dom("properties");
			config.addChild(properties);
		}
		// Add the rerun configuration path property
		properties.addChild(makeProperty("rerunConfigsPath", rerunConfigsPath));
		// Add violation report path property
		properties.addChild(makeProperty("violationReportsPath", violationReportsPath));
		// Pass along fork count
		properties.addChild(makeProperty("reuseForks", Boolean.toString(isReuseForks)));
		// Add critical reproduction path property if it is set
		if(criticalReproductionPath != null) {
			properties.addChild(makeProperty("criticalReproductionPath", criticalReproductionPath));
		}
		// Add the reruns file path property if it is set
		if(rerunsFilePath != null) {
			properties.addChild(makeProperty("rerunsFilePath", rerunsFilePath));
		}
		// Pass along disableViolationPrintingExecution if it is set
		if(disableViolationPrintingExecution) {
			properties.addChild(makeProperty("disableViolationPrinting", "true"));
		}
		if(System.getProperty("ifc.port") != null) {
			properties.addChild(makeProperty("ifc.port", System.getProperty("ifc.port")));
		}
	}

	/* Returns a new Xpp3Dom property with the specified name and value. */
	private Xpp3Dom makeProperty(String name, String value) {
		Xpp3Dom property = new Xpp3Dom("property");
		Xpp3Dom propertyName = new Xpp3Dom("name");
		propertyName.setValue(name);
		Xpp3Dom propertyValue = new Xpp3Dom("value");
		propertyValue.setValue(value);
		property.addChild(propertyName);
		property.addChild(propertyValue);
		return property;
	}
}

