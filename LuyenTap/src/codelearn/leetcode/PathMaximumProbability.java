package codelearn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PathMaximumProbability {
    class Node{
        int index;
        double prob;
        Node(int index, double prob){
            this.index = index;
            this.prob = prob;
        }
    }
    public static void main(String[] args) {
        PathMaximumProbability pathMaximumProbability = new PathMaximumProbability();
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int start = 0;
        int end = 2;
        double result = pathMaximumProbability.maxProbability(n, edges, succProb, start, end);
        System.out.println(result);
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<double[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            adj.get(edge[0]).add(new double[]{edge[1], succProb[i]});
            adj.get(edge[1]).add(new double[]{edge[0], succProb[i]});
        }
        if( adj.get(start).isEmpty() || adj.get(end).isEmpty())
            return 0;

        double[] prob = new double[n];
        Arrays.fill(prob, 0.0);
        prob[start] = 1.0;

        boolean[] visited = new boolean[n];
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        queue.add(new Node(start, 1.0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if( visited[cur.index])
                continue;
            visited[cur.index] = true;
            for (double[] next : adj.get(cur.index)) {
                if( !visited[(int)next[0]] && prob[(int)next[0]] < cur.prob * next[1]){
                    prob[(int)next[0]] = cur.prob * next[1];
                    queue.add(new Node((int)next[0], prob[(int)next[0]]));
                }
            }
        }
        return (double) Math.round(prob[end] * 100000) / 100000;
    }
}
