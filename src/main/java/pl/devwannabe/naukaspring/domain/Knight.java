package pl.devwannabe.naukaspring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static pl.devwannabe.naukaspring.Starter.BLUE;
import static pl.devwannabe.naukaspring.Starter.RESET_COLOR;


public class Knight {

    private String name;
    private int age;
    private Quest quest;

    public Knight() {
        this.name = "Lancelot";
        this.age = 29;

    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Autowired
    public void setQuest(Quest quest) {
        System.out.println(BLUE + "I'm injecting a quest!" + RESET_COLOR);
        this.quest = quest;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "A knight named " + name +
                "(" + age + ") - current quest: \n" + quest;

    }

}