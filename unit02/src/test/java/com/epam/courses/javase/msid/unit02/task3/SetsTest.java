package com.epam.courses.javase.msid.unit02.task3;

import com.epam.courses.javase.msid.unit02.task2.Stationery;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by msid on 26.02.17.
 */
public class SetsTest {

    @Test
    public void testEmptySet() {
        Sets sets = new Sets();
        assertEquals(sets, sets.setNewEmployerSet(new ArrayList<>()));
    }

    @Test
    public void testDefaultSet() {
        Sets sets = new Sets().setDefoultSets();
        Stationery[] stationeries = {
                new Glue(100, LocalDate.MAX),
                new Pen(10, Integer.MAX_VALUE),
                new NoteBook(40, 500),
                new Sticker(50, 100)
        };
        for (Stationery s : stationeries) {
            assertTrue(sets.getNewEmployerSet().contains(s));
        }
    }

}