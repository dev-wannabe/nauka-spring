package pl.devwannabe.naukaspring.domain;

import org.springframework.stereotype.Component;

@Component
public class Quest {

    private String description;

    public Quest() {
        this.description = "Save the princess";
    }

    @Override
    public String toString() {
        return description;
    }
}