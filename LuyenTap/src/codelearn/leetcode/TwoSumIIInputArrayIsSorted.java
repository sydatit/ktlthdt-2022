package codelearn.leetcode;

import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{-1,-1,1}, -2)));
    }
//    public static int[] twoSum(int[] numbers, int target) {
//        for (int i = 0; i < numbers.length - 1; i++) {
//            int sum = numbers[i];
//            int j = i + 1;
//            while (j < numbers.length && numbers[j] + sum < target) j++;
//            if (j < numbers.length && numbers[j] + sum == target) {
//                return new int[]{i + 1, j + 1};
//            }
//        }
//
//        return new int[0];
//    }
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) break;
            if (numbers[left] + numbers[right] < target) {
                left++;
                continue;
            }
            right--;
        }
        return new int[]{left + 1, right + 1};
    }
}
