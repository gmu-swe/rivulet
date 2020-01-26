package io.rivulet.fuzz.maven.surefire.junitcore;

import io.rivulet.RemoteTaintServerFacade;
import io.rivulet.fuzz.RerunProgress;
import org.apache.maven.surefire.booter.ForkingRunListener;
import org.apache.maven.surefire.report.ReporterFactory;
import org.apache.maven.surefire.report.RunListener;
import org.apache.maven.surefire.suite.RunResult;

public class WrappingReporterFactory implements ReporterFactory {
	private final ReporterFactory delegate;
	private final String rerunConfigsPath;
	private final String violationReportsPath;
	private final String criticalReproductionPath;
	private final RerunProgress rerunProgress;
	private final RemoteTaintServerFacade remoteTaintServerFacade;

	public WrappingReporterFactory(ReporterFactory delegate, String rerunConfigsPath, String violationReportsPath,
								   String criticalReproductionPath,  RerunProgress rerunProgress, RemoteTaintServerFacade remoteTaintServerFacade) {
		this.delegate = delegate;
		this.rerunConfigsPath = rerunConfigsPath;
		this.violationReportsPath = violationReportsPath;
		this.criticalReproductionPath = criticalReproductionPath;
		this.rerunProgress = rerunProgress;
		this.remoteTaintServerFacade = remoteTaintServerFacade;
	}

	public RunListener createReporter() {
		RunListener ret = delegate.createReporter();

		if(remoteTaintServerFacade == null)
			ret = new TaintTrackingRunListener((ForkingRunListener) ret, rerunConfigsPath, violationReportsPath, criticalReproductionPath, rerunProgress);
		else
			ret = new RemoteServerTaintTrackingRunListener((ForkingRunListener) ret, rerunConfigsPath, violationReportsPath, criticalReproductionPath, rerunProgress, remoteTaintServerFacade);
		return ret;
	}

	public RunResult close() {
		return delegate.close();
	}
}
