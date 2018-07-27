package pl.devwannabe.naukaspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.devwannabe.naukaspring.domain.Knight;
import pl.devwannabe.naukaspring.domain.Quest;

@Component
public class Starter implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Quest saveThePrincess = new Quest("Save the princess");
        Quest killDragon = new Quest("Kill the dragon");
        Knight lancelot = new Knight("Lancelot", 29, saveThePrincess);
        Knight percival = new Knight("Percival",31);
        percival.setQuest(killDragon);

        System.out.println("\u001B[33m" +
                lancelot +
                "\u001B[0m");
        System.out.println("\u001B[33m" +
                percival +
                "\u001B[0m");
    }
}