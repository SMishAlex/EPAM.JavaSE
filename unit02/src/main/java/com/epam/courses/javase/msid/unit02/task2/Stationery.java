package com.epam.courses.javase.msid.unit02.task2;

import java.time.LocalDate;

public class Stationery {
    private long cost;
    private final LocalDate boughtDate;

    public Stationery(long cost, LocalDate boughtDate) {
        this.cost = cost;
        this.boughtDate = boughtDate;
    }

    /**
     * Simple stationery constructor.
     *
     * Set bought date as today.
     * @param cost how mach does this stationery cost
     */
    public Stationery(long cost){
        this(cost, LocalDate.now());
    }

    public long getCost(){
        return cost;
    }

    public LocalDate getBoughtDate() {
        return boughtDate;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj))
            return true;
        if (obj instanceof Stationery){
            if(((Stationery) obj).cost==cost&&
                    ((Stationery) obj).boughtDate.equals(boughtDate))
                return true;
        }
        return false;
    }


}
