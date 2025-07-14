package org.example;

import java.util.Arrays;
import java.util.List;

public class threeSum {
    public static void main(String[] args) {
        // Example usage
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println("Three Sum Results: " + result);
    }

    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new java.util.ArrayList<>();

        for(int k =0; k< nums.length -2; k++){
            if(nums[k] > 0) {
                break; // Since the array is sorted, no need to continue if the current number is greater than 0
            }
            if(k > 0 && nums[k] == nums[k-1]) {
                continue; // Skip duplicates
            }
            int left = k + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[k] + nums[left] + nums[right];
                if(sum < 0) {
                    while(left < right && nums[left] == nums[++left]);
                    // Skip duplicates

                } else if(sum > 0) {
                    while(left < right && nums[right] == nums[--right]);

                } else {
                    result.add(Arrays.asList(nums[k], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) {
                        left++; // Skip duplicates
                    }
                    while(left < right && nums[right] == nums[right - 1]) {
                        right--; // Skip duplicates
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
