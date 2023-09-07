package codelearn.leetcode;

import static java.util.Arrays.binarySearch;

public class SearchRotatedSortedArrayII {
    public static void main(String[] args) {
        SearchRotatedSortedArrayII test = new SearchRotatedSortedArrayII();
        int[] nums = {1,0,1,1,1};
        int target = 0;
        System.out.println(test.search(nums, target));
    }
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        int pivot = findPivot(nums);
        if (pivot == -1) {
            return binarySearch(nums, 0, nums.length, target) >= 0;
        }
        if (target >= nums[0]) {
            right = pivot;
        } else {
            left = pivot + 1;
        }
        return binarySearch(nums, left, right + 1, target) >= 0;
    }

    private int findPivot(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = (right - left) / 2 + left;
            if ( mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left]){
                right = mid - 1;
            } else {
                right--;
            }
        }
        return -1;
    }
}
