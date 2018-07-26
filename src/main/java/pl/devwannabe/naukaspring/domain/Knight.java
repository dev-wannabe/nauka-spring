package pl.devwannabe.naukaspring.domain;

public class Knight {

    private String name;
    private int age;
    private Quest quest;

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.quest = new Quest("Uratuj księżniczkę");
    }

    @Override
    public String toString() {
        return "Rycerz o imieniu " + name +
                "(" + age + ") - aktualne zadanie: \n" + quest;
    }

}