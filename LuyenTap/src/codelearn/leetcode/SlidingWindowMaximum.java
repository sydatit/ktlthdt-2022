package codelearn.leetcode;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum test = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] result = test.maxSlidingWindow(nums, 3);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k && i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
        }
        int[] result = new int[nums.length];
        result[0] = max;
        for (int i = k; i < nums.length; i++) {
            
        }
        return result;
    }
}
