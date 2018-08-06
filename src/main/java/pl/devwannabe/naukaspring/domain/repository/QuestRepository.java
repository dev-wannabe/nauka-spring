package pl.devwannabe.naukaspring.domain.repository;

import org.springframework.stereotype.Repository;
import pl.devwannabe.naukaspring.domain.Quest;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestRepository {

    List<Quest> questList = new ArrayList<>();

    public void createQuest(String description) {
        questList.add(new Quest(description));
    }

    public List<Quest> getAll() {
        return questList;
    }

    @PostConstruct
    public void init() {
        createQuest("Save the princess");
        createQuest("Take part in the tournament");
    }

    public void deleteQuest(Quest quest) {
        questList.remove(quest);
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + questList +
                '}';
    }
}