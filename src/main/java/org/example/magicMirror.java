package org.example;

public class magicMirror {
    public static void main(String[] args) {
        // 测试用例1：正常右旋转情况
        String word1 = "sample";
        String word2 = "plesam";
        System.out.println("测试用例1:");
        System.out.println("输入: word1=" + word1 + ", word2=" + word2);
        System.out.println("输出: " + findRotationIndex(word1, word2));  // 应输出2

        // 测试用例2：不是右旋转的情况
        word1 = "hello";
        word2 = "world";
        System.out.println("\n测试用例2:");
        System.out.println("输入: word1=" + word1 + ", word2=" + word2);
        System.out.println("输出: " + findRotationIndex(word1, word2));  // 应输出-1

        // 测试用例3：完全相同的字符串
        word1 = "rotation";
        word2 = "rotation";
        System.out.println("\n测试用例3:");
        System.out.println("输入: word1=" + word1 + ", word2=" + word2);
        System.out.println("输出: " + findRotationIndex(word1, word2));  // 应输出0

        // 测试用例4：长度不同的情况
        word1 = "abcd";
        word2 = "abcde";
        System.out.println("\n测试用例4:");
        System.out.println("输入: word1=" + word1 + ", word2=" + word2);
        System.out.println("输出: " + findRotationIndex(word1, word2));  // 应输出-1
    }

    public static int findRotationIndex(String word1, String word2) {
        // 检查长度是否相同
        if (word1.length() != word2.length()) {
            return -1;
        }

        // 检查是否是完全相同的字符串
        if (word1.equals(word2)) {
            return 0;
        }

        // 将word1与自身连接，方便检查所有可能的旋转
        String doubledWord1 = word1 + word1;

        // 检查word2是否是doubledWord1的子串
        int index = doubledWord1.indexOf(word2);
        if (index != -1) {
            // 计算旋转起始索引
            return (word1.length() - index) % word1.length();
        }

        return -1;
    }
}