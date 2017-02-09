package com.epam.courses.javase.msid.unit1;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by msid on 2/9/2017.
 */
public class Set64Test {

    @Test
    public void add() throws Exception {
        final Set64 set = new Set64();

        assertFalse(set.contains(0));

        set.add(0);

        assertTrue(set.contains(0));

        assertFalse(set.contains(15));

        set.add(15);
        set.add(15);

        assertTrue(set.contains(15));

        set.add(-1);
        assertFalse(set.contains(-1));
        set.add(64);
        assertFalse(set.contains(64));
    }

    @Test
    public void remove() throws Exception {
        final Set64 set = new Set64();
        assertFalse(set.contains(0));
        set.add(0);
        assertTrue(set.contains(0));
        set.add(0);
        set.remove(0);
        assertFalse(set.contains(0));
    }

    @Test
    public void contains() throws Exception {
        final Set64 set = new Set64();
        for (int i = -1; i < 65; i++) {
            assertFalse(set.contains(i));
        }

        set.add(-1);
        set.add(-1);
        set.add(0);
        set.add(0);
        set.add(64);
        set.add(64);
        set.add(63);
        set.add(7);
        set.add(45);

        assertFalse(set.contains(13));

        for (int i = -1; i < 65; i++) {
            if (i == 0 || i == 7 || i == 45 || i == 63) {
                assertTrue(set.contains(i));
            } else {
                assertFalse("At index " + i, set.contains(i));
            }
        }
    }

    @Test
    public void union() throws Exception {
        Set64 set1 = new Set64(10, 44, 60);
        Set64 set2 = new Set64(15, 32, 11);
        Set64 union = set1.union(set2);
        for (int i = -1; i < 65; i++) {
            if (i == 10 || i == 44 || i == 60 || i == 15 || i==32||i==11) {
                assertTrue(union.contains(i));
            } else {
                assertFalse("At index " + i, union.contains(i));
            }
        }

    }

    @Test
    public void intersect() throws Exception {
        Set64 set1 = new Set64(10, 44, 60);
        Set64 set2 = new Set64(44, 10, 11);
        Set64 intersect = set1.intersect(set2);
        for (int i = -1; i < 65; i++) {
            if (i == 10 || i == 44 ) {
                assertTrue(intersect.contains(i));
            } else {
                assertFalse("At index " + i, intersect.contains(i));
            }
        }
    }

}