package com.epam.courses.javase.msid.task2;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RWParse {

    private List<String> keyWords;
    private String Analyse;

    private Map<String, Integer> result;

    RWParse() {
        keyWords = new ArrayList<>();
        result = new HashMap<>();
    }

    public void outputResultToFile(String path) throws IOException {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(result.toString());
        }
    }

    public Map<String, Integer> getResult() {
        return new HashMap<>(result);
    }


    public void setKeyWordsFromFile(String path) throws IOException {
        try (FileReader fileReader = new FileReader(path)) {
            try (Scanner scanner = new Scanner(fileReader)) {
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
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(path)) {
            int read;
            do {
                read = fileReader.read();
                if(read>=0) {
                    stringBuilder.append((char)read);
                }
            }while (read !=-1);
        }
        Analyse = stringBuilder.toString();
    }
}
