package codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesMakeAllPathsLeadCityZero {
    public static void main(String[] args) {
        int[][] connections = {{1, 0}, {1, 2}, {3, 2}, {3, 4}};
        int n = 5;
        ReorderRoutesMakeAllPathsLeadCityZero obj = new ReorderRoutesMakeAllPathsLeadCityZero();
        System.out.println(obj.minReorder(n, connections));
    }
    static class Pair{
        int des;
        boolean exist;

        public Pair(int des, boolean exist) {
            this.des = des;
            this.exist = exist;
        }
    }
    boolean[] visited;
    public int minReorder(int n, int[][] connections) {
        List<Pair> pairs[] = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new ArrayList<>();
        }
        for (int[] connection :connections) {
            pairs[connection[0]].add(new Pair( connection[1], true));
            pairs[connection[1]].add(new Pair( connection[0], false));
        }
        int result = dfs(0, pairs);
        return result;
    }

    private int dfs(int u, List<Pair>[] pairs) {
        visited[u] = true;
        int count = 0;
        for (Pair item :pairs[u]) {
            if( !visited[item.des]){
                if(item.exist){
                    count++;
                }
                count += dfs(item.des, pairs);
            }
        }
        return count;
    }
}
