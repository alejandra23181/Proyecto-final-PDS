package co.com.poli.showtimes.services;

import co.com.poli.showtimes.client.MovieClient;
import co.com.poli.showtimes.entities.Showtimes;
import co.com.poli.showtimes.model.Movie;
import co.com.poli.showtimes.repositories.ShowtimesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimesServiceImpl implements ShowtimesService{

    private final ShowtimesRepository showtimesRepository;
    private final MovieClient movieClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Showtimes showtimes) {
        showtimesRepository.save(showtimes);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Showtimes showtimes) {
        showtimesRepository.delete(showtimes);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Showtimes> findAll() {
        return showtimesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Showtimes findById(Long id) {
        return showtimesRepository.findById(id).orElse(null);
    }



}
