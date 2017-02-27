package com.epam.courses.javase.msid.unit02.task5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by msid on 27.02.17.
 */
public class SubjectTest {
    @Test
    public void testAddedStudent(){
        Student student = new Student("Some Name");
        Subject<Integer> subject = new Subject<Integer>("Math", "Someone");
        subject.addStudent(student);
        assertTrue(subject.getGroup().containsKey(student));
        assertTrue(student.getSubjects().contains(subject));
    }
}