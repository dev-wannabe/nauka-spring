package pl.devwannabe.naukaspring.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


import static pl.devwannabe.naukaspring.Starter.BLUE;
import static pl.devwannabe.naukaspring.Starter.RESET_COLOR;

@Component
public class Castle {

    private String name = "East Watch";

    public Castle() {

    }

    @PostConstruct
    public void build() {
        System.out.println( BLUE +"A castle was built: " +
                name + RESET_COLOR);
    }

    @PreDestroy
    public void tearDown() {
        System.out.println(BLUE + "The castle will be tear down: " +
                name + RESET_COLOR);
    }
}
