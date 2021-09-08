package com.example.servicebookings.services;

import com.example.servicebookings.entities.Bookings;
import com.example.servicebookings.repositories.BookingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingsServiceImpl implements BookingService{

    private final BookingsRepository bookingsRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Bookings bookings) {
        bookingsRepository.save(bookings);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Bookings bookings) {
        bookingsRepository.delete(bookings);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Bookings> findAll() {
        return bookingsRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Bookings findById(Long id) {
        return bookingsRepository.findById(id).orElse(null);
    }
}
