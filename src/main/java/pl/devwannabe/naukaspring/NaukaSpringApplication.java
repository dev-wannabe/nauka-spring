package pl.devwannabe.naukaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pl.devwannabe.component.TestComponent;
import pl.devwannabe.naukaspring.domain.Castle;
import pl.devwannabe.naukaspring.domain.Knight;
import pl.devwannabe.naukaspring.domain.Quest;

@SpringBootApplication
//@ComponentScan({"pl.devwannabe.naukaspring", "pl.devwannabe.component"})
@ComponentScan(basePackageClasses = {Starter.class, Castle.class, Knight.class, Quest.class, TestComponent.class})
public class NaukaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaukaSpringApplication.class, args);
	}
}
