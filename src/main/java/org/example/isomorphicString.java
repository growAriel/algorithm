package org.example;

import java.util.HashMap;
import java.util.Map;

public class isomorphicString {
    public static void main(String[] args) {
        // Example usage
        String s = "egg";
        String t = "add";
        boolean result = isIsomorphic(s, t);
        System.out.println("Are '" + s + "' and '" + t + "' isomorphic? " + result);
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapS = new HashMap<>(), mapT = new HashMap<>();

        for(int i =0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(mapS.containsKey(charS) && mapS.get(charS) != charT || mapT.containsKey(charT)&& mapT.get(charT) != charS) {
                return false; // Mismatch in mapping from s to t or t to s
            }

            mapS.put(charS, charT);
            mapT.put(charT, charS);
        }

        return true;
    }
}
