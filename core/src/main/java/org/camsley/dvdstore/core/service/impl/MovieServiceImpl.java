package org.camsley.dvdstore.core.service.impl;

import org.camsley.dvdstore.core.entity.Movie;
import org.camsley.dvdstore.core.repository.IMovieRepository;
import org.camsley.dvdstore.core.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    public IMovieRepository movieRepository;

    public IMovieRepository getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void registerMovie(Movie movie) {
        movieRepository.add(movie);
    }

    @Override
    public List<Movie> getMovieList() {
        return movieRepository.list();
    }
}
