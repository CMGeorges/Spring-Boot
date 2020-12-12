package org.camsley.dvdstore.core.repository;

import org.camsley.dvdstore.core.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface IMovieRepository extends CrudRepository<Movie,Long> {

//    Movie add(Movie movie);
//    List<Movie> list();
//    Movie getById(long id);

}
