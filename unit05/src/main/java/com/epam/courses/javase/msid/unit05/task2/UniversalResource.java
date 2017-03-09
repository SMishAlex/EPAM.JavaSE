package com.epam.courses.javase.msid.unit05.task2;

import java.nio.file.NoSuchFileException;
import java.util.*;

public class UniversalResource {
    Map<String, String> data;

    /**
     * Universal resource of some bundle with base and language.
     *
     * @param resource base for resource bundle
     * @param local    An ISO 639 alpha-2 or alpha-3 language code. {@see {@link Locale#Locale(String)}}
     * @throws NoSuchFileException
     */
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

    /**
     * Return string with key.
     *
     * @param key
     * @return string that contains in property file with argument key
     * @throws NoSuchElementException if there is no such key in file
     */
    public String getString(String key) throws NoSuchElementException {
        String result = data.get(key);
        if (result == null)
            throw new NoSuchElementException();
        return result;
    }

    /**
     * Get data hashMap.
     *
     * @return copy of resources.
     */
    public Map<String, String> getData() {
        return new HashMap<>(data);
    }
}
