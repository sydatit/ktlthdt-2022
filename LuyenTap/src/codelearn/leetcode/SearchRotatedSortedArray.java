package codelearn.leetcode;

import static java.util.Arrays.binarySearch;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3,1}; // 0
        int target = 1;
        SearchRotatedSortedArray searchRotatedSortedArray = new SearchRotatedSortedArray();
        System.out.println(searchRotatedSortedArray.search(nums, target));

    }
    public int search(int[] nums, int target) {
        if( nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int pivot = findPivot(nums);
        int val;
        if (pivot == -1) {
            val = binarySearch(nums,  0, nums.length, target);
        } else if (nums[pivot] == target) {
            return pivot;
        } else if (target > nums[nums.length - 1]) {
            val = binarySearch(nums, 0, pivot, target);
        } else {
            val = binarySearch(nums, pivot, nums.length, target);
        }
        return  val < 0 ? -1 : val;
    }

    private int findPivot(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return -1; // not rotated
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // not rotated
    }
}
