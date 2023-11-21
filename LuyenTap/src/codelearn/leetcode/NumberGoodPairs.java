package codelearn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberGoodPairs {
    public static void main(String[] args) {
        NumberGoodPairs p = new NumberGoodPairs();
        int[] nums = new int[]{
                1,2,3,1,1,3
        };

        System.out.println(p.numIdenticalPairs(nums));
    }
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }

        return map.values().stream()
                .filter(item -> item > 1)
                .map(item -> calculatePair(item - 1))
                .reduce(0, Integer::sum);
    }
    private int calculatePair(int n) {
        return ((n + 1) * n) / 2;
    }
}
