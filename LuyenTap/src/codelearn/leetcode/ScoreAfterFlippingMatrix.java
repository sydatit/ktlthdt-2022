package codelearn.leetcode;

import java.util.Arrays;

public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        ScoreAfterFlippingMatrix scoreAfterFlippingMatrix = new ScoreAfterFlippingMatrix();
        System.out.println(scoreAfterFlippingMatrix.matrixScore(grid));
    }
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) {
                flippingRowOrColumn(grid[i]);
            }
        }
//        System.out.println(Arrays.deepToString(grid));
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += grid[j][i] == 1 ? 1 : 0;
            }
            if (count < Math.ceil(n/2d)) {
                for (int j = 0; j < n; j++) {
                    grid[j][i] = grid[j][i] == 1 ? 0 : 1;
                }
            }
            for (int j = 0; j < n; j++) {
                result += grid[j][i] * (int) Math.pow(2, m - i - 1);
            }
        }
//        System.out.println(Arrays.deepToString(grid));
//        for (int i = 0; i < n; i++) {
//            result += buildDecimal(grid[i]);
//        }
        return result;
    }

    private int buildDecimal(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res += arr[i] * (int) Math.pow(2, n - i - 1);
        }
        return res;
    }

    private void flippingRowOrColumn(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            arr[j] = arr[j] == 1 ? 0 : 1;
        }
    }
}
