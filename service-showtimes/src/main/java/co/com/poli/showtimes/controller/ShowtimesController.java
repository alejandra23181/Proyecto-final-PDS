package co.com.poli.showtimes.controller;

import co.com.poli.showtimes.entities.Showtimes;
import co.com.poli.showtimes.services.ShowtimesServiceImpl;
import co.com.poli.showtimes.utils.ErrorMessage;
import co.com.poli.showtimes.utils.Response;
import co.com.poli.showtimes.utils.ResponseBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowtimesController {

    private final ShowtimesServiceImpl showtimesService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@Valid @RequestBody Showtimes showtimes, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        showtimesService.save(showtimes);
        return builder.success(showtimes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Showtimes> delete(@PathVariable("id") Long id) {
        Showtimes showtimes = showtimesService.findById(id);
        if(showtimes==null){
            return ResponseEntity.notFound().build();
        }
        showtimesService.delete(showtimes);
        return ResponseEntity.ok(showtimes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Showtimes> save(@PathVariable("id") Long id, @RequestBody Showtimes showtimes){
        Showtimes showtimesData = showtimesService.findById(id);
        showtimesData.setDate(showtimes.getDate());
        showtimesData.setMovies(showtimes.getMovies());
        showtimesService.save(showtimes);
        return ResponseEntity.ok(showtimes);
    }


    @GetMapping
    public ResponseEntity<List<Showtimes>> findAll(){
        List<Showtimes> showtimes = showtimesService.findAll();
        if (showtimes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(showtimes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Showtimes> getById(@PathVariable("id") Long id){
        Showtimes showtimes = showtimesService.findById(id);
        if(showtimes==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(showtimes);
    }

        private String formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());

        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try{
            json = objectMapper.writeValueAsString(errorMessage);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return json;
    }

}
