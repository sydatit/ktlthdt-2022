package codelearn.io;

public class JumpGameII {
    public static void main(String[] args) {
        System.out.println((new JumpGameII()).jump(
                new int[]{2,3,1,1,4}
        ));
    }
    public int jump(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i++) {
//            dp[i] = Integer.MAX_VALUE;
//        }
//        dp[0] = 0;
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if(i - j <= nums[j]) dp[i] = Math.min(dp[j] + 1, dp[i] );
//            }
//        }
//        return dp[n - 1];
        if( nums.length == 1) return 0;
        int curr = 0;
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if( curr == i){
                count++;
                curr = max;
            }
            if( curr > nums.length - 1)
            {
                count++;
                break;
            }
        }
        return count;
    }
}
