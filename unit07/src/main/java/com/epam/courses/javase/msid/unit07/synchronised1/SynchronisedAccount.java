package com.epam.courses.javase.msid.unit07.synchronised1;

public class SynchronisedAccount implements Account {
    private int balance;

    public SynchronisedAccount(int startBalance) {
        balance = startBalance;
    }

    public synchronized void withdraw(int amount) {
        balance += amount;
    }

    public synchronized void deposit(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
