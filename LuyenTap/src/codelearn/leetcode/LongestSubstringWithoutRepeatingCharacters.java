package codelearn.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
