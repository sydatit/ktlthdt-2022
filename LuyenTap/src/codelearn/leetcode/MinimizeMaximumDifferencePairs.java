package codelearn.leetcode;

import java.util.*;

public class MinimizeMaximumDifferencePairs {
    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 2};
        int p = 1;
        System.out.println(new MinimizeMaximumDifferencePairs().minimizeMax(nums, p));
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            if(set.contains(num)) {
                set.remove(num);
                count++;
            } else {
                set.add(num);
            }
        }
        if(count >= p) return 0;
        List<Integer> list = new ArrayList<>(set);
        int max = Integer.MAX_VALUE;
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            int l = Math.abs(list.get(i) - list.get(i - 1));
            if(l < max) max = l;
        }
        return max;
    }
}
