package codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
        NumberProvinces numberProvinces = new NumberProvinces();
        System.out.println(numberProvinces.findCircleNum(isConnected));
    }
    private boolean[] visited;
    public List<Integer> adj[];
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        buildGraph(isConnected, n);
        int count = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int u) {
        visited[u] = true;
        for (int v : adj[u]) {
            if(!visited[v]) {
                dfs(v);
            }
        }
    }

    private void buildGraph(int[][] isConnected, int n) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
    }
}
