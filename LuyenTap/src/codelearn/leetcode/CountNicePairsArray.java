package codelearn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairsArray {
    public static void main(String[] args) {
        CountNicePairsArray a = new CountNicePairsArray();
        System.out.println(a.countNicePairs(new int[] { 11,1}));
    }
    final int MOD = (int) (1e9 + 7);
    public int countNicePairs(int[] nums) {
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num :nums) {
            int rev = getReverseNum(num);
            res += map.merge(num - rev, 1, Integer::sum) - 1;
        }
        return (int) res % MOD;
    }

//    public int countNicePairs(int[] nums) {
//        long result = 0;
//        Map<Integer, Long> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int reversedNumber = getReverseNum(nums[i]);
//            int key = nums[i] - reversedNumber;
//            long value = map.getOrDefault( key, 0L);
//            map.put(key, ++value);
//        }
//        for (Map.Entry<Integer, Long> item: map.entrySet()) {
//
//            long value = item.getValue();
//            result = (result + (((value - 1) * value)/2)% MOD)%MOD ;
//        }
//        return (int) result;
//    }

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
