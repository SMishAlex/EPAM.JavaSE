package javase01.t04;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by msid on 13.02.17.
 */
public class ArrayTest {

    @Test
    public void getMaxPaishortr(){
        Array array = new Array(1, 2, 3, 4);
        assertEquals("",5, array.getMaxPaishortr(),1e-16);

    }

}