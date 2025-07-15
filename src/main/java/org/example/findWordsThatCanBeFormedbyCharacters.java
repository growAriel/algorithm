package org.example;

public class findWordsThatCanBeFormedbyCharacters {
    public static void main(String[] args) {
        // Example usage
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        int result = countCharacters(words, chars);
        System.out.println("Total length of words that can be formed: " + result);
    }
    public static int countCharacters(String[] words, String chars) {
        int totalLength = 0;
        int[] charCount = new int[26];

        // Count characters in chars
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Check each word
        for (String word : words) {
            if (canFormWord(word, charCount)) {
                totalLength += word.length();
            }
        }

        return totalLength;
    }
    private static boolean canFormWord(String word, int[] charCount) {
        int[] tempCount = charCount.clone(); // Clone to avoid modifying original count

        for (char c : word.toCharArray()) {
            if (tempCount[c - 'a'] == 0) {
                return false; // Not enough characters to form the word
            }
            tempCount[c - 'a']--; // Use one character
        }

        return true; // Word can be formed
    }
}
