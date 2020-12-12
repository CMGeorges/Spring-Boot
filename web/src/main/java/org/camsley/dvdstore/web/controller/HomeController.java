package org.camsley.dvdstore.web.controller;

import org.camsley.dvdstore.core.entity.Movie;
import org.camsley.dvdstore.core.service.MovieService;
import org.camsley.dvdstore.web.form.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    @Autowired
    private MovieService movieService;

    public MovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/dvdstore-home")
    public @ModelAttribute("movies")Iterable<Movie> displayHome(){
        Iterable<Movie> movies = movieService.getMovieList();

        return movies;
    }

    @GetMapping("/add-movie-form")
    public String displayMovieForm(@ModelAttribute MovieForm movieForm){

        return "dvdstore-add-movie-form";
    }


}
