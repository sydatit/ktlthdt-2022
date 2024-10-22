package codelearn.leetcode;

public class PathMaximumGold {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 0, 7, 0, 0, 0},
            {2, 0, 6, 0, 1, 0},
            {3, 5, 6, 7, 4, 2},
            {4, 3, 1, 0, 2, 0},
            {3, 0, 5, 0, 20, 0}
        };
        PathMaximumGold pathMaximumGold = new PathMaximumGold();
        System.out.println(pathMaximumGold.getMaximumGold(grid));
    }
    private boolean[][] visited;
    public int getMaximumGold(int[][] grid) {
        int maximum = Integer.MIN_VALUE;
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    int maxGold = findPath(i, j, grid);
                    maximum = Math.max(maximum, maxGold);
                }
            }
        }
        return maximum;
    }

    private int findPath(int i, int j, int[][] grid) {
        int totalGold = grid[i][j];
        int n = grid.length;
        int m = grid[0].length;
        int maxGold = 0;
        visited[i][j] = true;
        if (i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] != 0) {
            maxGold = findPath(i - 1, j, grid);
        }
        if (i + 1 < n && !visited[i + 1][j] && grid[i + 1][j] != 0) {
            maxGold = Math.max(findPath(i + 1, j, grid), maxGold);
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] != 0) {
            maxGold = Math.max(findPath(i, j - 1, grid), maxGold);
        }
        if (j + 1 < m && !visited[i][j + 1] && grid[i][j + 1] != 0) {
            maxGold = Math.max(findPath(i, j + 1, grid), maxGold);
        }

        visited[i][j] = false;
        return totalGold + maxGold;
    }
}
