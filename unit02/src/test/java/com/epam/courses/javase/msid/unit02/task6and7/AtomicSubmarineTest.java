package com.epam.courses.javase.msid.unit02.task6and7;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by msid on 27.02.17.
 */
public class AtomicSubmarineTest {

    @Test
    public void testMoving() {
        AtomicSubmarine atomicSubmarine = new AtomicSubmarine(1.0);
        atomicSubmarine.speedUp(4000);
        atomicSubmarine.moveForward(10);
        atomicSubmarine.moveReverse(10);
        atomicSubmarine.changeAngle(Math.PI / 2);
        atomicSubmarine.moveForward(10);
        atomicSubmarine.moveReverse(10);
        atomicSubmarine.moveDown(10, Math.PI / 2);
        atomicSubmarine.moveUp(10, Math.PI / 2);
        AtomicSubmarine.Position pos = atomicSubmarine.getPos();
        assertEquals(pos.X, pos.Y);
        assertEquals(pos.X, pos.deep);
    }

}