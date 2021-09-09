package co.com.poli.showtimes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ShowtimesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowtimesApplication.class, args);
    }

}
