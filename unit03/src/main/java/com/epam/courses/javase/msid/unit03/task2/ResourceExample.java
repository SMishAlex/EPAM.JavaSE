package com.epam.courses.javase.msid.unit03.task2;

import java.io.IOException;
import java.util.*;

public class ResourceExample {
    public static void main(String[] args) throws IllegalFormatException, IOException {

        Locale locale;
        locale = askLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("question", locale);
        int numberOfQuestions = Integer.parseInt(bundle.getString("number.of.questions"));
        System.out.println(bundle.getString("title"));
        for (int i = 1; i < numberOfQuestions + 1; i++) {

            System.out.println(bundle.getString(String.format("question%d", i)));

            System.out.println(bundle.getString("ask.to.show.answer"));
            Scanner sc = new Scanner(System.in);
            String read = sc.nextLine();

            if (read.equals("Y") || read.equals("y")
                    || read.equals("Д") || read.equals("д")) {
                System.out.println(bundle.getString(String.format("answer%d", i)));
            }
        }
    }

    private static Locale askLocale() {
        Scanner sc = new Scanner(System.in);
        switch (sc.nextLine()) {
            case "ru":
                return new Locale("ru", "RU");
            case "en":
                return new Locale("en");
            default:
                throw new IllegalArgumentException("only ru or en available");
        }
    }
}
