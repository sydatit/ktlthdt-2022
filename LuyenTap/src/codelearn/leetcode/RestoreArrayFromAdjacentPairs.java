package codelearn.leetcode;

import java.util.*;

public class RestoreArrayFromAdjacentPairs {
    public static void main(String[] args) {
        RestoreArrayFromAdjacentPairs restore = new RestoreArrayFromAdjacentPairs();
        int[][] array = new int[][]{
                {4,-2},{1,4},{-3,1}
        };
        System.out.println(Arrays.toString(restore.restoreArray(array)));
    }
    Map<Integer, List<Integer>> map;
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        int[] res = new int[n];
        map = new HashMap<>();
        int current = 0;
        for (int[] pair : adjacentPairs) {
            List<Integer> firstList = map.getOrDefault(pair[0], new ArrayList<>());
            firstList.add(pair[1]);
            map.put(pair[0], firstList);
            List<Integer> secondList = map.getOrDefault(pair[1], new ArrayList<>());
            secondList.add(pair[0]);
            map.put(pair[1], secondList);
        }

        for (Map.Entry<Integer, List<Integer>> item :map.entrySet()) {
            if (item.getValue().size() == 1) {
                current = item.getKey();
                break;
            }
        }
        res[0] = current;
        int previous = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            List<Integer> list = map.get(current);
            int next = 0;
            for (Integer integer : list) {
                if (integer != previous) {
                    next = integer;
                    break;
                }
            }
            res[i] = next;
            current = next;
            previous = res[i - 1];
        }
        return res;
    }
}
