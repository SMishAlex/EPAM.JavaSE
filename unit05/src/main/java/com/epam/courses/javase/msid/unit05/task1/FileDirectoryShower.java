package com.epam.courses.javase.msid.unit05.task1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FileDirectoryShower {
    private File path;


    public FileDirectoryShower(String path) throws IOException {
        this.path = new File(path);
        if (!this.path.exists()) {
            throw new IOException("can't read file or directory");
        }
    }

    private File[] pathFilter(Predicate<? super File> predicate) {
        return Arrays
                .stream(path.listFiles())
                .filter(predicate)
                .toArray(File[]::new);
    }

    public File[] getDirectories() {
        return pathFilter(File::isDirectory);
    }

    public void showDirectories() {
        for (File directory : getDirectories()) {
            System.out.println(directory.getName());
        }
    }

    public File[] getFiles() {
        return pathFilter(File::isFile);
    }

    public void showFiles(){
        for (File directory : getFiles()) {
            System.out.println(directory.getName());
        }
    }
}
