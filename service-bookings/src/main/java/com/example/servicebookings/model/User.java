package com.example.servicebookings.model;


import lombok.Builder;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String lastname;
}
