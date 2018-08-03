package pl.devwannabe.naukaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.devwannabe.naukaspring.domain.Castle;
import pl.devwannabe.naukaspring.domain.Tournament;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    public static final String BLUE = "\u001B[34m";
    public static final String RESET_COLOR = "\u001B[0m";

    @Autowired
    Castle castle;

    @Autowired
    Tournament tournament;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(BLUE + castle + RESET_COLOR);
        tournament.duel();
        System.out.println(BLUE + tournament + RESET_COLOR);

        System.out.println(BLUE + castle + RESET_COLOR);



    }
}