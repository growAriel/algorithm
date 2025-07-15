package org.example;

import java.util.HashMap;
import java.util.Map;

public class wordPattern {
    public static void main(String[] args) {
        // Example usage
        String pattern = "abba";
        String s = "dog cat cat dog";
        boolean result = wordPattern(pattern, s);
        System.out.println("Does the string follow the pattern? " + result);
    }

    public static boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null) {
            return false;
        }
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false; // Length mismatch
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (!charToWord.containsKey(c)) {
                charToWord.put(c, word);
            } else if (!charToWord.get(c).equals(word)) {
                return false; // Mismatch in mapping
            }

            if (!wordToChar.containsKey(word)) {
                wordToChar.put(word, c);
            } else if (wordToChar.get(word) != c) {
                return false; // Mismatch in reverse mapping
            }
        }

        return true; // All characters and words match correctly
    }
}
