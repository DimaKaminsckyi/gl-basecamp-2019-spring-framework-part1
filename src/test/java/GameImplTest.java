import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.basecamp.config.AppContext;
import study.basecamp.service.Game;

import static org.junit.Assert.*;

public class GameImplTest {

    private AnnotationConfigApplicationContext context;
    private Game game;

    @Before
    public void initialization(){
        context = new AnnotationConfigApplicationContext(AppContext.class);
        game = context.getBean(Game.class);
    }

    @Test
    public void When_GuessDontEqualsNumber_Expected_GameLostAsTrue(){

        int number = game.getNumber();
        game.setGuess(number + 1);

        for (int i = 0 ; i < 10; i++){game.check();}

        assertTrue(game.isGameLost());
    }

    @Test
    public void When_GuessEqualsNumber_Expected_GameWonAsTrue(){

        int number = game.getNumber();
        game.setGuess(number);

        assertTrue( game.isGameWon());
    }

    @Test
    public void When_Check_Expect_CorrectBiggestNumber(){

        int number = game.getNumber();
        game.setGuess(number + 1);
        game.check();

        assertEquals(number , game.getBiggest());
    }

    @Test
    public void When_Check_Expect_CorrectSmallestNumber(){

        int number = game.getNumber();
        game.setGuess(number - 1);
        game.check();

        assertEquals(number , game.getSmallest());
    }

    @Test
    public void When_NumberGenerate_Expect_NumberAsNotNull(){
        assertNotNull(game.getNumber());
    }

}
