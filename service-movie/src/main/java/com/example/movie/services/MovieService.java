package com.example.movie.services;


import com.example.movie.entities.Movie;

import java.util.List;

public interface MovieService {

    void save(Movie movie);
    void delete(Movie movie);
    List<Movie> findAll();
    Movie findById(Long id);
}
