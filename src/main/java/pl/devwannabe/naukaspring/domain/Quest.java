package pl.devwannabe.naukaspring.domain;

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