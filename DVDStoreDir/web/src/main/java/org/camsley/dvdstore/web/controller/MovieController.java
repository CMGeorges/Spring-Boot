package org.camsley.dvdstore.web.controller;

import org.camsley.dvdstore.core.entity.Actor;
import org.camsley.dvdstore.core.entity.Movie;
import org.camsley.dvdstore.core.service.MovieService;
import org.camsley.dvdstore.web.form.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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

//    @GetMapping("/{id}")
//    public String displayMovieCard(@PathVariable("id")Long id, Model model){
//
//        model.addAttribute("movie",movieService.getMovieById(id));
//        return "movie-details";
//    }

    @PostMapping("/add")
    @Transactional
    public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult results){

        if (results.hasErrors() ) {
            return "dvdstore-add-movie-form";
        }

        Movie movie = new Movie();
        movie.setTitle(movieForm.getTitle());
        movie.setGenre(movieForm.getGenre());
        Actor actor = new Actor(movieForm.getFirstName(),movieForm.getName());
        movie.setMainActor(actor);
        movie.setDescription(movieForm.getDescription());

            movieService.registerMovie(movie);
        return "movie-added";

    }






}
