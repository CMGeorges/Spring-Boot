package org.camsley.dvdstore.core.repository;

import org.camsley.dvdstore.core.entity.Movie;

import java.util.List;

public interface IMovieRepository {

    void add(Movie movie);
    List<Movie> list();
    Movie getById(long id);
}
