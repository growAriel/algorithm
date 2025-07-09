package org.example;

public class firstIndexOfFirstOccurrence {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int result = strStr(haystack, needle);
        System.out.println(result); // Output: 2

        String haystack2 = "aaaaa";
        String needle2 = "bba";
        int result2 = strStr(haystack2, needle2);
        System.out.println(result2); // Output: -1
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0; // If needle is empty, return 0
        }
        if (haystack.length() < needle.length()) {
            return -1; // If haystack is shorter than needle, return -1
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // Return the index of the first occurrence
            }
        }
        return -1; // If not found, return -1
    }
}
