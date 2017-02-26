package com.epam.courses.javase.msid.unit02.task3;

import java.time.LocalDate;

/**
 * Created by msid on 26.02.17.
 */
public class Puncher extends DeviceStationery {
    public Puncher(long cost, LocalDate boughtDate, String brand) {
        super(cost, boughtDate, brand);
    }

    public Puncher(long cost, String brand) {
        super(cost, brand);
    }

    public Puncher(long cost) {
        super(cost);
    }

    public void makeHole(OfficePaper list){
        //list become list with hole =)
    }
}
