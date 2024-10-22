package codelearn.leetcode;

import java.util.Arrays;

public class FindPolygonWithLargestPerimeter {
    public static void main(String[] args) {
        FindPolygonWithLargestPerimeter f = new FindPolygonWithLargestPerimeter();
        System.out.println(f.largestPerimeter(new int[] {5,5,50}));
    }
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] preSum = new long[n];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = n - 1; i >= 2; i--) {
            if (preSum[i] > nums[i]) {
                return preSum[i] + nums[i];
            }
        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(preSum));

        return -1;
    }
}
