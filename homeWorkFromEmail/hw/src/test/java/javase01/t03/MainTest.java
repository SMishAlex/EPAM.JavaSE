package javase01.t03;

import javase01.t02.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by msid on 13.02.17.
 */
public class MainTest {
    @Test
    public void f() throws Exception {
        for(int i=0; i<10;i++){
            assertEquals(Main.f(Math.PI*i),Main.f(Math.PI*(i+1)), 1e-15);
        }
    }

}