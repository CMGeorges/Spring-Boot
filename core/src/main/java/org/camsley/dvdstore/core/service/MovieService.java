package org.camsley.dvdstore.core.service;

import org.camsley.dvdstore.core.entity.Movie;

import java.util.List;

public interface MovieService {


     Movie registerMovie(Movie movie);
     List<Movie> getMovieList();
     Movie getMovieById(long id);
}
