package codelearn.leetcode;

public class MinimumReplacementsSortArray {
    public static void main(String[] args) {
        MinimumReplacementsSortArray minimumReplacementsSortArray = new MinimumReplacementsSortArray();
        int[] nums = {12,9,7,6,17,19,21};
        System.out.println(minimumReplacementsSortArray.minimumReplacement(nums));
    }
    public long minimumReplacement(int[] nums) {
        long countOperation = 0;
        int n = nums.length;
        if ( n == 1)
            return 0;
        int prev = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > prev) {
                countOperation += Math.ceil((double) nums[i] / prev) - 1;
                prev = nums[i] % prev == 0 ? prev : nums[i] % prev;
            } else
                prev = nums[i];
        }
        return countOperation;
    }
}
/* 12,9,7,6,17,19,21
7 -> 12, 9, 3, 4, 6, 17, 19, 21
9 -> 12, 3, 3, 3, 3, 4, 6, 17, 19, 21
12 -> 3, 3, 3, 3, 3, 3, 3, 3, 4, 6, 17, 19, 21
think about UCLN
 */
