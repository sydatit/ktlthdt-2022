package codelearn.leetcode;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0};
        int goal = 2;
        System.out.println(new BinarySubarraysWithSum().numSubarraysWithSum(nums, goal));
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return 1;
    }
}
