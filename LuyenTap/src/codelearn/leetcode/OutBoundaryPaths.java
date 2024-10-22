package codelearn.leetcode;

import java.util.Arrays;

public class OutBoundaryPaths {
    public OutBoundaryPaths() {
    }

    public static void main(String[] args) {
        OutBoundaryPaths paths = new OutBoundaryPaths();
        System.out.println(paths.findPaths(2, 2, 2, 0, 0));
    }
    private int[][][] dp;
    private final int MOD = (int) (1e9 + 7);
    public int findPaths(int n, int m, int maxMove, int startRow, int startColumn) {
        dp = new int[n + 1][m + 1][maxMove + 1];
        for (int[][] grid : dp) {
            for (int[] row : grid) {
                Arrays.fill(row, -1); // Initialize with -1 indicating not calculated yet
            }
        }
        return tryToMove(n, m, maxMove, startRow, startColumn);
    }

    private int tryToMove(int n, int m, int remainMoves, int i, int j) {
        if (remainMoves == 0) return 0;
        int count = 0;
        if (dp[i][j][remainMoves] != -1)
            return dp[i][j][remainMoves];

        // go up
        if (i - 1 < 0) {
            count = (count + 1) % MOD;
        } else
            count = (count + tryToMove(n, m, remainMoves - 1, i - 1, j)) % MOD;
        // go down
        if (i + 1 >= n)
            count = (count + 1) % MOD;
        else
            count = (count + tryToMove(n, m, remainMoves - 1, i + 1, j)) % MOD;
        // go left
        if (j - 1 < 0)
            count = (count + 1) % MOD;
        else
            count = (count + tryToMove(n, m, remainMoves - 1, i, j - 1)) % MOD;
        // go right
        if (j + 1 >= m)
            count = (count + 1) % MOD;
        else
            count = (count + tryToMove(n, m, remainMoves - 1, i, j + 1)) % MOD;

        dp[i][j][remainMoves] = count;

        return count;
    }
}
