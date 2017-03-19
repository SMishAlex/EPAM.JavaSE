package com.epam.courses.javase.msid.unit07.deadlock;

import java.util.Random;

public class IntegerSetterGetter extends Thread {
    private SharedResource resource;
    private boolean run;

    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        try {
            while (run) {
                if (rand.nextBoolean()) {
                    getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }
            System.out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;
        int tryLimit = 10;

        synchronized (resource) {
            int tryCount = 0;
            System.out.println("Поток " + getName()
                    + " хочет извлечь число.");
            number = resource.getElement();
            while (number == null && (tryCount < tryLimit)) {
                System.out.println("Поток " + getName()
                        + " ждет пока очередь заполнится.");
                resource.wait(100);
                System.out
                        .println("Поток " + getName() + " возобновил работу.");
                number = resource.getElement();
                tryCount++;
            }
            System.out
                    .println("Поток " + getName() + " извлек число " + number);
        }
    }

    private void setIntegersIntoResource() throws InterruptedException {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число "
                    + number);
            resource.notify();
        }
    }
}
