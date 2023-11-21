package codelearn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairsArray {
    public static void main(String[] args) {

    }
    final int MOD = (int) (1e9 + 7);
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int reversedNumber = getReverseNum(nums[i]);
            int key = nums[i] - reversedNumber;
            int value = map.getOrDefault( key, 0);
            map.put(key, ++value);
        }
        for (Map.Entry<Integer, Integer> item: map.entrySet()) {
            item.get
        }
    }

    private int getReverseNum(int num) {
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }

}

/*
3
1 1 1
3
1 ... (n - 1)
(n - 1)n/2

2 1
 */
