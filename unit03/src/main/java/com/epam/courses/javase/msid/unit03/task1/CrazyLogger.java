package com.epam.courses.javase.msid.unit03.task1;


import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Created by msid on 28.02.17.
 */
public class CrazyLogger {
    @Override
    public String toString() {
        return data.toString();
    }

    private StringBuffer data = new StringBuffer();

    public void log(String message) {
        Instant instant = Instant.now();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-YYYY : HH-mm")
                        .withZone(ZoneId.systemDefault());
        String loged = String.format("%s - %s;", formatter.format(instant), message);
        data.append(loged);
    }

    public String findMessage(String message) {
        int start = data.indexOf(message) - "dd-MM-YYYY : HH-mm - ".length();
        int end = data.indexOf(";", start);
        return data.substring(start, end);
    }

    public String[] findMessages(String message) {
        return null;
    }
}
