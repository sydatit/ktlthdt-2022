package codelearn.leetcode;

import java.util.*;

public class SortIntegersTheNumber1Bits {
    public static void main(String[] args) {
        int i = 9;
//        System.out.println(countSetBits(i));
        SortIntegersTheNumber1Bits s = new SortIntegersTheNumber1Bits();
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(s.sortByBits(arr)));
    }
    int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public int[] sortByBits(int[] arr) {
//        int[] result = new int[arr.length];
        List<int[]> list = new ArrayList<>();
        for (int item :arr) {
//            System.out.println(item + " " + countSetBits(item));
            list.add(new int[]{item, countSetBits(item)});
        }
        list.sort((a, b) -> {
            if (a[1] < b[1])
                return -1;
            if (a[1] > b[1])
                return 1;
            if (a[0] < b[0])
                return -1;
            if (a[0] > b[0])
                return 1;
            return 0;
        });
//        for (int i = 0; i < arr.length; i++) {
//            result[i] = list.get(i)[0];
//        }
//        list.stream().map(item -> item[0]).toArray();
        return list.stream().map(item -> item[0]).mapToInt(Integer::intValue).toArray();
    }
}
