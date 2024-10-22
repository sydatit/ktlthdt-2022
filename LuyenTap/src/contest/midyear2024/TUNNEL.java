package contest.midyear2024;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class TUNNEL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        int[][] safeties = new int[n][n];


        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(safeties[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    safeties[i][j] = 0;
                }
            }
        }
        bfs(matrix, safeties, queue);

        System.out.println(findPathHaveMaxSafety(safeties, n));
    }

    private static int findPathHaveMaxSafety(int[][] safeties, int n) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = safeties[0][0];
        queue.add(new int[]{0, 0, safeties[0][0]});
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int safety = current[2];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && dp[newX][newY] < Math.min(safety, safeties[newX][newY])) {
                    dp[newX][newY] = Math.min(safety, safeties[newX][newY]);
                    queue.add(new int[]{newX, newY, dp[newX][newY]});
                }
            }
        }
        return dp[n - 1][n - 1];
    }

    private static void bfs(int[][] matrix, int[][] safeties, Queue<int[]> queue) {
        int n = matrix.length;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && matrix[newX][newY] == 0) {
                    if (safeties[newX][newY] > safeties[x][y] + 1) {
                        safeties[newX][newY] = safeties[x][y] + 1;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(safeties[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
/*
4
0 0 0 1
0 0 0 0
0 0 0 0
1 0 0 0
 */