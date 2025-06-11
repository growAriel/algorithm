package org.example;

public class rotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        //rotate1(nums, k);
        rotate2(nums, k); // Using the efficient method
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    //one way to rotate an array, but not the most efficient, when K=54944, timeout
    public static void rotate1(int[] nums, int k) {
        while (k>0) {
            int last = nums[nums.length - 1]; // Store the last element
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1]; // Shift elements to the right
            }
            nums[0] = last; // Place the last element at the front
            k--; // Decrease k after each rotation
        }
    }

    // Efficient way to rotate an array using reverse
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length; // Handle cases where k is greater than the length of the array
        reverse(nums, 0, nums.length - 1); // Reverse the entire array
        reverse(nums, 0, k - 1); // Reverse the first k elements
        reverse(nums, k, nums.length - 1); // Reverse the remaining elements
    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start]; // Swap elements
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
