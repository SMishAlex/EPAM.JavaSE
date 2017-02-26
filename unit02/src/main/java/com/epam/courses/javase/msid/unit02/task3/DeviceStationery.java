package com.epam.courses.javase.msid.unit02.task3;

import com.epam.courses.javase.msid.unit02.task2.Stationery;

import java.time.LocalDate;

/**
 * Created by msid on 26.02.17.
 */
public class DeviceStationery extends Stationery {

    final String brand;

    public DeviceStationery(long cost, LocalDate boughtDate, String brand) {
        super(cost, boughtDate);
        this.brand = brand;
    }

    public DeviceStationery(long cost, String brand) {
        super(cost);
        this.brand = brand;
    }

    public DeviceStationery(long cost) {
        super(cost);
        brand = "No brand";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DeviceStationery) {
            if (((DeviceStationery) obj).brand.equals(brand))
                return super.equals(obj);
        }
        return false;
    }
}
