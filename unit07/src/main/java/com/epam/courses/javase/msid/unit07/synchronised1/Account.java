package com.epam.courses.javase.msid.unit07.synchronised1;

public class Account {
    private int balance;

    public Account(int startBalance) {
        balance = startBalance;
    }

    public void withdraw(int amount) {
        balance += amount;
    }

    public void deposit(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
