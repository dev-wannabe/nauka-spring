package pl.devwannabe.naukaspring.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
@Entity
public class PlayerInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int gold;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
