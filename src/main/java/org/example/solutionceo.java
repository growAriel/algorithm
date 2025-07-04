import java.util.*;

public class solutionceo {
    public static void main(String[] args) {
        int[] test1 = {3, 4, 1, 5, 6, 7, 2}; // 期望输出5
        int[] test2 = {3, 4, 1, 2};           // 期望输出4
        //System.out.println(getMaxAttendingCEOs(test1.length, test1)); // 输出5
        System.out.println(getMaxAttendingCEOs(test2.length, test2)); // 输出4
    }

    public static int getMaxAttendingCEOs(int n, int[] likes) {
        // 记录每个节点的最长链长度
        int[] maxChain = new int[n];
        // 记录是否访问过
        boolean[] visited = new boolean[n];
        int maxCycle = 0;
        int pairSum = 0;

        // 先找所有环
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int cur = i;
                Map<Integer, Integer> pos = new HashMap<>();
                int step = 0;
                while (!pos.containsKey(cur) && !visited[cur]) {
                    pos.put(cur, step++);
                    cur = likes[cur];
                }
                if (!visited[cur] && pos.containsKey(cur)) {
                    int cycleLen = step - pos.get(cur);
                    if (cycleLen == 2) {
                        // 记录所有互相喜欢的对
                        int a = cur, b = likes[cur];
                        maxChain[a] = Math.max(maxChain[a], getChainLen(likes, a, b));
                        maxChain[b] = Math.max(maxChain[b], getChainLen(likes, b, a));
                        pairSum += 2;
                    } else {
                        maxCycle = Math.max(maxCycle, cycleLen);
                    }
                }
                // 标记所有访问过的节点
                for (int k : pos.keySet()) visited[k] = true;
            }
        }
        // 统计所有互相喜欢的对加上他们各自的链
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (likes[likes[i]] == i && i < likes[i]) {
                total += maxChain[i] + maxChain[likes[i]] + 2;
            }
        }
        return Math.max(maxCycle, total);
    }

    // 求以from为起点，不能经过to的最长链长度
    private static int getChainLen(int[] likes, int from, int to) {
        int len = 0;
        for (int i = 0; i < likes.length; i++) {
            if (i != from && i != to && likes[i] == from) {
                len = Math.max(len, 1 + getChainLen(likes, i, to));
            }
        }
        return len;
    }
}