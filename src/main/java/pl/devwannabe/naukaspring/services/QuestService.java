package pl.devwannabe.naukaspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.devwannabe.naukaspring.domain.Quest;
import pl.devwannabe.naukaspring.domain.repository.KnightRepository;
import pl.devwannabe.naukaspring.domain.repository.QuestRepository;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestService {

    @Autowired
    KnightRepository knightRepository;

    QuestRepository questRepository;

    private static final Random RANDOM = new Random();

    public void assignRandomQuest(String knightName) {
        List<Quest> allQuest = questRepository.getAllQuests();
        Quest randomQuest = allQuest.get(RANDOM.nextInt(allQuest.size()));
        knightRepository.getKnight(knightName).ifPresent(knight -> knight.setQuest(randomQuest));
        questRepository.deleteQuest(randomQuest);
    }

    public List<Quest> getAllNotStartedQuests() {
        List<Quest> QuestsNotStarted = questRepository.getAllQuests().stream()
                .filter(quest -> !quest.isStarted())
                .collect(Collectors.toList());
        return QuestsNotStarted;
    }

    @Autowired
    public void setQuestRepository(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }
}