package com.example.movieapii3.controller;

import com.example.movieapii3.entity.Movie;
import com.example.movieapii3.service.MovieService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000") 
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Simple GET endpoint to test if the server is running
    @GetMapping("/hello")
    public String sayHello() {
        return "Welcome to the Movie API!";
    }

    // POST request to add movies using the Movie entity
    @PostMapping("/movies")
    public String createMovie(@RequestBody Movie movie) {
        // Call the service to save the movie
        movieService.saveMovie(movie);
        return "Movie added successfully!";
    }
 

    @GetMapping("/movies/{id}")
public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
    return null;
    }

  
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        // Your logic to return a list of movies
        return movieService.getAllMovies();
    }

}

