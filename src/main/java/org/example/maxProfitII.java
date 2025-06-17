package org.example;

public class maxProfitII {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0; // Handle edge cases

        int profit = 0; // Initialize maxProfit to 0
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) { // If the current price is greater than the previous price
                profit += prices[i] - prices[i - 1]; // Add the profit from this transaction
            }
        }
        return profit; // Return the total profit
    }
}
