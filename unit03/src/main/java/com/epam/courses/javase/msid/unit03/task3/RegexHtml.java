package com.epam.courses.javase.msid.unit03.task3;

import com.sun.istack.internal.NotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHtml {

    Scanner scanner;
    List<Integer> picturesNumbers;

    private RegexHtml(Scanner scanner) {
        this.scanner = scanner;
    }

    public static RegexHtml of(@NotNull String path) throws FileNotFoundException {
        FileReader fileReader = new FileReader(path);
        RegexHtml regexHtml = new RegexHtml(new Scanner(fileReader));
        return regexHtml;
    }
    
    @NotNull
    public String[] findAllSentenceWithPictures() {
        List<String> picturesSentence = new ArrayList<>();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] splited= splitOnTegs(line);
            for(String s: splited){
                Pattern picture = Pattern.compile("Рис\\. ([0-9]+)");
                Matcher m = picture.matcher(s);
                if(m.matches())
                    picturesSentence.add(s);
                while (m.find()) {
                    for (int i = 1; i <= m.groupCount(); i++) {
                        System.out.println("Found '" + m.group(i) + "' at position "
                                + m.start(i) + "-" + m.end(i));
                        picturesNumbers.add(Integer.parseInt(m.group(i)));
                    }
                }
            }
        }
        String[] strings = new String[picturesSentence.size()];
        picturesSentence.toArray(strings);
        return strings;
    }

    public List<Integer> takePicturesNumbers() {
        return null;
    }

    public boolean isSequentiallyPictures() {
        return false;
    }

    public void moveToContent() {
        while (scanner.findInLine(".*<div id=\"content\">.*") == null)
            scanner.nextLine();
    }

    private String[] splitOnTegs(String src) {
        Pattern separator = Pattern.compile("(<[^>]+>)+");
        return separator.split(src);
    }

    public void close() {
        scanner.close();
    }


}
