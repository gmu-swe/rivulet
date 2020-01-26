package io.rivulet.maven;

import io.rivulet.internal.ViolationReport;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;

@Mojo(name = "report", defaultPhase = LifecyclePhase.VERIFY)
public class PhosphorReportingMojo extends AbstractMojo {

	@Parameter(readonly = true)
	private MavenProject project;

	@Parameter(readonly = true)
	private String violationReportDirPath;

	@Parameter(readonly = true)
	private String phosphorReportFile;

	@Override
	public void execute() throws MojoExecutionException {
		System.out.println("Building Phosphor violation report...");
		boolean rerunCriteriaFailed = false;
		try {
			// Build the final report up from the individual report files
			LinkedList<ViolationReport> reports = new LinkedList<>();
			Files.walkFileTree(Paths.get(violationReportDirPath), new ReportGatheringFileVisitor(reports));
			ViolationReport finalReport = new ViolationReport();
			for(ViolationReport report : reports) {
				finalReport.merge(report);
			}
			// Fill in information about the number of violations verified per sink
			finalReport.addVerifiedViolationsInformation();
			// Check that the expected number of reruns and critical violations criteria was met for each test and then
			// erase it
			rerunCriteriaFailed = finalReport.checkExpectedInfo();
			finalReport.clearExpectedInfo();
			// Serialize the report
			finalReport.writeJsonToFile(new File(phosphorReportFile));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Failed to build Phosphor violation report: " + phosphorReportFile);
		} finally {
			if(rerunCriteriaFailed) {
				throw new MojoExecutionException("Expected Rivulet rerun or critical violation criteria was not met.");
			}
		}
	}

	private static class ReportGatheringFileVisitor implements FileVisitor<Path> {

		LinkedList<ViolationReport> reports;
		public ReportGatheringFileVisitor(LinkedList<ViolationReport> reports) {
			this.reports = reports;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) {
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
			if(Files.isRegularFile(file) && file.toFile().getName().endsWith(".json")) {
				reports.add(ViolationReport.readJsonFromFile(file.toFile()));
			}
			return FileVisitResult.CONTINUE;
		}
	}
}
