package pl.devwannabe.naukaspring.domain;

import static pl.devwannabe.naukaspring.Starter.BLUE;
import static pl.devwannabe.naukaspring.Starter.RESET_COLOR;

public class Castle {

    private String name;

    Knight knight;

    public Castle() {

    }

    public Castle(Knight knight) {
        this.knight = knight;
    }

    Castle(Knight knight, String name) {
        this.knight = knight;
        this.name = name;
    }

    public void build() {
        System.out.println(BLUE + "A castle was built: " +
                name + RESET_COLOR);
    }

    public void tearDown() {
        System.out.println(BLUE + "The castle will be tear down: " +
                name + RESET_COLOR);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Here is a castle called " + name + ". Inhabited by a knight. " + knight;
    }
}
