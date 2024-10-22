package codelearn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DetermineTwoStringsAreClose {
    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));
    }
    public static boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n != m) return false;
        int[] firstCountW = new int[26];
        int[] secondCountW = new int[26];
        Map<Integer, Integer> fMap = new HashMap<>();
        Map<Integer, Integer> sMap = new HashMap<>();
        for (char c: word1.toCharArray()) {
            firstCountW[c - 'a']++;
        }
        for (char c: word2.toCharArray()) {
            secondCountW[c - 'a']++;
        }
//        System.out.println(Arrays.toString(firstCountW));
//        System.out.println(Arrays.toString(secondCountW));
        for (int i = 0; i < firstCountW.length; i++) {
            if (firstCountW[i] != 0) {
                int count = fMap.getOrDefault(firstCountW[i], 0);
                fMap.put(firstCountW[i], ++count);
            }
            if (secondCountW[i] != 0) {
                int count = sMap.getOrDefault(secondCountW[i], 0);
                sMap.put(secondCountW[i], ++count);
            }
        }
        for (Map.Entry<Integer, Integer> item : fMap.entrySet()) {
            if (!sMap.containsKey(item.getKey()))
                return false;
            if (!sMap.get(item.getKey()).equals(item.getValue()))
                return false;
        }
        return true;
    }
}
