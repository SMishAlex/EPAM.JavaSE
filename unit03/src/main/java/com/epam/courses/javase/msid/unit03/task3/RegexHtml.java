package com.epam.courses.javase.msid.unit03.task3;

import com.sun.istack.internal.NotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHtml {

    Scanner scanner;
    List<Integer> picturesNumbers;
    List<String> picturesSentence;


    private RegexHtml(Scanner scanner) {
        this.scanner = scanner;
        picturesNumbers = new ArrayList<>();
    }

    public static RegexHtml of(@NotNull String path) throws FileNotFoundException {
        FileReader fileReader = new FileReader(path);
        RegexHtml regexHtml = new RegexHtml(new Scanner(fileReader));

        return regexHtml;
    }

    @NotNull
    public List<String> findAllSentenceWithPictures() {
        picturesSentence = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitted = splitOnTags(line);
            for (String s : splitted) {
                addIfContainPicture(s);
            }
        }
        return picturesSentence;
    }

    private void addIfContainPicture(String s) {
        Pattern picture = Pattern.compile("[Рр]ис\\. ?([0-9]+)");
        Matcher m = picture.matcher(s);
        if(m.find()) {
            picturesSentence.add(s);
            addAllNumberFromSentence(m);
        }
    }

    private void addAllNumberFromSentence(Matcher m) {
        m.find(0);
        do {
            for (int i = 1; i <= m.groupCount(); i++) {
                picturesNumbers.add(Integer.parseInt(m.group(i)));
            }
        } while (m.find());
    }

    public List<Integer> takePicturesNumbers() {
        return new ArrayList<>(picturesNumbers);
    }

    public boolean isSequentiallyPictures() {
        Integer precios = Integer.MIN_VALUE;
        for(Integer cur:picturesNumbers) {
            if (precios <= cur) {
                precios = cur;
            } else {
                return false;
            }
        }
        return true;
    }

    public void moveToContent() {
        while (scanner.findInLine(".*<div id=\"content\">.*") == null)
            scanner.nextLine();
    }

    private String[] splitOnTags(String src) {
        Pattern separator = Pattern.compile("(<[^>]+>)+");
        String[] split = separator.split(src);
        return split;
    }

    public void close() {
        scanner.close();
    }


}
