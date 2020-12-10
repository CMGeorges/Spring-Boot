package org.camsley.dvdstore.core.repository.memory;

import org.camsley.dvdstore.core.entity.Movie;
import org.camsley.dvdstore.core.repository.IMovieRepository;

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
