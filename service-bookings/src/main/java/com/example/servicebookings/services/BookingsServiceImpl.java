package com.example.servicebookings.services;

import com.example.servicebookings.client.ShowtimeClient;
import com.example.servicebookings.client.UserClient;
import com.example.servicebookings.entities.Bookings;
import com.example.servicebookings.model.Showtime;
import com.example.servicebookings.model.User;
import com.example.servicebookings.repositories.BookingsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingsServiceImpl implements BookingService{

    private final BookingsRepository bookingsRepository;
    private UserClient userClient;
    private ShowtimeClient showtimeClient;

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

    @Override
    public Bookings findByNumberBooking(Long id) {
        Bookings bookings = bookingsRepository.findByNumberBooking(id);
        ModelMapper modelMapper = new ModelMapper();
        User user =
                modelMapper.map(
                        userClient.findById(bookings.getUserId()).getData(),
                        User.class);
        bookings.setUser(user);

        Showtime showtime =
                modelMapper.map(
                  showtimeClient.findById(bookings.getShowtimeId()).getData(),
                        Showtime.class);
        bookings.setShowtime(showtime);
        return bookingsRepository.findByNumberBooking(id);
    }
}
