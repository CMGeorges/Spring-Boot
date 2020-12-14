package org.camsley.dvdstore.web.api;

import org.camsley.dvdstore.core.entity.Movie;
import org.camsley.dvdstore.core.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    @Autowired
    private MovieService movieService;

    public MovieResource(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable("id")Long id){
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Movie add(@RequestBody Movie movie){
//
       return movieService.registerMovie(movie);

    }

    @GetMapping
    public Iterable<Movie> list(){
        return movieService.getMovieList();
    }





}
