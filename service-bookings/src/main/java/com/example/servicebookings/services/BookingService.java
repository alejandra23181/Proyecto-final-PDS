package com.example.servicebookings.services;

import com.example.servicebookings.entities.Bookings;

import java.util.List;

public interface BookingService {

    void save(Bookings bookings);
    void delete(Bookings bookings);
    List<Bookings> findAll();
    Bookings findById(Long id);
    Bookings findByNumberBooking(Long id);
}
