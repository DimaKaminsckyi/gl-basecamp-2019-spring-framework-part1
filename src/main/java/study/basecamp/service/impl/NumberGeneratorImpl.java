package study.basecamp.service.impl;

import org.springframework.beans.factory.annotation.Value;
import study.basecamp.service.NumberGenerator;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {

    private final Random random = new Random();

    @Value("${game.max}")
    private int maxNumber;

    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

}
