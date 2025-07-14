package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public static void main(String[] args) {
        // Example usage
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println("Three Sum Results: " + result);

        int[] nums2 = {-2,0,1,1,2};
        List<List<Integer>> result2 = threeSum(nums2);
        System.out.println("Three Sum Results: " + result2);
    }

    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int k =0; k< nums.length-2; k++){
            if(nums[k]>0) break;

            if(k>0 && nums[k] == nums[k-1]) continue;

            int left = k + 1, right= nums.length- 1;

            while(left < right){
                int sum = nums[k] + nums[left] + nums[right];
                if(sum < 0){
                    while(left <right && nums[left] == nums[++left]);
                }else if(sum > 0){
                    while(left < right && nums[right] == nums[--right]);
                }else{
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[left], nums[right], nums[k])));
                    while(left < right && nums[left] == nums[++left]);
                    while(left < right && nums[right] == nums[--right]);
                }
            }
        }
        return result;
    }
}
