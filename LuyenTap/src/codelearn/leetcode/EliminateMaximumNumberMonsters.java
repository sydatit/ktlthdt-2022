package codelearn.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EliminateMaximumNumberMonsters {
    public static void main(String[] args) {
        EliminateMaximumNumberMonsters maximumNumberMonsters = new EliminateMaximumNumberMonsters();
        int[] dist = new int[]{4,4,3,4,4};
        int[] speed  = new int[]{1,2,1,1,1};
        System.out.println(maximumNumberMonsters.eliminateMaximum(dist, speed));
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] timeToCity = new double[n];
        for (int i = 0; i < n; i++) {
            timeToCity[i] = (double) dist[i]/speed[i];
        }
        for (int i = 0; i < n; i++) {
            if (i >= timeToCity[i]) {
                return i;
            }
        }
        return 0;
    }
}
