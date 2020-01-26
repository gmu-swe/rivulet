package io.rivulet.fuzz;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import edu.columbia.cs.psl.phosphor.BasicSourceSinkManager;
import edu.columbia.cs.psl.phosphor.Configuration;
import edu.columbia.cs.psl.phosphor.Instrumenter;
import io.rivulet.FileGatheringVisitor;
import io.rivulet.RemoteTaintServerFacade;
import io.rivulet.ViolationReportingUtils;
import io.rivulet.fuzz.maven.surefire.junitcore.TaintTrackingRunListener;
import io.rivulet.fuzz.maven.surefire.junitcore.WrappingReporterFactory;
import io.rivulet.internal.RivuletAutoTaintWrapper;
import io.rivulet.internal.ViolationReport;
import io.rivulet.internal.fuzz.generator.RerunGeneratorWrapper;
import io.rivulet.internal.rerun.TestRerunConfiguration;
import org.apache.maven.surefire.booter.Command;
import org.apache.maven.surefire.booter.CommandListener;
import org.apache.maven.surefire.booter.CommandReader;
import org.apache.maven.surefire.common.junit4.JUnit4RunListener;
import org.apache.maven.surefire.common.junit4.JUnitTestFailureListener;
import org.apache.maven.surefire.common.junit4.Notifier;
import org.apache.maven.surefire.common.junit48.FilterFactory;
import org.apache.maven.surefire.common.junit48.JUnit48Reflector;
import org.apache.maven.surefire.common.junit48.JUnit48TestChecker;
import org.apache.maven.surefire.junitcore.ConcurrentRunListener;
import org.apache.maven.surefire.junitcore.JUnitCoreParameters;
import org.apache.maven.surefire.junitcore.JUnitCoreRunListener;
import org.apache.maven.surefire.junitcore.JUnitCoreWrapper;
import org.apache.maven.surefire.junitcore.NonConcurrentRunListener;
import org.apache.maven.surefire.junitcore.TestSet;
import org.apache.maven.surefire.providerapi.AbstractProvider;
import org.apache.maven.surefire.providerapi.ProviderParameters;
import org.apache.maven.surefire.report.ConsoleStream;
import org.apache.maven.surefire.report.ReporterFactory;
import org.apache.maven.surefire.suite.RunResult;
import org.apache.maven.surefire.testset.TestListResolver;
import org.apache.maven.surefire.testset.TestSetFailedException;
import org.apache.maven.surefire.util.RunOrderCalculator;
import org.apache.maven.surefire.util.ScanResult;
import org.apache.maven.surefire.util.ScannerFilter;
import org.apache.maven.surefire.util.TestsToRun;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.apache.maven.surefire.booter.CommandReader.getReader;
import static org.apache.maven.surefire.common.junit4.JUnit4ProviderUtil.generateFailingTests;
import static org.apache.maven.surefire.common.junit4.JUnit4Reflector.createDescription;
import static org.apache.maven.surefire.common.junit4.JUnit4RunListenerFactory.createCustomListeners;
import static org.apache.maven.surefire.common.junit4.Notifier.pureNotifier;
import static org.apache.maven.surefire.junitcore.ConcurrentRunListener.createInstance;
import static org.apache.maven.surefire.report.ConsoleOutputCapture.startCapture;
import static org.apache.maven.surefire.testset.TestListResolver.optionallyWildcardFilter;
import static org.apache.maven.surefire.util.TestsToRun.fromClass;

/**
 * Based heavily on the JUnit 4.7 Core Provider, original @author Kristian Rosenvold
 */
@SuppressWarnings("UnusedDeclaration")
public class RivuletJUnitCoreProvider extends AbstractProvider {

