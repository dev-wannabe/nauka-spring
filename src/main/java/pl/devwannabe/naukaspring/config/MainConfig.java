package pl.devwannabe.naukaspring.config;

import org.springframework.context.annotation.*;
import pl.devwannabe.naukaspring.domain.repository.DBKnightRepository;
import pl.devwannabe.naukaspring.domain.repository.InMemoryKnightRepository;
import pl.devwannabe.naukaspring.domain.repository.KnightRepository;

@Configuration
public class MainConfig {

    @Bean(name="inMemoryKnightRepository")
    @Profile("dev")
    public KnightRepository createInMemoryRepository() {
        KnightRepository knightRepository = new InMemoryKnightRepository();
        return knightRepository;
    }

    @Bean(name="DBKnightRepository")
    @Profile("prod")
    public KnightRepository createDBKnightRepository() {
        KnightRepository knightRepository = new DBKnightRepository();
        return knightRepository;
    }
}
