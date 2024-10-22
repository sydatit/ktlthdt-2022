package codelearn.leetcode;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {

    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (prefix[right + 1] / prefix[left] < k) {
                right++;
            } else {
                int n = right - left + 1;
                count += calculate(n);
                left = right;
            }
        }
        return 1;
    }

    private int calculate(int n) {
        return n * (n + 1) / 2;
    }
}
