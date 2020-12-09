package org.camsley.dvdstore.repository.memory;

import org.camsley.dvdstore.entity.Movie;
import org.camsley.dvdstore.repository.IMovieRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements IMovieRepository {


    private final static List<Movie> movies= new ArrayList<>();

    @Override
    public void add(Movie movie){
        movies.add(movie);
        System.out.println("The movie "+movie.getTitle()+" has been added.");
    }

    @Override
    public List<Movie> list() {
        return movies;
    }
}
