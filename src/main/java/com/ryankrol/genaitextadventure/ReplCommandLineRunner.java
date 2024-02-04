package com.ryankrol.genaitextadventure;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class ReplCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input;
            System.out.println("Welcome to MyREPL. Type 'exit' to quit.");

            while (true) {
                System.out.print("> ");
                input = scanner.nextLine();

                if ("exit".equalsIgnoreCase(input.trim())) {
                    break;
                }

                String result = evaluate(input);
                System.out.println(result);
            }
        }
    }

    // Evaluate the input here
    private String evaluate(String input) {
        // For now, it just echoes back the input
        return "You entered: " + input;
    }
}
