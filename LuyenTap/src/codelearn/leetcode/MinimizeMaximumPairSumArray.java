package codelearn.leetcode;

import java.util.Arrays;

public class MinimizeMaximumPairSumArray {
    public static void main(String[] args) {
        MinimizeMaximumPairSumArray a = new MinimizeMaximumPairSumArray();
        System.out.println(a.minPairSum(new int[] {
                4,1,5,1,2,5,1,5,5,4
        }));
    }
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 2)
            return nums[0] + nums[1];
        int mid = (nums.length - 1) / 2;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mid; i++) {
            max = Math.max( max, nums[i] + nums[ nums.length - i  - 1 ]);
        }
        return max;
    }
//    public int minPairSum(int[] nums) {
//        Arrays.sort(nums);
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        int target = (int) Math.ceil((double) sum / (nums.length/ 2));
//        return findMinOfPair(target, nums);
//    }

    private int findMinOfPair(int target, int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int min = Integer.MIN_VALUE;
        while (i < j) {
            if (min < nums[i] + nums[j] && nums[i] + nums[j] >= target) {
                min = nums[i] + nums[j];
            }
            i++;
            j--;
        }
        return min;
    }
}
