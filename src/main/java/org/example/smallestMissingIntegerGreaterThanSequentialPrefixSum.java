package org.example;

import java.util.HashSet;
import java.util.Set;

public class smallestMissingIntegerGreaterThanSequentialPrefixSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int result = missingInteger(nums);
        System.out.println(result); // Output: 15

        int[] nums2 = {1, 2, 4, 5};
        int result2 = missingInteger(nums2);
        System.out.println(result2); // Output: 3
    }

    public static int missingInteger(int[] nums) {
        int sum = nums[0];

        for(int i =1; i< nums.length; i++){
            if(nums[i] == nums[i-1] +1){
                sum += nums[i];
            } else {
                break;
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }

        while(set.contains(sum)){
            sum++;
        }
        return sum;
    }
}
