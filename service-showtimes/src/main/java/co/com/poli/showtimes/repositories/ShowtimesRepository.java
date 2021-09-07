package co.com.poli.showtimes.repositories;

import co.com.poli.showtimes.entities.Showtimes;
import co.com.poli.showtimes.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimesRepository extends JpaRepository<Showtimes,Long> {
}
