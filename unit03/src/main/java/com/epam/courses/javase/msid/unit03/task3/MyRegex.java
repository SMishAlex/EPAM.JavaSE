package com.epam.courses.javase.msid.unit03.task3;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class MyRegex {
    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        Pattern pattern = Pattern.compile("(<[^>]+>)([а-яА-Я]+)(</[^>]+>)");
        String text = "<body style='background-image:url('http://ss.de/img.jpg');dfg:fgfg; fgfgf:gggg'>Привет</body>";
        Matcher m = pattern.matcher(text);
        while (m.find()) {
            for (int i = 1; i <= m.groupCount(); i++)
                System.out.println("Found '" + m.group(i) + "' at position "
                        + m.start(i) + "-" + m.end(i));
        }
    }

    private static void test2() {
        Pattern separator = Pattern.compile("(<[^>]+>)+");
        String text = "<div>В электроне (позитроне) гамма-коллапсары образуют семь гамма-трубок (Рис. 3), в каждой из семи гамма-трубок по семь элементарных трубок, всего в электроне (позитроне) 49 элементарных трубок, сорок девятая трубка расположена в центре. Последовательное электрическое взаимодействие элементарных (кулоновских) зарядов противоположного знака полярности в коллапсарах называется элементарными трубками.</div><div>Многоуважаемые учёные!</div><div>Написана книга «Новая фундаментальная физика», под условным названием «Истина коллапсара-семёрки». В настоящей статье приведены причины краха электронной теории и доказательства объединения всех взаимодействий.</div>";
        String[] strings = separator.split(text);
        for (String s : strings) {
            System.out.println(s);
            Pattern picture = Pattern.compile("Рис\\. ([0-9]+)");
            Matcher m = picture.matcher(s);
            while (m.find()) {
                for (int i = 1; i <= m.groupCount(); i++)
                    System.out.println("Found '" + m.group(i) + "' at position "
                            + m.start(i) + "-" + m.end(i));
            }
        }
    }
}

