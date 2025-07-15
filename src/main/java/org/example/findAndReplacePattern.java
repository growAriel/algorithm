package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findAndReplacePattern {
    public static void main(String[] args) {
        // Example usage
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        findAndReplacePattern solution = new findAndReplacePattern();
        List<String> result = solution.findAndReplacePattern(words, pattern);
        System.out.println("Words matching the pattern: " + result);

    }

        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> result = new ArrayList<>();

            for(int i =0; i < words.length; i++){
                String word = words[i];
                if(wordPattern(word, pattern)){
                    result.add(word);
                }
            }
            return result;
        }

        public boolean wordPattern(String word, String pattern){
            Map<Character, Character> word2pattern = new HashMap<>();
            Map<Character, Character> pattern2word = new HashMap<>();

            for(int i =0; i <word.length(); i++){
                char w = word.charAt(i);
                char p = pattern.charAt(i);

                if(!word2pattern.containsKey(w)){
                    word2pattern.put(w, p);
                }else if(word2pattern.get(w)!=p){
                    return false;
                }

                if(!pattern2word.containsKey(p)){
                    pattern2word.put(p, w);
                }else if(pattern2word.get(p)!=w){
                    return false;
                }
            }
            return true;
        }

}

