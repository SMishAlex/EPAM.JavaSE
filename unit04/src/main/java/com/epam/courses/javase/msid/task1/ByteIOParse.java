package com.epam.courses.javase.msid.task1;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ByteIOParse {
    private List<String> keyWords;
    private String Analyse;

    public Map<String, Integer> getResult() {
        return new HashMap<>(result);
    }

    private Map<String, Integer> result;

    ByteIOParse() {
        keyWords = new ArrayList<>();
        result = new HashMap<>();
    }


    public void setKeyWordsFromFile(String path) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(path)) {
            try (Scanner scanner = new Scanner(inputStream)) {
                while (scanner.hasNext()) {
                    keyWords.add(scanner.next());
                }
            }
        }
    }

    public List<String> getKeyWords() {
        return new ArrayList<>(keyWords);
    }

    public void analyseFile(String path) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(path)) {
            byte[] bufer = new byte[inputStream.available()];
            inputStream.read(bufer);
            Analyse = new String(bufer);
        }
        for (String key : keyWords) {
            Pattern currentKeyPattern = Pattern.compile(key);
            Matcher m = currentKeyPattern.matcher(Analyse);
            int keyValue = 0;
            while (m.find()) {
                keyValue += 1;
            }
            result.put(key, keyValue);
        }
    }
}
