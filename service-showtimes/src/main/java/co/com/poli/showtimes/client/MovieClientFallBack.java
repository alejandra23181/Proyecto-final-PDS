package co.com.poli.showtimes.client;

import co.com.poli.showtimes.model.Movie;
import co.com.poli.showtimes.utils.Response;
import co.com.poli.showtimes.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieClientFallBack implements MovieClient{

    private final ResponseBuilder builder;

    @Override
        public Response findById(Long id) {
            Movie movie = new Movie();
            return builder.success(movie);
        }
    }

