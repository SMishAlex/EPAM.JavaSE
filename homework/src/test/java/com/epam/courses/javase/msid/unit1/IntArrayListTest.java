package com.epam.courses.javase.msid.unit1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by msid on 2/9/2017.
 */
public class IntArrayListTest {
    @Test
    public void binarySearch() throws Exception {
        IntArrayList list = new IntArrayList(1, 3, 5, 7, 9);
        list.sort();
        assertEquals(2, list.binarySearch(5));
        assertEquals(-3, list.binarySearch(4));
        assertEquals(-1, list.binarySearch(0));
        assertEquals(0, list.binarySearch(1));
        assertEquals(-6, list.binarySearch(500));
        assertEquals(4,list.binarySearch(9));

        assertEquals(9, list.get(list.binarySearch(9)));

    }

}