    private static final String UNDETERMINED_TESTS_DESCRIPTION = "Cannot determine test in forked JVM with surefire";
    private final ClassLoader testClassLoader;
    private final JUnitCoreParameters jUnitCoreParameters;
    private final ScannerFilter scannerFilter;
    private final String customRunListeners;
    private final ProviderParameters providerParameters;
    private final ScanResult scanResult;
    private final int rerunFailingTestsCount;
    private final JUnit48Reflector jUnit48Reflector;
    private final RunOrderCalculator runOrderCalculator;
    private final TestListResolver testResolver;
    private final CommandReader commandsReader;
    private TestsToRun testsToRun;
    private final String rerunConfigsPath;
    private final String violationReportsPath;
    // Path to the directory created for critical reproduction files or null if reproduction files should not be created
    private final String criticalReproductionPath;
    // If running reruns from a specific configuration file, the path to a file containing unprocessed reruns. Otherwise,
    // null.
    private final String rerunsFilePath;
    // Whether the test being run are Rivulet generated reruns
    public static boolean isReruns;
    // Whether test errors and failures for reruns should be reported.
    public static boolean reportRerunFailures;
    // Whether additional test reruns for a particular violation should stop being run when the violation has already been verified
    // by previous rerun
    private static boolean stopRerunsWhenVerified;
    // Whether violation information should be printed to standard out
    public static boolean disableViolationPrinting = false;
    // The last generator that was used to provide a set of sink methods. A null value indicates that Instrumenter.sinksFile
    // was used to provide sinks, i.e. the same sinks that were used for the original run were used.
    private static RerunGeneratorWrapper sinksProvider = null;
    // Set of IDs for violations that have been verified by a critical violation.
    public static final HashSet<String> verifiedViolationIDs = new HashSet<>();
    // Port to use for the remote server, if there is one
    private final int remoteTaintServerPort;

    public RivuletJUnitCoreProvider(ProviderParameters bootParams) {
        // Don't start a thread in CommandReader while we are in in-plugin process
        commandsReader = bootParams.isInsideFork() ? getReader().setShutdown(bootParams.getShutdown()) : null;
        providerParameters = bootParams;
        testClassLoader = bootParams.getTestClassLoader();
        scanResult = bootParams.getScanResult();
        runOrderCalculator = bootParams.getRunOrderCalculator();
        jUnitCoreParameters = new JUnitCoreParameters(bootParams.getProviderProperties());
        scannerFilter = new JUnit48TestChecker(testClassLoader);
        testResolver = bootParams.getTestRequest().getTestListResolver();
        rerunFailingTestsCount = bootParams.getTestRequest().getRerunFailingTestsCount();
        customRunListeners = bootParams.getProviderProperties().get("listener");
        jUnit48Reflector = new JUnit48Reflector(testClassLoader);
        rerunConfigsPath = bootParams.getProviderProperties().get("rerunConfigsPath");
        violationReportsPath = bootParams.getProviderProperties().get("violationReportsPath");
        criticalReproductionPath = bootParams.getProviderProperties().get("criticalReproductionPath");
        rerunsFilePath = bootParams.getProviderProperties().get("rerunsFilePath");
        isReruns = bootParams.getProviderProperties().get("isReruns") != null;
        reportRerunFailures = bootParams.getProviderProperties().get("reportRerunFailures") != null;
        stopRerunsWhenVerified = bootParams.getProviderProperties().get("stopRerunsWhenVerified") != null;
        disableViolationPrinting = bootParams.getProviderProperties().get("disableViolationPrinting") != null;
        String remoteTaintServerPortStr = bootParams.getProviderProperties().get("ifc.port");
        remoteTaintServerPort = (remoteTaintServerPortStr == null) ? -1 : Integer.parseInt(remoteTaintServerPortStr);
    }

    public Iterable<Class<?>> getSuites() {
        if(isReruns) {
            TestRerunDirector director;
            if(rerunsFilePath != null) {
                director = new TestRerunDirector(Collections.singletonList(new File(rerunsFilePath)));
            } else {
                director = new TestRerunDirector(rerunConfigsPath);
            }
            List<Class<?>> ret = director.prepareConfigs(scanClassPath());
            if(providerParameters.isInsideFork() || providerParameters.getProviderProperties().get("reuseForks").equals("false")) {
                // If we are inside of the same process that will run the tests, OR if we are not reusing JVMs, then we should return the reruns
                return ret;
            } else {
                LinkedList<Class<?>> filtered = new LinkedList<>();
                HashSet<Class> added = new HashSet<>();
                for(Class c : ret)
                    if(added.add(c))
                        filtered.add(c);
                return filtered; //else, return each test only once
            }
        } else {
            return scanClassPath();
        }
    }

    private boolean isSingleThreaded() {
        return jUnitCoreParameters.isNoThreading();
    }

