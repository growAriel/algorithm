package org.example;

public class removeDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4};
        int newLength = removeDuplicates(nums);
        System.out.println("New length: " + newLength);
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // Handle empty array case

        int k = 1; // Pointer for the next unique element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) { // Check if current element is different from the last unique element
                nums[k++] = nums[i]; // Copy the unique element to the next position
            }
        }
        return k; // Return the new length of the array
    }
}
