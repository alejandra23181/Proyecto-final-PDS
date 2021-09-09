package com.example.servicebookings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceBookingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBookingsApplication.class, args);
    }

}
