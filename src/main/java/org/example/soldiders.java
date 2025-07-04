package org.example;

import java.util.*;

public class soldiders {
    /**
     * Performs the soldier swap actions and returns the ID at the requested position.
     * @param N Number of soldiers
     * @param actions List of int[]{row, col} pairs for each action
     * @param K The position to query (1-based)
     * @return The ID of the soldier at position K after all actions
     */
    public static int findSoldierAtPosition(int N, List<int[]> actions, int K) {
        int[] soldiers = new int[N];
        for (int i = 0; i < N; i++) soldiers[i] = i + 1;
        for (int[] action : actions) {
            int row = action[0] - 1; // convert to 0-based
            int col = action[1] - 1;
            int m = 0;
            while (row + m < col - m) {
                int left = row + m;
                int right = col - m;
                int temp = soldiers[left];
                soldiers[left] = soldiers[right];
                soldiers[right] = temp;
                m++;
            }
        }
        return soldiers[K - 1];
    }

    public static void main(String[] args) {
        // Example test case from the description (add your own as needed)
        // Input: N = 5, Q = 1, S = 2, actions = [[2, 5]], K = 3
        int N = 5;
        List<int[]> actions = new ArrayList<>();
        actions.add(new int[]{2, 5});
        int K = 3;
        System.out.println("Test 1: " + findSoldierAtPosition(N, actions, K)); // Expected output depends on swaps

        // Additional test cases
        // Test 2: No actions
        N = 4;
        actions = new ArrayList<>();
        K = 2;
        System.out.println("Test 2: " + findSoldierAtPosition(N, actions, K)); // Should be 2

        // Test 3: Multiple actions
        N = 6;
        actions = new ArrayList<>();
        actions.add(new int[]{1, 6});
        actions.add(new int[]{2, 5});
        K = 4;
        System.out.println("Test 3: " + findSoldierAtPosition(N, actions, K));
    }
}