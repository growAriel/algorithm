package org.example;

import java.util.Arrays;

public class maximizeTopAfterKMoves {
    public static void main(String[] args) {
        int[] nums = {5,2,2,4,0,6};
        int k = 4;
        int result = maximumTop(nums, k);
        System.out.println(result); // Output: 5

        int[] nums2 = {2};
        int k2 = 1;
        int result2 = maximumTop(nums2, k2);
        System.out.println(result2); // Output: -1

        int[] nums3 = {68,76,53,73,85,87,58,24,48,59,38,80,38,65,90,38,45,22,3,28,11};
        int k3 = 1;
        int result3 = maximumTop(nums3, k3);
        System.out.println(result3); // Output: 76

        int[] nums4 = {91,98,17,79,15,55,47,86,4,5,17,79,68,60,60,31,72,85,25,77,8,78,40,96,76,69,95,2,42,87,48,72,45,25,40,60,21,91,32,79,2,87,80,97,82,94,69,43,18,19,21,36,44,81,99};
        int k4 = 2;
        int result4 = maximumTop(nums4, k4);
        System.out.println(result4); // Output: 91

        int[] nums5 = {100,9,6,8,7};
        int k5 = 5;
        int result5 = maximumTop(nums5, k5);
        System.out.println(result5); // Output: 100

        int[] nums6 = {35,43,23,86,23,45,84,2,18,83,79,28,54,81,12,94,14,0,0,29,94,12,13,1,48,85,22,95,24,5,73,10,96,97,72,41,52,1,91,3,20,22,41,98,70,20,52,48,91,84,16,30,27,35,69,33,67,18,4,53,86,78,26,83,13,96,29,15,34,80,16,49};
        int k6 = 15;
        int result6 = maximumTop(nums6, k6);
        System.out.println(result6); // Output: 94

    }
    public static int maximumTop(int[] nums, int k) {
        int n = nums.length;

        if(n == 1){
            return (k%2==1)?-1:nums[0];
        }

        // If k is 0, we cannot remove any elements, so we return the first element
        if(k == 0){
            return nums[0];
        }

        // if k is 1, we can only remove the first element and return the second element
        if(k == 1){
            return nums[1];
        }

        // If k is less than n, we can take the maximum of the first k-1 elements and the k-th element
        // If k is equal to n, we can take the maximum of the first k-1 elements
        // If k is greater than or equal to n, we can take the maximum of the entire array
        if(k<n){
           // int maxRemoved = Arrays.stream(nums, 0, k-1).max().getAsInt();
            return Math.max(Arrays.stream(nums, 0, k-1).max().getAsInt(), nums[k]);
        }else if(k==n){
            return Arrays.stream(nums, 0, k-1).max().getAsInt();
        }else {
            return Arrays.stream(nums, 0, n).max().getAsInt();
        }
    }
}
