package com.epam.courses.javase.msid.unit05.task1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileDirectoryShowerTest {
    @Test
    public void testGetDirectories() throws IOException {
        FileDirectoryShower shower = new FileDirectoryShower(".");
        assertEquals(3, shower.getDirectories().length);
    }

}