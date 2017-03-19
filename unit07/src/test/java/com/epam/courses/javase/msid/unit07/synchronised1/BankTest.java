package com.epam.courses.javase.msid.unit07.synchronised1;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class BankTest {
    private Account a0;
    private Account a1;

    @Before
    public void init(){

        a0 = new SynchronisedAccount(100);
        a1 = new SynchronisedAccount(100);

        Bank.accounts.add(a0);
        Bank.accounts.add(a1);
    }

    @Test
    public void testWorkingRegexTransaction() {

        Bank.transaction("from: 0 to: 1 - 100");

        assertEquals(0, a0.getBalance());
        assertEquals(200, a1.getBalance());
    }

    @Test
    public void testMultithreadedOperations() throws IOException, InterruptedException {

        File transactions = new File("transactions.txt");
        Bank.transaction(transactions);

        assertEquals(a1.getBalance(), a0.getBalance());

    }


}