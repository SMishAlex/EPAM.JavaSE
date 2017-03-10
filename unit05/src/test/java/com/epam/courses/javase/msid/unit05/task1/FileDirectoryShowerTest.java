package com.epam.courses.javase.msid.unit05.task1;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileDirectoryShowerTest {
    FileDirectoryShower shower;

    @Before
    public void init() throws IOException {
        shower =  new FileDirectoryShower(".");
    }

    @Test
    public void testGetDirectories() throws IOException {
        assertEquals(3, shower.getDirectories().length);
    }

    @Test
    public void testGetFiles(){
        assertEquals(2,shower.getFiles().length);
        shower.showFiles();
        assertTrue(shower.contains("pom.xml"));
    }

}