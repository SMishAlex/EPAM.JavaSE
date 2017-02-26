package com.epam.courses.javase.msid.unit02.task3;

import com.epam.courses.javase.msid.unit02.task2.Stationery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msid on 26.02.17.
 */
public class Sets {
    private static List<Stationery> newEmployerSet;

    public Sets(){
        newEmployerSet = new ArrayList<>();
        
    }

    public static void setNewEmployerSet(List<Stationery> newEmployerSet) {
        Sets.newEmployerSet = newEmployerSet;
    }

    public List<Stationery> getNewEmployerSet(){
        return newEmployerSet;
    }




}
