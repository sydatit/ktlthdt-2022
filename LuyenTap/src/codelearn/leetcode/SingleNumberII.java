package codelearn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberII {
    public static void main(String[] args) {
        SingleNumberII singleNumberII = new SingleNumberII();
        int[] nums = {2,2,3,2};
        int result = singleNumberII.singleNumber(nums);
        System.out.println(result);
    }
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            if( count == 3)
                map.remove(num);
            else
                map.put(num, count);
        }
        return map.keySet().iterator().next();
    }
}
