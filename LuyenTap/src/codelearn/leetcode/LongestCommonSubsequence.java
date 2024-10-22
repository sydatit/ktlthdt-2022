package codelearn.leetcode;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            char charT1 = text1.charAt(i);
            for (int j = 0; j < m; j++) {
                char charT2 = text2.charAt(j);
                if (charT1 == charT2) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else
                    dp[i + 1][j + 1] = Math.max( dp[i + 1][j], dp[i][j + 1]);

            }
            max = Math.max(max, dp[i + 1][m]);
        }

        return max;
    }
}
