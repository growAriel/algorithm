package org.example.algo;
public class solution {
    // 快速幂：计算 (base^exponent) % mod
    public static long fastPow(long base, long exponent, long mod) {
        long result = 1;
        base = base % mod;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent = exponent >> 1;
        }
        return result;
    }

    // 核心方法：输入 2 3 4 → 输出 4096
    public static int findSecretCode(int secretCode, int firstKey, int secondKey) {
        long S = secretCode;
        long N = firstKey;
        long M = secondKey;

        // 正确逻辑：S^(N*M) 取最后 M 位
        long exponent = N * M;       // 3*4=12
        long modValue = (long) Math.pow(10, M); // 10^4=10000
        long ans = fastPow(S, exponent, modValue); // 2^12 % 10000 = 4096

        return (int) ans;
    }

    // 测试入口
    public static void main(String[] args) {
        // 测试用例：输入 2 3 4
        System.out.println(findSecretCode(2, 3, 4));
    }
}