package codelearn.leetcode;

import java.util.*;

public class FindKPairsSmallestSums {
    public static void main(String[] args) {
        FindKPairsSmallestSums findKPairsSmallestSums = new FindKPairsSmallestSums();
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        int k = 10;
        List<List<Integer>> result = findKPairsSmallestSums.kSmallestPairs(nums1, nums2, k);
        System.out.println(result);
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] + a[1])));
        List<List<Integer>> result = new ArrayList<>();
        if( nums1.length == 0 || nums2.length == 0 || k == 0){
            return result;
        }
        for (int i = 0; i < nums1.length; i++) {
            queue.add(new int[]{ nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !queue.isEmpty()) {
            int[] cur = queue.poll();
            List<Integer> list = new ArrayList<>(Arrays.asList(cur[0], cur[1]));
            result.add(list);
            if( cur[2] == nums2.length - 1)
                continue;
            queue.add(new int[]{ cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return result;
    }
}
