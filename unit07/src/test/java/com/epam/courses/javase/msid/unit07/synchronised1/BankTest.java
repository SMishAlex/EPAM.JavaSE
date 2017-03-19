package com.epam.courses.javase.msid.unit07.synchronised1;

import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void test() {
        Account a0 = new SynchronisedAccount(100);
        Account a1 = new SynchronisedAccount(100);
        Bank.accounts.add(a0);
        Bank.accounts.add(a1);
        Bank.transaction("from: 0 to: 1 - 100");
        assertEquals(0, a0.getBalance());
        assertEquals(200, a1.getBalance());
    }

}