    /* Configures various components of Rivulet and Phosphor based on the specified rerun configuration in preparation for a
     * rerun. */
    private void setUpPhosphorForConfig(TestRerunConfiguration config) {
        config.resetReplacements(); // mark the config's replacements as unsuccessful
        if (RivuletAutoTaintWrapper.remoteTaintServerFacade != null) {
            RivuletAutoTaintWrapper.remoteTaintServerFacade.setCurrentRerunConfigAndAutotainters(config);
        } else {
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

    /* Reads a list of TestRerunConfigurations and a set of IDs for the original test violations that have been
     * verified from the specified file. Adds the strings in the set of IDs for the original test violations to
     * verifiedViolationIDs. Returns the list of TestRerunConfigurations read from the file or null if an exception
     * was thrown. */
    @SuppressWarnings("unchecked")
    private LinkedList<TestRerunConfiguration> readConfigsFile(File configsFile, RerunProgress rerunProgress) {
        try {
            ObjectInputStream stream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(configsFile)));
            rerunProgress.setNumRerunsTotal(stream.readInt());
            LinkedList<TestRerunConfiguration> rerunConfigs = (LinkedList<TestRerunConfiguration>) stream.readObject();
            verifiedViolationIDs.addAll((HashSet<String>) stream.readObject());
            stream.close();
            rerunProgress.setNumRerunsCompleted(rerunProgress.getNumRerunsTotal() - rerunProgress.getNumberOfRerunsRemaining(rerunConfigs));
            return rerunConfigs;
        } catch(Exception ex) {
            ex.printStackTrace();
            System.err.println("Failed to read rerun configurations from: " + configsFile);
            return null;
        }
    }

