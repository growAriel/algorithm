package org.example;

import java.util.Arrays;

public class hIndex {
    public static void main(String[] args) {
        int[] citations1 = {3, 0, 6, 1, 5};
        int[] citations2 = {1, 3, 1};
        System.out.println(hIndex(citations1)); // 输出: 3
        System.out.println(hIndex(citations2)); // 输出: 1
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}