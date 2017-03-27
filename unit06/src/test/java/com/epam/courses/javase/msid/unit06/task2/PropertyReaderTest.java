package com.epam.courses.javase.msid.unit06.task2;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PropertyReaderTest {

    private Set<Object> keySet = new HashSet<Object>(2) {
        {
            add("key1");
            add("key2");
        }
    };
    private PropertyReader propertyReader;

    @Before
    public void init() throws FileNotFoundException {
        propertyReader = new PropertyReader("property.properties");
    }

    @Test
    public void testReadingProperties() {
        assertTrue(propertyReader.getKeySet().containsAll(keySet));
    }

    @Test
    public void testReadingOnce() throws FileNotFoundException {
        PropertyReader propertyReader2 = new PropertyReader("property.properties");

        assertTrue("not same referent",
                propertyReader.getKeySet() == propertyReader2.getKeySet());
    }

    @Test
    public void testTwoThreadReading() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                new PropertyReader("property.properties");
            } catch (FileNotFoundException /*| InterruptedException*/ e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }


}