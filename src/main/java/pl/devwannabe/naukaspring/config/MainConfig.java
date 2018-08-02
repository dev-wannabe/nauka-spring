package pl.devwannabe.naukaspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import pl.devwannabe.naukaspring.domain.Castle;
import pl.devwannabe.naukaspring.domain.Knight;
import pl.devwannabe.naukaspring.domain.Quest;

@Configuration
@ImportResource("classpath:config/castle-config.xml")
public class MainConfig {

    @Bean
    public Quest createQuest() {
        return new Quest();
    }

    @Bean
    public Knight knight() {
        Knight knight = new Knight("Lancelot", 29);
        knight.setQuest(createQuest());
        return knight;
    }

}
