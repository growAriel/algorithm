package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class distributeCandies {
    public static void main(String[] args) {
        int[] candies = {1, 1, 2, 2, 3, 3};
        int result = distributeCandies(candies);
        System.out.println(result); // Output: 3

        int[] candies2 = {1, 1, 2, 3};
        int result2 = distributeCandies(candies2);
        System.out.println(result2); // Output: 2
    }
    public static int distributeCandies(int[] candies) {
        if (candies == null || candies.length == 0) {
            return 0;
        }

        // Use a HashSet to store unique candy types
        Set<Integer> uniqueCandies = new HashSet<>();
        for (int candy : candies) {
            uniqueCandies.add(candy);
        }

        // The maximum number of different types of candies the sister can eat
        int maxTypes = candies.length / 2;

        // Return the minimum of unique candy types and maxTypes
        return Math.min(uniqueCandies.size(), maxTypes);
    }

    public static int distributeCandies2(int[] candies) {
        if (candies == null || candies.length == 0) {
            return 0;
        }
        return (int)Math.min(candies.length/2, Arrays.stream(candies).distinct().count());
    }
}
