package com.ryankrol.genaitextadventure.lib;

public class StringUtils {

    /**
     * Divides a given sentence into chunks with a maximum size, ensuring that words are not split across chunks.
     * The function will return a single string where chunks are separated by newline characters.
     *
     * @param input The input sentence to be chunked. It can be a single word or multiple words separated by spaces.
     * @param chunkSize The maximum length of each chunk. It must be a positive integer.
     *                  Chunks will be as close to this size as possible without splitting words across chunks.
     * @return A String containing the chunked sentence. If the input is null or the chunkSize is less than or equal to 0,
     *         an empty string is returned. If a word in the input sentence is longer than the chunkSize,
     *         the word is split to fit the chunk, and the process continues with the next part of the word in the following chunk.
     *         Each chunk is separated by a newline character. The last chunk may be shorter than the chunkSize if there are not
     *         enough words to fill it to the maximum length.
     */
    public static String chunkSentence(String input, int chunkSize) {
        if (input == null || chunkSize <= 0) {
            return ""; // Return an empty string for invalid input
        }

        StringBuilder result = new StringBuilder();
        String[] words = input.split("\\s+");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            // Check if adding the next word exceeds the chunk size
            if (currentLine.length() + word.length() > chunkSize) {
                // Handle case where single word is longer than chunk size
                if (currentLine.isEmpty()) {
                    // Split the long word to fit the chunk, then continue with the next part of the word
                    int splitPoint = chunkSize - currentLine.length();
                    currentLine.append(word, 0, splitPoint);
                    word = word.substring(splitPoint);
                    result.append(currentLine.toString()).append("\n");
                    currentLine = new StringBuilder();
                    // Recursively add the remaining part of the word
                    while (word.length() > chunkSize) {
                        result.append(word, 0, chunkSize).append("\n");
                        word = word.substring(chunkSize);
                    }
                    currentLine.append(word);
                } else {
                    // Add the current line to result and start a new line
                    result.append(currentLine.toString()).append("\n");
                    currentLine = new StringBuilder(word); // Start next line with the current word
                }
            } else {
                // Add a space before the word if it's not the first word in the line
                if (!currentLine.isEmpty()) {
                    currentLine.append(" ");
                }
                currentLine.append(word);
            }
        }
        // Add any remaining text to the result
        if (!currentLine.isEmpty()) {
            result.append(currentLine.toString());
        }

        return result.toString();
    }

}
