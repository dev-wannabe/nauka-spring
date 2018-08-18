package pl.devwannabe.naukaspring.domain;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class QuestTest {

    @Test
    public void settingStartedFlagToTrueShouldSetStartDate() {
        Quest quest = new Quest(1, "Test quest");
        quest.setStarted(true);
        assertNotNull(quest.startDate);
    }

    @Test
    public void questShouldBeCompletedAfter() {
        Quest quest = new Quest(1, "Test quest");
        quest.setStarted(true);
        quest.lengthInSeconds = -1;
        assertTrue(quest.isCompleted());
        //drugi assert żeby wiedzieć czy flaga została ustawiona
        assertTrue(quest.isCompleted());
    }

    @Test
    public void questShouldBeNotCompletedAfter() {
        Quest quest = new Quest(1, "Test quest");
        quest.setStarted(true);
        quest.lengthInSeconds = 1;
        assertFalse(quest.isCompleted());
        assertFalse(quest.isCompleted());

    }
}
