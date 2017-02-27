package com.epam.courses.javase.msid.unit02.task5;

/**
 * Created by msid on 27.02.17.
 */
public enum Subjects {
    MATH("Math", "Teacer"),
    PHYSICS("Physic", "Other Teacher");

    Subject<Integer> s;

    Subjects(String title, String teacher) {
        s = new Subject<>(title, teacher);
    }
    }
