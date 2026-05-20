package org.example.shl.university;

import java.util.*;

public class university {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] like = new int[n];

        for (int i = 0; i < n; i++) {
            like[i] = sc.nextInt();
        }
        // 如果输入是 1..N（题目示例是这种情况），转成 0..N-1
        boolean needShift = false;
        for (int v : like) {
            if (v >= n) {
                needShift = true;
                break;
            }
        }
        if (needShift) {
            for (int i = 0; i < n; i++) {
                like[i] = like[i] - 1;
            }
        }

        List<Integer> result = findBestCycle(n, like);

        // 输出（题目示例是 1-based）
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result.get(i) + (needShift ? 1 : 0));
        }
        System.out.println();

        sc.close();
    }

    private static List<Integer> findBestCycle(int n, int[] like) {
        int[] state = new int[n]; // 0=未访问 1=当前路径 2=已完成

        int maxSize = 0;
        List<Integer> best = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (state[i] != 0) continue;

            Map<Integer, Integer> pos = new HashMap<>();
            int cur = i;
            int step = 0;

            while (state[cur] == 0) {
                state[cur] = 1;
                pos.put(cur, step++);
                cur = like[cur];
            }

            if (state[cur] == 1) {
                int start = pos.get(cur);
                List<Integer> cycle = new ArrayList<>();

                for (Map.Entry<Integer, Integer> e : pos.entrySet()) {
                    if (e.getValue() >= start) {
                        cycle.add(e.getKey());
                    }
                }

                Collections.sort(cycle);

                if (cycle.size() > maxSize ||
                        (cycle.size() == maxSize && isLexicographicallySmaller(cycle, best))) {
                    maxSize = cycle.size();
                    best = cycle;
                }
            }

            cur = i;
            while (state[cur] == 1) {
                state[cur] = 2;
                cur = like[cur];
            }
        }

        return best;
    }

    private static boolean isLexicographicallySmaller(List<Integer> a, List<Integer> b) {
        if (b.isEmpty()) return true;
        int len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }
}