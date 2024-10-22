package codelearn.leetcode;

import java.util.Arrays;

public class MinimumIncrementMakeArrayUnique {
    public static void main(String[] args) {
        MinimumIncrementMakeArrayUnique minimumIncrementMakeArrayUnique = new MinimumIncrementMakeArrayUnique();
        int[] nums = {3,2,1,2,1,7};
        System.out.println(minimumIncrementMakeArrayUnique.minIncrementForUnique(nums));
    }
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int minValue = nums[0] + 1;
        int count = 0;
        for (int i = 1; i < n;i++) {
            if (nums[i] < minValue) {
                count += minValue - nums[i];
                minValue++;
            } else {
                minValue = nums[i] + 1;
            }
        }
        return count;
    }
}
