package pl.devwannabe.naukaspring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.devwannabe.naukaspring.controllers.QuestController;
import pl.devwannabe.naukaspring.domain.Knight;
import pl.devwannabe.naukaspring.domain.PlayerInformation;
import pl.devwannabe.naukaspring.domain.Quest;
import pl.devwannabe.naukaspring.services.KnightService;
import pl.devwannabe.naukaspring.services.QuestService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class WebContextTests {

    @Mock
    KnightService knightService;

    @Mock
    QuestService questService;

    @Mock
    PlayerInformation playerInformation;

    @InjectMocks
    QuestController questController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(questController).build();
    }

    @Test
    public void checkQuest() throws Exception {

        Quest quest = new Quest(0, "Test quest");

        Knight testNight1 = new Knight("testNight1", 33);
        Knight testNight2 = new Knight("testNight2", 34);
        testNight1.setQuest(quest);

        List<Knight> knights = new ArrayList<>(2);
        knights.add(testNight1);
        knights.add(testNight2);

        when(knightService.getAllknights()).thenReturn(knights);

        mockMvc.perform(get("/checkQuests"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/knights"));
    }

    @Test
    public void contextLoads() {

    }

}
