package codelearn.leetcode;

public class CountSubarraysWhereMaxElementAppearsLeastKTimes {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,3};
        int k = 2;
        System.out.println(new CountSubarraysWhereMaxElementAppearsLeastKTimes().countSubarrays(nums, k));
    }
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int count = 0, j = 0, result = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == max ? 1 : 0;
            while (count >= k) {
                count -= nums[j++] == max ? 1 : 0;
            }
            result += j;
        }
        return result;
    }
}
