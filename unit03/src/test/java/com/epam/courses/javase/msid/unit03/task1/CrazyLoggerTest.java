package com.epam.courses.javase.msid.unit03.task1;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Locale;

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

    @Test
    public void test(){
        Instant date = Instant.now();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-YYYY : HH-mm").withZone(ZoneId.systemDefault());
        System.out.println(formatter.format(date));
    }
}