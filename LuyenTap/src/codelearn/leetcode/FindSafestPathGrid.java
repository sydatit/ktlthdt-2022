package codelearn.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindSafestPathGrid {
    public static void main(String[] args) {
FindSafestPathGrid findSafestPathGrid = new FindSafestPathGrid();
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(0, 0, 1),
                Arrays.asList(0, 0, 0),
                Arrays.asList(0, 0, 0)
        );
        System.out.println(findSafestPathGrid.maximumSafenessFactor(grid));
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] minimumDis = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minimumDis[i], Integer.MAX_VALUE);
        }
        bfs(minimumDis, grid, m, m);
        System.out.println(Arrays.deepToString(minimumDis));

        return 0;
    }

    private int[] cols = new int[] {0, 0, -1, 1};
    private int[] rows = new int[] {-1, 1, 0, 0};
    private void bfs(int[][] minimumDis, List<List<Integer>> grid, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.add(new int[]{i, j});
                    minimumDis[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] u = queue.poll();
            int x = u[0];
            int y = u[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + rows[i];
                int newY = y + cols[i];
                if (0 <= newX && newX < n && 0 <= newY && newY < n && minimumDis[newX][newY] > minimumDis[x][y] + 1) {
                    minimumDis[newX][newY] = minimumDis[x][y] + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
    }
}
