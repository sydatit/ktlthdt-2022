package codelearn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        int n = 6;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        System.out.println(minimumHeightTrees.findMinHeightTrees(n, edges));
    }
    private ArrayList<Integer>[] adj;
    private boolean[] visited;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 2) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }
        adj = new ArrayList[n];
        visited = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> potentialVertices = new ArrayList<>();
        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            potentialVertices.add(i);
        }
        for (int[] edge :edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        // sort potentialVertices by adj[i].size()
        potentialVertices.sort((a, b) ->  adj[b].size() - adj[a].size());
//        System.out.println(potentialVertices);
        for (Integer vertex :potentialVertices) {
            int h = bfs(vertex);
            List<Integer> vertices = map.getOrDefault(h, new ArrayList<>());
            vertices.add(vertex);
            map.putIfAbsent(h, vertices);
            minHeight = Math.min(minHeight, h);
            if (h > minHeight) {
                break;
            }
            resetVisited();
        }

        return map.get(minHeight);
    }

    private void resetVisited() {
        Arrays.fill(visited, false);
    }

    private int bfs(Integer u) {
        int count = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        visited[u] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                if (queue.isEmpty()) {
                    break;
                }
                int head = queue.poll();
                for (Integer v :adj[head]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }
        }
        return count;
    }
}
