package org.example;

public class repeatedSubstringPatternSolution {
    public static void main(String[] args) {
        String s1 = "abab";
        boolean result1 = repeatedSubstringPattern(s1);
        System.out.println(result1); // Output: true

        String s2 = "aba";
        boolean result2 = repeatedSubstringPattern(s2);
        System.out.println(result2); // Output: false

        String s3 = "abcabcabcabc";
        boolean result3 = repeatedSubstringPattern(s3);
        System.out.println(result3); // Output: true
    }

    public static boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        String doubled = s + s;
        String substring = doubled.substring(1, doubled.length() - 1);
        return substring.contains(s);
    }
}
