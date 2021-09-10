package com.example.servicebookings.client;

import com.example.servicebookings.model.Movie;
import com.example.servicebookings.model.User;
import com.example.servicebookings.utils.Response;
import com.example.servicebookings.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieClientFallBack implements MovieClient{

    private final ResponseBuilder builder;

    @Override
    public Response findById(Long id) {
        Movie movie = new Movie();
        return builder.success(movie);
    }

}
