package org.camsley.dvdstore.controller;

import org.camsley.dvdstore.entity.Movie;
import org.camsley.dvdstore.service.MovieService;
import org.camsley.dvdstore.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;

    public MovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    public void addUsingConsole(){
        System.out.println( "What is the title??" );
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.println( "What is the genre??" );
        String genre = scanner.nextLine();
        Movie movie= new Movie(title,genre);
        movieService.registerMovie(movie);
    }


}
