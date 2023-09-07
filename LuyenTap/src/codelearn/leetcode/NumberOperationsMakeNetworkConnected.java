package codelearn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOperationsMakeNetworkConnected {
    public static void main(String[] args) {
        int[][] connections = {{0,1},{0,2},{0,3},{1,2}};
        System.out.println(new NumberOperationsMakeNetworkConnected().makeConnected(6, connections));
    }
    public int makeConnected(int n, int[][] connections) {
        List<Integer> adj[] = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] item :connections) {
            adj[item[0]].add(item[1]);
            adj[item[1]].add(item[0]);
        }
        Integer connectedComponent = 0;
        int redundantEdge = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if( !visited[i]){
                connectedComponent++;
                visited[i] = true;
                queue.add(i);
                while (!queue.isEmpty()){
                    int u = queue.poll();
                    for (int v :adj[u]) {
                        if( !visited[v]){
                            visited[v] = true;
                            queue.add(v);

                        }else{
                            redundantEdge++;
                        }
                        adj[v].remove(Integer.valueOf(u));
                    }
                }
            }
        }
        return redundantEdge >= connectedComponent - 1 ? connectedComponent - 1 : -1;
    }

}
