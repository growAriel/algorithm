package org.example;

public class ransomNote {
    public static void main(String[] args) {
        // Example usage
        String ransomNote = "aaa";
        String magazine = "abb";
        boolean result = canConstruct(ransomNote, magazine);
        System.out.println("Can the ransom note be constructed from the magazine? " + result);


    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] charCount = new int[26]; // Assuming only lowercase letters a-z

        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false; // Not enough characters in magazine
            }
            charCount[c - 'a']--;
        }

        return true; // All characters in ransomNote can be constructed from magazine
    }
}
