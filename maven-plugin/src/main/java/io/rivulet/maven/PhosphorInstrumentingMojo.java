package io.rivulet.maven;

import edu.columbia.cs.psl.phosphor.Configuration;
import edu.columbia.cs.psl.phosphor.Instrumenter;
import edu.columbia.cs.psl.phosphor.instrumenter.TaintTrackingClassVisitor;
import io.rivulet.internal.RivuletCV;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

@Mojo(name = "instrument", defaultPhase = LifecyclePhase.VERIFY)
public class PhosphorInstrumentingMojo extends AbstractMojo {

	@Parameter(readonly = true)
	private String jvm;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		//also make sure the sources, sinks etc files get copied to target/
		generateInstrumentedJVM();
	}

	void generateInstrumentedJVM() {
		if(jvm != null) {
			String baseJVM = System.getenv("INST_HOME");
			if(baseJVM == null) {
				baseJVM = System.getenv("JAVA_HOME");
			}
			File jvmDir = new File(jvm);
			if(!jvmDir.exists()) {
				System.out.println("Generating instrumented JVM...");
				Configuration.IMPLICIT_LIGHT_TRACKING = false;
				Configuration.IMPLICIT_TRACKING = false;
				Configuration.MULTI_TAINTING = true;
				Configuration.ARRAY_INDEX_TRACKING = true;
				Configuration.PRIOR_CLASS_VISITOR = RivuletCV.class;
				Configuration.init();
				TaintTrackingClassVisitor.IS_RUNTIME_INST = false;
				Instrumenter.ANALYZE_ONLY = true;
				Instrumenter._main(new String[]{baseJVM, jvm});
				Instrumenter.ANALYZE_ONLY = false;
				Instrumenter._main(new String[]{baseJVM,jvm});

				try {
					Files.walkFileTree(Paths.get(jvm, "bin"), new CHModdingFileVisitor());
					Files.walkFileTree(Paths.get(jvm, "lib"), new CHModdingFileVisitor());
					if(new File(jvm, "jre").exists()) {
						Files.walkFileTree(Paths.get(jvm, "jre", "bin"), new CHModdingFileVisitor());
						Files.walkFileTree(Paths.get(jvm, "jre", "lib"), new CHModdingFileVisitor());
					}
				} catch (IOException e) {
					//
				}
			}
		}
	}

	static class CHModdingFileVisitor implements FileVisitor<Path> {
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
			file.toFile().setExecutable(true);
			return FileVisitResult.CONTINUE;
		}
	}
}
