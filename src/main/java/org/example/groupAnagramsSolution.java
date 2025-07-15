package org.example;

import java.util.*;

public class groupAnagramsSolution {
    public static void main(String[] args) {
        // Example usage
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println("Grouped Anagrams: " + result);

        String[] strs2 = {"", "b"};
        List<List<String>> result2 = groupAnagrams(strs2);
        System.out.println("Grouped Anagrams: " + result2);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            anagramMap.putIfAbsent(sortedStr, new ArrayList<>());
            anagramMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }
}
