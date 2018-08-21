package pl.devwannabe.naukaspring.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.devwannabe.naukaspring.domain.Quest;
import pl.devwannabe.naukaspring.domain.repository.QuestRepository;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestServiceTests {

    @Mock
    QuestRepository repositoryMock;

    @Test
    public void returnsNotStartedQuests() {

        List<Quest> quest = new ArrayList<>();

        Quest q1 = new Quest(1,"Test quest 1");
        Quest q2 = new Quest(2,"Test quest 2");
        Quest q3 = new Quest(3,"Test quest 3");

        q2.setStarted(true);

        quest.add(q1);
        quest.add(q2);
        quest.add(q3);

        when(repositoryMock.getAllQuests()).thenReturn(quest);

        QuestService questService = new QuestService();

        questService.setQuestRepository(repositoryMock);

        List<Quest> allNotStartedQuests = questService.getAllNotStartedQuests();

        assertEquals("Size of returned quest", 2, allNotStartedQuests.size());
        assertThat(allNotStartedQuests, containsInAnyOrder(q1, q3));
    }

}