    /* Writes the specified list and verifiedViolationIDs to the specified file. */
    private void writeConfigsFile(File configsFile, LinkedList<TestRerunConfiguration> rerunConfigs, RerunProgress rerunProgress) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(configsFile)));
            stream.writeInt(rerunProgress.getNumRerunsTotal());
            stream.writeObject(rerunConfigs);
            stream.writeObject(verifiedViolationIDs);
            stream.close();
        } catch(IOException e) {
            e.printStackTrace();
            System.err.println("Failed to write rerun configurations to: " + configsFile);
        }
    }

    private void printSkipped(int numSkipped, RerunProgress rerunProgress) {
        if(numSkipped > 0) {
            String info = ViolationReportingUtils.colorText("RIVULET-RERUN-INFO", ViolationReportingUtils.RivuletColor.INFO);
            info = ViolationReportingUtils.boldText(info);
            int start = rerunProgress.getNumRerunsCompleted() + 1;
            int end = start + numSkipped - 1;
            System.out.printf("[%s] Skipped %d reruns (#%d-#%d) out of %d reruns.\n", info, numSkipped, start, end, rerunProgress.getNumRerunsTotal());
            rerunProgress.setNumRerunsCompleted(end);
        }
    }

    /* Returns whether the rerun for the specified TestRerunConfiguration should be skipped because stopRerunsWhenVerified
     * is true and all of the violations that could be verified by the specified TestRerunConfiguration has already been
     * verified. */
    private boolean shouldSkip(TestRerunConfiguration rerunConfiguration) {
        return stopRerunsWhenVerified && verifiedViolationIDs.containsAll(rerunConfiguration.getViolationUIDs());
    }

    /* Pops configurations from the specified map's list values until the top configuration is not skipped or the list is
     * empty. Notifies ViolationReport about the removed configurations. Returns whether any configurations were removed. */
    private void skipConfigs(LinkedList<TestRerunConfiguration> rerunConfigs, RerunProgress rerunProgress) {
        int numSkipped = 0;
        if(stopRerunsWhenVerified) {
            while(!rerunConfigs.isEmpty() && shouldSkip(rerunConfigs.peek())) {
                ViolationReport.reportSkippedRerun(rerunConfigs.poll());
                numSkipped++;
            }
        }
        printSkipped(numSkipped, rerunProgress);
    }

    /* Checks if the specified the rerun for the specified TestRerunConfiguration should be skipped. If it should, skips
     * the rerun and notifies ViolationReport that it was skipped. Otherwise, runs the rerun. Returns whether the rerun
     * was run. */
    private boolean executeRerun(TestRerunConfiguration config, JUnitCoreWrapper core, RerunProgress rerunProgress) throws TestSetFailedException {
        if(shouldSkip(config)) {
            ViolationReport.reportSkippedRerun(config);
            printSkipped(1, rerunProgress);
            return false;
        } else {
            setUpPhosphorForConfig(config);
            Filter filter = new Filter() {
                @Override
                public boolean shouldRun(Description desc) {
                    // Filter to just the test method specified in the rerun configuration
                    if(desc.getMethodName() == null && (config.getTestClass().equals(desc.getClassName())
                            || desc.getClassName() == null || desc.getClassName().startsWith("["))) {
                        return true;
                    }
                    return config.matchesTestInfo(desc.getClassName(), desc.getMethodName());
                }

                @Override
                public String describe() {
                    return null;
                }
            };
            core.execute(testsToRun, createCustomListeners(customRunListeners), filter);
            return true;
        }
    }

    /* Executes the specified group of reruns from the same test class. */
    private boolean executeReruns(LinkedList<TestRerunConfiguration> batch, JUnitCoreWrapper core, RerunProgress rerunProgress, Notifier notifier) throws TestSetFailedException {
        skipConfigs(batch, rerunProgress);
        if(batch.isEmpty()) {
            return false;
        }
        String targetTestClass = batch.peek().getTestClass();
        HashMap<String, TestRerunConfiguration> methodConfigMap = createMethodConfigMap(batch);
        Filter filter = createFilterForConfigs(methodConfigMap, targetTestClass);
        RunListener phosphorFuzzerUpdater = new RunListener() {
            @Override
            public void testStarted(Description desc) {
                if(desc.getMethodName() != null) {
                    TestRerunConfiguration config = methodConfigMap.get(desc.getMethodName());
                    if(!config.matchesTestInfo(desc.getClassName(), desc.getMethodName())) {
                        throw new IllegalStateException(String.format("Out of sync! Popped %s#%s but just started %s#%s",
                                config.getTestMethod(), config.getTestClass(), desc.getMethodName(), desc.getTestClass()));
                    } else {
                        setUpPhosphorForConfig(config);
                    }
                }
            }
        };
        LinkedList<RunListener> listeners = new LinkedList<>(createCustomListeners(customRunListeners));
        listeners.add(phosphorFuzzerUpdater);
        core.execute(testsToRun, listeners, filter);
        notifier.removeListener(phosphorFuzzerUpdater);
        return true;
    }

    private static Description createTestsDescription(Iterable<Class<?>> classes ) {
        // "null" string rather than null; otherwise NPE in junit:4.0
        Description description = createDescription("null");
        for(Class<?> clazz : classes) {
            description.addChild(createDescription(clazz.getName()));
        }
        return description;
    }

    public RunResult invoke(Object forkTestSet) throws TestSetFailedException {
        final RerunProgress rerunProgress = new RerunProgress();
        if (remoteTaintServerPort > 0) {
            try {
                RivuletAutoTaintWrapper.remoteTaintServerFacade = new RemoteTaintServerFacade(remoteTaintServerPort);
                RivuletAutoTaintWrapper.remoteTaintServerFacade.setReruns(isReruns);
            } catch (IOException e) {
                e.printStackTrace();
                throw new IllegalStateException("Unable to connect to remote server");
            }
        }
        try {
            final ReporterFactory reporterFactory = new WrappingReporterFactory(providerParameters.getReporterFactory(),
                    rerunConfigsPath, violationReportsPath, criticalReproductionPath, rerunProgress, RivuletAutoTaintWrapper.remoteTaintServerFacade);
            final ConsoleStream consoleStream = providerParameters.getConsoleLogger();
            Filter filter = jUnit48Reflector.isJUnit48Available() ? createJUnit48Filter() : null;
            Notifier notifier = new Notifier(createRunListener(reporterFactory, consoleStream), getSkipAfterFailureCount());
            // startCapture() called in createRunListener() in prior to setTestsToRun()
            if (testsToRun == null) {
                if (isReruns) {
                    setTestsToRun(forkTestSet == null ? getSuites() : forkTestSet);
                } else {
                    setTestsToRun(forkTestSet);
                }
            }
            // Add test failure listener
            JUnitTestFailureListener testFailureListener = new JUnitTestFailureListener();
            notifier.addListener(testFailureListener);
            if (isFailFast() && commandsReader != null) {
                registerPleaseStopJUnitListener(notifier);
            }
            if (testsToRun != null) {
                notifier.fireTestRunStarted(testsToRun.allowEagerReading()
                        ? createTestsDescription(testsToRun)
                        : createDescription(UNDETERMINED_TESTS_DESCRIPTION));
            } else if (forkTestSet instanceof TestsToRun) {
                notifier.fireTestRunStarted(((TestsToRun) forkTestSet).allowEagerReading()
                        ? createTestsDescription((TestsToRun) forkTestSet)
                        : createDescription(UNDETERMINED_TESTS_DESCRIPTION));
            }

            if (commandsReader != null) {
                registerShutdownListener(testsToRun);
                commandsReader.awaitStarted();
            }

            final RunResult runResult;
            try {
                JUnitCoreWrapper core = new JUnitCoreWrapper(notifier, jUnitCoreParameters, consoleStream);
                if (commandsReader != null) {
                    registerShutdownListener(testsToRun);
                    commandsReader.awaitStarted();
                }
                if (isReruns) {
                    // Rivulet-generated rerun in a forked JVM
                    boolean executedLastTest = false;
                    if (forkTestSet instanceof Class) {
                        File configsFile = getConfigsFile((Class) forkTestSet);
                        if (!configsFile.exists()) {
                            return RunResult.noTestsRun();
                        }
                        LinkedList<TestRerunConfiguration> rerunConfigs = readConfigsFile(configsFile, rerunProgress);
                        skipConfigs(rerunConfigs, rerunProgress);
                        if (rerunConfigs != null && !rerunConfigs.isEmpty()) {
                            notifier.asFailFast(isFailFast());
//                            executedLastTest = executeRerun(rerunConfigs.poll(), core, rerunProgress);
                            LinkedList<TestRerunConfiguration> batch = new LinkedList<>();
                            HashSet<String> testMethodsThisBatch = new HashSet<>();
                            if (rerunConfigs != null) {
                                while (!rerunConfigs.isEmpty()) {
                                    //Try to batch configurations
                                    skipConfigs(rerunConfigs, rerunProgress);
                                    if (!rerunConfigs.isEmpty()) {
                                        TestRerunConfiguration rerunConfiguration = rerunConfigs.poll();
                                        if (!testMethodsThisBatch.add(rerunConfiguration.getTestMethod())) {
                                            executedLastTest = executeReruns(batch, core, rerunProgress, notifier);
                                            testMethodsThisBatch.clear();
                                            batch.clear();
                                            testMethodsThisBatch.add(rerunConfiguration.getTestMethod());
                                        }
                                        batch.add(rerunConfiguration);
                                    }
                                }
                            }
                            if(!batch.isEmpty()){
                                executedLastTest = executeReruns(batch, core, rerunProgress, notifier);
                                testMethodsThisBatch.clear();
                                batch.clear();
                            }
                            writeConfigsFile(configsFile, rerunConfigs, rerunProgress);
                        } else {
                            // Try to delete the file when it has been emptied
                            if (!configsFile.delete()) {
                                writeConfigsFile(configsFile, rerunConfigs, rerunProgress);
                            }
                        }
                    } else if (forkTestSet instanceof TestsToRun) {
                        TestsToRun ttr = (TestsToRun) forkTestSet;
                        for (Class c : ttr) {
                            setTestsToRun(Collections.singleton(c));
                            File configsFile = getConfigsFile(c);
                            if (!configsFile.exists()) {
                                return RunResult.noTestsRun();
                            }
                            LinkedList<TestRerunConfiguration> rerunConfigs = readConfigsFile(configsFile, rerunProgress);
                            if (rerunConfigs != null) {
                                while (!rerunConfigs.isEmpty()) {
                                    skipConfigs(rerunConfigs, rerunProgress);
                                    if (!rerunConfigs.isEmpty()) {
                                        TestRerunConfiguration rerunConfiguration = rerunConfigs.poll();
                                        executedLastTest = executeRerun(rerunConfiguration, core, rerunProgress);
                                    }
                                }
                            }
                        }
                    } else {
                        try {
                            Iterable<File> configFiles;
                            if (rerunsFilePath == null) {
                                configFiles = FileGatheringVisitor.getSortedFiles(rerunConfigsPath, TestRerunDirector.PROCESSED_CONFIG_SUFFIX);
                            } else {
                                configFiles = Collections.singletonList(getConfigsFile(null));
                            }
                            for (File configFile : configFiles) {
                                LinkedList<TestRerunConfiguration> rerunConfigs = readConfigsFile(configFile, rerunProgress);
                                LinkedList<TestRerunConfiguration> batch = new LinkedList<>();
                                HashSet<String> testMethodsThisBatch = new HashSet<>();
                                if (rerunConfigs != null) {
                                    while (!rerunConfigs.isEmpty()) {
                                        //Try to batch configurations
                                        skipConfigs(rerunConfigs, rerunProgress);
                                        if (!rerunConfigs.isEmpty()) {
                                            TestRerunConfiguration rerunConfiguration = rerunConfigs.poll();
                                            if (!testMethodsThisBatch.add(rerunConfiguration.getTestMethod())) {
                                                executedLastTest = executeReruns(batch, core, rerunProgress, notifier);
                                                testMethodsThisBatch.clear();
                                                batch.clear();
                                                testMethodsThisBatch.add(rerunConfiguration.getTestMethod());
                                            }
                                            batch.add(rerunConfiguration);
                                        }
                                    }
                                }
                                if(!batch.isEmpty()){
                                    executedLastTest = executeReruns(batch, core, rerunProgress, notifier);
                                    testMethodsThisBatch.clear();
                                    batch.clear();
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.err.println("Failed to get rerun configuration files from: " + rerunConfigsPath);
                        }
                    }
                    if (!executedLastTest && ViolationReport.RECORD_SKIPPED_RERUNS) {
                        // Last rerun was skipped, ensure that the skipped rerun is serialized
                        org.apache.maven.surefire.report.RunListener listener = reporterFactory.createReporter();
                        if (!(listener instanceof TaintTrackingRunListener)) {
                            throw new RuntimeException("RunListener should be of type TaintTrackingRunListener");
                        }
                        listener.testSetCompleted(null);
                        return RunResult.noTestsRun();
                    }
                } else {
                    // Original test run
                    notifier.asFailFast(isFailFast());
                    core.execute(testsToRun, createCustomListeners(customRunListeners), filter);
                    notifier.asFailFast(false);
                    rerunFailingTests(notifier, consoleStream, testFailureListener);
                }
            } finally {
                runResult = reporterFactory.close();
                notifier.removeListeners();
            }
            return runResult;
        } finally {
            if (RivuletAutoTaintWrapper.remoteTaintServerFacade != null) {
                try {
                    RivuletAutoTaintWrapper.remoteTaintServerFacade.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* Checks that the specified configurations are all from the same class and all have different test methods. Returns
     * a map from test method names to a configuration that tests the method. */
    private HashMap<String, TestRerunConfiguration> createMethodConfigMap(Iterable<TestRerunConfiguration> configs) {
        HashMap<String, TestRerunConfiguration> map = new HashMap<>();
        String targetClassName = null;
        for(TestRerunConfiguration config : configs) {
            if(targetClassName == null) {
                targetClassName = config.getTestClass();
            }
            if(!config.getTestClass().equals(targetClassName)) {
                throw new IllegalStateException(String.format("Cannot batch reruns from different classes: %s & %s", targetClassName, config.getTestClass()));
            } else if(map.containsKey(config.getTestMethod())) {
                throw new IllegalStateException(String.format("Duplicate rerun in batch: %s", config.getTestMethod()));
            } else {
                map.put(config.getTestMethod(), config);
            }
        }
        return map;
    }

    /* Returns a filter which only reruns tests from the specified class for which there is a configuration in the specified map. */
    private Filter createFilterForConfigs(HashMap<String, TestRerunConfiguration> methodConfigMap, String targetTestClass) {
        return new Filter() {
            @Override
            public boolean shouldRun(Description desc) {
                if(desc.getMethodName() == null && (targetTestClass.equals(desc.getClassName()) || desc.getClassName() == null ||
                        desc.getClassName().startsWith("["))) {
                    return true;
                } else {
                    return targetTestClass.equals(desc.getClassName()) && methodConfigMap.containsKey(desc.getMethodName());
                }
            }

            @Override
            public String describe() {
                return null;
            }
        };
    }

    /* Returns the rerun configurations file for the specified class. */
    private File getConfigsFile(Class clazz) {
        if(rerunsFilePath != null) {
            String path = rerunsFilePath;
            if(path.endsWith(TestRerunDirector.RAW_CONFIG_SUFFIX)) {
                path = path.substring(0, path.length() - TestRerunDirector.RAW_CONFIG_SUFFIX.length());
            }
            path += TestRerunDirector.PROCESSED_CONFIG_SUFFIX;
            return new File(path);
        } else {
            return new File(rerunConfigsPath, clazz.getName() + TestRerunDirector.PROCESSED_CONFIG_SUFFIX);
        }
    }

    /* Reruns failing tests if rerunFailingTestsCount is larger than 0. */
    private void rerunFailingTests(Notifier notifier, final ConsoleStream consoleStream, JUnitTestFailureListener testFailureListener) throws TestSetFailedException {
        if(isRerunFailingTests()) {
            Notifier rerunNotifier = pureNotifier();
            notifier.copyListenersTo(rerunNotifier);
            JUnitCoreWrapper rerunCore = new JUnitCoreWrapper(rerunNotifier, jUnitCoreParameters, consoleStream);
            for(int i = 0; i < rerunFailingTestsCount && !testFailureListener.getAllFailures().isEmpty(); i++) {
                List<Failure> failures = testFailureListener.getAllFailures();
                Map<Class<?>, Set<String>> failingTests = generateFailingTests(failures, testClassLoader);
                testFailureListener.reset();
                FilterFactory filterFactory = new FilterFactory(testClassLoader);
                Filter failingMethodsFilter = filterFactory.createFailingMethodFilter(failingTests);
                rerunCore.execute(testsToRun, failingMethodsFilter);
            }
        }
    }

    private void setTestsToRun(Object forkTestSet) throws TestSetFailedException {
        if(forkTestSet instanceof TestsToRun) {
            testsToRun = (TestsToRun) forkTestSet;
        } else if(forkTestSet instanceof Class) {
            Class<?> theClass = (Class<?>) forkTestSet;
            testsToRun = fromClass(theClass);
        } else {
            testsToRun = scanClassPath();
        }
    }

    private boolean isRerunFailingTests() {
        return rerunFailingTestsCount > 0;
    }

    private boolean isFailFast() {
        return providerParameters.getSkipAfterFailureCount() > 0;
    }

    private int getSkipAfterFailureCount() {
        return isFailFast() ? providerParameters.getSkipAfterFailureCount() : 0;
    }

    private void registerShutdownListener(final TestsToRun testsToRun) {
        commandsReader.addShutdownListener(new CommandListener() {
            public void update(Command command) {
                testsToRun.markTestSetFinished();
            }
        });
    }

    private void registerPleaseStopJUnitListener(final Notifier stoppable) {
        commandsReader.addSkipNextTestsListener(new CommandListener() {
            public void update(Command command) {
                stoppable.pleaseStop();
            }
        });
    }

    private JUnit4RunListener createRunListener(ReporterFactory reporterFactory, ConsoleStream consoleStream) throws TestSetFailedException {
        if(isSingleThreaded()) {
            NonConcurrentRunListener rm = new NonConcurrentRunListener(reporterFactory.createReporter());
            startCapture(rm);
            return rm;
        } else {
            final Map<String, TestSet> testSetMap = new ConcurrentHashMap<String, TestSet>();
            ConcurrentRunListener listener = createInstance(testSetMap, reporterFactory, isParallelTypes(),
                    isParallelMethodsAndTypes(), consoleStream);
            startCapture(listener);
            return new JUnitCoreRunListener(listener, testSetMap);
        }
    }

    private boolean isParallelMethodsAndTypes() {
        return jUnitCoreParameters.isParallelMethods() && isParallelTypes();
    }

    private boolean isParallelTypes() {
        return jUnitCoreParameters.isParallelClasses() || jUnitCoreParameters.isParallelSuites();
    }

    private Filter createJUnit48Filter() {
        final FilterFactory factory = new FilterFactory(testClassLoader);
        Map<String, String> props = providerParameters.getProviderProperties();
        Filter groupFilter = factory.canCreateGroupFilter(props) ? factory.createGroupFilter(props) : null;
        TestListResolver methodFilter = optionallyWildcardFilter(testResolver);
        boolean onlyGroups = methodFilter.isEmpty() || methodFilter.isWildcard();
        if(onlyGroups) {
            return groupFilter;
        } else {
            Filter jUnitMethodFilter = factory.createMethodFilter(methodFilter);
            return groupFilter == null ? jUnitMethodFilter : factory.and(groupFilter, jUnitMethodFilter);
        }
    }

    private TestsToRun scanClassPath() {
        TestsToRun scanned = scanResult.applyFilter(scannerFilter, testClassLoader);
        return runOrderCalculator.orderTestClasses(scanned);
    }
}
