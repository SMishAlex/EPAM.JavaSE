package com.epam.courses.javase.msid.unit05.task1;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
        //assertTrue(shower.contains(fileName));
    }

    @Test
    public void testCreatingFile() {
        TextFile.create(fileName);
        assertTrue("file wasn't create ", shower.contains(fileName));
    }

    @Test
    public void testWriteToEndOfFile() {
        TextFile textFile = new TextFile(fileName);
        int lines = textFile.getLinesNumber();
        List<String> toWrite = new ArrayList<>();
        toWrite.add("some line");
        textFile.writeToEnd(toWrite);
        assertEquals(lines + toWrite.size(), textFile.getLinesNumber());
    }

    @After
    public void removeTestingFiles() {
        TextFile.remove(fileName);
        assertFalse(shower.contains(fileName));
    }

}