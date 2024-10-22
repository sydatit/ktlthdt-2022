package codelearn.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleNumberIII {
    public static void main(String[] args) {
        SingleNumberIII singleNumberIII = new SingleNumberIII();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = singleNumberIII.singleNumber(nums);
        for (int num : result) {
            System.out.println(num);
        }
    }
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }
        int[] result = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() == 1) {
                result[index++] = entry.getKey();
            }
        }
        return result;
    }
}
