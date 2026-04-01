package org.example.shl.ceo;

import java.util.*;

public class ceo {

    public static int maxCEOs(int[] like) {
        int n = like.length;
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            indegree[like[i]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] depth = new int[n];

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            int v = like[u];
            depth[v] = Math.max(depth[v], depth[u] + 1);

            indegree[v]--;
            if (indegree[v] == 0) {
                q.offer(v);
            }
        }

        boolean[] visited = new boolean[n];
        int maxCycle = 0;
        int pairSum = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] > 0 && !visited[i]) {
                int cur = i;
                int len = 0;

                while (!visited[cur]) {
                    visited[cur] = true;
                    cur = like[cur];
                    len++;
                }

                if (len == 2) {
                    int a = i;
                    int b = like[i];
                    pairSum += 2 + depth[a] + depth[b];
                } else {
                    maxCycle = Math.max(maxCycle, len);
                }
            }
        }

        return Math.max(maxCycle, pairSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] like = new int[num];

        for (int i = 0; i < num; i++) {
            like[i] = sc.nextInt() - 1; // 转成0-based
        }

        int result = maxCEOs(like);
        System.out.println(result);

        sc.close();
    }
}