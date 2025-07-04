package org.example;

import java.util.*;

public class sortListPartial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputListSize = scanner.nextInt(); // N
        int[] arr = new int[inputListSize];

        for (int i = 0; i < inputListSize; i++) {
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt(); // K

        // 分成两部分
        int[] firstPart = Arrays.copyOfRange(arr, 0, k);
        int[] secondPart = Arrays.copyOfRange(arr, k, inputListSize);

        // 升序排序前K个元素
        Arrays.sort(firstPart);

        // 降序排序剩下的元素
        Arrays.sort(secondPart);
        reverseArray(secondPart);

        // 合并两个数组
        int[] result = new int[inputListSize];
        System.arraycopy(firstPart, 0, result, 0, k);
        System.arraycopy(secondPart, 0, result, k, inputListSize - k);

        // 输出结果
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }
    }

    // 反转数组的辅助函数
    private static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}