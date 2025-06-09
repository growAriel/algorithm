package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class majorityElementSolution {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        int result1 = majorityElement1(nums);
        int result2 = majorityElement2(nums);
        int result3 = majorityElement3(nums);
        System.out.println("Majority Element: " + result1);
        System.out.println("Majority Element: " + result2);
        System.out.println("Majority Element: " + result3);
    }

    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for(int num:nums){
            if(!counts.containsKey(num)){
                counts.put(num, 1);
            }else{
                counts.put(num,counts.get(num)+1);
            }
        }

        Map.Entry<Integer,  Integer> majorityElement = null;
        for(Map.Entry<Integer, Integer> entry: counts.entrySet()){
            if(majorityElement == null || entry.getValue()> majorityElement.getValue()){
                majorityElement = entry; // Update the majority element if the current one has a higher count
            }
        }
        return majorityElement.getKey(); // Return the key of the majority element

       /* return counts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalArgumentException("No majority element found"));*/
    }

    // simple linear scan to find the majority element
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums); // Sort the array
        return nums[nums.length/2]; // Return the middle element
    }

    // Boyer-Moore Voting Algorithm to find the majority element
    public static int majorityElement3(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num; // Set the candidate to the current number
            }
            count += (num == candidate) ? 1 : -1; // Increment or decrement the count
        }
        return candidate; // Return the majority element
    }
}
