package com.epam.courses.javase.msid.unit05.task2;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.NoSuchFileException;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class UniversalResourceTest {
    UniversalResource resource;

    @Test(expected = NoSuchFileException.class)
    public void testNoPropertyFileException() throws NoSuchFileException {
        UniversalResource ru = new UniversalResource("1", "ru");
    }

    @Before
    public void init() throws NoSuchFileException {
        resource = new UniversalResource("resources", "ru");
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchKeyException() {
        resource.getString("no");
    }

    @Test
    public void testThatAllPropertyHaveBeenRead() {
        assertEquals(3, resource.getData().size());

    }

}