package codelearn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumFallingPathSumII {
    public static void main(String[] args) {
        int[][] grid = {{-73,61,43,-48,-36},{3,30,27,57,10},{96,-76,84,59,-15},{5,-49,76,31,-7},{97,91,61,-46,67}};
        System.out.println(new MinimumFallingPathSumII().minFallingPathSum(grid));
    }
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[j] += grid[i][j];
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    if (k != j) {
                        min = Math.min(dp[k], min);
                    }
                }
                dp[j] += min;
            }
            System.out.println(Arrays.toString(dp));
        }

        return Arrays.stream(dp).min().getAsInt();
    }
}
