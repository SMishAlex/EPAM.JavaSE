package com.epam.courses.javase.msid.task3;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Converter {

    public static String[] readUtf8(String path) throws IOException {
        List<String> result = new ArrayList<>();
        try (FileReader fileReader = new FileReader(path);
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        }
        String[] strings = new String[result.size()];
        result.toArray(strings);
        return strings;
    }

    public static void writeUtf16(String path, String[] data) throws IOException {
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(path), "utf16")) {
            Arrays.stream(data).forEach((String x) -> {
                try {
                    outputStreamWriter.write(x+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

    }

    public static String[] read(String path) throws IOException {
        List<String> result = new ArrayList<>();
        try (FileReader fileReader = new FileReader(path);
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        }
        String[] strings = new String[result.size()];
        result.toArray(strings);
        return strings;
    }
}
