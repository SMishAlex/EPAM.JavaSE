package com.epam.courses.javase.msid.unit07.synchronised1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bank {
    volatile static List<Account> accounts = new ArrayList<>();
    private static Pattern pattern = Pattern.compile("from: (\\d+) to: (\\d+) - (\\d+)");

    public static void transaction(Account a1, Account a2, int amount) {
        a1.deposit(amount);
        a2.withdraw(amount);
    }

    public static void transaction(String transactionInfo) {

        Matcher matcher = pattern.matcher(transactionInfo);

        if (matcher.find()) {
            parseTransaction(matcher);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void transaction(File transactionInfo) throws IOException, InterruptedException {
        try (FileReader fileReader = new FileReader(transactionInfo);
             Scanner scanner = new Scanner(fileReader)) {
            List<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            lines.parallelStream().forEach(x -> transaction(x));
        }
    }


    private static void parseTransaction(Matcher matcher) {
        int fromID = Integer.valueOf(matcher.group(1));
        int toID = Integer.valueOf(matcher.group(2));
        int amount = Integer.valueOf(matcher.group(3));
        Account fromAccount = accounts.get(fromID);
        Account toAccount = accounts.get(toID);
        transaction(fromAccount, toAccount, amount);
    }

}
