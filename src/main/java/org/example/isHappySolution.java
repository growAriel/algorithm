package org.example;

public class isHappySolution {
    public static void main(String[] args) {
        // Example usage
        int n = 19;
        boolean result = isHappy(n);
        System.out.println("Is " + n + " a happy number? " + result);

        int n2 = 2;
        boolean result2 = isHappy(n2);
        System.out.println("Is " + n2 + " a happy number? " + result2);
    }
    public static boolean isHappy(int n) {
        if (n <= 0) return false;
        int slow = n, fast = getNext(n);
        while(slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return slow == 1;
    }
    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n /= 10;
        }
        return totalSum;
    }
}
