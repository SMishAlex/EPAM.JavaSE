package com.epam.courses.javase.msid.unit02.task4;

import com.epam.courses.javase.msid.unit02.task2.Stationery;

import java.util.Comparator;

/**
 * Created by msid on 26.02.17.
 */
public class Comparators {
    public static class CostComparator implements Comparator<Stationery> {

        @Override
        public int compare(Stationery o1, Stationery o2) {
            if (o1.getCost() == o2.getCost()) {
                return 0;
            }
            return o1.getCost() > o2.getCost() ? +1 : -1;
        }
    }

    public static class NameComparator implements Comparator<Stationery>{

        @Override
        public int compare(Stationery o1, Stationery o2) {
            String o1Name = o1.getClass().toString();
            String o2Name = o2.getClass().toString();
            return o1Name.compareTo(o2Name);
        }
    }

    public static class CostAndNameComparator implements Comparator<Stationery>{

        @Override
        public int compare(Stationery o1, Stationery o2) {
            if (o1.getCost() == o2.getCost()) {
                String o1Name = o1.getClass().toString();
                String o2Name = o2.getClass().toString();
                return o1Name.compareTo(o2Name);
            }
            return o1.getCost() > o2.getCost() ? +1 : -1;
        }
    }
}
