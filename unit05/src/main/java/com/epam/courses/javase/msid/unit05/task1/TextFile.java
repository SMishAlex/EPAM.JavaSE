package com.epam.courses.javase.msid.unit05.task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

public class TextFile {
    private File data;

    public TextFile(String fileName) throws NoSuchFileException, IllegalArgumentException {
        isEndWithTatOrTrowIllegalArgumentException(fileName);
        data = new File(fileName);
        if (!data.exists()) {
            throw new NoSuchFileException("file " + fileName + " not found");
        }
    }

    public static void create(String fileName) throws IOException, IllegalArgumentException {
        isEndWithTatOrTrowIllegalArgumentException(fileName);
        File created = new File(fileName);
        if (created.exists()) {
            throw new IOException("file " + fileName + " is already created");
        }
        created.createNewFile();
    }

    public static void remove(String fileName) throws IOException, IllegalArgumentException {
        isEndWithTatOrTrowIllegalArgumentException(fileName);
        File created = new File(fileName);
        if (!created.exists()) {
            throw new IOException("there is no " + fileName + " file");
        }
        created.delete();
    }


    public int getLinesNumber() {


        int linesNumber = 0;
        return linesNumber;
    }

    public void writeToEnd(List<String> toWrite) {
    }

    private static void isEndWithTatOrTrowIllegalArgumentException(String fileName) {
        if (!fileName.endsWith(".txt")) {
            throw new IllegalArgumentException("only txt files available");
        }
    }
}
