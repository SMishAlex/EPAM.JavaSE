package javase01.t05;

import java.util.Arrays;

/**
 * Created by msid on 13.02.17.
 */
public class Matrix {
    final int[][] data;
    final public int N;

    /**
     * create matrix NxN
     * @param n
     */
    public Matrix(int n){
        N=n;
        data = new int[n][];
        for(int i=0;i<n;i++){
           data[i]=new int[n];
        }
    }

    public Matrix(int n, int diagonalsValue){
        this(n);
        for(int i=0;i<n;i++){
            data[i][i]=diagonalsValue;
            data[i][n-i-1]= diagonalsValue;
        }
    }

    public void print(){
        System.out.println(Arrays.deepToString(data));
    }
}
