package pl.devwannabe.naukaspring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static pl.devwannabe.naukaspring.Starter.BLUE;
import static pl.devwannabe.naukaspring.Starter.RESET_COLOR;

@Component
public class Knight {

    @Value("Lancelot")
    private String name;

    private int age = 29;
    private Quest quest;

    public Knight() {

    }
    
    @Autowired
    public void setQuest(Quest quest){
        System.out.println(BLUE +"I'm injecting a quest!" + RESET_COLOR);
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "A knight named " + name +
                "(" + age + ") - current quest: \n" + quest;

    }

}