package org.example.secretCode;

public class secretCode {

    // 快速幂
    public static long fastPow(long base, long exponent, long mod) {
        long result = 1;
        base %= mod;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }
        return result;
    }

    public static int findSecretCode(int secretCode, int firstKey, int secondKey) {
        int MOD = 1000000007;

        // Step1: S^N % 10
        long part1 = fastPow(secretCode, firstKey, 10);

        // Step2: (part1)^M % MOD
        long result = fastPow(part1, secondKey, MOD);

        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(findSecretCode(2, 3, 4)); // 4096
        System.out.println(findSecretCode(3, 1000000007, 4)); // 2401
    }
}