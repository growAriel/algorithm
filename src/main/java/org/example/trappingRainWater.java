package org.example;

public class trappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trap(height);
        System.out.println(result);

        int[] height2 = {4,2,0,3,2,5};
        int result2 = trap(height2);
        System.out.println(result2);
    }

    public static int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }

        return water;
    }

    public static int trapBruteForce(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = 0;
        rightMax[n - 1] = 0;

        //leftMax[] = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3}
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i-1]);
        }

        //rightMax[] = {3, 3, 3, 3, 2, 2, 2, 1, 1, 0, 0, 0}
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i+1]);
        }

        // Calculate the water trapped at each index
        int water = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            if (minHeight > height[i]) {
                water += minHeight - height[i];
            }
        }
        return water;
    }
}
