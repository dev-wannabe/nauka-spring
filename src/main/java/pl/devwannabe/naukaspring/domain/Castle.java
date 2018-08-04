package pl.devwannabe.naukaspring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static pl.devwannabe.naukaspring.Starter.BLUE;
import static pl.devwannabe.naukaspring.Starter.RESET_COLOR;

@Component
public class Castle {

    @Value("${my.castle.name:East Watch}")
    private String name;

    Knight knight;

    public Castle() {

    }

    @Autowired
    public Castle(Knight knight) {
        this.knight = knight;
    }

    Castle(Knight knight, String name) {
        this.knight = knight;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Here is a castle called " + name + ". Inhabited by a knight. " + knight;
    }
}
