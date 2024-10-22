package codelearn.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class TheNumberBeautifulSubsets {
    public static void main(String[] args) {
        TheNumberBeautifulSubsets theNumberBeautifulSubsets = new TheNumberBeautifulSubsets();
        int[] nums = {1,1,2,3};
        int k = 1;
        System.out.println(theNumberBeautifulSubsets.beautifulSubsets(nums, k));
    }
    private int[] dp;
    public int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        dp = new int[n];
        int[] existing = new int[1001];
        Arrays.fill(dp, -1);
        return countNumberSubsets(0, n, k, nums, existing, true);
    }

    private int countNumberSubsets(int i, int n, int k, int[] nums, int[] existing, boolean isEmpty) {
        if (i == n) {
            return isEmpty ? 0 : 1;
        }
//        if (dp[i] != -1)
//            return dp[i];

        int curNum = nums[i];
        int totalSubsets = 0;
        if ((curNum + k + 1 > existing.length || existing[curNum + k] != 1) && (curNum - k <= 0 || existing[curNum - k] != 1)) {
            existing[curNum] = 1;
            totalSubsets += countNumberSubsets(i + 1, n, k, nums, existing, false);
            existing[curNum] = 0;
        }

        totalSubsets += countNumberSubsets(i + 1, n, k, nums, existing, isEmpty);

        dp[i] = totalSubsets;
        return totalSubsets;
    }

}
