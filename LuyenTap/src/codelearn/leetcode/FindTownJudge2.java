package codelearn.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTownJudge2 {
    public static void main(String[] args) {
        System.out.println(findJudge(3, new int[][]{
                {1, 3},
                {2, 3}
        }));
    }
    public static int findJudge(int n, int[][] trusts) {
        if ( n > trusts.length + 1) return -1;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] trust: trusts) {
            set.add(trust[0]);
            int count = map.getOrDefault(trust[1], 0);
            map.put(trust[1], ++count);
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i) && map.getOrDefault(i, 0) == n - 1)
                return i;
        }
        return -1;
    }
}
