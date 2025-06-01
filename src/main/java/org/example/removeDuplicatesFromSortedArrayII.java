package org.example;

public class removeDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int newLength = removeDuplicates(nums);
        System.out.println("New length: " + newLength);
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length; //

        int k = 2; // Start from the third element
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) { // Check if current element is different from the element two positions back
                nums[k++] = nums[i]; // Copy the unique element to the next position
            }
        }
        return k;
    }
}
