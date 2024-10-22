package codelearn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOperationsMakeArrayEmpty {
    public static void main(String[] args) {
//        System.out.println(calculateNumberOfOperations(8));
        System.out.println(minOperations(new int[]{14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12}));
    }
    public static int minOperations(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int count = 0;
            while (i < nums.length && current == nums[i]) {
                i++;
                count++;
            }
            if (count == 1) return -1;
            result += calculateNumberOfOperations(count);
            i--;
        }
        return result;
    }

    private static int calculateNumberOfOperations(int fre) {
        int remainder = fre % 3;

        if (remainder == 0) return fre/3;
        else{
            int res = fre/3;
            if (remainder == 1)
                res -= 1;
            return res + (fre - res * 3)/2;
        }
    }
}
/*
2*x + 3*y = 10
(x + y) min
2 + 2
10 / 3 = 3 du 1
    if du 1 then result = fre / 3 - 1
8 / 3 = 2 du 2

 */