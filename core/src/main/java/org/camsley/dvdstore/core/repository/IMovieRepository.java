package org.camsley.dvdstore.core.repository;

import org.camsley.dvdstore.core.entity.Movie;

import java.util.List;

public interface IMovieRepository {

    Movie add(Movie movie);
    List<Movie> list();
    Movie getById(long id);

}
