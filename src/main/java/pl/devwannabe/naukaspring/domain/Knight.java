package pl.devwannabe.naukaspring.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

import static pl.devwannabe.naukaspring.Starter.BLUE;
import static pl.devwannabe.naukaspring.Starter.RESET_COLOR;

public class Knight {

    private int id;

    @NotNull
    @Size(min=2, max=40, message = "The name of the knight can contain from 2 to 40 characters.")
    private String name;

    @NotNull
    @Range(min=18, max=60, message = "A knight can not be younger than 18 and older than 60.")
    private int age;

    private int level;

    private Quest quest;

    public Knight() {
        this.level = 1;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return age == knight.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    public void setQuest(Quest quest) {
        System.out.println(BLUE + "I'm setup a quest!" + RESET_COLOR);
        quest.setStarted(true);
        this.quest = quest;
    }

    public Quest getQuest() {
        return quest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "A knight named " + name +
                "(" + age + ") - current quest: \n" + quest;
    }
}