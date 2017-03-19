package com.epam.courses.javase.msid.unit07.synchronised2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertyReader {
    private static volatile Map<String, Properties> history;
    private Properties properties;
    private static Lock lock = new ReentrantLock();

    public PropertyReader(String fileName) throws FileNotFoundException {
        waitUnlocking();
        if (history == null) {
            history = new HashMap<>();
        }
        if (history.containsKey(fileName)) {
            properties = history.get(fileName);
        } else {
            readProperties(fileName);
            history.put(fileName, properties);
        }
        lock.unlock();
    }

    private void waitUnlocking() {
        while (!lock.tryLock()) {
            System.out.println("file is busy...");
        }
    }

    private void readProperties(String fileName) throws FileNotFoundException {
        properties = new Properties();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            Pattern pattern = Pattern.compile("([^=]+)=(.+)");
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                Matcher m = pattern.matcher(input);
                if (m.find()) {
                    properties.put(m.group(1), m.group(2));
                }
            }
        }
    }

    public Set<Object> getKeySet() {
        return properties.keySet();
    }

    public Object get(Object key){
        return properties.get(key);
    }
}
