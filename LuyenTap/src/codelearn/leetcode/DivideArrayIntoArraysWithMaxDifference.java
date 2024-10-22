package codelearn.leetcode;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {
    public static void main(String[] args) {
        DivideArrayIntoArraysWithMaxDifference test = new DivideArrayIntoArraysWithMaxDifference();
        System.out.println(Arrays.deepToString(test.divideArray(new int[]{1,3,3,2,7,3}, 3)));
    }
    public int[][] divideArray(int[] nums, int k) {
        int length = nums.length;
        int[][] result = new int[length/3][3];
        boolean isSatisfy = true;
        Arrays.sort(nums);
        for (int i = 0; i < length; i += 3) {
            if (nums[i + 2]  - nums[i] > k) {
                isSatisfy = false;
                break;
            }
        }
        if (!isSatisfy) {
            return new int[0][0];
        }
        for (int i = 0; i < length; i ++) {
            result[i/3][i%3] = nums[i];
        }
        return result;
    }
}
