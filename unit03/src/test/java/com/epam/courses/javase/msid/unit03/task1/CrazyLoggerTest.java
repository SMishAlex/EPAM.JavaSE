package com.epam.courses.javase.msid.unit03.task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class CrazyLoggerTest {
    @Test
    public void testLoggerFindMessage() {
        CrazyLogger crazyLogger = new CrazyLogger();
        String message = "some message";
        crazyLogger.log(message);
        String found = crazyLogger.findMessage(message);
        System.out.println(found);
        assertFalse(found.isEmpty());
    }

    @Test
    public void testLoggerFindMessages() {
        CrazyLogger crazyLogger = new CrazyLogger();
        String message = "some message";
        crazyLogger.log(message);
        crazyLogger.log(message);
        String[] found = crazyLogger.findMessages(message);
        System.out.println(found);
        assertEquals(2,found.length);
    }

}