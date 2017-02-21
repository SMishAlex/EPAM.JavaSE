package com.epam.courses.javase.msid.unit1;
//`remove`, `contains`, `union`, `intersection`, `difference`, `isSubsetOf`

import java.util.Arrays;

// TODO: 2/9/2017 Write java doc
/**
 *
 */
public class IntSet {
    private long[] positivData;
    private long[] negativData;

    public IntSet(){
        this(new int[0]);
    }

    public IntSet(int... ints){
        positivData = new long[1];
        negativData = new long[1];
        for(int i:ints){
            this.add(i);
        }
    }

    public void add(int value){
        if(value>=0){
            addPositiv(value);
        }
        else addNegativ(value);
    }


    private void addNegativ(int value) {
        value = -(value + 1);
        //nameToRefactor(value,negativData);
        if(negativData.length*64<value){
            negativData = Arrays.copyOf(negativData, value / 64 +1);
        }
        negativData[value/64] |= 1L<<(value%64);
    }

    private void addPositiv(int value) {
        if(positivData.length*64<value){
            positivData = Arrays.copyOf(positivData, value / 64 +1);
        }
        positivData[value/64] |= 1L<<(value%64);
    }

    public void remove(int value){
        if(!this.contains(value)){
            return;
        }
        long[] ref;
        if(value<0){
            ref = negativData;
            value=-(value+1);
        } else {
            ref=positivData;
        }
        long mask = 1L<<(value%64);
        ref[value/64]&= ~mask;
    }

    public boolean contains(int value){
        long[] ref;
        if(value<0){
            ref = negativData;
            value=-(value+1);
        } else {
            ref=positivData;
        }
        if (value>ref.length*64L) {
            return false;
        }
        long mask = 1L<<(value%64);
        return (ref[value/64]&mask)!=0;
    }

    public IntSet union(IntSet other){
        IntSet dstSet = new IntSet();

        long[] maxPositiv = this.positivData.length>other.positivData.length ?
                this.positivData
                :other.positivData;

        int maxPositivLen = maxPositiv.length;
        dstSet.positivData = new long[maxPositivLen];
        for(int i=0;i<maxPositivLen;i++){
            if((i<this.positivData.length)&&(i<other.positivData.length)) {
                dstSet.positivData[i] = this.positivData[i] | other.positivData[i];
            } else{
                dstSet.positivData[i] = maxPositiv[i];
            }
        }

        long[] maxNegativ = this.negativData.length>other.negativData.length ?
                this.negativData
                :other.negativData;

        int maxNegativLen = maxNegativ.length;
        dstSet.negativData = new long[maxNegativLen];
        for(int i=0;i<maxNegativLen;i++){
            if((i<this.negativData.length)&&(i<other.negativData.length)) {
                dstSet.negativData[i] = this.negativData[i] | other.negativData[i];
            } else{
                dstSet.negativData[i] = maxNegativ[i];
            }
        }
        return dstSet;
    }

    public IntSet intersection(IntSet other){
        IntSet dstSet = new IntSet();

        long[] minPositiv = this.positivData.length<other.positivData.length ?
                this.positivData
                :other.positivData;

        int minPositivLen = minPositiv.length;
        dstSet.positivData = new long[minPositivLen];
        for(int i=0;i<minPositivLen;i++){
            dstSet.positivData[i] = this.positivData[i] & other.positivData[i];
        }

        long[] minNegativ = this.negativData.length<other.negativData.length ?
                this.negativData
                :other.negativData;

        int minNegativLen = minNegativ.length;
        dstSet.negativData = new long[minNegativLen];
        for(int i=0;i<minNegativLen;i++){
            dstSet.negativData[i] = this.negativData[i] & other.negativData[i];
        }
        return dstSet;
    }

    public IntSet difference(IntSet other){
        IntSet dstSet = new IntSet();

        dstSet.positivData = new long[this.positivData.length];
        for(int i=0;i<this.positivData.length;i++){
            if(i<other.positivData.length) {
                dstSet.positivData[i] = this.positivData[i] & ~other.positivData[i];
            } else {
                dstSet.positivData[i] = this.positivData[i];
            }
        }
        dstSet.negativData = new long[this.negativData.length];
        for(int i=0;i<this.negativData.length;i++){
            if(i<other.negativData.length) {
                dstSet.negativData[i] = this.negativData[i] & ~other.negativData[i];
            } else {
                dstSet.negativData[i] = this.negativData[i];
            }
        }

        return dstSet;
    }

    public boolean isSubsetOf(IntSet other){
        boolean subPositiv = isSubset(this.positivData,other.positivData);
        boolean subNegativ = isSubset(this.negativData, other.negativData);
        return  subNegativ&&subPositiv;
    }

    private boolean isSubset(long[] subSet, long[] set){
        if(subSet.length>set.length){
            return false;
        }
        for(int i=0;i<subSet.length;i++){
            if(subSet[i]!=0&&(subSet[i]&set[i])==0){
                return false;
            }
        }
        return true;
    }

}
