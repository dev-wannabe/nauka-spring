package pl.devwannabe.naukaspring.domain;

public class Quest {

    private String description;

    public Quest(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return description;
    }
}
