package co.com.poli.showtimes.services;

import co.com.poli.showtimes.entities.Showtimes;
import co.com.poli.showtimes.repositories.ShowtimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface ShowtimesService {

    void save(Showtimes showtimes);
    void delete(Showtimes showtimes);
    List<Showtimes> findAll();
    Showtimes findById(Long id);
}
