package codelearn.leetcode;

import java.util.Stack;

public class StepsMakeArrayNonDecreasing {
    public static void main(String[] args) {
        StepsMakeArrayNonDecreasing stepsMakeArrayNonDecreasing = new StepsMakeArrayNonDecreasing();
        int[] nums = {1,3,2,4,3,5,2,6};
        System.out.println(stepsMakeArrayNonDecreasing.totalSteps(nums));
    }
    public int totalSteps(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int n = nums.length;
        int[] dp = new int[n];
        int maxRound = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[i] < nums[stk.peek()]) {
                dp[i] = Math.max(dp[i] + 1, dp[stk.pop()]);
            }
            stk.push(i);
            maxRound = Math.max(maxRound, dp[i]);
        }
        return maxRound;
    }
}
/*
0 1 2 3 4 5
1 3 2 4 3 5
1   2   3
1
 */