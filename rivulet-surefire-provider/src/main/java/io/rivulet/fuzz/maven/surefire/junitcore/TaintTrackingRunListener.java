package io.rivulet.fuzz.maven.surefire.junitcore;

import edu.columbia.cs.psl.phosphor.struct.PowerSetTree;
import io.rivulet.PhosphorHttpRequest;
import io.rivulet.fuzz.RerunProgress;
import io.rivulet.fuzz.RivuletJUnitCoreProvider;
import io.rivulet.internal.RivuletAutoTaintWrapper;
import io.rivulet.internal.ViolationReport;
import io.rivulet.fuzz.TestRerunDirector;
import org.apache.maven.surefire.booter.ForkingRunListener;
import org.apache.maven.surefire.report.ReportEntry;
import org.apache.maven.surefire.report.TestSetReportEntry;

/* Test Run listener which record violation information before passing calls to a delegate. */
public class TaintTrackingRunListener extends DelegatingTaintTrackingRunListener {

	public TaintTrackingRunListener(ForkingRunListener delegate, String rerunConfigsPath, String violationReportsPath,
									String criticalReproductionPath, RerunProgress rerunProgress) {
		super(delegate, rerunConfigsPath, violationReportsPath, criticalReproductionPath, rerunProgress);

		// Alert RivuletAutoTaintWrapper that JUnit tests are being run
		RivuletAutoTaintWrapper.setRunningJUnitTests(true);
	}

	@Override
	public void testSetStarting(TestSetReportEntry report) {
		// Set information for the report file
		setReportFileInfo(report.getSourceName());
		// Clear the number of violations
		violationNumber.set(0);
		// Clear the violation report
		violationReport = new ViolationReport();
		super.testSetStarting(report);
	}

	@Override
	public void testStarting(ReportEntry report) {
		// Clear the requests intercepted by PhosphorHttpRequest
		PhosphorHttpRequest.clearInterceptedRequests();
		// Clear all Taint instances' label sets before the new test starts
		PowerSetTree.getInstance().reset();
		// Reset RivuletAutoTaintWrapper
		RivuletAutoTaintWrapper.resetForNextTest();
		// Tell the violation report which test is going to be run
		String className = report.getSourceName();
		String methodName = getMethodName(report);
		if(className != null && methodName != null) {
			violationReport.reportTestWasRun(className, methodName);
		}
		super.testStarting(report);
	}

	@Override
	public synchronized void testSetCompleted(TestSetReportEntry report) {
		// Clear all Taint instance's label sets before Serializing
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
			writeToAppendingObjectStream(rerunConfigsDirectory, report.getSourceName() + TestRerunDirector.RAW_CONFIG_SUFFIX, generatedRerunConfigs);
			generatedRerunConfigs.clear();
		}
		if(report != null) {
			super.testSetCompleted(report);
		}
	}

	@Override
	public void testSucceeded(ReportEntry report) {
		int numViolations = addTaintInfo(report.getSourceName(), getMethodName(report));
		if(RivuletJUnitCoreProvider.isReruns) {
			reportRerunResult("Succeeded", report.getSourceName(), getMethodName(report), numViolations);
		}
		super.testSucceeded(report);
	}

	@Override
	public void testAssumptionFailure(ReportEntry report) {

	}

	@Override
	public void testError(ReportEntry report) {
		int numViolations = addTaintInfo(report.getSourceName(), getMethodName(report));
		if(RivuletJUnitCoreProvider.isReruns) {
			reportRerunResult("Error", report.getSourceName(), getMethodName(report), numViolations);
		}
		if(RivuletJUnitCoreProvider.isReruns && !RivuletJUnitCoreProvider.reportRerunFailures) {
			super.testSucceeded(report);
		} else {
			super.testError(report);
		}
	}

	@Override
	public void testFailed(ReportEntry report) {
		int numViolations = addTaintInfo(report.getSourceName(), getMethodName(report));
		if(RivuletJUnitCoreProvider.isReruns) {
			reportRerunResult("Failed", report.getSourceName(), getMethodName(report), numViolations);
		}
		if(RivuletJUnitCoreProvider.isReruns && !RivuletJUnitCoreProvider.reportRerunFailures) {
			super.testSucceeded(report);
		} else {
			super.testFailed(report);
		}
	}

	/* Return the name of the method associated with the specified report. */
	private static String getMethodName(ReportEntry report) {
		String reportName = report.getName();
		if(reportName == null || !reportName.contains("(")) {
			return null;
		} else {
			return reportName.substring(0, reportName.indexOf('('));
		}
	}

	@Override
	public void testSkipped(ReportEntry report) {

	}

	@Override
	public void testExecutionSkippedByUser() {

	}
}
