package io.rivulet.maven;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "clean", defaultPhase = LifecyclePhase.CLEAN)
public class PhosphorCleanMojo extends AbstractMojo {

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		String instrumentedJVMDir = System.getProperty("instrumentedJVMDir", System.getProperty("user.home") + File.separator + ".phosphor-jvm");
		File f = new File(instrumentedJVMDir);
		if (f.exists()) {
			Path directory = Paths.get(instrumentedJVMDir);
			try {
				Files.walkFileTree(directory, new FileVisitor<Path>() {
					@Override
					public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
						Files.delete(file);
						return FileVisitResult.CONTINUE;
					}

					@Override
					public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
						Files.delete(dir);
						return FileVisitResult.CONTINUE;
					}

					@Override
					public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
						return FileVisitResult.CONTINUE;

					}

					@Override
					public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
						return FileVisitResult.CONTINUE;

					}

				});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
