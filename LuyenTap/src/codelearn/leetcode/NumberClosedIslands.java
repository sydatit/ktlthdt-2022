package codelearn.leetcode;

public class NumberClosedIslands {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,0,1,1,1,1,0,0,1,0},
                {1,0,1,1,0,0,0,1,1,1},
                {0,1,1,0,0,0,1,0,0,0},
                {1,0,1,1,0,1,0,0,1,0},
                {0,1,1,1,0,1,0,1,0,0},
                {1,0,0,1,0,0,1,0,0,0},
                {1,0,1,1,1,0,0,1,1,0},
                {1,1,0,1,1,0,1,0,1,1},
                {0,0,1,1,1,0,1,0,1,1},
                {1,0,0,1,1,1,1,0,1,1}
        };
        System.out.println(new NumberClosedIslands().closedIsland(grid));
    }
    private boolean[][] visited;

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];
        int count = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (dfs(grid, i, j)) {
                        System.out.println("count = " + count);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid, int i, int j) {
        visited[i][j] = true;
        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
            return false;
        }
        System.out.println("i = " + i + ", j = " + j);
        boolean result = true;
        if( i > 0 && grid[i- 1][j] == 0 && !visited[i - 1][j]){
            result &= dfs(grid, i - 1, j);
        }
        if( i < grid.length - 1 && grid[i + 1][j] == 0 && !visited[i + 1][j]){
            result &= dfs(grid, i + 1, j);
        }
        if( j > 0 && grid[i][j - 1] == 0 && !visited[i][j - 1]){
            result &= dfs(grid, i, j - 1);
        }
        if( j < grid[0].length - 1 && grid[i][j + 1] == 0 && !visited[i][j + 1]){
            result &= dfs(grid, i, j + 1);
        }
        return result;
    }
}
