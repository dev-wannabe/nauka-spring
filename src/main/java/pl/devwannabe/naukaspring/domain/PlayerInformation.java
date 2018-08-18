package pl.devwannabe.naukaspring.domain;

import org.springframework.stereotype.Component;

@Component
public class PlayerInformation {

    private int gold;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
