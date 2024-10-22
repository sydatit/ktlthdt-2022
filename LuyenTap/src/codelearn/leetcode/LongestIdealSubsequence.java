package codelearn.leetcode;

import java.util.Arrays;

public class LongestIdealSubsequence {
    public static void main(String[] args) {
        LongestIdealSubsequence longestIdealSubsequence = new LongestIdealSubsequence();
//        System.out.println(longestIdealSubsequence.longestIdealString("acfgbd", 2)); // 4
//        System.out.println(longestIdealSubsequence.longestIdealString("abcd", 3)); // 3
        System.out.println(longestIdealSubsequence.longestIdealString("azaza", 25)); // 3
    }
    public int longestIdealString(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[n];
        int[] counts = new int[26];
        Arrays.fill(dp,1);
        counts[chars[0] - 'a']++;
        int max = 1;
        for (int i = 1; i < n; i++) {
            int indexInCounts = chars[i] - 'a';
            int minJ = Math.max(0, indexInCounts - k);
            int maxJ = Math.min(26, indexInCounts + k + 1);
            for (int j = minJ; j < maxJ; j++) {
                dp[i] = Math.max(dp[i], 1 + counts[j]);
            }
            counts[indexInCounts] = dp[i];
            max = Math.max(dp[i], max);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(counts));
        return max;
    }
}
