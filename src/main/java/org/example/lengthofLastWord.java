package org.example;

public class lengthofLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        int result = lengthOfLastWord(s);
        System.out.println(result); // Output: 5

        String s2 = "   fly me to the moon   ";
        int result2 = lengthOfLastWord(s2);
        System.out.println(result2); // Output: 4
    }

    public static int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        return s.strip().substring(s.strip().lastIndexOf(' ') + 1).length();
    }
}
