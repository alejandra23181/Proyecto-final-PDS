package com.example.servicebookings.services;

import com.example.servicebookings.entities.Bookings;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    void save(Bookings bookings);
    void delete(Bookings bookings);
    List<Bookings> findAll();
    Optional<Bookings> findById(Long id);
}
