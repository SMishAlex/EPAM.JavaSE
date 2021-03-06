package com.epam.courses.javase.msid.unit02.task3;

import com.epam.courses.javase.msid.unit02.task2.Stationery;

import java.time.LocalDate;

/**
 * Created by msid on 25.02.17.
 */
public class ShelfLifeStationery extends Stationery {

    private final LocalDate expires;

    public ShelfLifeStationery(long cost, LocalDate boughtDate, LocalDate expires) {
        super(cost, boughtDate);
        this.expires = expires;
    }

    public ShelfLifeStationery(long cost, LocalDate expires) {
        super(cost);
        this.expires = expires;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ShelfLifeStationery){
            if(((ShelfLifeStationery) obj).expires.equals(this.expires)){
                return super.equals(obj);
            }
        }
        return false;
    }


    public LocalDate getExpires() {
        return expires;
    }

    public boolean isExpires() {
        return LocalDate.now().isBefore(expires);
    }
}
