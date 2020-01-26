package io.rivulet.fuzz.maven.surefire.junitcore;

import io.rivulet.fuzz.RerunProgress;
import org.apache.maven.plugin.surefire.log.api.ConsoleLogger;
import org.apache.maven.surefire.booter.ForkingRunListener;
import org.apache.maven.surefire.report.ConsoleOutputReceiver;
import org.apache.maven.surefire.report.ConsoleStream;
import org.apache.maven.surefire.report.ReportEntry;
import org.apache.maven.surefire.report.RunListener;
import org.apache.maven.surefire.report.StackTraceWriter;
import org.apache.maven.surefire.report.TestSetReportEntry;

public class DelegatingTaintTrackingRunListener extends BaseTaintTrackingTestListener implements RunListener, ConsoleLogger, ConsoleOutputReceiver, ConsoleStream {
	private final ForkingRunListener delegate;

	public DelegatingTaintTrackingRunListener(ForkingRunListener delegate, String rerunConfigsPath, String violationReportsPath, String criticalReproductionPath, RerunProgress rerunProgress) {
		super(delegate, rerunConfigsPath, violationReportsPath, criticalReproductionPath, rerunProgress);
		this.delegate = delegate;
	}

	@Override
	public void testSetStarting(TestSetReportEntry report) {
		delegate.testSetStarting(report);
	}

	@Override
	public void testSetCompleted(TestSetReportEntry report) {
		delegate.testSetCompleted(report);
	}

	@Override
	public void testStarting(ReportEntry report) {
		delegate.testStarting(report);
	}

	@Override
	public void testSucceeded(ReportEntry report) {
		delegate.testSucceeded(report);
	}

	@Override
	public void testAssumptionFailure(ReportEntry report) {
		delegate.testAssumptionFailure(report);
	}

	@Override
	public void testError(ReportEntry report) {
		delegate.testError(report);
	}

	@Override
	public void testFailed(ReportEntry report) {
		delegate.testFailed(report);
	}

	@Override
	public void testSkipped(ReportEntry report) {
		delegate.testSkipped(report);
	}

	@Override
	public void testExecutionSkippedByUser() {
		delegate.testExecutionSkippedByUser();
	}

	@Override
	public void writeTestOutput(byte[] buf, int off, int len, boolean stdout) {
		synchronized (target) {
			delegate.writeTestOutput(buf, off, len, stdout);
		}
	}

	public static byte[] createHeader(byte booterCode, int testSetChannel) {
		return ForkingRunListener.createHeader(booterCode, testSetChannel);
	}

	@Override
	public void debug(String message) {
		delegate.debug(message);
	}

	@Override
	public void info(String message) {
		delegate.info(message);
	}

	@Override
	public void warning(String message) {
		delegate.warning(message);
	}

	@Override
	public void error(String message) {
		delegate.error(message);
	}

	@Override
	public void error(String message, Throwable t) {
		delegate.error(message, t);
	}

	@Override
	public void error(Throwable t) {
		delegate.error(t);
	}

	public static void encode(StringBuilder stringBuilder, StackTraceWriter stackTraceWriter, boolean trimStackTraces) {
		ForkingRunListener.encode(stringBuilder, stackTraceWriter, trimStackTraces);
	}

	@Override
	public void println(String message) {
		delegate.println(message);
	}

	@Override
	public void println(byte[] buf, int off, int len) {
		delegate.println(buf, off, len);
	}
}
