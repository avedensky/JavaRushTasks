package com.javarush.task.task31.task3111;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


import static java.nio.file.FileVisitResult.CONTINUE;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private List<Path> foundFiles = new ArrayList<>();
    private String partOfName;
    private String partOfContent;

    boolean minSizeCheck;
    boolean maxSizeCheck;
    boolean partOfNameCheck;
    boolean partOfContentCheck;
    private int minSize;
    private int maxSize;


    public SearchFileVisitor() {
        this.partOfName = null;
        this.partOfContent = null;
        this.minSize = 0;
        this.maxSize = 0;

        this.minSizeCheck = false;
        this.maxSizeCheck = false;
        this.partOfNameCheck = false;
        this.partOfContentCheck = false;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        this.minSizeCheck = true;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        this.maxSizeCheck = true;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        this.partOfNameCheck = true;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
        this.partOfContentCheck = true;
    }

    public List<Path> getFoundFiles() {
        return this.foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (!attrs.isRegularFile()) return CONTINUE;

        if (partOfNameCheck && file.getFileName().toString().indexOf(this.partOfName) == -1)
            return CONTINUE;

        if (minSizeCheck && attrs.size() < minSize)
            return CONTINUE;

        if (maxSizeCheck && attrs.size() > maxSize)
            return CONTINUE;

        if (partOfContentCheck && new String(Files.readAllBytes(file)).indexOf(partOfContent) == -1)
            return CONTINUE;

        foundFiles.add(file);

        return CONTINUE;
    }
}
