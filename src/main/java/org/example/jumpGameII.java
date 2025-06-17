package org.example;

public class jumpGameII {
    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};
        System.out.println(jump(nums)); // 输出: 2
    }
    public static int jump(int[] nums) {
        int jumps = 0; // 跳跃次数
        int currentEnd = 0; // 当前跳跃的最远位置
        int farthest = 0; // 最远可达位置

        for (int i = 0; i < nums.length -1; i++) { // 不��要到达最后一个位置
            farthest = Math.max(farthest, i + nums[i]); // 更新最远可达位置
            if (i == currentEnd) { // 到达当前跳跃的最远位置
                jumps++; // 增加跳跃次数
                currentEnd = farthest; // 更新当前跳跃的最远位置
            }
        }
        return jumps;
    }
}
