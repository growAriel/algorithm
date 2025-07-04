package org.example;

import java.util.HashSet;

import java.util.Arrays;
import java.util.Set;

public class giftBasketCounter {
    public static void main(String[] args) {
        // 测试用例1：示例情况
        int[] prices1 = {1, 3, 5, 7};
        int k1 = 2;
        System.out.println("测试用例1:");
        System.out.println("商品价格: " + Arrays.toString(prices1));
        System.out.println("目标价格差: " + k1);
        System.out.println("幸运顾客数: " + countLuckyCustomers2(prices1, k1)); // 应输出3

        // 测试用例2：无满足条件的组合
        int[] prices2 = {2, 4, 6, 8};
        int k2 = 3;
        System.out.println("\n测试用例2:");
        System.out.println("商品价格: " + Arrays.toString(prices2));
        System.out.println("目标价格差: " + k2);
        System.out.println("幸运顾客数: " + countLuckyCustomers(prices2, k2)); // 应输出0

        // 测试用例3：包含重复差值
        int[] prices3 = {1, 5, 3, 4, 2};
        int k3 = 1;
        System.out.println("\n测试用例3:");
        System.out.println("商品价格: " + Arrays.toString(prices3));
        System.out.println("目标价格差: " + k3);
        System.out.println("幸运顾客数: " + countLuckyCustomers(prices3, k3)); // 应输出4

        // 测试用例4：单个商品
        int[] prices4 = {10};
        int k4 = 5;
        System.out.println("\n测试用例4:");
        System.out.println("商品价格: " + Arrays.toString(prices4));
        System.out.println("目标价格差: " + k4);
        System.out.println("幸运顾客数: " + countLuckyCustomers(prices4, k4)); // 应输出0
    }

    public static int countLuckyCustomers(int[] prices, int k) {
        Set<Integer> priceSet = new HashSet<>();
        for (int price : prices) {
            priceSet.add(price);
        }

        int count = 0;
        for (int price : prices) {
            if (priceSet.contains(price + k)) {
                count++;
            }
            // 不需要检查price - k，因为会被其他元素遍历到
            // 例如：当检查3时发现1（3-2=1），当检查1时会发现3（1+2=3）
        }
        return count;
    }

    public static int countLuckyCustomers2(int[] prices, int k) {
        int count = 0;
        Set<String> pairs = new HashSet<>();
        
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (Math.abs(prices[i] - prices[j]) == k) {
                    // Create a unique key for the pair (order doesn't matter)
                    String pair = prices[i] < prices[j] ? 
                        prices[i] + "," + prices[j] : 
                        prices[j] + "," + prices[i];
                    pairs.add(pair);
                }
            }
        }
        
        return pairs.size();
    }
}