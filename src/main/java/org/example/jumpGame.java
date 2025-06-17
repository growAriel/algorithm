package org.example;

public class jumpGame {
    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums)); // 输出: true
    }
 public static boolean canJump(int[] nums) {
        int maxReach = 0; // 最远可达位置
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // 如果当前位置超过了最远可达位置，说明无法到达
            }
            maxReach = Math.max(maxReach, i + nums[i]); // 更新最远可达位置
            if (maxReach >= nums.length - 1) {
                return true; // 如果最远可达位置已经超过或等于最后一个位置，返回true
            }
        }
        return false; // 遍历结束后仍未到达最后一个位置，返回false
    }
}
