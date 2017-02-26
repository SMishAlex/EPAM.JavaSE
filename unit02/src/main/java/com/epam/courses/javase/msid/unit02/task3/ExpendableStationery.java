package com.epam.courses.javase.msid.unit02.task3;

import com.epam.courses.javase.msid.unit02.task2.Stationery;

import java.time.LocalDate;

/**
 * Created by msid on 26.02.17.
 */
public class ExpendableStationery extends Stationery {

    private int currentValue;

    public ExpendableStationery(long cost, LocalDate boughtDate, int currentValue) {
        super(cost, boughtDate);
        this.currentValue = currentValue;
    }

    public ExpendableStationery(long cost, int currentValue) {
        super(cost);
        this.currentValue = currentValue;
    }

    public void use(int value){
        if(currentValue <value)
            throw new IllegalArgumentException("not enough value to use!");
        currentValue -=value;
    }
}
