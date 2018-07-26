package pl.devwannabe.naukaspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.devwannabe.naukaspring.domain.DragonKillingNight;
import pl.devwannabe.naukaspring.domain.Knight;

@Component
public class Starter implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Knight lancelot = new Knight("Lancelot", 29);
        DragonKillingNight percival = new DragonKillingNight("Percival", 31);

        System.out.println("\u001B[33m" +
                lancelot +
                "\u001B[0m");
        System.out.println("\u001B[33m" +
                percival +
                "\u001B[0m");

    }

}