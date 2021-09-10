package com.example.servicebookings.model;

import lombok.Data;

@Data
public class Movie {
    private Long id;
    private String title;
    private String director;
    private Integer rating;
}
