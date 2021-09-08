package co.com.poli.showtimes.services;


import co.com.poli.showtimes.entities.Showtimes;

import co.com.poli.showtimes.repositories.ShowtimesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowtimesServiceImpl implements ShowtimesService{

    private final ShowtimesRepository showtimesRepository;

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
    @Transactional(readOnly = true)
    public List<Showtimes> findAll() {
        return showtimesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Showtimes findById(Long id) {
        return showtimesRepository.findById(id).orElse(null);
    }


}
