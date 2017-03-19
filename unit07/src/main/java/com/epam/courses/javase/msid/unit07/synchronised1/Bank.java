package com.epam.courses.javase.msid.unit07.synchronised1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bank {
    static List<Account> accounts = new ArrayList<>();

    public static void transaction(Account a1, Account a2, int amount) {

        a1.deposit(amount);
        a2.withdraw(amount);
    }

    public static void transaction(String transactionInfo) {

        Pattern p = Pattern.compile("from: (\\d+) to: (\\d+) - (\\d+)");
        Matcher matcher = p.matcher(transactionInfo);

        if (matcher.find()) {
            int fromID = Integer.valueOf(matcher.group(1));
            int toID = Integer.valueOf(matcher.group(2));
            int amount = Integer.valueOf(matcher.group(3));
            Account fromAccount = accounts.get(fromID);
            Account toAccount = accounts.get(toID);
            transaction(fromAccount,toAccount,amount);
        }
    }
}
