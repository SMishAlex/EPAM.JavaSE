package com.epam.courses.javase.msid.unit07.synchronised1;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentAccount implements Account {
    private AtomicInteger balance;

    public ConcurrentAccount(int startBalance) {
        balance = new AtomicInteger(startBalance);
    }

    public synchronized void withdraw(int amount) {
        balance.getAndAdd(amount);
    }

    public synchronized void deposit(int amount) {
        balance.getAndAdd(-amount);
    }

    public int getBalance() {
        return balance.get();
    }
}
