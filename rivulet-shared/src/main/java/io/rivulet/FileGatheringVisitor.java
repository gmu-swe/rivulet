package io.rivulet;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.LinkedList;

/* Gathers a list of files in a directory. */
public class FileGatheringVisitor implements FileVisitor<Path> {

    private final LinkedList<File> files = new LinkedList<>();
    private final String suffix;

    public FileGatheringVisitor(String suffix) {
        this.suffix = suffix;
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
        if(Files.isRegularFile(file) && (suffix == null || file.toString().endsWith(suffix))) {
            files.add(file.toFile());
        }
        return FileVisitResult.CONTINUE;
    }

    /* Returns a sorted list of files in the specified directory. */
    public static LinkedList<File> getSortedFiles(String dirPath) throws IOException {
      return getSortedFiles(dirPath, null);
    }

    /* Returns a sorted list of files in the specified directory that end with given suffix. */
    public static LinkedList<File> getSortedFiles(String dirPath, String suffix) throws IOException {
        FileGatheringVisitor visitor = new FileGatheringVisitor(suffix);
        Files.walkFileTree(Paths.get(dirPath), visitor);
        LinkedList<File> files = visitor.files;
        Collections.sort(files);
        return files;
    }
}
