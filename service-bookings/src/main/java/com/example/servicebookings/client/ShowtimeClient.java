package com.example.servicebookings.client;

import com.example.servicebookings.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "service-showtimes")
public interface ShowtimeClient {

    @GetMapping("/showtimes/{id}")
    Response findById(@PathVariable("id") Long id);

}
