package com.example.servicebookings.repositories;

import com.example.servicebookings.entities.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long> {
    Optional<Bookings> findById(Long id);

}
