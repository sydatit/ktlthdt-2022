package codelearn.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvertArrayInto2DArrayWithConditions {
    public static void main(String[] args) {
        System.out.println(findMatrix(new int[]{1,3,4,1,2,3,1}));
    }
    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        boolean[] visited = new boolean[nums.length];
        while (true) {
            Set<Integer> set = new HashSet<>();
            int i = start;
            int beforeChange = start;
            for (; i < nums.length; i++) {
                if (set.contains(nums[i]) && start != i && start == beforeChange) {
                    start = i;
                }
                if (!set.contains(nums[i]) && !visited[i]) {
                    set.add(nums[i]);
                    visited[i] = true;
                }
            }
            result.add(new ArrayList<>(set));
            if (start == beforeChange)
                break;
        }

        return result;
    }
}
