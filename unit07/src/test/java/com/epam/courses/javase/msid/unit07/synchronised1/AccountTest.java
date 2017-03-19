package com.epam.courses.javase.msid.unit07.synchronised1;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void testThreadSaveSynchronised() throws InterruptedException {

        Account account = new SynchronisedAccount(1000);
        testThreadSave(account);
    }

    @Test
    public void testThreadSaveConcurrent() throws InterruptedException {
        Account account = new ConcurrentAccount(1000);
        testThreadSave(account);
    }

    private void testThreadSave(Account account) throws InterruptedException {
        int transactionNumber = 10_000_000;

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

        depositorThread.join();
        withdrawerThread.join();

        Assert.assertEquals(1000, account.getBalance());
    }

}