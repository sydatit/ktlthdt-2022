package codelearn.leetcode;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println((new HouseRobber()).rob(nums));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = -1;
        if(n > 1)
            dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            if( i - 3 >= 0) dp[i] = Math.max( dp[i - 3], dp[ i - 2]) + nums[i];
            else dp[i] = nums[i] + dp[ i - 2];
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
