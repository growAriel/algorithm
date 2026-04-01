package org.example.shl.submatrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubmatrixProduct {

    private static final long OVERFLOW = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine();
        StringTokenizer st = new StringTokenizer(firstLine);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long K;
        boolean hasKInFirstLine = st.hasMoreTokens();

        if (hasKInFirstLine) {
            K = Long.parseLong(st.nextToken());
        } else {
            K = -1; // 先占位
        }

        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 如果第一行没有K，这里读
        if (!hasKInFirstLine) {
            K = Long.parseLong(br.readLine().trim());
        }

        System.out.println(solve(A, N, M, K));
    }

    static long solve(int[][] A, int N, int M, long K) {
        long count = 0;
        long[] prod = new long[M];
        boolean[] zeroCol = new boolean[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int val = A[i][j];

                if (zeroCol[j]) {
                    count++;
                } else if (val == 0) {
                    zeroCol[j] = true;
                    prod[j] = 0;
                    count++;
                } else {
                    long base = (i == 0) ? (j == 0 ? 1L : prod[j - 1]) : prod[j];
                    long cur = safeMul(base, val, K);
                    prod[j] = cur;
                    if (cur != OVERFLOW) count++;
                }
            }
        }

        return count;
    }

    static long safeMul(long a, long b, long K) {
        if (a == OVERFLOW) return OVERFLOW;
        if (a > K / b) return OVERFLOW;
        return a * b;
    }
}