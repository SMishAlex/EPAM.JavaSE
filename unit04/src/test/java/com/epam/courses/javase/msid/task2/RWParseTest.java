package com.epam.courses.javase.msid.task2;

import com.epam.courses.javase.msid.task1.ByteIOParse;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class RWParseTest {
    @Test
    public void outputResultToFile() throws Exception {
        rwParse.analyseFile("src//main//java//com//epam//courses//javase//msid//task1//ByteIOParse.java");
        rwParse.outputResultToFile("out.txt");
    }

    private RWParse rwParse;

    @Before
    public void testSetKeyWordsFromFile() throws IOException {
        rwParse = new RWParse();
        rwParse.setKeyWordsFromFile("keys");
        assertEquals(50, rwParse.getKeyWords().size());
        assertEquals("abstract", rwParse.getKeyWords().get(0));
    }

    @Test
    public void testFileInput() throws IOException {
        rwParse.analyseFile("src//main//java//com//epam//courses//javase//msid//task2//RWParse.java");
        assertEquals(4, rwParse.getResult().get("try").intValue());
    }

}