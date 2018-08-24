package pl.devwannabe.naukaspring.domain.repository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.devwannabe.naukaspring.domain.Quest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class QuestRepository {

    private static final Random RANDOM = new Random();

    @PersistenceContext
    private EntityManager em;


    public List<Quest> getAllQuests() {
       return em.createQuery("from Quest", Quest.class).getResultList();
    }

    @Transactional
    public void deleteQuest(Quest quest) {
        em.remove(quest);
    }

    @Transactional
    public void update(Quest quest) {
           em.merge(quest);
    }

    public Quest getQuest(Integer id) {
        return em.find(Quest.class, id);
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    @Transactional
    public void createRandomQuest() {
        List<String> descriptions = new ArrayList<>();
        descriptions.add("Save the princess");
        descriptions.add("Take part in the tournament");
        descriptions.add("Kill gangs of goblins");
        descriptions.add("Kill the dragon");
        String description = descriptions.get(RANDOM.nextInt(descriptions.size()));
        createQuest(description);
    }

    @Transactional
    private void createQuest(String description) {
        Quest newQuest = new Quest(description);
        em.persist(newQuest);
        System.out.println(newQuest);
    }

}