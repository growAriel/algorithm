package org.example;

public class reverseWordsInString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        String result = reverseWords(s);
        System.out.println(result); // Output: "blue is sky the"

        String s2 = "  hello world  ";
        String result2 = reverseWords(s2);
        System.out.println(result2); // Output: "world hello"
    }

    public static String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String[] words = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }
}