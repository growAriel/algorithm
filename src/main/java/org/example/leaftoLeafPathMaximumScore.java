package org.example;

import java.util.*;

public class leaftoLeafPathMaximumScore {
    static int[] values; // 节点值
    static List<Integer>[] tree; // 邻接表
    static long maxProduct = Long.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 节点数量
        values = new int[n + 1]; // 1-based
        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
        }

        int numEdges = sc.nextInt();
        int numNodes = sc.nextInt(); // 始终为 2

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < numEdges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        sc.close();

        boolean[] visited = new boolean[n + 1];
        maxProduct = calculateMaxProduct(1, visited);

        System.out.println(maxProduct);
    }

    private static long calculateMaxProduct(int node, boolean[] visited) {
        visited[node] = true;
        long maxChildProduct = 0;
        long secondMaxChildProduct = 0;

        for (int neighbor : tree[node]) {
            if (!visited[neighbor]) {
                long childProduct = calculateMaxProduct(neighbor, visited);
                if (childProduct > maxChildProduct) {
                    secondMaxChildProduct = maxChildProduct;
                    maxChildProduct = childProduct;
                } else if (childProduct > secondMaxChildProduct) {
                    secondMaxChildProduct = childProduct;
                }
            }
        }

        if (secondMaxChildProduct > 0) {
            maxProduct = Math.max(maxProduct, maxChildProduct * secondMaxChildProduct);
        }

        return values[node] + maxChildProduct;
    }
}
