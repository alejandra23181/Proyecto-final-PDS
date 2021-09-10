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

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingsServiceImpl implements BookingService{

    private final BookingsRepository bookingsRepository;
    private final UserClient userClient;
    private final ShowtimeClient showtimeClient;

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
        Optional<Bookings> bookings = Optional.ofNullable(bookingsRepository.findById(id).orElse(null));

        ModelMapper modelMapper = new ModelMapper();
        Object data = userClient.findById(bookings.get().getUserId()).getData();

        User user =
                modelMapper.map(
                        userClient.findById(bookings.get().getUserId()).getData(),
                        User.class);
        bookings.get().setUser(user);

        /* Showtime showtime =
                modelMapper.map(
                        showtimeClient.findById(bookings.get().getShowtimeId()).getData(),
                        Showtime.class);
        bookings.get().setShowtime(showtime);*/

        return bookingsRepository.findById(id).orElse(null);
    }

}
