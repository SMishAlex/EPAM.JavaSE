package com.epam.courses.javase.msid.unit03.task3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RegexHtmlTest {
    RegexHtml html;

    @Before
    public void init() throws FileNotFoundException {
        html = RegexHtml.of("Java.SE.03.Information handling_task_attachment.html");
    }

    @After
    public void closeHtml(){
        html.close();
    }

    @Test
    public void toContent() throws Exception {
        html.moveToContent();
    }

    @Test
    public void testNotNull() throws FileNotFoundException {
        //html = RegexHtml.of(null);
    }

    @Test
    public void testFindAllSentenceWithPictures(){
        html.moveToContent();
        String[] sentences= html.findAllSentenceWithPictures();
        Arrays.stream(sentences).forEach(System.out::println);

        assertTrue(sentences.length>0);
    }

    @Test
    public void testThatPicturesNumberSequentiallyRecoded(){
        List<Integer> picturesNumbers = html.takePicturesNumbers();
        int previousNumber = Integer.MIN_VALUE;
        boolean result = true;
        for (int currentNumber:picturesNumbers){
            if(currentNumber>previousNumber) {
                previousNumber = currentNumber;
            }
            else{
                result = false;
                break;
            }
        }
        assertEquals(result, html.isSequentiallyPictures());
    }

}