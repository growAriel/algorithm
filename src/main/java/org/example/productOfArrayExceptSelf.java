package org.example;

public class productOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] answer = new int[n];

        int[] prefix = new int[n];
        prefix[0] = 1;
        for(int i = 1; i < n; i ++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        int[] suffix = new int[n];
        suffix[n-1] = 1;
        for(int i = n - 2; i>=0; i--){
            suffix[i]=suffix[i+1] * nums[i+1];
        }

        for(int i = 0; i < n; i++){
            answer[i] = prefix[i] * suffix[i];
        }
        return answer;
    }
}
