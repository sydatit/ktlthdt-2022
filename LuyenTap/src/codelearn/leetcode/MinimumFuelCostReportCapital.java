package codelearn.leetcode;

import java.util.*;

public class MinimumFuelCostReportCapital {
    public static void main(String[] args) {
        System.out.println((new MinimumFuelCostReportCapital()).minimumFuelCost(
                new int[][]{
                        {0,1},{2,1},{3,2},{4,2},{4,5},{6,0},{5,7},{8,4},{9,2}
                },
                2
        ));
    }
    private ArrayList<Integer> adjL[];
    private boolean[] mark;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        adjL = new ArrayList[n];
        mark = new boolean[n];
        for (int i = 0; i < n; i++) {
            adjL[i] = new ArrayList<>();
        }
        for (int[] road :roads) {
            adjL[road[0]].add(road[1] );
            adjL[road[1]].add(road[0] );
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if( adjL[i].size() == 1){
                mark[i] = true;
                queue.add(new int[] {i, 1});
            }
        }
        long result = travelCity(queue, n, seats);
        return result;
    }

    private long travelCity(Queue<int[]> queue, int n, int seats) {
        long result = 0;
        int[][] node = new int[n][2];
        while (!queue.isEmpty()){
            int[] head = queue.poll();
            if(head[0] != 0)
                result += Math.ceil((float)head[1]/seats);
            for (Integer item :adjL[head[0]]) {
                if(!mark[item]){
                    node[item][0]++;
                    node[item][1] += head[1];
                    if(node[item][0] == adjL[item].size() - 1 && item != 0){
                        queue.add(new int[]{ item, node[item][1] + 1});
                        mark[item] = true;
                    }
                }
            }
        }

        return result;
    }
}
