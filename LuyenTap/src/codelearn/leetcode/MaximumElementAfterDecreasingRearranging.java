package codelearn.leetcode;

import java.util.Arrays;

public class MaximumElementAfterDecreasingRearranging {
    public static void main(String[] args) {
        MaximumElementAfterDecreasingRearranging m = new MaximumElementAfterDecreasingRearranging();
        System.out.println(m.maximumElementAfterDecrementingAndRearranging(new int[]{
                1000, 1, 100000
        }));
    }
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + 1 < arr[i]) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }
}
