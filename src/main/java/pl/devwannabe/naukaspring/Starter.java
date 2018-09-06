package pl.devwannabe.naukaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.devwannabe.naukaspring.config.SecurityConfig;
import pl.devwannabe.naukaspring.domain.PlayerInformation;
import pl.devwannabe.naukaspring.domain.repository.KnightRepository;
import pl.devwannabe.naukaspring.domain.repository.PlayerInformationRepository;
import pl.devwannabe.naukaspring.domain.repository.QuestRepository;
import pl.devwannabe.naukaspring.services.QuestService;
import pl.devwannabe.naukaspring.utils.Role;
import pl.devwannabe.naukaspring.utils.RoleRepository;

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

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        knightRepository.createKnight("Percival", 32);

        PlayerInformation playerInformation1 = new PlayerInformation("user1", doHash("123"));
        PlayerInformation playerInformation2 = new PlayerInformation("user2", doHash("123"));
        playerInformationRepository.createPlayerInformation(playerInformation1);
        playerInformationRepository.createPlayerInformation(playerInformation2);

        Role user1RoleUSER = new Role("user1", "USER");
        Role user2RoleUSER = new Role("user2", "USER");
        Role user2RoleADMIN = new Role("user2", "ADMIN");

        roleRepository.persistRole(user1RoleUSER);
        roleRepository.persistRole(user2RoleUSER);
        roleRepository.persistRole(user2RoleADMIN);

        questService.assignRandomQuest("Percival");

    }

    public String doHash(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        password = passwordEncoder.encode(password);
        return password;
    }

}