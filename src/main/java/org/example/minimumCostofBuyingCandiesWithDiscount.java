package org.example;

public class minimumCostofBuyingCandiesWithDiscount {
    public static void main(String[] args) {
        int[] price = {1, 2, 3, 4, 5};
        int result = minimumCost(price);
        System.out.println(result); // Output: 7

        int[] price2 = {5, 5, 5};
        int result2 = minimumCost(price2);
        System.out.println(result2); // Output: 10
    }

    public static int minimumCost(int[] price) {
        if (price == null || price.length == 0) {
            return 0;
        }

        // Sort the prices in descending order
        java.util.Arrays.sort(price);
        int n = price.length;
        int totalCost = 0;

        // Iterate through the prices from the end
        for (int i = n - 1; i >= 0; i--) {
            // Add the price to total cost if it's not the third candy
            if ((n - i) % 3 != 0) {
                totalCost += price[i];
            }
        }

        return totalCost;
    }
}
