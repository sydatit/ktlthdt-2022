package codelearn.leetcode;

import java.util.*;

public class ShortestPathGetAllKeys {
    public static void main(String[] args) {
        String[] grid = new String[] { "@.a.#",
                                       "###.#",
                                       "b.A.B" };
        System.out.println(new ShortestPathGetAllKeys().shortestPathAllKeys(grid));
    }
    private char[][] map;
    private Set<Character> keys;
    private boolean[][] visited;
    private LinkedList<int[]> queue;
    public int shortestPathAllKeys(String[] grid) {
        map = new char[grid.length][grid[0].length()];
        int startI = 0;
        int startJ = 0;
        visited = new boolean[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            map[i] = grid[i].toCharArray();
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '@') {
                    startI = i;
                    startJ = j;
                }
            }
        }
        keys = new HashSet<>();
        queue = new LinkedList<>();
        queue.add(new int[] { startI, startJ, 0 });
        int res = bfs(startI, startJ, 0);
        return res == 0 ? -1 : res;
    }

    private int bfs(int startI, int startJ, int i) {
        visited[startI][startJ] = true;
        int[][] dirs = new int[][] { { 0, 1 },
                                     { 0, -1 },
                                     { 1, 0 },
                                     { -1, 0 } };
        while (!queue.isEmpty()) {

        }
        return 0;
    }
    private void resetVisited() {
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
    }
}
