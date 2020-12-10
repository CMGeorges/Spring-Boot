package org.camsley.dvdstore.web.controller;

import org.camsley.dvdstore.core.entity.Movie;
import org.camsley.dvdstore.core.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @RequestMapping("/dvdstore-home")
    public @ModelAttribute("movies")List<Movie> displayHome(){
        List<Movie> movies = movieService.getMovieList();

        return movies;
    }
}
