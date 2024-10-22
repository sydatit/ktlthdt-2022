package codelearn.leetcode;

import java.util.Arrays;
import java.util.List;

public class MaximumLengthConcatenatedStringUniqueCharacters {
    public static void main(String[] args) {

    }
//    public static int maxLength(List<String> list) {
//        int[][] counts = new int[list.size()][26];
//
//        for (int i = 0; i < list.size(); i++) {
//            String item = list.get(i);
//            analyzeAlphabetic(item, counts[i]);
//        }
//
//        for (int i = 1; i < counts.length; i++) {
//            int max = 0;
//            int finalIndex = -1;
//            for (int j = i - 1; j >= 0; j--) {
//                if (suitable(counts[i], counts[j]) && list.get(j).length() > max) {
//                    finalIndex = j;
//                }
//            }
//        }
//        return 0;
//    }
//
//    private static void analyzeAlphabetic(String item, int[] count) {
//        for (char c : item.toCharArray()) {
//            count[c - 'a']++;
//        }
//    }
}
