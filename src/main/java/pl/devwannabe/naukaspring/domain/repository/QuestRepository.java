package pl.devwannabe.naukaspring.domain.repository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import pl.devwannabe.naukaspring.domain.Quest;
import pl.devwannabe.naukaspring.utils.Ids;

import java.util.*;

@Repository
public class QuestRepository {

    private static final Random RANDOM = new Random();
    Map<Integer, Quest> quests = new HashMap<>();

    private void createQuest(String description) {
        int newId = Ids.generateNewId(quests.keySet());
        Quest newQuest = new Quest(newId, description);
        quests.put(newId, newQuest);
    }

    public List<Quest> getAllQuests() {
        return new ArrayList<>(quests.values());
    }

    public void deleteQuest(Quest quest) {
        quests.remove(quest.getId());
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    public void createRandomQuest() {

        List<String> descriptions = new ArrayList<>();

        descriptions.add("Save the princess");
        descriptions.add("Take part in the tournament");
        descriptions.add("Kill gangs of goblins");
        descriptions.add("Kill the dragon");

        String description = descriptions.get(RANDOM.nextInt(descriptions.size()));
        createQuest(description);
    }

    public void update(Quest quest) {
        quests.put(quest.getId(), quest);
    }

    public Quest getQuest(Integer id) {
        return quests.get(id);
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + quests +
                '}';
    }

}