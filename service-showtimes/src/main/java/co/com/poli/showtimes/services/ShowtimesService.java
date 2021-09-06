package co.com.poli.showtimes.services;

import co.com.poli.showtimes.entities.Showtimes;

import java.util.List;

public interface ShowtimesService {
    void save(Showtimes showtimes);
    void delete(Showtimes showtimes);
    List<Showtimes> findAll();
    Showtimes findById(Long id);
    Showtimes findByMovieId(Long id);
}
