package pl.devwannabe.naukaspring.domain;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


import static pl.devwannabe.naukaspring.Starter.BLUE;
import static pl.devwannabe.naukaspring.Starter.RESET_COLOR;

@Component
@PropertySource("classpath:castle.properties")
public class Castle {

    @Value("${my.castle.name:East Watch}")
    private String name;

    Knight knight;

    public Castle(Knight knight) {
        this.knight = knight;
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

    @Override
    public String toString() {
        return "Here is a castle called " + name + ". Inhabited by a knight. " + knight;
    }
}
