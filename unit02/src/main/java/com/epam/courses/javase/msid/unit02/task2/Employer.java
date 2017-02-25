package com.epam.courses.javase.msid.unit02.task2;

import java.util.ArrayList;
import java.util.List;

public class Employer {
    /**
     * Full list of stationeries that employer had.
     */
    private ArrayList<Stationery> stationeries;
    /**
     * First and second names of employer written in one line (string).
     */
    private final String name;

    public Employer(String name) {
        stationeries = new ArrayList<>();
        this.name = name;
    }

    public void addStationery(Stationery stationery) {
        if(stationery.getCost()<0)
            throw new IllegalArgumentException("cost can't be less than 0!");
        stationeries.add(stationery);
    }


    public long getCostOfStationery() {
        long result = 0;
        for (Stationery s : stationeries)
            result += s.getCost();
        return result;
    }

    public List<Stationery> getStationers() {
        return stationeries;
    }
}
