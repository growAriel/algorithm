package org.example;

import java.util.HashMap;

/**
 * This class provides two methods to replace each value in an array with its corresponding index.
 * The first method uses a simple array to store indices, while the second method uses a HashMap.
 *
 * You are given a list of N unique positive numbers ranging from 0 to (N - 1). Write an algorithm to replace the value of each number with its corresponding index value in the list.
 *
 * Input
 * The first line of the input consists of an integer size, representing the size of the list (N).
 * The next line consists of N space-separated integers, *arr[0], arr[1].... arr[N-1]* representing the given list of numbers.
 *
 * Output
 * Print N space-separated integers representing the list obtained by replacing the values of the numbers with their corresponding index values in the list.
 *
 * Constraints
 * 0 < size ≤ 10^5
 * 0 ≤ arr[i] ≤ 10^5
 * 0 ≤ i < size
 *
 * Note
 * All the numbers in the list are unique.
 *
 * Example
 * Input:
 * 4
 * 3 2 0 1
 */

public class replaceValueWithIndices {
    public static void main(String[] args) {
        int[] arr = {3,2,0,1};
        int[] indices = replaceValueWithIndices1(arr);

        int[] arr2 = {3,2,0,1};
        int[] indices2 = replaceValueWithIndices2(arr2);

        for (int index : indices) {
            System.out.print(index + " ");
        }

        for (int index : indices2) {
            System.out.print(index + " ");
        }
    }

    private static int[] replaceValueWithIndices2(int[] arr) {
        // Create a map to store value to index mapping
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();

        // Store each value's original index
        for (int i = 0; i < arr.length; i++) {
            valueToIndex.put(arr[i], i);
        }

        // Create result array by replacing each value with its index
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = valueToIndex.get(i);
        }

        return result;
    }

    public static int[] replaceValueWithIndices1(int[] arr) {
        int[] indices = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indices[arr[i]] = i; // Replace value with its corresponding index value
        }
        return indices;
    }

}
