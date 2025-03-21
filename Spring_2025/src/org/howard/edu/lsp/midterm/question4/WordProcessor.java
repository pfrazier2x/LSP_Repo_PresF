package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

public class WordProcessor {
	
	/**
	 * Preston Frazier
	 * @param args
	 */
	
	private String sentence;
    

    // Constructor
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    // Method to find all longest words
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords; // Return empty list for empty input
        }

        String[] words = sentence.trim().split("\\s+"); // Splitting by whitespace
        int maxLength = 0;

        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWords.clear();
                longestWords.add(word);
            } else if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }
        return longestWords;
    }
}
