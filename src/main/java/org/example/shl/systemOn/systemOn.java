package org.example.shl.systemOn;

import java.util.*;

public class systemOn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int systemCount = scanner.nextInt();

        int[] systemState = new int[systemCount];
        for (int i = 0; i < systemCount; i++) {
            systemState[i] = scanner.nextInt();
        }

        long[] position = new long[systemCount];
        for (int i = 0; i < systemCount; i++) {
            position[i] = scanner.nextLong();
        }

        List<Integer> onIndices = new ArrayList<>();
        for (int i = 0; i < systemCount; i++) {
            if (systemState[i] == 1) {
                onIndices.add(i);
            }
        }

        // 题目保证至少有一个 ON，这里只是防御性写法
        if (onIndices.isEmpty()) {
            System.out.println(0);
            return;
        }

        long totalCableLength = 0;

        int firstOnIndex = onIndices.get(0);
        int lastOnIndex = onIndices.get(onIndices.size() - 1);

        // 1) 第一个 ON 左边：必须逐个串起来
        for (int i = 0; i < firstOnIndex; i++) {
            totalCableLength += position[i + 1] - position[i];
        }

        // 2) 最后一个 ON 右边：必须逐个串起来
        for (int i = lastOnIndex; i < systemCount - 1; i++) {
            totalCableLength += position[i + 1] - position[i];
        }

        // 3) 两个 ON 之间
        for (int group = 0; group < onIndices.size() - 1; group++) {
            int leftOnIndex = onIndices.get(group);
            int rightOnIndex = onIndices.get(group + 1);

            long segmentLength = position[rightOnIndex] - position[leftOnIndex];
            long largestGap = 0;

            for (int i = leftOnIndex; i < rightOnIndex; i++) {
                largestGap = Math.max(largestGap, position[i + 1] - position[i]);
            }

            totalCableLength += segmentLength - largestGap;
        }

        System.out.println(totalCableLength);
    }
}