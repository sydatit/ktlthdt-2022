package codelearn.leetcode;

import java.util.HashSet;
import java.util.Set;

public class OptimalPartitionString {
    public static void main(String[] args) {
        String s = "abacaba";

        System.out.println();
    }
    public int partitionString(String s) {
        Set<Character> characters = new HashSet<>();
        int result = s.length() > 0 ? 1 : 0 ;
        for (int i = 0; i < s.length(); i++) {
            char charI = s.charAt(i);
            if(characters.contains(charI)){
                result++;
                characters.clear();
            }

            characters.add(charI);
        }
        return result;
    }


}
