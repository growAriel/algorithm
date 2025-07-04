package org.example;

import java.util.Arrays;

public class flowerStickArrangement {
    public static void main(String[] args) {
        // 测试用例1（题目示例）
        int[] test1Sticks = {11, 7, 5, 10, 46, 23, 16, 8};
        int test1K = 3;
        System.out.println("测试用例1:");
        System.out.println("输入: " + Arrays.toString(test1Sticks) + ", K=" + test1K);
        System.out.println("输出: " + Arrays.toString(arrangeFlowerSticks(test1Sticks, test1K)));

        // 测试用例2（K=0，全部降序）
        int[] test2Sticks = {5, 3, 9, 1, 4};
        int test2K = 0;
        System.out.println("\n测试用例2:");
        System.out.println("输入: " + Arrays.toString(test2Sticks) + ", K=" + test2K);
        System.out.println("输出: " + Arrays.toString(arrangeFlowerSticks(test2Sticks, test2K)));

        // 测试用例3（K=数组长度，全部升序）
        int[] test3Sticks = {15, 3, 8, 2};
        int test3K = 4;
        System.out.println("\n测试用例3:");
        System.out.println("输入: " + Arrays.toString(test3Sticks) + ", K=" + test3K);
        System.out.println("输出: " + Arrays.toString(arrangeFlowerSticks(test3Sticks, test3K)));
    }

    public static int[] arrangeFlowerSticks(int[] flowerSticks, int k) {
        // 检查输入是否有效
        if (flowerSticks == null || flowerSticks.length == 0) {
            return new int[0];
        }
        // 处理前k个元素的升序排列
        int[] firstPart = Arrays.copyOfRange(flowerSticks, 0, k);
        Arrays.sort(firstPart);

        // 处理剩余元素的降序排列
        int[] secondPart = Arrays.copyOfRange(flowerSticks, k, flowerSticks.length);
        Arrays.sort(secondPart);
        reverseArray(secondPart);

        // 合并两部分
        int[] result = new int[flowerSticks.length];
        System.arraycopy(firstPart, 0, result, 0, firstPart.length);
        System.arraycopy(secondPart, 0, result, k, secondPart.length);

        return result;
    }


    private static void reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}