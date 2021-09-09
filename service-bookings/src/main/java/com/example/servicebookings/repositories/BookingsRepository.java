package com.example.servicebookings.repositories;

import com.example.servicebookings.entities.Bookings;
import com.example.servicebookings.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long> {
    List<Bookings> findByUserId(Long userId);
    Bookings findByNumberBooking(Long id);
}