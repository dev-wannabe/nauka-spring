package pl.devwannabe.naukaspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.devwannabe.naukaspring.domain.repository.InMemoryKnightRepository;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NaukaSpringApplicationTests {


	@Autowired
    InMemoryKnightRepository inMemoryKnightRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCastle() {
		String except = "Here is a inMemoryKnightRepository called InMemoryKnightRepository Black. Inhabited by a knight. A knight named Lancelot(29) - current quest: \n" +
				"Save the princess";
		assertEquals(except, inMemoryKnightRepository.toString());
	}

}
