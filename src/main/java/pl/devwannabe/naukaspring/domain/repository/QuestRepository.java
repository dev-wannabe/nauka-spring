package pl.devwannabe.naukaspring.domain.repository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import pl.devwannabe.naukaspring.domain.Quest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static pl.devwannabe.naukaspring.Starter.BLUE;
import static pl.devwannabe.naukaspring.Starter.RESET_COLOR;

@Repository
public class QuestRepository {

    private static final Random RANDOM = new Random();
    private List<Quest> questList = new ArrayList<>();


    public void createQuest(String description) {
        questList.add(new Quest(description));
    }

    public List<Quest> getAllQuests() {
        return questList;
    }

    public void deleteQuest(Quest quest) {
        questList.remove(quest);
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    public void createRandomQuest() {

        List<String> descriptions = new ArrayList<>();

        descriptions.add("Save the princess");
        descriptions.add("Take part in the tournament");
        descriptions.add("Kill gangs of goblins");
        descriptions.add("Kill the dragon");

        String description = descriptions.get(RANDOM.nextInt(descriptions.size()));
        System.out.println(BLUE + "task created: " + description + RESET_COLOR);
        createQuest(description);
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + questList +
                '}';
    }
}