package pl.devwannabe.naukaspring.domain;

import org.junit.Test;
import pl.devwannabe.naukaspring.utils.Ids;

import static junit.framework.TestCase.assertTrue;

public class KnightTest {

    @Test
    public void testIfQuestMarkedAsStarted() {
        Knight knight = new Knight("Percival", 25);
        Quest quest = new Quest(1,"Testing task");

        knight.setQuest(quest);
        assertTrue(knight.getQuest().isStarted());

    }
}
