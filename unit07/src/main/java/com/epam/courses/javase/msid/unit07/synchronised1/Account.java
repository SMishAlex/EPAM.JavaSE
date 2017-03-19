package com.epam.courses.javase.msid.unit07.synchronised1;

import java.util.concurrent.atomic.AtomicInteger;

public interface Account {

    void withdraw(int amount);

    void deposit(int amount);

    int getBalance();
}
