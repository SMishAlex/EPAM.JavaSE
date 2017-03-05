package com.epam.courses.javase.msid.task4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Actor implements Serializable {
    private String name;
    private List<Film> films;

    public Actor(String name) {
        this.name = name;
        films = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Film> getFilms() {
        return new ArrayList<>(films);
    }

    public void addFilms(Film film) {
        this.films.add(film);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;

        Actor actor = (Actor) o;

        return name.equals(actor.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
