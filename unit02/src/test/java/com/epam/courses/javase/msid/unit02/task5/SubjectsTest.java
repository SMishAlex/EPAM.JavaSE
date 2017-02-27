package com.epam.courses.javase.msid.unit02.task5;

import org.junit.Test;

import static com.epam.courses.javase.msid.unit02.task5.Subjects.MATH;
import static com.epam.courses.javase.msid.unit02.task5.Subjects.PHYSICS;
import static org.junit.Assert.*;

/**
 * Created by msid on 27.02.17.
 */
public class SubjectsTest {

    @Test
    public void testNotSameObject() {
        Student student = new Student("Name");
        MATH.MANAGE.addStudent(student);
        MATH.MANAGE.evaluateStudent(student, 5);
        assertTrue(MATH.MANAGE.getGroup().containsKey(student));
        assertTrue(PHYSICS.MANAGE.getGroup().isEmpty());
    }

}