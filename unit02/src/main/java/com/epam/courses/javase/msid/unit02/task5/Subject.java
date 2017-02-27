package com.epam.courses.javase.msid.unit02.task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Subject<T extends Number> {

    private final String title;
    private String teacher;
    Map<Student, List<T>> group;

    public Subject(String title, String teacher) {
        this.title = title;
        this.teacher = teacher;
        group = new HashMap<Student, List<T>>();
    }

    public void addStudent(Student student) {
        group.put(student, new ArrayList<T>());
        student.addSubject(this);
    }

    public void excludeStudent(Student student) {
        group.remove(student);
        student.removeSubject(this);
    }

    public void changeTeacher(String newTeacherName) {
        teacher = newTeacherName;
    }

    public String getTeacherName() {
        return teacher;
    }

    public String getTitle() {
        return title;
    }

    public Map<Student, List<T>> getGroup() {
        HashMap<Student, List<T>> dst = new HashMap<Student, List<T>>();
        dst.putAll(group);
        return dst;
    }

    public void evaluateStudent(Student student, T mark) {
        studentMarks(student).add(mark);
    }

    private List<T> studentMarks(Student student) {
        if (!group.containsKey(student))
            throw new IllegalArgumentException("there is no such student");
        List<T> marks = group.get(student);
        return marks;
    }

    public List<T> getStudentsMarks(Student student) {
        List<T> marks = studentMarks(student);
        List dst = new ArrayList(marks);
        return dst;

    }
}
