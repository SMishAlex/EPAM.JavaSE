package com.epam.courses.javase.msid.unit03.task3;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RegxHtmlTest {
    RagHtml html;

    @Before
    public void init(){
        html = new RagHtml("Java.SE.03.Information handling_task_attachment.html");
    }

    @Test
    public void testFindAllSentenceWithPictures(){
        String[] sentences= RagHtml.findAllSentenceWithPictures();
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