package com.epam.courses.javase.msid.unit02.task3;

import java.time.LocalDate;
import java.util.Objects;

public class Glue extends ShelfLifeStationery {
    public Glue(long cost, LocalDate boughtDate, LocalDate expires) {
        super(cost, boughtDate, expires);
    }

    public Glue(long cost, LocalDate expires) {
        super(cost, expires);
    }


    private Object glue(Objects o1, Objects o2) {
        return new Object[]{o1, o2};
    }
}
