package codelearn.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberGoodPaths {
    public static void main(String[] args) {

    }
    HashMap<Integer, List<Integer>> dij;
    boolean[] mark;
    int[] isExistCouple;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        dij = new HashMap<>();
        mark = new boolean[n];
        isExistCouple = new int[100000];
        for (int i = 0; i < edges.length; i++) {
            int head = edges[i][0];
            int last = edges[i][1];
            dij.putIfAbsent(head, new ArrayList<>());
            dij.putIfAbsent(last, new ArrayList<>());
            dij.get(head).add(last);
            dij.get(last).add(head);
            isExistCouple[head]++;
            isExistCouple[last]++;
        }
        for (int i = 0; i < n; i++) {
            
        }
        return 0;
    }
}
