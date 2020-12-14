package org.camsley.dvdstore.core.service.impl;

import org.camsley.dvdstore.core.entity.Movie;
import org.camsley.dvdstore.core.repository.IMovieRepository;
import org.camsley.dvdstore.core.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
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
    public Movie registerMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    @Override
    public Iterable<Movie> getMovieList() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        Optional<Movie> optionalMovie= movieRepository.findById(id);
        if (optionalMovie.isEmpty()) {
            throw new NoSuchElementException();
        }
        Movie movie= optionalMovie.get();
        //Initialize proxys

        movie.getReviews().forEach(review->{
            review.getMark();
            review.setMovie(null);
        });


        return movie;
    }
}
