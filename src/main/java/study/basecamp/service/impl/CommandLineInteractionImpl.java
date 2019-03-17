package study.basecamp.service.impl;


import study.basecamp.service.CommnadLineInteraction;

import javax.annotation.PostConstruct;
import java.util.Scanner;

public class CommandLineInteractionImpl implements CommnadLineInteraction {

    private Scanner scanner;

    @PostConstruct
    @Override
    public void initialization(){
        scanner = new Scanner(System.in);
    }

    @Override
    public int numberScann() {
        return scanner.nextInt();
    }

}
