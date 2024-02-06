package com.ryankrol.genaitextadventure.lib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilsTest {

    @Test
    void TestChunkSentenceNullInput() {
        String input = null;
        String result = StringUtils.chunkSentence(input, 20);

        assertEquals(
                "",
                result,
                "The method should return an empty string when provided with a null input string."
        );
    }

    @Test
    void TestChunkSentenceZeroChunkSize() {
        String input = "Some input";
        String result = StringUtils.chunkSentence(input, 0);

        assertEquals(
                "",
                result,
                "The method should return an empty string when provided with a 0 chunk size."
        );
    }

    @Test
    void TestChunkSentenceNegativeChunkSize() {
        String input = "Some input";
        String result = StringUtils.chunkSentence(input, -1);

        assertEquals(
                "",
                result,
                "The method should return an empty string when provided with a negative chunk size."
        );
    }

    @Test
    void TestChunkSentenceNoChunking() {
        String input = "Small String";
        String result = StringUtils.chunkSentence(input, 20);

        assertEquals(
                input,
                result,
                "The method should not modify a string that is within the maximum allowed length."
        );
    }

    @Test
    void TestChunkSentenceChunkSingleLongWord() {
        String input = "123456789";
        String result = StringUtils.chunkSentence(input, 3);

        assertEquals(
                "123\n456\n789",
                result,
                "The method should correctly chunk a single long word into specified lengths."
        );
    }

    @Test
    void TestChunkSentenceChunkMultipleWords() {
        String input = "12345 67890";
        String result = StringUtils.chunkSentence(input, 6);

        assertEquals(
                "12345\n67890",
                result,
                "The method should chunk on word boundaries, respecting spaces between words."
        );
    }

    @Test
    void TestChunkSentenceExactChunkSize() {
        String input = "ExactSize";
        int chunkSize = input.length(); // Ensure the chunk size is exactly the length of the input
        String result = StringUtils.chunkSentence(input, chunkSize);

        assertEquals(
                input,
                result,
                "The method should not modify a string that exactly matches the chunk size."
        );
    }

}