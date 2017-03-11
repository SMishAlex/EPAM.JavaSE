package com.epam.courses.javase.msid.unit05.task1;

import java.io.*;
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


    public long getLinesNumber() {
        long linesNumber = 0;
        try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(data))) {
            while (lineNumberReader.readLine() != null) {
                linesNumber++;
            }

        } catch (IOException e) {
            // TODO: 11.03.17 some exception
        }
        return linesNumber;
    }

    public void writeToEnd(List<String> toWrite) throws IOException {
        try (FileWriter writer = new FileWriter(data)) {
            for (String stringToWrite : toWrite) {
                writer.write(stringToWrite+'\n');
            }
        } catch (IOException e) {
            throw new IOException("file is not available", e);
        }

    }

    private static void isEndWithTatOrTrowIllegalArgumentException(String fileName) {
        if (!fileName.endsWith(".txt")) {
            throw new IllegalArgumentException("only txt files available");
        }
    }
}
