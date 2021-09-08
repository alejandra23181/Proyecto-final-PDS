package com.example.servicebookings.controller;

import com.example.servicebookings.entities.Bookings;
import com.example.servicebookings.services.BookingService;
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

    private final BookingService bookingService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@Valid @RequestBody Bookings bookings, BindingResult result) {
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        bookingService.save(bookings);
        return builder.success(bookings);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bookings> delete(@PathVariable() Long id) {
        Bookings bookings = bookingService.findById(id);
        if (bookings == null) {
            return ResponseEntity.notFound().build();
        }
        bookingService.delete(bookings);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping
    public ResponseEntity<List<Bookings>> findAll(){
        List<Bookings> bookings = bookingService.findAll();
        if(bookings.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bookings> findById(@PathVariable("id") Long id){
        Bookings bookings = bookingService.findById(id);
        if(bookings==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookings);
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

