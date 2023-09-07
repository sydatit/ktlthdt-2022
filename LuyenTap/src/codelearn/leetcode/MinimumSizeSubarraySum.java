package codelearn.leetcode;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(test.minSubArrayLen(target, nums));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int sumOfWindow = 0;
        if(nums.length == 1)
            return nums[0] >= target ? 1 : 0;
        if( nums[0] >= target)
            return 1;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        for (; right < nums.length; right++) {
            sumOfWindow += nums[right];
            while (sumOfWindow >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sumOfWindow -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
