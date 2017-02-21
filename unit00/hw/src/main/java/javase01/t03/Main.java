package javase01.t03;

/**
 * Created by msid on 13.02.17.
 */
public class Main {
    static double f(double x){
        return Math.tan(2*x) -3;
    }

    static void printTable(double a, double b, double h){
        System.out.println("   X     |   F(x)     ");
        for(double curX=a; curX<=b; curX+=h){
            System.out.println("    " + curX + "      |   " + f(curX));
        }
    }

    public static void main(String[] args) {
        printTable(0,10,0.01);
    }
}
