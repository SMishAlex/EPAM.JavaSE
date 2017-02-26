package com.epam.courses.javase.msid.unit02.task3;

import java.awt.*;
import java.time.LocalDate;

/**
 * Created by msid on 25.02.17.
 */
public class Pen extends ExpendableStationery {

    private final Color color;

    public Pen(long cost, LocalDate boughtDate, int currentValue, Color color) {
        super(cost, boughtDate, currentValue);
        this.color = color;
    }

    public Pen(long cost, int currentValue, Color color) {
        super(cost, currentValue);
        this.color = color;
    }

    public Pen(long cost, int currentValue){
        super(cost,currentValue);
        color = Color.BLUE;
    }

    public void write(String line){
        this.use(line.length());
        System.out.println(line);
    }
}
