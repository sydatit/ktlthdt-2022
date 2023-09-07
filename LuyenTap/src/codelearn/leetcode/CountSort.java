package codelearn.leetcode;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        CountSort cs = new CountSort();
        System.out.println(Arrays.toString(cs.sortArray(nums)));
    }
    public int[] sortArray(int[] nums) {
        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int[] range = new int[maxVal - minVal + 1];
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            range[nums[i] - minVal]++;
        }
        int count = 0;
        for (int i = 0; i < range.length; i++) {
            range[i] += count;
            count = range[i];
        }
        for (int i = 0; i < nums.length; i++) {
            result[--range[nums[i] - minVal]] = nums[i];
        }
        return result;
    }
}
