package io.rivulet.fuzz.maven.surefire.junitcore;

import edu.columbia.cs.psl.phosphor.struct.PowerSetTree;
import io.rivulet.RemoteTaintServerFacade;
import io.rivulet.fuzz.RerunProgress;
import io.rivulet.fuzz.RivuletJUnitCoreProvider;
import io.rivulet.internal.RivuletAutoTaintWrapper;
import org.apache.maven.surefire.booter.ForkingRunListener;
import org.apache.maven.surefire.report.ReportEntry;
import org.apache.maven.surefire.report.RunListener;
import org.apache.maven.surefire.report.TestSetReportEntry;

import java.lang.reflect.Field;

/* Test Run listener which record violation information before passing calls to a delegate. */
public class RemoteServerTaintTrackingRunListener extends DelegatingTaintTrackingRunListener {

	// Used to interface with the remote taint server
	private final RemoteTaintServerFacade remoteTaintServerFacade;
	// Used to preserve thread safety of the output stream
	private final Object target;
	// For keeping track of how many have ben done
	private final RerunProgress rerunProgress;

	public RemoteServerTaintTrackingRunListener(ForkingRunListener delegate, String rerunConfigsPath, String violationReportsPath,
	                                            String criticalReproductionPath,
	                                            RerunProgress rerunProgress, RemoteTaintServerFacade remoteTaintServerFacade) {
		super(delegate, rerunConfigsPath, violationReportsPath, criticalReproductionPath, rerunProgress);
		this.rerunProgress = rerunProgress;
		this.target = getStreamSynchronizationTarget(delegate);
		this.remoteTaintServerFacade = remoteTaintServerFacade;
		// Alert RivuletAutoTaintWrapper that JUnit tests are being run
		RivuletAutoTaintWrapper.setRunningJUnitTests(true);
		remoteTaintServerFacade.initListener(rerunConfigsPath, violationReportsPath, criticalReproductionPath);
	}

	/* Returns the private output stream used by the specified delegate for synchronization. */
	private static Object getStreamSynchronizationTarget(RunListener delegate) {
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

	/* Return the name of the method associated with the specified report. */
	private static String getMethodName(ReportEntry report) {
		String reportName = report.getName();
		if (reportName == null || !reportName.contains("(")) {
			return null;
		} else {
			return reportName.substring(0, reportName.indexOf('('));
		}
	}

	@Override
	public void testSetStarting(TestSetReportEntry report) {
		remoteTaintServerFacade.testSetStarting(report.getSourceName());
		super.testSetStarting(report);
	}

	@Override
	public void testStarting(ReportEntry report) {
		// Clear all Taint instances' label sets before the new test starts
		PowerSetTree.getInstance().reset();
		// Reset RivuletAutoTaintWrapper
		RivuletAutoTaintWrapper.resetForNextTest();
		String className = report.getSourceName();
		String methodName = getMethodName(report);
		remoteTaintServerFacade.testStarting(className, methodName);
		super.testStarting(report);
	}

	@Override
	public synchronized void testSetCompleted(TestSetReportEntry report) {
		// Clear all Taint instance's label sets before Serializing
		PowerSetTree.getInstance().reset();
		remoteTaintServerFacade.testSetCompleted(report.getSourceName());
		if (report != null) {
			super.testSetCompleted(report);
		}
	}

	@Override
	public void testSucceeded(ReportEntry report) {
		int numViolations = remoteTaintServerFacade.testSucceeded(report.getSourceName(), getMethodName(report));
		if(RivuletJUnitCoreProvider.isReruns) {
			reportRerunResult("Succeeded", report.getSourceName(), getMethodName(report), numViolations);
		}
		super.testSucceeded(report);
	}

	@Override
	public void testError(ReportEntry report) {
		int numViolations = remoteTaintServerFacade.testError(report.getSourceName(), getMethodName(report));
		if(RivuletJUnitCoreProvider.isReruns) {
			reportRerunResult("Error", report.getSourceName(), getMethodName(report), numViolations);
		}
		if (RivuletJUnitCoreProvider.isReruns && !RivuletJUnitCoreProvider.reportRerunFailures) {
			super.testSucceeded(report);
		} else {
			super.testError(report);
		}
	}

	@Override
	public void testFailed(ReportEntry report) {
		int numViolations = remoteTaintServerFacade.testFailed(report.getSourceName(), getMethodName(report));
		if(RivuletJUnitCoreProvider.isReruns) {
			reportRerunResult("Failed", report.getSourceName(), getMethodName(report), numViolations);
		}
		if (RivuletJUnitCoreProvider.isReruns && !RivuletJUnitCoreProvider.reportRerunFailures) {
			super.testSucceeded(report);
		} else {
			super.testFailed(report);
		}
	}
}
