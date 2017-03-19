package com.epam.courses.javase.msid.unit07.deadlock;

import java.util.ArrayList;
import java.util.List;

public class UserResourceThread {

    private static int threadNumber = 10;

    public static void main(String[] args) throws InterruptedException {

        SharedResource res = new SharedResource();
        List<IntegerSetterGetter> setterGetterList = new ArrayList<>();

        for (int i = 0; i < threadNumber; i++) {
            setterGetterList.add(new IntegerSetterGetter(i + "", res));
        }

        for (IntegerSetterGetter t : setterGetterList) {
            t.start();
        }

        Thread.sleep(100);

        for (IntegerSetterGetter t : setterGetterList) {
            t.stopThread();
        }

        for (IntegerSetterGetter t : setterGetterList) {
            t.join();
        }

        System.out.println("main");
    }
}
