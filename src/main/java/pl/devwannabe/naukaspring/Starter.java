package pl.devwannabe.naukaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.devwannabe.naukaspring.domain.repository.KnightRepository;
import pl.devwannabe.naukaspring.domain.repository.QuestRepository;
import pl.devwannabe.naukaspring.services.QuestService;

@Component
public class Starter implements CommandLineRunner {

    public static final String BLUE = "\u001B[34m";
    public static final String RESET_COLOR = "\u001B[0m";

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @Override
    public void run(String... args) throws Exception {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

    }
}