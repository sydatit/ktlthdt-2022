package codelearn.leetcode;

import java.util.Arrays;

public class NumberLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,3,3,3};
        NumberLongestIncreasingSubsequence solution = new NumberLongestIncreasingSubsequence();
        System.out.println(solution.findNumberOfLIS(nums));
    }
    public int findNumberOfLIS(int[] nums) {
        if(nums.length <= 1 )
            return nums.length;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] countLIS = new int[n];
        int max = dp[0];
        countLIS[0] = 1;
        for (int i = 1; i < n; i++) {
            int count = 1;
            for (int j = i -1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                    if (dp[j] + 1 == dp[i]) {
                        count += countLIS[j];
                    }
                }
            }
            countLIS[i] = count == 1 ? 1 : count - 1;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                result += countLIS[i];
            }
        }
        return result;
    }
}
