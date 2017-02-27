package com.epam.courses.javase.msid.unit02.task5;

import com.epam.courses.javase.msid.unit02.task1.Pen;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by msid on 27.02.17.
 */
public class SubjectTest {

    @Test
    public void testAddedStudent() {
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
        } catch (IllegalArgumentException e) {
            catchException = true;
            System.out.println(e);
        }
        assertTrue(catchException);

    }

    @Test
    public void testRemovingStudentThatNotInThatGroupException() {
        Student student = new Student("Some Name");
        Subject<Integer> subject = new Subject<Integer>("Math", "Someone");
        subject.addStudent(student);
        boolean catchException = false;
        Student otherStudent = new Student("Some Name");
        try {
            subject.excludeStudent(otherStudent);
        } catch (IllegalArgumentException e) {
            catchException = true;
            System.out.println(e);
        }
        assertTrue(catchException);
    }

    @Test
    public void testMutableGroupGetter(){
        Student student = new Student("Some Name");
        Subject<Integer> subject = new Subject<Integer>("Math", "Someone");
        subject.addStudent(student);
        Map<Student, List<Integer>> group = subject.getGroup();
        group.remove(student);
        System.out.println(group);
        assertTrue(subject.getGroup().containsKey(student));
    }

    @Test
    public void testMutableMarksGetter(){
        Student student = new Student("Some Name");
        Subject<Integer> subject = new Subject<Integer>("Math", "Someone");
        subject.addStudent(student);
        List<Integer> studentsMarks = subject.getStudentsMarks(student);
        Integer mark = new Integer(5);
        studentsMarks.add(mark);
        System.out.println(studentsMarks);
        assertFalse(subject.getStudentsMarks(student).contains(mark));
    }
}