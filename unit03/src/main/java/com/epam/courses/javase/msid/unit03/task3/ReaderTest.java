package com.epam.courses.javase.msid.unit03.task3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaderTest {
    public static void main(String[] args) throws FileNotFoundException {
        try(FileReader reader = new FileReader("1.txt"))
        {
            try(Scanner scanner = new Scanner(reader)) {
                while (scanner.findInLine(".*<div id=\"content\">.*") == null)
                    scanner.nextLine();
                while (scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    Pattern picture = Pattern.compile("[Рр]ис\\. ?([0-9]+)");
                    Matcher m = picture.matcher(line);
                    while (m.find()){
                        System.out.println(m.group(1));
                    }

                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
