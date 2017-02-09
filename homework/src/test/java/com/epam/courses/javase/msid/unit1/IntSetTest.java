package com.epam.courses.javase.msid.unit1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by msid on 2/9/2017.
 */
public class IntSetTest {
    @Test
    public void add() throws Exception {
        IntSet intSet = new IntSet();
        intSet.add(-6);
        assertTrue(intSet.contains(-6));
        intSet.add(0);
        assertTrue(intSet.contains(0));
        intSet.add(Integer.MAX_VALUE);
        assertTrue(intSet.contains(Integer.MAX_VALUE));
        intSet.add(Integer.MIN_VALUE);
        assertTrue(intSet.contains(Integer.MIN_VALUE));
        intSet.add(-1);
        assertTrue(intSet.contains(-1));
    }


    @Test
    public void add2(){
        IntSet intSet = new IntSet(10, 44, 56, -10, -20);
        assertTrue(intSet.contains(10));
        assertTrue(intSet.contains(44));
        assertTrue(intSet.contains(56));
        assertTrue(intSet.contains(-10));
        assertTrue(intSet.contains(-20));
    }


    @Test
    public void remove() throws Exception {
        IntSet intSet = new IntSet(10, 0, 1, -1, Integer.MAX_VALUE, Integer.MIN_VALUE);
        intSet.remove(10);
        assertFalse(intSet.contains(10));
        assertTrue(intSet.contains(0));
        assertTrue(intSet.contains(1));
        assertTrue(intSet.contains(-1));
        assertTrue(intSet.contains(Integer.MAX_VALUE));
        assertTrue(intSet.contains(Integer.MIN_VALUE));

        intSet.remove(Integer.MAX_VALUE);
        assertFalse(intSet.contains(Integer.MAX_VALUE));
        intSet.remove(Integer.MIN_VALUE);
        assertFalse(intSet.contains(Integer.MIN_VALUE));
        intSet.remove(-1);
        assertFalse(intSet.contains(-1));

        assertTrue(intSet.contains(0));
        assertTrue(intSet.contains(1));
    }

    @Test
    public void contains() throws Exception {

    }

    @Test
    public void union() throws Exception {
        IntSet set1 = new IntSet(10, 20, 30,-10,100,Integer.MAX_VALUE);
        IntSet set2 = new IntSet(40, 50, 60,-100);

        IntSet union = set1.union(set2);

        assertTrue(union.contains(10));
        assertTrue(union.contains(20));
        assertTrue(union.contains(30));
        assertTrue(union.contains(40));
        assertTrue(union.contains(50));
        assertTrue(union.contains(60));
        assertTrue(union.contains(-10));
        assertTrue(union.contains(-100));
        assertTrue(union.contains(100));
        assertTrue(union.contains(Integer.MAX_VALUE));
    }

    @Test
    public void intersection() throws Exception {
        IntSet set1 = new IntSet(10, 40, 30,-10,100,Integer.MAX_VALUE);
        IntSet set2 = new IntSet(40, 50, 60,100);

        IntSet intrsection = set1.intersection(set2);

        assertFalse(intrsection.contains(10));
        assertFalse(intrsection.contains(20));
        assertFalse(intrsection.contains(30));
        assertTrue(intrsection.contains(40));
        assertFalse(intrsection.contains(50));
        assertFalse(intrsection.contains(60));
        assertFalse(intrsection.contains(-10));
        assertFalse(intrsection.contains(-100));
        assertTrue(intrsection.contains(100));
        assertFalse(intrsection.contains(Integer.MAX_VALUE));
    }

    @Test
    public void difference() throws Exception {
        IntSet set1 = new IntSet(10, 40, 30,-10,100,Integer.MAX_VALUE);
        IntSet set2 = new IntSet(40, 50, 60,100,-10);

        IntSet diff = set1.difference(set2);

        assertTrue(diff.contains(10));
        assertFalse(diff.contains(40));
        assertTrue(diff.contains(30));
        assertFalse(diff.contains(100));
        assertFalse(diff.contains(-10));
        assertTrue(diff.contains(Integer.MAX_VALUE));
    }

    @Test
    public void isSubsetOf() throws Exception {
        IntSet set = new IntSet(10, 20, 30, 40);
        IntSet subSet = new IntSet(10, 40);
        assertTrue(subSet.isSubsetOf(set));

        set = new IntSet(-10, 20, 30, 40, 200, Integer.MIN_VALUE);
        subSet = new IntSet(10, 40, Integer.MIN_VALUE);
        assertTrue(subSet.isSubsetOf(set));

        subSet.add(-100);
        assertFalse(subSet.isSubsetOf(set));

        subSet = new IntSet(10, 40, 120);
        assertFalse(subSet.isSubsetOf(set));
    }


}