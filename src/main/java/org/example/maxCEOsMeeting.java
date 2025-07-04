package org.example;

import java.util.*;

public class maxCEOsMeeting {
    public static void main(String[] args) {
        // 示例测试用例
        int[] likes1 = {3, 4, 1, 5, 6, 7, 2}; // 输出: 5
        int[] likes2 = {3, 4, 1, 2};          // 输出: 4

        System.out.println(maxCEOs(likes1));
        System.out.println(maxCEOs(likes2));
    }

    public static int maxCEOs(int[] likes) {
        int n = likes.length;
        boolean[] visited = new boolean[n];
        int maxRing = 0;
        int pairChainSum = 0;

        // 用于记录每对互相喜欢的人及其可拓展的链长度
        int[] maxChainTo = new int[n];

        // Step 1: 遍历所有 CEO，寻找环和互相喜欢的组合
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int current = i;
            Map<Integer, Integer> path = new HashMap<>();
            int length = 0;

            // 找环或终止点
            while (!path.containsKey(current) && !visited[current] && likes[current] < n) {
                path.put(current, length++);
                current = likes[current];
            }

            // 如果形成一个环
            if (path.containsKey(current)) {
                int ringSize = length - path.get(current);
                if (ringSize == 2) {
                    // 互相喜欢的情况
                    int a = current;
                    int b = likes[current];
                    maxChainTo[a] = Math.max(maxChainTo[a], path.get(a));
                    maxChainTo[b] = Math.max(maxChainTo[b], path.get(b));
                } else {
                    maxRing = Math.max(maxRing, ringSize);
                }
            }

            // 标记路径为已访问
            for (int node : path.keySet()) {
                visited[node] = true;
            }
        }

        // Step 2: 汇总所有互相喜欢的对以及它们可拓展的链长度
        for (int i = 0; i < n; i++) {
            int j = likes[i];
            if (j < n && likes[j] == i && i < j) { // 保证只算一次
                pairChainSum += 2 + maxChainTo[i] + maxChainTo[j];
            }
        }

        return Math.max(maxRing, pairChainSum);
    }
}
