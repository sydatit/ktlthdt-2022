package codelearn.leetcode;

import java.util.HashSet;

public class MinCostConnectAllPoints {
    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        MinCostConnectAllPoints test = new MinCostConnectAllPoints();
        System.out.println(test.minCostConnectPoints(points));
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        int ans = 0;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        for (int i = 1; i < n; i++) dist[i] = findDist(points, 0, i);
        while (n != visited.size()) {
            int nextP = -1;
            for (int i = 0; i < n; i++) {
                if (visited.contains(i)) continue;
                if ( nextP == -1 || dist[nextP] > dist[i]) nextP = i;
            }
            visited.add(nextP);
            ans += dist[nextP];
            for (int i = 0; i < n; i++) {
                if (visited.contains(i)) continue;
                dist[i] = Math.min(dist[i], findDist(points, nextP, i));
            }
        }
        return ans;
    }

    private int findDist(int[][] points, int a, int b) {
        int x = points[a][0] - points[b][0];
        int y = points[a][1] - points[b][1];
        return Math.abs(x) + Math.abs(y);
    }
}
