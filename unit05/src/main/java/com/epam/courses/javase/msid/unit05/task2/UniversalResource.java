package com.epam.courses.javase.msid.unit05.task2;

import java.nio.file.NoSuchFileException;
import java.util.*;

public class UniversalResource {
    Map<String, String> data;

    public UniversalResource(String resource, String local) throws NoSuchFileException {
        try {
            Locale locale = new Locale(local);
            ResourceBundle bundle = ResourceBundle.getBundle(resource, locale);
            data = new HashMap<>();
            for (String key : bundle.keySet()) {
                data.put(key, bundle.getString(key));
            }
        } catch (MissingResourceException e) {
            throw new NoSuchFileException(resource);
        }
    }

    public String getString(String key) {
        String result = data.get(key);
        if (result == null)
            throw new NoSuchElementException();
        return result;
    }

    public Map<String, String> getData() {
        return new HashMap<>(data);

    }
}
