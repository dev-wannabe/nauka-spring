package pl.devwannabe.naukaspring.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CastleTest {

    @Test
    public void castleToStringMessage() {
        Quest quest = new Quest();
        Knight knight = new Knight();
        knight.setQuest(quest);
        Castle castle = new Castle(knight, "Castle Black");
        String except = "Here is a castle called Castle Black. Inhabited by a knight. A knight named Lancelot(29) - current quest: \n" +
                "Save the princess";
        assertEquals(except, castle.toString());
    }

}
