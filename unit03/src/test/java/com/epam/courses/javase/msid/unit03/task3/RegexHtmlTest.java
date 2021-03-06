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
        html = RegexHtml.of("1.txt");
    }

    @After
    public void closeHtml() {
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
    public void testFindAllSentenceWithPictures() {
        html.moveToContent();
        List<String> sentences = html.findAllSentenceWithPictures();
        assertEquals(80, sentences.size());
    }

    @Test
    public void testThatPicturesNumberSequentiallyRecoded() {
        html.findAllSentenceWithPictures();
        List<Integer> picturesNumbers = html.takePicturesNumbers();
        int previousNumber = Integer.MIN_VALUE;
        boolean result = true;
        for (int currentNumber : picturesNumbers) {
            if (currentNumber > previousNumber) {
                previousNumber = currentNumber;
            } else {
                result = false;
                break;
            }
        }
        assertEquals(result, html.isSequentiallyPictures());
    }

}