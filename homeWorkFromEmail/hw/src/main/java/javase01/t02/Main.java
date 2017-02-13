package javase01.t02;

/**
 * Created by msid on 13.02.17.
 */
public class Main {
    public static void main(String[] args) {
        int result = logic(1e-3);
        System.out.println("min element number is " + result);
    }

    public static int logic(double eps) {
        double a_i=Double.MAX_VALUE;
        int i=0;
        while(a_i>=eps){
            i += 1;
            a_i = 1.0/Math.pow(i+1, 2);
            System.out.println("curent element is"  + a_i);
        }
        return i;
    }
}
