package codelearn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        System.out.println(Arrays.toString(new RelativeSortArray().relativeSortArray(arr1, arr2)));
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        return Arrays.stream(arr1).boxed().sorted((a, b) -> {
            if (map.containsKey(a) && map.containsKey(b)) {
                return map.get(a) - map.get(b);
            } else if (map.containsKey(a)) {
                return -1;
            } else if (map.containsKey(b)) {
                return 1;
            } else {
                return a - b;
            }
        }).mapToInt(Integer::intValue).toArray();
    }
}
