package com.ryankrol.genaitextadventure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.io.InputStream;


@Component
public class ReplCommandLineRunner implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    @Autowired
    ResourceReader resourceReader;

    private final InputStream inputStream;

    public ReplCommandLineRunner(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Scanner scanner = new Scanner(inputStream)) {
            final String content = resourceReader.readFileAsString("./screens/start.txt");

            String input;
            // ANSI escape sequence to clear the screen
            System.out.print("\033[H\033[2J");

            // Move the cursor to the top-left corner (optional)
            System.out.print("\033[H");

            System.out.println("Welcome to MyREPL. Type 'exit' to quit.");
            System.out.println(content);

            while (true) {
                System.out.print("> ");
                input = scanner.nextLine();

                if ("exit".equalsIgnoreCase(input.trim())) {
                    System.out.println("Goodbye friend, I hope you remembered to save!");
                    break;
                }

                String result = evaluate(input);
                System.out.println(result);
            }

        } finally {
            SpringApplication.exit(context); // Gracefully shutdown the Spring context
        }
    }

    // Evaluate the input here
    private String evaluate(String input) {
        // For now, it just echoes back the input
        return "You entered: " + input;
    }
}
