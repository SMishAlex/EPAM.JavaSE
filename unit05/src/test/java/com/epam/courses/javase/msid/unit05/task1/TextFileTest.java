package com.epam.courses.javase.msid.unit05.task1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TextFileTest {

    private String fileName;
    private FileDirectoryShower shower;

    @Before
    public void init() throws IOException {
        fileName = "test1.txt";
        TextFile.create(fileName);
        shower = new FileDirectoryShower(".");
        assertTrue(shower.contains(fileName));
    }

    @Test
    public void testCreatingAndRemovingFile() throws IOException {
        String name = "some.txt";
        TextFile.create(name);
        assertTrue("file wasn't create ", shower.contains(name));
        TextFile.remove(name);
    }

    @Test
    public void testWriteToEndOfFile() throws IOException {
        TextFile textFile = new TextFile(fileName);
        long lines = textFile.getLinesNumber();
        List<String> toWrite = new ArrayList<>();
        toWrite.add("some line");
        toWrite.add("one more line");
        textFile.writeToEnd(toWrite);
        assertEquals(lines + toWrite.size(), textFile.getLinesNumber());
        textFile.writeToEnd(toWrite);
        assertEquals(lines + toWrite.size() * 2, textFile.getLinesNumber());
    }

    @After
    public void removeTestingFiles() throws IOException {
        TextFile.remove(fileName);
        assertFalse(shower.contains(fileName));
    }

}