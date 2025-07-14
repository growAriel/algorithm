package org.example;

public class isSubsequenceSolution {
    public static void main(String[] args) {
        // Example usage
        String s = "abc";
        String t = "ahbgdc";
        boolean result = isSubsequence(s, t);
        System.out.println("Is '" + s + "' a subsequence of '" + t + "'? " + result);
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }
}
