package pl.devwannabe.naukaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.devwannabe.naukaspring.domain.repository.KnightRepository;
import pl.devwannabe.naukaspring.domain.repository.QuestRepository;
import pl.devwannabe.naukaspring.services.QuestService;

@Component
@Scope("singleton")
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

        questService.assignRandomQuest("Lancelot");
        questService.assignRandomQuest("Percival");
        System.out.println(BLUE + knightRepository + RESET_COLOR);
//        System.out.println(BLUE + questRepository + RESET_COLOR);


    }
}