package com.epam.courses.javase.msid.unit07.synchronised1;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    static List<Account> accounts = new ArrayList<>();

    public static void transaction(Account a1, Account a2, int amount){
        a1.deposit(amount);
        a2.withdraw(amount);
    }

    public static void transaction(String transactionInfo){
        
    }
}
