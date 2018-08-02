package pl.devwannabe.naukaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:config/spring-config.xml")
public class NaukaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaukaSpringApplication.class, args);
	}
}
