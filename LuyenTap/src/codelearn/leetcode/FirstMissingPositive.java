package codelearn.leetcode;

import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int[] nums = {1, 2, 0};
        System.out.println(firstMissingPositive.firstMissingPositive(nums));
        int[] nums2 = {3, 4, -1, 1};
        System.out.println(firstMissingPositive.firstMissingPositive(nums2));
        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive.firstMissingPositive(nums3));
        int[] nums4 = {1, 2, 3};
        System.out.println(firstMissingPositive.firstMissingPositive(nums4));
        int[] nums5 = {0, 1, 2};
        System.out.println(firstMissingPositive.firstMissingPositive(nums5));
        int[] nums6 = {1};
        System.out.println(firstMissingPositive.firstMissingPositive(nums6));
        int[] nums7 = {2};
        System.out.println(firstMissingPositive.firstMissingPositive(nums7));
        int[] nums8 = {0};
        System.out.println(firstMissingPositive.firstMissingPositive(nums8));
        int[] nums9 = {-1, -2, -3};
        System.out.println(firstMissingPositive.firstMissingPositive(nums9));
        int[] nums10 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(firstMissingPositive.firstMissingPositive(nums10));
        int[] nums11 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12};
        System.out.println(firstMissingPositive.firstMissingPositive(nums11));
        int[] nums12 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(firstMissingPositive.firstMissingPositive(nums12));
        int[] nums13 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13};
        System.out.println(firstMissingPositive.firstMissingPositive(nums13));
        int[] nums14 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println(firstMissingPositive.firstMissingPositive(nums14));
    }
    public int firstMissingPositive(int[] nums) {
        int minimum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (nums[i] - minimum >= 2) {
                    return minimum + 1;
                } else {
                    minimum = nums[i];
                }
            }
        }

        return nums[nums.length - 1] <= 0 ? 1 : nums[nums.length - 1] + 1;
    }
}
