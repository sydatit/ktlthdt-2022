package codelearn.leetcode;

import java.util.HashSet;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        FindDuplicateNumber test = new FindDuplicateNumber();
        int[] nums = {1,3,4,2,2};
        System.out.println(test.findDuplicate(nums));
    }
    public int findDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = (left + right)/2;
            int count = 0;
            for(int num : nums) {
                if(num <= mid) count++;
            }
            if(count > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
/*
1 2 3 4 4 5
0 1 2 3 4 5
5/2 = 2
2
 */