package javase01.t05;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by msid on 13.02.17.
 */
public class MatrixTest {
    @Test
    public void print() throws Exception {
        Matrix matrix = new Matrix(5, 1);
        matrix.print();
    }

}