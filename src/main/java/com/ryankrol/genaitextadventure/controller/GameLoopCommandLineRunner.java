package com.ryankrol.genaitextadventure;

import com.ryankrol.genaitextadventure.lib.JsonResourceReader;
import com.ryankrol.genaitextadventure.lib.StringUtils;
import com.ryankrol.genaitextadventure.model.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


@Component
public class GameLoopCommandLineRunner implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    @Autowired
    JsonResourceReader resourceReader;

    private final InputStream inputStream;

    public GameLoopCommandLineRunner(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Scanner scanner = new Scanner(inputStream)) {
            // ANSI escape sequence to clear the screen
            System.out.print("\033[H\033[2J");

            // Move the cursor to the top-left corner (optional)
            System.out.print("\033[H");

            // for now, we'll just assume that the game always starts here
            Scene scene = resourceReader.readJsonFile("scenes/FOREST_CLEARING.json", Scene.class);

            String input;

            while (true) {

                System.out.println(StringUtils.chunkSentence(scene.getDescription(), 80));

                System.out.print("> ");
                input = scanner.nextLine();

                if ("exit".equalsIgnoreCase(input.trim())) {
                    System.out.println("Goodbye friend, I hope you remembered to save!");
                    break;
                }

                String result = evaluate(input);
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
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
