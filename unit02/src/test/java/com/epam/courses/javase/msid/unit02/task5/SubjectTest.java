package com.epam.courses.javase.msid.unit02.task5;

import com.epam.courses.javase.msid.unit02.task1.Pen;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test
    public void testEvaluateStudent() {
        Student student = new Student("Some Name");
        Subject<Integer> subject = new Subject<Integer>("Math", "Someone");
        subject.addStudent(student);
        Integer mark = new Integer(5);
        subject.evaluateStudent(student, mark);
        assertTrue(subject.getStudentsMarks(student).contains(mark));
    }

    @Test
    public void testNoEvaluatedStudentInGroupException() {

        Student student = new Student("Some Name");
        Subject<Integer> subject = new Subject<Integer>("Math", "Someone");
        subject.addStudent(student);
        Integer mark = new Integer(5);

        boolean catchException = false;
        Student otherStudent = new Student("Some Name");
        try {
            subject.evaluateStudent(otherStudent, mark);
        }
        catch (IllegalArgumentException e){
            catchException = true;
            System.out.println(e);
        }
        assertTrue(catchException);

    }
}