package codelearn.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class MaximalNetworkRank {
    public static void main(String[] args) {
        int n = 5;
        int[][] roads = new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}};
        System.out.println(new MaximalNetworkRank().maximalNetworkRank(n, roads));
    }
    private List<Integer> adj[];
    public int maximalNetworkRank(int n, int[][] roads) {
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            adj[road[0]].add(road[1]);
            adj[road[1]].add(road[0]);
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] rank = new int[2];
            rank[0] = i;
            rank[1] = adj[i].size();
            list.add(rank);
        }
        Collections.sort(list, (a, b) -> b[1] - a[1]);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] a = list.get(i);
                int[] b = list.get(j);
                int val = adj[a[0]].contains(b[0]) ? a[1] + b[1] - 1 : a[1] + b[1];
                max = Math.max(max, val);
            }
        }

        return max;
    }
}
