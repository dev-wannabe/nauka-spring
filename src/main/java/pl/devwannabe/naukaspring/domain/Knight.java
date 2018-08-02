package pl.devwannabe.naukaspring.domain;

import static pl.devwannabe.naukaspring.Starter.BLUE;
import static pl.devwannabe.naukaspring.Starter.RESET_COLOR;

public class Knight {

    private String name;
    private int age;
    private Quest quest;

    public Knight() {

    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setQuest(Quest quest) {
        System.out.println(BLUE + "I'm injecting a quest!" + RESET_COLOR);
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "A knight named " + name +
                "(" + age + ") - current quest: \n" + quest;

    }

}