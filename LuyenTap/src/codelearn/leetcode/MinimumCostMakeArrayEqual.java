package codelearn.leetcode;

import java.util.Arrays;

public class MinimumCostMakeArrayEqual {
    public static void main(String[] args) {
        MinimumCostMakeArrayEqual minimumCostMakeArrayEqual = new MinimumCostMakeArrayEqual();
        int[] nums = {1, 3, 5, 2};
        int[] cost = {2, 3, 1, 14};
        System.out.println(minimumCostMakeArrayEqual.minCost(nums, cost));
    }

    public long minCost(int[] nums, int[] cost) {
        quickSort(nums, cost, 0, nums.length - 1);
        long sum = Long.MAX_VALUE;
        int equalNum;
        for (int i = 0; i < nums.length; i++) {
            equalNum = nums[i];
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                temp += Math.abs(nums[j] - equalNum) * cost[j];
            }
            sum = Math.min(sum, temp);
        }
        return sum;
    }

    // implement quick sort. By cost we want to sort with descending order
    public void quickSort(int[] nums, int[] cost, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(nums, cost, start, end);
        quickSort(nums, cost, start, pivot - 1);
        quickSort(nums, cost, pivot + 1, end);
    }
    // implement partition
    public int partition(int[] nums, int[] cost, int start, int end) {
        int pivot = cost[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (cost[j] >= pivot) {
                i++;
                swap(nums, cost, i, j);
            }
        }
        swap(nums, cost, i + 1, end);
        return i + 1;
    }
    // implement swap
    public void swap(int[] nums, int[] cost, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        temp = cost[i];
        cost[i] = cost[j];
        cost[j] = temp;
    }
}
/*
nums = [1, 3, 5, 2]
cost = [2, 3, 1, 14]

----
equalNum = 2
cost = 2 + 3 + 1 + 1 + 1 = 8

----
equalNum = 3
cost = 2 + 2 + 1 + 1 + 14 = 20

----
equalNum = 1
const = 3 + 3 + 1 + 1 + 1 + 1 + 14 = 24
----
equalNum = 5
const = 2 + 2 + 2 + 2 + 3 + 3 + 14 + 14 + 14 = 56

 */
