package com.epam.courses.javase.msid.unit02.task3;

import java.time.LocalDate;

/**
 * Created by msid on 25.02.17.
 */
public class Pen extends ExpendableStationery {
    public Pen(long cost, LocalDate boughtDate, int currentValue) {
        super(cost, boughtDate, currentValue);
    }

    public Pen(long cost, int currentValue) {
        super(cost, currentValue);
    }
}
