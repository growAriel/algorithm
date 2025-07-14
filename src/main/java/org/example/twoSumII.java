package org.example;

public class twoSumII {
    public static void main(String[] args) {
        // Example usage
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        twoSumII solution = new twoSumII();
        int[] result = solution.twoSum(numbers, target);
        System.out.println("Indices of the two numbers that add up to " + target + ": [" + result[0] + ", " + result[1] + "]");
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for(int i = 0;  i < numbers.length-1; i++){
            for(int j = i+1; j<numbers.length; j ++){
                if(numbers[i] + numbers[j] == target){
                    result[0]=i+1;
                    result[1]=j+1;
                }
            }
        }
        return result;
    }

    public int[] twoSumOptimized(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // Return 1-based indices
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0]; // Return an empty array if no solution is found
    }
}
