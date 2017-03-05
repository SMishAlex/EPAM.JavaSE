package com.epam.courses.javase.msid.task1;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ByteIOParse {
    private List<String> keyWords;
    private String Analyse;

    private Map<String, Integer> result;

    ByteIOParse() {
        keyWords = new ArrayList<>();
        result = new HashMap<>();
    }

    public void outputResultToFile(String path) throws IOException {
        try(FileOutputStream outputStream = new FileOutputStream(path)){
            outputStream.write(result.toString().getBytes());
        }
    }

    public Map<String, Integer> getResult() {
        return new HashMap<>(result);
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
        readFileAsOneString(path);
        searchKeywordsInString();
    }

    private void searchKeywordsInString() {
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

    private void readFileAsOneString(String path) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(path)) {
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            Analyse = new String(buffer);
        }
    }
}
