package org.camsley.dvdstore.core.repository;

import org.camsley.dvdstore.core.entity.Movie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IMovieRepository extends CrudRepository<Movie,Long> {

    @EntityGraph(value = "movie.actor-and-reviews", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Movie> findById(Long id);

//    Movie add(Movie movie);
//    List<Movie> list();
//    Movie getById(long id);

}
