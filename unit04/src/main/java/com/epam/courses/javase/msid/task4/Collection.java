package com.epam.courses.javase.msid.task4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Collection implements Serializable {
    private List<Actor> actors;
    private List<Film> films;

    Collection() {
        actors = new ArrayList<>();
        films = new ArrayList<>();
    }

    public void addFilm(Film film) {
        films.add(film);
        film.getActors().forEach(actor -> {
            if (!actors.contains(actor)) {
                actors.add(actor);
            }
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Collection)) return false;

        Collection that = (Collection) o;

        return films.equals(that.films);
    }

    @Override
    public int hashCode() {
        return films.hashCode();
    }

    @Override
    public String toString() {
        return "Collection{" +
                "actors=" + actors +
                ", films=" + films +
                '}';
    }
}
