package pl.devwannabe.naukaspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        auth.inMemoryAuthentication().passwordEncoder(encoder)
                .withUser("user").password(encoder.encode("user")).roles("USER")
                .and()
                .withUser("admin").password(encoder.encode("admin")).roles("ADMIN");

    }

}