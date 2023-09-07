package codelearn.leetcode;

import java.util.Arrays;

public class KRadiusSubarrayAverages {
    public static void main(String[] args) {
KRadiusSubarrayAverages solution = new KRadiusSubarrayAverages();
        int[] nums = {8};
        int k = 1000000;
        int[] result = solution.getAverages(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        if( 2 * k >= n){
            return result;
        }
        long sum = 0;
        for (int i = 0; i <= 2 * k && i < n; i++) {
            sum += nums[i];
        }
        for (int i = k, j = k * 2; j < n - k ; i++, j++) {
            result[i] = (int) (sum / (2 * k + 1));
            if(j + 1 < n){
                sum += nums[j + 1] - nums[i - k];
            }
        }
        return result;
    }
}
/*
[7,4,3,9,1,8,5,2,6]
 0 1 2 3 4 5 6 7 8
 k = 3
    7 4 3

    i + k < n - k
    2k < n
 */

/*

 */