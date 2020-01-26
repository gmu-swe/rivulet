package io.rivulet.fuzz.maven.surefire.junitcore;

import io.rivulet.PhosphorHttpRequest;
import io.rivulet.RerunResult;
import io.rivulet.ViolationReportingUtils;
import io.rivulet.fuzz.RerunProgress;
import io.rivulet.fuzz.RivuletJUnitCoreProvider;
import io.rivulet.internal.RivuletAutoTaintWrapper;
import io.rivulet.internal.TaintedSinkValueSet;
import io.rivulet.internal.Violation;
import io.rivulet.internal.ViolationReport;
import io.rivulet.internal.rerun.TestRerunConfiguration;
import io.rivulet.fuzz.TestRerunDirector;
import org.apache.maven.surefire.report.RunListener;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BaseTaintTrackingTestListener {
	// Directory where rerun configuration files generated for original test runs should be written
	protected final File rerunConfigsDirectory;
	// Directory where serialized json test result files should be written
	protected final File violationReportsDirectory;
	// Directory created for critical reproduction files or null if reproduction files should not be created
	protected final File criticalReproductionDirectory;
	// Used to serialize information about test results to json and output it to a file
	protected ViolationReport violationReport;
	// File in the report directory to which results from the current test set should be reported
	protected File currentReportFile;
	// Stored rerun configurations that need to be serialized
	protected LinkedHashSet<TestRerunConfiguration> generatedRerunConfigs = new LinkedHashSet<>();
	// Used to distinguish between violations in a test set
	protected final AtomicInteger violationNumber;
	// For keeping track of how many have ben done
	protected final RerunProgress rerunProgress;
	// Used to preserve thread safety of the output stream
	protected final Object target;
	// The prefix used for Violations' IDs created in the current test set
	private String testSetPrefix;


	public BaseTaintTrackingTestListener(Object target, String rerunConfigsPath, String violationReportsPath, String criticalReproductionPath, RerunProgress rerunProgress) {
		this.rerunConfigsDirectory = new File(rerunConfigsPath);
		this.violationReportsDirectory = new File(violationReportsPath);
		this.criticalReproductionDirectory = criticalReproductionPath == null ? null : new File(criticalReproductionPath);
		ensureDirectoriesInitialized(this.rerunConfigsDirectory, this.violationReportsDirectory, this.criticalReproductionDirectory);
		this.violationReport = new ViolationReport();
		this.violationNumber = new AtomicInteger(0);
		this.rerunProgress = rerunProgress;
		this.target = getStreamSynchronizationTarget(target);

	}

	/* Returns the private output stream used by the specified delegate for synchronization. */
	private static Object getStreamSynchronizationTarget(Object delegate) {
		if(delegate instanceof RunListener) {
			Object target = new Object();
			try {
				Field targetField = delegate.getClass().getDeclaredField("target");
				targetField.setAccessible(true);
				target = targetField.get(delegate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return target;
		}
		return delegate;
	}

	/* Ensures that all of the specified files that are non-null have been created as directories. */
	protected static void ensureDirectoriesInitialized(File ... directories) {
		for(File directory : directories) {
			if(directory != null) {
				if(!directory.isDirectory()) {
					if(directory.exists()) {
						if(!directory.delete()) {
							System.err.println("Failed to delete file: " + directory);
						}
						if(!directory.mkdirs()) {
							System.err.println("Failed to make directory: " + directory);
						}
					}
				}
			}
		}
	}
	/* Finds the lowest numbered filename starting with a prefix based off the classname for which a file in the specified
	 * directory does not already exist. Creates that file, sets the currentReportFile to the path to that file and sets
	 * testSetPrefix to be based off of that file's name. */
	protected void setReportFileInfo(String className) {
		testSetPrefix = className;
		className = (className == null) ? "" :  "-" + className;
		String reportFilePrefix = String.format("%s%s-", RivuletJUnitCoreProvider.isReruns ? "RERUN" : "RUN", className);
		int[] runNum = new int[1];
		this.currentReportFile = getLowestNumberedFile(reportFilePrefix, ".json", violationReportsDirectory, runNum);
		testSetPrefix += "-" + (runNum[0]);
	}
	/* Prints any violations that occurred and adds them to the report violation list. Returns the number of violations added. */
	protected synchronized int addTaintInfo(String className, String methodName) {
		LinkedHashMap<Violation, LinkedHashSet<TestRerunConfiguration>> violationMap = RivuletAutoTaintWrapper.getAndClearViolationConfigsMap();
		if(className == null || methodName == null) {
			return 0;
		}
		// Merge violations that are the same except for their sinkValues or indexInfos
		LinkedHashMap<Violation, LinkedList<Violation>> mergedViolationsMap = TaintedSinkValueSet.mergeViolations(violationMap.keySet());
		for(Violation mergedViolation : mergedViolationsMap.keySet()) {
			// Add test info to the violation
			String uniqueID = testSetPrefix + "-" + violationNumber.getAndIncrement();
			mergedViolation.setTestInfo(uniqueID, className, methodName);
			if(!RivuletJUnitCoreProvider.isReruns) {
				// Report the violation if it occurred in an original test run
				violationReport.reportViolation(mergedViolation);
			}
			if(!RivuletJUnitCoreProvider.disableViolationPrinting) {
				synchronized(target) {
					// Print the violation to standard out
					System.out.println(mergedViolation.toString(RivuletJUnitCoreProvider.isReruns, RivuletAutoTaintWrapper.getCurrentRerunConfig()));
				}
			}
			if(!RivuletJUnitCoreProvider.isReruns) {
				// Add the reruns for the merged violation
				for(Violation originalViolation : mergedViolationsMap.get(mergedViolation)) {
					for(TestRerunConfiguration config : violationMap.get(originalViolation)) {
						// Add test info based on the merge violation to the config
						config.setTestInfo(uniqueID, className, methodName);
						generatedRerunConfigs.add(config);
					}
				}
			}
		}
		return mergedViolationsMap.keySet().size();
	}
	/* Outputs a message about the result of the test rerun. Adds any critical violations that occurred during the rerun
	 * to the violation report. */
	protected synchronized void reportRerunResult(String testOutcomeMessage, String sourceName, String methodName, int numViolations) {
		String testName = ViolationReportingUtils.formatTestName(sourceName, methodName);
		String criticalViolationStatus;
		TestRerunConfiguration config = RivuletAutoTaintWrapper.getCurrentRerunConfig();
		if(numViolations > 0) {
			criticalViolationStatus = RerunResult.CRITICAL_VIOLATION.message;
			// Record that all of the violations associated with the current rerun configuration were verified
			RivuletJUnitCoreProvider.verifiedViolationIDs.addAll(config.getViolationUIDs());
			if(criticalReproductionDirectory != null) {
				// Create reproduction files for this critical violation
				writeCriticalViolationReproductionFiles(sourceName, methodName);
			}
		} else if(!config.requiredReplacementsSuccessful()) {
			criticalViolationStatus = RerunResult.REPLACEMENT_FAILURE.message;
		} else if(RivuletAutoTaintWrapper.checkAndClearReachedSink()) {
			criticalViolationStatus = RerunResult.SINK_REACHED.message;
		} else {
			criticalViolationStatus = RerunResult.FAILED_TO_REACH.message;
		}
		String info = ViolationReportingUtils.colorText("RIVULET-RERUN-INFO", ViolationReportingUtils.RivuletColor.INFO);
		info = ViolationReportingUtils.boldText(info);
		String outcomeMessage = String.format("[%s] %s Test outcome: %s - %s. Completed: %d/%d", info, criticalViolationStatus, testOutcomeMessage, testName, rerunProgress.incrementAndGetNumberOfRerunsCompleted(), rerunProgress.getNumRerunsTotal());
		if(!RivuletJUnitCoreProvider.disableViolationPrinting || numViolations > 0) {
			// Only print successes if not printing violation information
			synchronized(target) {
				System.out.println(outcomeMessage);
			}
		}
		// Send the rerun's result to the violation report
		if(sourceName != null && methodName != null) {
			violationReport.reportTestRerunResult(sourceName, methodName, criticalViolationStatus, testOutcomeMessage, config);
		}
	}

	/* Writes the current test rerun configuration to a file in the critical reproduction directory. */
	protected void writeCriticalViolationReproductionFiles(String className, String methodName) {
		// Make a directory within the critical reproduction directory for the current test class
		File testReproductionsDirectory = new File(criticalReproductionDirectory, className);
		testReproductionsDirectory.mkdirs();
		// Serialize the current rerun configuration
		List<TestRerunConfiguration> currentConfig = Collections.singletonList(RivuletAutoTaintWrapper.getCurrentRerunConfig());
		writeToAppendingObjectStream(testReproductionsDirectory, methodName + TestRerunDirector.RAW_CONFIG_SUFFIX, currentConfig);
		List<String> interceptedRequests = PhosphorHttpRequest.getAndClearInterceptedRequests();
		if(!interceptedRequests.isEmpty()) {
			// Write intercepted requests for the rerun to a file
			String prefix = "REQUESTS-" + methodName + "-";
			File requestsFile = getLowestNumberedFile(prefix, ".txt", testReproductionsDirectory, new int[1]);
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(requestsFile));
				for(String request : interceptedRequests) {
					writer.write(request);
					writer.newLine();
					writer.newLine();
					writer.newLine();
				}
				writer.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
			// Create a bash script for the requests
			String prefix2 = requestsFile.getName();
			prefix2 =  prefix2.substring(0, prefix2.length() - ".txt".length());
			String bashFileName = prefix2 + ".sh";
			File requestsBashFile = new File(requestsFile.getParent(), bashFileName);
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(requestsBashFile ));
				writer.write("#!/usr/bin/env bash\n\n");
				writeRequestsAsCurlCommands(testReproductionsDirectory, prefix2 + "-", interceptedRequests, writer);
				writer.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected static void writeRequestsAsCurlCommands(File directory, String prefix, Iterable<String> requests, Writer writer) {
		int i = 0;
		String uriPrefix = "http://localhost:8080";
		for(String request : requests) {
			try {
				StringBuilder builder = new StringBuilder("curl -b cookies.txt -c cookies.txt \\\n");
				String[] lines = request.split("\r\n");
				String[] requestLine = lines[0].split(" ");
				String method = requestLine[0];
				String uri = requestLine[1];
				// Write headers
				int j = 1;
				for(; j < lines.length; j++) {
					String line = lines[j];
					if(line.length() == 0) {
						j++;
						break;
					}
					if(!line.startsWith("Cookie")) {
						builder.append("\t -H \"").append(line).append("\" \\\n");
					}
				}
				// Write the body
				if(j < lines.length) {
					File postDataFile = getLowestNumberedFile(prefix, ".dat", directory, null);
					builder.append("\t --data-binary @")
							.append(postDataFile.getName())
							.append(" \\\n");
					BufferedWriter bodyWriter = new BufferedWriter(new FileWriter(postDataFile));
					try {
						for(; j < lines.length; j++) {
							bodyWriter.write(lines[j]);
							if(j < lines.length - 1) {
								bodyWriter.write("\r\n");
							}
						}
					} finally {
						bodyWriter.close();
					}
				}
				builder.append(String.format("\t-o response%d.txt \\\n", i++));
				if(uri.startsWith("http")) {
					builder.append(String.format("\t-X %s %s\n\n", method, uri));
				} else {
					builder.append(String.format("\t-X %s %s%s\n\n", method, uriPrefix, uri));
				}
				writer.write(builder.toString());
			} catch(Exception e) {
				System.err.println("Failed to write an intercepted request to a generated bash script.");
			}
		}
	}

	/* Writes the specified Object items to the specified file in the specified directory using an AppendingObjectOutputStream. */
	protected static synchronized void writeToAppendingObjectStream(File directory, String fileName, Object... items) {
		try {
			// Acquire a FileLock on the lock file used by instances of this class trying to write exclusively to the
			// specified directory.
			File lockFile = new File(directory, "ifc.lock");
			lockFile.createNewFile();
			RandomAccessFile raFile = new RandomAccessFile(lockFile, "rw");
			try {
				FileChannel channel = raFile.getChannel();
				try {
					FileLock lock = channel.lock();
					try {
						ObjectOutputStream stream = AppendingObjectOutputStream.newInstance(new File(directory, fileName));
						try {
							for(Object obj : items) {
								stream.writeObject(obj);
							}
						} finally {
							stream.close();
						}
					} finally {
						lock.release();
					}
				} finally {
					channel.close();
				}
			} finally {
				raFile.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/* Finds the lowest numbered filename starting with the specified prefix and suffix for which a file in the specified
	 * directory does not already exist. Creates that file and return the number assigned to the file created. */
	protected static synchronized File getLowestNumberedFile(String fileNamePrefix, String fileNameSuffix, File directory, int[] number) {
		try {
			File file;
			if(number == null || number.length < 1) {
				number = new int[1];
			}
			number[0] = -1;
			// Acquire a FileLock on the lock file used by instances of this class trying to write exclusively to the
			// specified directory.
			File lockFile = new File(directory, "ifc.lock");
			lockFile.createNewFile();
			RandomAccessFile raFile = new RandomAccessFile(lockFile, "rw");
			try {
				FileChannel channel = raFile.getChannel();
				try {
					FileLock lock = channel.lock();
					try {
						do {
							String fileName = String.format("%s%d%s", fileNamePrefix, ++number[0], fileNameSuffix);
							file = new File(directory, fileName);
						} while(file.exists());
						if(!file.createNewFile()) {
							System.err.println("Failed to create new file: " + file);
						}
					} finally {
						lock.release();
					}
				} finally {
					channel.close();
				}
			} finally {
				raFile.close();
			}
			return file;
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to create unique file in: " + directory);
		}
	}
}

