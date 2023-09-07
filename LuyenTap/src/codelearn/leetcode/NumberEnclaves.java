package codelearn.leetcode;

public class NumberEnclaves {
    private boolean[][] visited;
    public int numEnclaves(int[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]){
                    count += dfs( grid, i , j);
                }
            }
        }
        return count;
    }

    private int dfs(int[][] grid, int i, int j) {
        visited[i][j] = true;
        if( i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length)
            return 0;
        int count = 1;
        if( i > 0 && grid[i - 1][j] == 1 && !visited[i-1][j]){
            count += dfs(grid, i - 1, j);
        }
        if( j > 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]){
            count += dfs(grid, i, j - 1);
        }
        if( i < grid.length && grid[i+ 1][j] == 1 && !visited[i + 1][j]){
            count += dfs(grid, i + 1, j);
        }
        if( j < grid[0].length && grid[i][j + 1] == 1 && !visited[i][j + 1]){
            count += dfs(grid, i, j + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,1,1,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,0}
        };
        System.out.println(new NumberEnclaves().numEnclaves(grid));
    }
}
