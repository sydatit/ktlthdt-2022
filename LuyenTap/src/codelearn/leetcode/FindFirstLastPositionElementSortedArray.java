package codelearn.leetcode;

import java.util.Arrays;

public class FindFirstLastPositionElementSortedArray {
    public static void main(String[] args) throws InterruptedException {
        FindFirstLastPositionElementSortedArray a = new FindFirstLastPositionElementSortedArray();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(a.searchRange(nums, target)));
        double hours = 23.75;
        long display = 27;
        long display2 = 19;

        long res = 0;
        res += display/hours + display2/hours;

        System.out.println(res);

        double res2 = (double) display/display2;
        System.out.println(res2);
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) return res;
        int find = Arrays.binarySearch(nums, target);
        if (find < 0)
            return res;
        int left = findNumberFirstOccur(nums, target);
        int right = findNumberLastOccur(nums, target);

        res[0] = left;
        res[1] = right;
        return res;
    }

    private int findNumberFirstOccur(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int m = (right + left)/ 2;
            if (nums[m] >= target) {
                right = m - 1;
            }else {
                left = m + 1;
            }
        }
        return left;
    }

    private int findNumberLastOccur(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int m = (right + left)/ 2;
            if (nums[m] <= target) {
                left = m + 1;
            }else {
                right = m - 1;
            }
        }
        return right;
    }
}
