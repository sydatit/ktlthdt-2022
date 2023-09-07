package codelearn.io;

import java.util.*;

public class NonDecreasingSubsequences {
    public static void main(String[] args) {
        System.out.println((new NonDecreasingSubsequences()).findSubsequences(
                new int[]{
                        100,90,80,70,60,50,60,70,80,90,100
                }
        ));
    }
    private int[] mark;
    private int n;
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> lists = new HashSet<>();
        n = nums.length;
        mark = new int[n];
        Try(0, nums, lists);
        return new ArrayList<>(lists);
    }
    private void Try(int i, int[] nums, Set<List<Integer>> lists ){
        for (int j = 0; j <= 1; j++) {
//            System.out.println(i + " " + j + " " + Arrays.toString(mark));
            mark[i] = j;
            if( i == n - 1){
                saveResult(nums, lists);
            }else {
                Try(i + 1, nums, lists);
            }
        }
    }

    private void saveResult(int[] nums, Set<List<Integer>> lists ) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        boolean isNonDecreasing = true;
        int lastR = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if( mark[i] == 1){
                result.add(nums[i]);
                count++;
                if( nums[i] >= lastR){
                    lastR = nums[i];
                }else {
                    isNonDecreasing = false;
                    break;
                }
            }
        }
        if( count >= 2 && isNonDecreasing)
            lists.add(result);
    }
}
