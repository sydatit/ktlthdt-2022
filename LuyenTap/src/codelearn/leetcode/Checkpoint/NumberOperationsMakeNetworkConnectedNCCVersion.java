package codelearn.leetcode.Checkpoint;

import java.util.*;

public class NumberOperationsMakeNetworkConnectedNCCVersion {
    private static List<Integer> adj[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(makeConnected(n, m, scanner));
    }
    public static int makeConnected(int n, int m, Scanner scanner) {
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj[u].add(v);
            adj[v].add(u);
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
