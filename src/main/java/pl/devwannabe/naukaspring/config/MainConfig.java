package pl.devwannabe.naukaspring.config;

import org.springframework.context.annotation.*;
import pl.devwannabe.naukaspring.domain.Knight;
import pl.devwannabe.naukaspring.domain.Quest;

@Configuration
//@PropertySource("classpath:castle.properties")
//@ImportResource("classpath:config/castle-config.xml")
public class MainConfig {

//    @Autowired
//    Quest quest;

    @Bean
    public Quest createQuest() {
        return new Quest();
    }

    @Bean(name="lancelot")
    @Primary
    public Knight lancelot() {
        Knight lancelot = new Knight("Lancelot", 29);
        lancelot.setQuest(createQuest());
        return lancelot;
    }

    @Bean(name="percival")
    public Knight createKnightBean() {
        Knight percival = new Knight("Percival", 25);
        percival.setQuest(createQuest());
        return percival;
    }

}
