package codelearn.leetcode;

import java.util.Arrays;

public class MinimumNumberOperationsMakeArrayContinuous {
//    public static void main(String[] args) {
//        MinimumNumberOperationsMakeArrayContinuous c = new MinimumNumberOperationsMakeArrayContinuous();
//        int[] arr = new int[]{1,10,100,1000};
//        System.out.println(c.minOperations(arr));
//    }
    public int minOperations(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return 0;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = length - 1; i > 0 ; i--) {
            int minValue = nums[i] + 1 - length;

            int index = Arrays.binarySearch(nums, minValue);
            // find it
            if (index >= 0) {
                int missNumber = index + length - i - 1;
                int availableNum = nums[i] - nums[index];
                if (availableNum >= missNumber)
                    res = Math.min(res, missNumber);
            } else {
                index = -(index + 1);
                int missNumber = index + length - i - 1;
                int availableNum = nums[i] - minValue;
                if (availableNum >= missNumber)
                    res = Math.min(res, missNumber);
            }
        }
        return res;
    }

    public static int findFirstElementGreaterOrEqual(int[] array, int target) {
        int index = Arrays.binarySearch(array, target);
        if (index < 0) {
            index = -(index + 1);
        }
        if (index < array.length) {
            return index;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13};
        int target = 10;

        int result = findFirstElementLessOrEqual(array, target);
        if (result != -1) {
            System.out.println("First element less than or equal to the target: " + result);
        } else {
            System.out.println("No suitable element found.");
        }
    }

    public static int findFirstElementLessOrEqual(int[] array, int target) {
        int index = Arrays.binarySearch(array, target);
        if (index < 0) {
            // If the target is not found, binarySearch returns (-(insertion point) - 1)
            // We convert it to the actual insertion point by taking the absolute value and subtracting 1
            index = -(index + 1) - 1;
        }
        if (index >= 0) {
            return array[index];
        }
        return -1;
    }
}
