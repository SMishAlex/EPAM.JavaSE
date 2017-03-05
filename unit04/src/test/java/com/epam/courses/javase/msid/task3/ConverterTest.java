package com.epam.courses.javase.msid.task3;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ConverterTest {
    @Test
    public void test() throws IOException {
        String[] data = Converter.readUtf8("keys");
        Converter.writeUtf16("keys2", data);
        assertEquals(Converter.read("keys").length, Converter.read("keys2").length);
    }

}