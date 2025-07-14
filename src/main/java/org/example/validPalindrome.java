package org.example;

public class validPalindrome {

    public static void main(String[] args) {
        // Example usage
        String s = "A man, a plan, a canal: Panama";
        boolean result = isValidPalindrome(s);
        System.out.println("Is the string a valid palindrome? " + result);
    }
    public static boolean isValidPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

}
