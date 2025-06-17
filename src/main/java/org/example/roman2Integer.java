package org.example;

import java.util.HashMap;
import java.util.Map;

public class roman2Integer {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s)); // 输出: 1994
    }
    public static int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL",40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int total = 0; // 初始化总值

        for(int i = 0; i < s.length(); i++) {
            // 检查是否有两个字符的组合
            if (i < s.length() - 1 && map.containsKey(s.substring(i, i + 2))) {
                total += map.get(s.substring(i, i + 2)); // 如果有组合，添加其值
                i++; // 跳过下一个字符
            } else {
                total += map.get(s.substring(i, i + 1)); // 否则添加单个字符的值
            }
        }

        return total; // 返回总值

    }
}
