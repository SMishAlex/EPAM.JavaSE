package com.epam.courses.javase.msid.unit1;


public class Set64 {

    private long data;

    public Set64() {
        this(0b0);
    }

    public Set64(int ... data){
        this();
        for(int i:data){
            this.add(i);
        }
    }

    private Set64(long data) {
        this.data = data;
    }

    public void add(int value) {
        if (value < 0 || value > 63) {
            return;
        }

        data |= 1L << value;
    }

    public void remove(int value) {
        if (value < 0 || value > 63) {
            return;
        }

        data &= ~(1L << value);
    }

    public boolean contains(int value) {
        if (value < 0 || value > 63) {
            return false;
        }

        final long mask = 1L << value;
        final long res = data & mask;
        return res != 0;
    }

    public Set64 union(Set64 other) {
        final long result = this.data | other.data;
        return new Set64(result);
    }

    public Set64 intersect(Set64 other) {
        final long result = this.data & other.data;
        return new Set64(result);
    }

}
