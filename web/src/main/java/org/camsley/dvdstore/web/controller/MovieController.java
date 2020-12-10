package org.camsley.dvdstore.web.controller;

import org.camsley.dvdstore.core.entity.Movie;
import org.camsley.dvdstore.core.service.MovieService;
import org.camsley.dvdstore.core.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;

@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    public MovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id")Long id, Model model){

        model.addAttribute("movie",movieService.getMovieById(id));
        return "movie-details";
    }

    @PostMapping("/movie")
    public String addMovie(@ModelAttribute Movie movie){
//        movieService = new MovieServiceImpl();
            movieService.registerMovie(movie);
        return "movie-added";

    }




}
