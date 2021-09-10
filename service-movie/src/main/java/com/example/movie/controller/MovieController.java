package com.example.movie.controller;

import co.com.poli.commons.Librery.FormatMessage;
import co.com.poli.commons.Librery.Response;
import co.com.poli.commons.Librery.ResponseBuilder;
import com.example.movie.entities.Movie;
import com.example.movie.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ResponseBuilder builder = new ResponseBuilder();
    private final FormatMessage message = new FormatMessage();

    @PostMapping
    public Response save(@Valid @RequestBody Movie movie, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(message.formatMessage(result));
        }
        movieService.save(movie);
        return builder.success(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> delete(@PathVariable("id") Long id){
        Movie movie = movieService.findById(id);
        if(movie==null){
            return ResponseEntity.notFound().build();
        }
        movieService.delete(movie);
        return ResponseEntity.ok(movie);
    }

    @GetMapping()
    public ResponseEntity<List<Movie>> findAll(){
        List<Movie> movies = movieService.findAll();
        if(movies.isEmpty()){
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.ok(movies);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable("id") Long id) {
        Movie movie = movieService.findById(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }


}