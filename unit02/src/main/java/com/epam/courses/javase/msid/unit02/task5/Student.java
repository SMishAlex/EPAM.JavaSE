package com.epam.courses.javase.msid.unit02.task5;

import java.util.ArrayList;
import java.util.List;

// TODO: 27.02.17 write documentation
public class Student {
    private String name;

    private List<Subject> subjects;

    public Student(String name) {
        this.name = name;
        subjects = new ArrayList<>();
    }


    public List<Subject> getSubjects() {
        List<Subject> dst = new ArrayList<>();
        dst.addAll(subjects);
        return dst;
    }

    void addSubject(Subject subject) {
        subjects.add(subject);
    }

    void removeSubject(Subject subject) {
        subjects.remove(subject);
    }

    public String getName() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public boolean isStating(Subject subject){
        return subjects.contains(subject);
    }

    @Override
    public String toString(){
        return name;
    }

}
