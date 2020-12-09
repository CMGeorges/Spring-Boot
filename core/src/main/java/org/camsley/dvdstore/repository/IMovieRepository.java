package org.camsley.dvdstore.repository;

import org.camsley.dvdstore.entity.Movie;

import java.util.List;

public interface IMovieRepository {

    void add(Movie movie);
    List<Movie> list();
}
