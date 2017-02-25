package com.epam.courses.javase.msid.unit02.task2;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by msid on 25.02.17.
 */
public class StationeryTest {
    @Test
    public void testCostSum() {
        String name = "Some Name";
        Employer employer = new Employer(name);
        employer.addStationery(new Stationery(200));
        long cost = employer.getCostOfStationery();

        Assert.assertEquals(200, cost);
    }

    @Test
    public void testCostOfEmptyStationery(){
        String name = "Some Name";
        Employer employer = new Employer(name);
        Assert.assertEquals(0,employer.getCostOfStationery());
    }

    @Test
    public void testThatCanAddStationery() {
        String name = "Some Name";
        Employer employer = new Employer(name);
        Stationery stationery = new Stationery(200);
        employer.addStationery(stationery);

        ArrayList<Stationery> expand = new ArrayList<Stationery>();
        expand.add(stationery);

        Assert.assertEquals(expand, employer.getStationers());
    }

    @Test
    public void testNotValidStationery() {
        String name = "Some Name";
        Employer employer = new Employer(name);
        LocalDate boughtDate = LocalDate.now();
        try {
            employer.addStationery(new Stationery(-20, boughtDate));
        }catch (IllegalArgumentException e){
            System.err.println(e);
        }

        Assert.assertTrue(employer.getStationers().size() == 0);
    }

}