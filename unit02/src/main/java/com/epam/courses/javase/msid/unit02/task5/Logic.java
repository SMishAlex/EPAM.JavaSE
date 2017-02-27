package com.epam.courses.javase.msid.unit02.task5;

import java.util.Random;

import static com.epam.courses.javase.msid.unit02.task5.Subjects.MATH;
import static com.epam.courses.javase.msid.unit02.task5.Subjects.PHYSICS;

/**
 * Created by msid on 27.02.17.
 */
public class Logic {
    public static void main(String[] args) {
        Student student = new Student("Vasia");
        initial(student);
        makeRandomMarks(student, 5);
        System.out.println(student+":");
        for(Subjects s:Subjects.values()){
            if(student.isStating(s.MANAGE))
            System.out.println(s);
            System.out.println(s.MANAGE.getStudentsMarks(student));
        }

    }

    private static void makeRandomMarks(Student student, int value) {
        Random r = new Random(2);
        for (int i = value; i > 0; i--) {
            for (Subject subject : student.getSubjects()) {
                subject.evaluateStudent(student, r.nextInt(3)+2);
            }
        }
    }

    private static void initial(Student student) {
        MATH.MANAGE.addStudent(student);
        PHYSICS.MANAGE.addStudent(student);
    }


}
