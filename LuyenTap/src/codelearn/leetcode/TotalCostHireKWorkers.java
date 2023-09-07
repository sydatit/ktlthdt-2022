package codelearn.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TotalCostHireKWorkers {
    public static void main(String[] args) {
        TotalCostHireKWorkers test = new TotalCostHireKWorkers();
        int[] costs = {2,2,2,2,2,2,1,4,5,5,5,5,5,2,2,2,2,2,2,2,2,2,2,2,2,2};
        System.out.println(test.totalCost(costs, 7, 3));
    }

    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long total = 0;
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for (int i = 0; i < candidates; i++) {
            if (!map.containsKey(costs[i])) {
                map.put(costs[i], new PriorityQueue<>());
            }
            map.get(costs[i]).add(1);
        }
        if (candidates * 2 >= n) {
            for (int i = candidates; i < n ; i++) {
                if (!map.containsKey(costs[i])) {
                    map.put(costs[i], new PriorityQueue<>());
                }
                map.get(costs[i]).add(i);
            }
            for (int i = 0; i < k; i++) {
                int min = map.firstKey();
                map.get(min).poll();
                total += min;
                if (map.get(min).isEmpty()) {
                    map.remove(min);
                }
            }
        } else {
            for (int i = n - 1; i >= n - candidates ; i--) {
                if (!map.containsKey(costs[i])) {
                    map.put(costs[i], new PriorityQueue<>());
                }
                map.get(costs[i]).add(2);
            }
            int x = candidates;
            int y = n - candidates - 1;
            for (int i = 0; i < k; i++) {
                int min = map.firstKey();
                int part = map.get(min).poll();
                total += min;
                if (map.get(min).isEmpty()) {
                    map.remove(min);
                }
                if( x <= y){
                    if (part == 1) {
                        if (!map.containsKey(costs[x])) {
                            map.put(costs[x], new PriorityQueue<>());
                        }
                        map.get(costs[x]).add(1);
                        x++;
                    } else {
                        if (!map.containsKey(costs[y])) {
                            map.put(costs[y], new PriorityQueue<>());
                        }
                        map.get(costs[y]).add(2);
                        y--;
                    }
                }
            }
        }
        return total;
    }
}
