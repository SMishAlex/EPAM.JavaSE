package com.epam.courses.javase.msid.unit02.task3;

import java.time.LocalDate;

/**
 * Created by msid on 25.02.17.
 */
public class Stapler extends DeviceStationery {

    public Stapler(long cost, LocalDate boughtDate, String brand) {
        super(cost, boughtDate, brand);
    }

    public Stapler(long cost, String brand) {
        super(cost, brand);
    }

    public Stapler(long cost) {
        super(cost);
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) return true;
        else return false;
    }

    public void staple(OfficePaper[] document){
        //document with some pages become stapled
    }
}
