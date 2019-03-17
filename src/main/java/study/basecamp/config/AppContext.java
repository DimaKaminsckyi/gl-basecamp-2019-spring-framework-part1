package study.basecamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import study.basecamp.service.CommnadLineInteraction;
import study.basecamp.service.Game;
import study.basecamp.service.NumberGenerator;
import study.basecamp.service.impl.CommandLineInteractionImpl;
import study.basecamp.service.impl.GameImpl;
import study.basecamp.service.impl.NumberGeneratorImpl;

@Configuration
@PropertySource("aplication.properties")
public class AppContext {

    @Bean
    public NumberGenerator numberGenerator(){
        NumberGeneratorImpl numberGenerator = new NumberGeneratorImpl();
        return numberGenerator;
    }

    @Bean
    public CommnadLineInteraction commnadLineInteraction(){
        CommandLineInteractionImpl commandLineInteraction = new CommandLineInteractionImpl();
        return commandLineInteraction;
    }

    @Bean
    public Game game(){
        GameImpl game = new GameImpl(numberGenerator());
        return game;
    }
}
