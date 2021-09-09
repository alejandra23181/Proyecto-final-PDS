package com.example.servicebookings.client;

import com.example.servicebookings.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-users", fallback = UserClientFallBack.class)
public interface UserClient {

    @GetMapping("/user/{id}")
    Response findById(@PathVariable("id") Long id);

    @GetMapping("/user/numberId/{id}")
    Response findNumberId(@PathVariable("id") Long id);
}
