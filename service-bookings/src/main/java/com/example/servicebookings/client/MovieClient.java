package com.example.servicebookings.client;

import com.example.servicebookings.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-movie", fallback = MovieClientFallBack.class)
public interface MovieClient {

    @GetMapping("/movies/{id}")
    Response findById(@PathVariable("id") Long id);

}
