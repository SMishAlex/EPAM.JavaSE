package com.epam.courses.javase.msid.unit1;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IntArrayList {
    private int[] data;
    private int size;

    //region writen on the lesson

    public IntArrayList(int... data) {
        this.data = Arrays.copyOf(data, data.length);
        size = data.length;
    }

    public IntArrayList() {
        data = new int[10];
        size = 0;
    }

    public void add(int value) {
        ensureCapasity(size + 1);
        data[size] = value;
        size += 1;
    }

    public int get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }

        return data[i];
    }

    public int getSize() {
        return size;
    }

    public int maxValueInefficient() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return maxValueRec(data, 0, size);
    }


    private int maxValueRec(int[] data, int startInclusive, int endExlusive) {
        final int length = endExlusive - startInclusive;

        if (length == 1) {
            return data[startInclusive];
        } else if (length == 0) {
            return Integer.MIN_VALUE;
        }

        final int mid = startInclusive + length/2;
        return Math.max(
                maxValueRec(data, startInclusive, mid),
                maxValueRec(data, mid, endExlusive)
        );
    }

    public void sort(){
        mergeSort(data, 0, getSize(), new int[getSize()]);
    }

    public void upSort(){
        uperMergeSort(data, new int[getSize()]);
    }

    //endregion

    /**
     * Expects collection to be sorted.
     *
     * @param value value to find in collection
     * @return index of the value or -indexToInsert - 1
     */
    public int binarySearch(int value) {
        return bs(value,0,this.size);
    }

    private int bs(int value, int startInclusive, int endExclusive){
        int length=endExclusive - startInclusive;
        if (length<1){
            return -startInclusive -1;
        }
        int mid = startInclusive+(length)/2;
        if (value==data[mid]){
            return mid;
        }
        return value>data[mid]?
                bs(value,mid+1, endExclusive):
                bs(value,startInclusive,mid);
    }

    private void uperMergeSort(int[] data, int[] free){
        int curSize;
        for(curSize=1;curSize<data.length;curSize<<=1){
            for(int start=0;start<data.length;start+=curSize*2){
                int endExclusiv = Math.min(start+curSize*2,data.length);
                int mid = start+curSize;
                merger(data,start,mid,endExclusiv,free);
            }
        }
    }

    //region writen on the lesson too
    private static void mergeSort(int[] data, int startInclusive, int endExclusive, int[] free) {
        final int length = endExclusive - startInclusive;
        if (length <= 1) {
            return;
        }

        final int mid = startInclusive + length/2;

        mergeSort(data, startInclusive, mid, free);
        mergeSort(data, mid, endExclusive, free);

        merger(data, startInclusive, mid, endExclusive, free);
    }

    private static void merger(int[] data, int startInclusive, int mid, int endExclusive, int[] free) {
        System.arraycopy(data, startInclusive, free, startInclusive, endExclusive - startInclusive);

        int i = startInclusive;
        int j = mid;
        for (int k = startInclusive; k < endExclusive; k++) {
            if (i >= mid) data[k] = free[j++];
            else if (j >= endExclusive) data[k] = free[i++];
            else if (free[i] < free[j]) data[k] = free[i++];
            else data[k] = free[j++];
        }
    }

    private void ensureCapasity(int requiredCapacity) {
        if (requiredCapacity <= getCapacity()) {
            return;
        }
        final int newCapasity = Math.max(requiredCapacity, (getCapacity() * 3) / 2 + 1);
        data = Arrays.copyOf(data, newCapasity);
    }

    private int getCapacity() {
        return data.length;
    }

    //endregion
}