package org.example;

public class repeatedStringMatchSolution {
    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";
        int result = repeatedStringMatch(a, b);
        System.out.println(result); // Output: 3

    }
    public static int repeatedStringMatch(String a, String b) {
        StringBuilder repeatedString = new StringBuilder();
        int count = 0;

        while(repeatedString.length() < b.length()){
            repeatedString.append(a);
            count ++;
        }

        if(repeatedString.toString().contains(b)){
            return count;
        }

        repeatedString.append(a);
        if(repeatedString.toString().contains(b)){
            return count +1;
        }

        return -1;
    }
}
