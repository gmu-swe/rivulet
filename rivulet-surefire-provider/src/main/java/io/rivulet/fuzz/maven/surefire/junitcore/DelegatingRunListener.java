package io.rivulet.fuzz.maven.surefire.junitcore;

import org.apache.maven.plugin.surefire.log.api.ConsoleLogger;
import org.apache.maven.surefire.booter.ForkingRunListener;
import org.apache.maven.surefire.junitcore.TestSet;
import org.apache.maven.surefire.report.ConsoleOutputReceiver;
import org.apache.maven.surefire.report.ConsoleStream;
import org.apache.maven.surefire.report.ReportEntry;
import org.apache.maven.surefire.report.RunListener;
import org.apache.maven.surefire.report.TestSetReportEntry;

/* Run listener which passes all calls to a delegate. */
public class DelegatingRunListener implements RunListener, ConsoleLogger, ConsoleOutputReceiver, ConsoleStream {

    // Listener to which test reporting is delegated
    private final ForkingRunListener delegate;

    public DelegatingRunListener(ForkingRunListener delegate) {
        this.delegate = delegate;
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return delegate.equals(obj);
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    @Override
    public void writeTestOutput(byte[] buf, int off, int len, boolean stdout) {
        delegate.writeTestOutput(buf, off, len, stdout);
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

    @Override
    public void println(String message) {
        delegate.println(message);
    }

    @Override
    public void println(byte[] buf, int off, int len) {
        delegate.println(buf, off, len);
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
}
