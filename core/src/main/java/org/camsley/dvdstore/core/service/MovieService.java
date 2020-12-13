package org.camsley.dvdstore.core.service;

import org.camsley.dvdstore.core.entity.Movie;

public interface MovieService {

     Movie registerMovie(Movie movie);
     Iterable<Movie> getMovieList();
     Movie getMovieById(Long id);
}
