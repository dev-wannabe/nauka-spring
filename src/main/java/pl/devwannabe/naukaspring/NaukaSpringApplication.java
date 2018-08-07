package pl.devwannabe.naukaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@PropertySource("classpath:knightRepository.properties")
@EnableScheduling
public class NaukaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(NaukaSpringApplication.class, args);
    }
}
