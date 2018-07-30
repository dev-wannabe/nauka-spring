package pl.devwannabe.naukaspring.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Knight {

    @Value("Lancelot")
    private String name;
    private int age = 29;
//    private Quest quest;

    public Knight() {

    }

//    public Knight(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }

//    public Knight(String name, int age, Quest quest) {
//        this.name = name;
//        this.age = age;
//        this.quest = quest;
//    }

//    public void setQuest(Quest quest){
//        this.quest = quest;
//    }

    @Override
    public String toString() {
        return "A knight named " + name +
                "(" + age + ") - current quest: \n";
    }

}