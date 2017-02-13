package javase01.t04;

/**
 * Created by msid on 13.02.17.
 */
public class Array {
    double[] data;

    public Array(double... data){
        this.data = data;
    }

    public double getMaxPaishortr(){
        double max= Double.MIN_VALUE;
        int n=data.length;
        for(int i = 0; i < (n >> 1); i++){
            double cuple = data[i] + data [n-i-1];
            max = Math.max(cuple, max);
        }
        return max;
    }
}
