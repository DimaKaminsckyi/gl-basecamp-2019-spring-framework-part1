package study.basecamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.basecamp.config.AppContext;
import study.basecamp.service.CommnadLineInteraction;
import study.basecamp.service.Game;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context  =
                new AnnotationConfigApplicationContext(AppContext.class);

        CommnadLineInteraction commnadLineInteraction
                = context.getBean(CommnadLineInteraction.class);

        Game game = context.getBean(Game.class);

        log.info("Guess number ! ");

        while (!game.isGameWon() && game.getRemainingGuesses() != 0){

            log.info("Enter you number : ");
            int number = commnadLineInteraction.numberScann();
            game.setGuess(number);
            game.check();
            log.info("Number is between " + game.getSmallest() + " and " + game.getBiggest());

            if (game.isGameWon()){
                log.info("WIN!!!!!!!");
            }else
                log.info("WRONG");

            log.info("remaining guess: " + game.getRemainingGuesses());
        }

        context.close();

    }
}
