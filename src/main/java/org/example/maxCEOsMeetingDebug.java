package org.example;

import java.util.*;

public class maxCEOsMeetingDebug {
    public static void main(String[] args) {
        int[] likes1 = {3, 4, 1, 5, 6, 7, 2}; // 输出: 5
        int[] likes2 = {3, 4, 1, 2};          // 输出: 4

        System.out.println("== Debug for likes1 ==");
        System.out.println("Max CEOs attending: " + maxCEOs(likes1));
        System.out.println("\n== Debug for likes2 ==");
        System.out.println("Max CEOs attending: " + maxCEOs(likes2));
    }

    public static int maxCEOs(int[] likes) {
        int n = likes.length;
        boolean[] visited = new boolean[n];
        int maxCycle = 0;

        for (int start = 0; start < n; start++) {
            if (!visited[start]) {
                List<Integer> path = new ArrayList<>();
                int current = start;

                while (current >= 0 && current < likes.length) {
                    if (visited[current]) {
                        // 找到环的起始位置
                        int cycleStart = path.indexOf(current);
                        if (cycleStart != -1) {
                            int cycleLength = path.size() - cycleStart;
                            maxCycle = Math.max(maxCycle, cycleLength);
                        }
                        break;
                    }

                    visited[current] = true;
                    path.add(current);
                    current = likes[current];
                }

                // 如果路径中没有环，跳过处理
                if (current < 0 || current >= likes.length) {
                    continue;
                }
            }
        }

        return maxCycle;
    }
}
