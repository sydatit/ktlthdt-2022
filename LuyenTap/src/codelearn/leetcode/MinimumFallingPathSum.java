package codelearn.leetcode;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][] {
                {-19,57},
                {-40,-5},
        }));
    }
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp = dp[i - 1][j];
                if (j - 1 >= 0)
                    temp = Math.min(temp, dp[i - 1][j - 1]);
                if (j + 1 < m)
                    temp = Math.min(temp, dp[i - 1][j + 1]);
                dp[i][j] = matrix[i][j] + temp;
            }
        }
        for (int i = 0; i < m; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }
}
