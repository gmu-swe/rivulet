package io.rivulet.internal.server;

import edu.columbia.cs.psl.phosphor.struct.PowerSetTree;
import io.rivulet.PhosphorHttpRequest;
import io.rivulet.fuzz.RerunProgress;
import io.rivulet.fuzz.RivuletJUnitCoreProvider;
import io.rivulet.fuzz.maven.surefire.junitcore.BaseTaintTrackingTestListener;
import io.rivulet.internal.RivuletAutoTaintWrapper;
import io.rivulet.internal.ViolationReport;

import static io.rivulet.fuzz.TestRerunDirector.RAW_CONFIG_SUFFIX;

public class ServerTaintTrackingTestListener extends BaseTaintTrackingTestListener {
	public ServerTaintTrackingTestListener(Object target, String rerunConfigsPath, String violationReportsPath, String criticalReproductionPath, RerunProgress rerunProgress) {
		super(target, rerunConfigsPath, violationReportsPath, criticalReproductionPath, rerunProgress);

		// Alert RivuletAutoTaintWrapper that JUnit tests are being run
		RivuletAutoTaintWrapper.setRunningJUnitTests(true);
	}

	public void testSetStarted(String className) {
		// Set information for the report file
		setReportFileInfo(className);
		// Clear the number of violations
		violationNumber.set(0);
		// Clear the violation report
		violationReport = new ViolationReport();
	}

	public void testSetEnded(String className) {
		PowerSetTree.getInstance().reset();
		if(currentReportFile == null) {
			// testSetCompleted was directly called by RivuletJUnitCoreProvider to ensure that information about
			// a skipped test was recorded
			setReportFileInfo("SKIPPED");
		}
		// Serialize the violation report and write it to a file
		violationReport.writeJsonToFile(currentReportFile);
		if(!RivuletJUnitCoreProvider.isReruns && !generatedRerunConfigs.isEmpty()) {
			// Serialize the rerun configurations
			writeToAppendingObjectStream(rerunConfigsDirectory, className + RAW_CONFIG_SUFFIX, generatedRerunConfigs);
			generatedRerunConfigs.clear();
		}

	}

	public void testStarted(String className, String methodName) {
// Clear the requests intercepted by PhosphorHttpRequest
		PhosphorHttpRequest.clearInterceptedRequests();
		// Clear all Taint instances' label sets before the new test starts
		PowerSetTree.getInstance().reset();
		// Reset RivuletAutoTaintWrapper
		RivuletAutoTaintWrapper.resetForNextTest();
		// Tell the violation report which test is going to be run
		if (className != null && methodName != null) {
			violationReport.reportTestWasRun(className, methodName);
		}
	}

	public int testError(String className, String methodName) {
		int numViolations = addTaintInfo(className, methodName);
		if (RivuletJUnitCoreProvider.isReruns) {
			reportRerunResult("Error", className, methodName, numViolations);
		}
		return numViolations;
	}

	public int testFailed(String className, String methodName) {
		int numViolations = addTaintInfo(className, methodName);
		if (RivuletJUnitCoreProvider.isReruns) {
			reportRerunResult("Failed", className, methodName, numViolations);
		}
		return numViolations;
	}

	public int testSucceeded(String className, String methodName) {
		int numViolations = addTaintInfo(className, methodName);
		if (RivuletJUnitCoreProvider.isReruns) {
			reportRerunResult("Succeeded", className, methodName, numViolations);
		}
//		addTaintInfo(className, methodName);//TODO is this a bug to call twice? This is how it already was when I found it - JB
		return numViolations;
	}
}
