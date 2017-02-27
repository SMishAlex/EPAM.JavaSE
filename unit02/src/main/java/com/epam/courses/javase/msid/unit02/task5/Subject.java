package com.epam.courses.javase.msid.unit02.task5;

import java.util.ArrayList;
import java.util.List;


public class Subject {

    private final String title;
    private String teacher;
    private List<Student> group;

    public Subject(String title, String teacher) {
        this.title = title;
        this.teacher = teacher;
        group = new ArrayList<>();
    }

    public void addStudent(Student student) {
        group.add(student);
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

    public List<Student> getGroup() {
        List<Student> dst = new ArrayList<>();
        dst.addAll(group);
        return dst;
    }
}
