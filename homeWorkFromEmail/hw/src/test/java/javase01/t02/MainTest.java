package javase01.t02;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by msid on 13.02.17.
 */
public class MainTest {
    @Test
    public void test(){
        assertTrue(Main.logic(1.0/4) == 2 );
        for(int i=1;i<10;i++){
            assertEquals(""+i, i+1, Main.logic(1.0/Math.pow(i+1,2)));
        }
    }

}