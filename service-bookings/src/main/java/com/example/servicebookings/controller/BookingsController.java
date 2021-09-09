package com.example.servicebookings.controller;

import com.example.servicebookings.entities.Bookings;
import com.example.servicebookings.services.BookingService;
import com.example.servicebookings.services.BookingsServiceImpl;
import com.example.servicebookings.utils.ErrorMessage;
import com.example.servicebookings.utils.Response;
import com.example.servicebookings.utils.ResponseBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingsController {

    private final BookingsServiceImpl bookingsService;
    private final ResponseBuilder builder;

    @PostMapping()
    public Response save(@Valid @RequestBody Bookings bookings, BindingResult result) {
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        bookingsService.save(bookings);
        return builder.success(bookings);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable() Long id) {
        Bookings bookings = bookingsService.findByNumberBooking(id);
        if (bookings == null) {
            return builder.failed(bookings);
        }
        return builder.success(bookings);
    }

    @GetMapping("/{id}")
    public Response getByNumberBooking(@PathVariable("id") Long id){
        Bookings bookings = bookingsService.findByNumberBooking(id);
        if(bookings==null){
            return builder.success();
        }
        return builder.success(bookings);
    }

    private String formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());

        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try{
            json = objectMapper.writeValueAsString(errorMessage);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return json;
    }

}

