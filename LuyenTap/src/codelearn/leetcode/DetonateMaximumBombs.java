package codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DetonateMaximumBombs {
    public static void main(String[] args) {
        int[][] bombs = {
                {855,82,158}
            ,{17,719,430}
            ,{90,756,164}
            ,{376,17,340}
            ,{691,636,152}
            ,{565,776,5}
            ,{464,154,271}
            ,{53,361,162}
            ,{278,609,82}
            ,{202,927,219}
            ,{542,865,377}
            ,{330,402,270}
            ,{720,199,10}
            ,{986,697,443}
            ,{471,296,69}
            ,{393,81,404}
            ,{127,405,177}
        };
        System.out.println(new DetonateMaximumBombs().maximumDetonation(bombs));
    }
    public List<Integer> adj[];
    public boolean[] visited;
    public int maximumDetonation(int[][] bombs) {
        buildAdjacencyList(bombs);
        int n = bombs.length;
        visited = new boolean[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dfs(i));
            visited = new boolean[n];
        }
        return max;
    }
    private int dfs(int u){
        visited[u] = true;
        int count = 1;
        for (int v : adj[u]) {
            if(!visited[v]){
                count += dfs(v);
            }
        }
        return count;
    }

    private void buildAdjacencyList(int[][] bombs) {
        int n = bombs.length;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n ; j++) {
                int x1 = bombs[i][0];
                int y1 = bombs[i][1];
                int r1 = bombs[i][2];
                int x2 = bombs[j][0];
                int y2 = bombs[j][1];
                int r2 = bombs[j][2];
                int d = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);

                if(Math.sqrt(d) <= r1)
                    adj[i].add(j);
                if(Math.sqrt(d) <= r2)
                    adj[j].add(i);
            }
        }
    }

}
