package org.example;

import java.util.*;

public class flowerStick {
    // Algorithm logic in one function
    public static int[] arrangeFlowerSticks(int[] flowerSticks, int k) {
        int n = flowerSticks.length;
     
        int[] result = new int[n];
        // First k: sort ascending
        int[] firstPart = Arrays.copyOfRange(flowerSticks, 0, k);
        Arrays.sort(firstPart);
        // Remaining n-k: sort descending
        int[] secondPart = Arrays.copyOfRange(flowerSticks, k, n);
        Arrays.sort(secondPart);
        for (int i = 0; i < secondPart.length / 2; i++) {
            int temp = secondPart[i];
            secondPart[i] = secondPart[secondPart.length - 1 - i];
            secondPart[secondPart.length - 1 - i] = temp;
        }
        // Merge
        System.arraycopy(firstPart, 0, result, 0, k);
        System.arraycopy(secondPart, 0, result, k, n - k);
        return result;
    }

    // Helper to print array
    public static String arrToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Test case 1: Given input/output from the problem
        int[] sticks1 = {11, 7, 5, 10, 46, 23, 16, 8};
        int k1 = 3;
        System.out.println("Test 1:");
        System.out.println("Input: sticks=" + Arrays.toString(sticks1) + ", k=" + k1);
        int[] out1 = arrangeFlowerSticks(sticks1, k1);
        System.out.println("Output: " + arrToString(out1));
        System.out.println("Expected: 5 7 11 46 23 16 10 8");
        System.out.println();

        // Test case 2: All ascending
        int[] sticks2 = {5, 3, 9, 1, 4};
        int k2 = 5;
        System.out.println("Test 2:");
        System.out.println("Input: sticks=" + Arrays.toString(sticks2) + ", k=" + k2);
        int[] out2 = arrangeFlowerSticks(sticks2, k2);
        System.out.println("Output: " + arrToString(out2));
        System.out.println();

        // Test case 3: All descending
        int[] sticks3 = {5, 3, 9, 1, 4};
        int k3 = 0;
        System.out.println("Test 3:");
        System.out.println("Input: sticks=" + Arrays.toString(sticks3) + ", k=" + k3);
        int[] out3 = arrangeFlowerSticks(sticks3, k3);
        System.out.println("Output: " + arrToString(out3));
        System.out.println();

        // Test case 4: k = 1
        int[] sticks4 = {8, 2, 5, 7};
        int k4 = 1;
        System.out.println("Test 4:");
        System.out.println("Input: sticks=" + Arrays.toString(sticks4) + ", k=" + k4);
        int[] out4 = arrangeFlowerSticks(sticks4, k4);
        System.out.println("Output: " + arrToString(out4));
        System.out.println();

        // Test case 5: k = n-1
        int[] sticks5 = {10, 20, 30, 40, 50};
        int k5 = 4;
        System.out.println("Test 5:");
        System.out.println("Input: sticks=" + Arrays.toString(sticks5) + ", k=" + k5);
        int[] out5 = arrangeFlowerSticks(sticks5, k5);
        System.out.println("Output: " + arrToString(out5));
        System.out.println();
    }
} 