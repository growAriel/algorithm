package org.example;

public class maxProfit1 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0; // Handle edge cases

        int cost = prices[0]; // Initialize minPrice to the first price
        int profit = 0; // Initialize maxProfit to 0
        for(int price: prices){
            cost = Math.min(cost, price); // Update minPrice if current price is lower
            profit = Math.max(profit, price - cost); // Calculate profit if selling at current price
        }
        return profit; // Return the maximum profit found
    }
}
