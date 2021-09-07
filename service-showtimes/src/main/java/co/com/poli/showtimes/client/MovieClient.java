package co.com.poli.showtimes.client;

import co.com.poli.showtimes.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-movie")
public interface MovieClient{

    @GetMapping("/movies/{id}")
    Response findByMovieId(@PathVariable("id") Long id);


}
