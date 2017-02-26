package com.epam.courses.javase.msid.unit02.task3;

import java.time.LocalDate;

/**
 * Created by msid on 26.02.17.
 */
public class OfficePaper extends ExpendableStationery {
    public OfficePaper(long cost, LocalDate boughtDate, int currentValue) {
        super(cost, boughtDate, currentValue);
    }

    public OfficePaper(long cost, int currentValue) {
        super(cost, currentValue);
    }
}
