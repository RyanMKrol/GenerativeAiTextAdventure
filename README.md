# Generative AI Text Adventure

This project serves as a personal exploration into the integration of generative AI with the classic text-based adventure game format. It's a learning repository where I'll be experimenting with various generative AI APIs provided by OpenAI, using the text adventure concept as a foundational base. 

## Prerequisites

Before you begin, ensure you have the following installed on your system:

- Java 21: This project requires Java 21 to run. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) or use a package manager like Homebrew on macOS (`brew install java`) or apt on Ubuntu (`sudo apt-get install openjdk-21-jdk`). Verify the installation by running `java -version` in your terminal.

## Setup
### Credentials
This project requires a .env file to exist at the root. This .env file should contain values in the following format:
```
apikey.openai="SOME VALUE GOES HERE"
```

## Running
You can either run the application from your IDE by going to the Application.java file, and clicking the play icon. Or you can run it from the IDE by navigating to the root of the project and running:
```
./gradlew --console=plain runRepl 
```