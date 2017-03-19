package com.epam.courses.javase.msid.unit07.synchronised1;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeMap;

public class AccountTest {

    @Test
    public void testTreadSave() {
        Account account = new Account(1000);
        int transactionNumber = 10_000;
        Runnable depositor = () -> {
            for (int i = 0; i < transactionNumber; i++) {
                account.deposit(200);
            }
        };
        Runnable withdrawer = () -> {
            for (int i = 0; i < transactionNumber; i++) {
                account.withdraw(200);
            }
        };
        Thread depositorThread = new Thread(depositor);
        Thread withdrawerThread = new Thread(withdrawer);
        depositorThread.start();
        withdrawerThread.start();

        Assert.assertEquals(1000, account.getBalance());


    }

}