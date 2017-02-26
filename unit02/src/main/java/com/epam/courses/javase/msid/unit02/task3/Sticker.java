package com.epam.courses.javase.msid.unit02.task3;

import java.time.LocalDate;

/**
 * Created by msid on 25.02.17.
 */
public class Sticker extends ExpendableStationery {
    public Sticker(long cost, LocalDate boughtDate) {
        super(cost, boughtDate, curentValue);
    }

    public Sticker(long cost) {
        super(cost, curentValue);
    }
}
