package com.epam.courses.javase.msid.unit02.task3;

import com.epam.courses.javase.msid.unit02.task2.Stationery;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

    public Sets setDefoultSets(){
        Stationery[] stationeries = {
                new Glue(100, LocalDate.MAX),
                new Pen(10,Integer.MAX_VALUE),
                new NoteBook(40, 500),
                new Sticker(50, 100)
        };
        newEmployerSet.addAll(Arrays.asList(stationeries));
        return this;
    }




}
