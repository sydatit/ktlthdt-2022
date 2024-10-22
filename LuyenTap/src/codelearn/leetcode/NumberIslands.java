package codelearn.leetcode;

public class NumberIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        NumberIslands numberIslands = new NumberIslands();
        System.out.println(numberIslands.numIslands(grid));
    }
    private boolean[][] visited;
    public int numIslands(char[][] grid) {
        int sum = 0;
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    sum++;
                    dfs(i, j, n, m, grid);
                }
            }
        }
        return sum;
    }

    private void dfs(int i, int j, int n, int m, char[][] grid) {
        visited[i][j] = true;
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
            dfs(i - 1, j, n, m, grid);
        }
        if (i + 1 < n && grid[i + 1][j] == '1' && !visited[i + 1][j]) {
            dfs(i + 1, j, n, m, grid);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
            dfs(i, j - 1, n, m, grid);
        }
        if (j + 1 < m && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
            dfs(i, j + 1, n, m, grid);
        }
    }
}
