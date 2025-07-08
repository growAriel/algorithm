package org.example;

import java.util.Arrays;

public class candies {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        int result = candy(ratings);
        System.out.println(result); // Output: 5

        int[] ratings2 = {1, 2, 2};
        int result2 = candy(ratings2);
        System.out.println(result2); // Output: 4

        int ratings3[] = {1, 3, 2, 2, 1};
        int result3 = candy(ratings3);
        System.out.println(result3); // Output: 9
    }

    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length;
        int[] candies = new int[n];

        // Initialize candies array with 1 candy for each child
        for(int i =0; i < ratings.length; i++){
            candies[i]=1;
        }

        // First pass: left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Second pass: right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate the total number of candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }


    public int candy2(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for(int i = 1; i < ratings.length; i++){
            if(ratings[i-1] < ratings[i]){
                left[i] = left[i-1] +1;
            }
        }

        int count = left[ratings.length-1];

        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1] ){
                right[i] = right[i+1] +1;
            }
            count +=Math.max(left[i], right[i]);
        }
        return count;
    }
}
