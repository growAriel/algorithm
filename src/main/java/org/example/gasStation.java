package org.example;

public class gasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int result = canCompleteCircuit(gas, cost);
        System.out.println(result); // Output: 3

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        int result2 = canCompleteCircuit(gas2, cost2);
        System.out.println(result2); // Output: -1
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            // If current gas is negative, reset the start index
            if (currentGas < 0) {
                startIndex = i + 1;
                currentGas = 0;
            }
        }

        // If total gas is less than total cost, return -1
        return totalGas < totalCost ? -1 : startIndex;

    }

}
