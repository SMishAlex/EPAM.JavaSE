package com.epam.courses.javase.msid.unit02.task4;

import com.epam.courses.javase.msid.unit02.task2.Stationery;
import com.epam.courses.javase.msid.unit02.task3.*;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by msid on 26.02.17.
 */
public class ComparatorsTest {

    @Test
    public void testCostSort() {
        Sets sets = new Sets().setDefoultSets();
        List<Stationery> newEmployerSet = sets.getNewEmployerSet();
        newEmployerSet.sort(new Comparators.CostComparator());
        Stationery[] sorted = {
                new Pen(10, Integer.MAX_VALUE),
                new NoteBook(40, 500),
                new Sticker(50, 100),
                new Glue(100, LocalDate.MAX),
        };
        newEmployerSet.stream().forEach(System.out::println);
        assertEquals(Arrays.asList(sorted), newEmployerSet);
    }

    @Test
    public void testNameSort() {
        Sets sets = new Sets().setDefoultSets();
        List<Stationery> newEmployerSet = sets.getNewEmployerSet();
        newEmployerSet.sort(new Comparators.NameComparator());
        Stationery[] sorted = {
                new Glue(100, LocalDate.MAX),
                new NoteBook(40, 500),
                new Pen(10, Integer.MAX_VALUE),
                new Sticker(50, 100),
        };
        newEmployerSet.stream().forEach(System.out::println);
        assertEquals(Arrays.asList(sorted), newEmployerSet);
    }

    @Test
    public void testCostAndNameSort() {
        Sets sets = new Sets().setDefoultSets();
        List<Stationery> newEmployerSet = sets.getNewEmployerSet();
        newEmployerSet.sort(new Comparators.CostAndNameComparator());
        Stationery[] sorted = {
                new Pen(10, Integer.MAX_VALUE),
                new NoteBook(40, 500),
                new Sticker(50, 100),
                new Glue(100, LocalDate.MAX),
        };
        newEmployerSet.stream().forEach(System.out::println);
        assertEquals(Arrays.asList(sorted), newEmployerSet);
    }

}