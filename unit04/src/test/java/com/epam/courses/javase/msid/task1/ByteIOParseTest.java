package com.epam.courses.javase.msid.task1;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ByteIOParseTest {
    @Test
    public void outputResultToFile() throws Exception {
        ioParse.analyseFile("src//main//java//com//epam//courses//javase//msid//task1//ByteIOParse.java");
        ioParse.outputResultToFile("out.txt");
    }

    private ByteIOParse ioParse;

    @Before
    public void testSetKeyWordsFromFile() throws IOException {
        ioParse = new ByteIOParse();
        ioParse.setKeyWordsFromFile("keys");
        assertEquals(50, ioParse.getKeyWords().size());
        assertEquals("abstract", ioParse.getKeyWords().get(0));
    }

    @Test
    public void testFileInput() throws IOException {
        ioParse.analyseFile("src//main//java//com//epam//courses//javase//msid//task1//ByteIOParse.java");
        assertEquals(3, ioParse.getResult().get("try").intValue());
    }


}