package com.epam.courses.javase.msid.task4;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Film implements Serializable {
    private List<Actor> actors;
    private String name;
    private final long budget;

    public Film(List<Actor> actors, String name, long budget) {
        this.actors = actors;
        this.name = name;
        this.budget = budget;
        actors.stream()
                .forEach((x) -> x.addFilms(this));
    }

    public Film(String name, long budget, Actor... actors) {
        this(Arrays.asList(actors), name, budget);
    }

    List<Actor> getActors() {
        return new ArrayList<>(actors);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBudget() {
        return budget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;

        Film film = (Film) o;

        if (budget != film.budget) return false;
        if (!actors.equals(film.actors)) return false;
        return name.equals(film.name);
    }

    @Override
    public int hashCode() {
        int result = actors.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (int) (budget ^ (budget >>> 32));
        return result;
    }
}
