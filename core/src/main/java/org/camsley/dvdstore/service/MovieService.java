package org.camsley.dvdstore.service;

import org.camsley.dvdstore.entity.Movie;

import java.util.List;

public interface MovieService {


     void registerMovie(Movie movie);
     List<Movie> getMovieList();
}
