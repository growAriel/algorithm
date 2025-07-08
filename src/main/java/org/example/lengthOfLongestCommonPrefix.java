package org.example;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestCommonPrefix {
    public static void main(String[] args) {
        int[] arr1 = {123, 456, 789};
        int[] arr2 = {1234, 5678, 91011};
        int result = longestCommonPrefix(arr1, arr2);
        System.out.println(result); // Output: 3

        int[] arr3 = {12, 34, 56};
        int[] arr4 = {78, 90};
        int result2 = longestCommonPrefix(arr3, arr4);
        System.out.println(result2); // Output: 0

        int[] arr5 = {1, 2, 3};
        int[] arr6 = {4, 4, 4};
        int result3 = longestCommonPrefix(arr5, arr6);
        System.out.println(result3); // Output: 0

    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {

        Set<Integer> prefixSet1 = new HashSet<>();
        Set<Integer> prefixSet2 = new HashSet<>();


        for(int x: arr1){
            for(; x>0 ; x /= 10){
                prefixSet1.add(x);
            }
        }

        for(int x: arr2){
            for(; x >0; x/=10){
                prefixSet2.add(x);
            }
        }

        Set<Integer> intersection = new HashSet<>(prefixSet1);
        intersection.retainAll(prefixSet2);

        Integer result = 0;
        if(!intersection.isEmpty()){
            result = Collections.max(intersection);
        }
        return result==0? 0: String.valueOf(result).length();

    }
}
