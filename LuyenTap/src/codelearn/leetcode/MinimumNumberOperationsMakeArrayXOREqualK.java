package codelearn.leetcode;

public class MinimumNumberOperationsMakeArrayXOREqualK {
    public static void main(String[] args) {
        MinimumNumberOperationsMakeArrayXOREqualK minimumNumberOperationsMakeArrayXOREqualK = new MinimumNumberOperationsMakeArrayXOREqualK();
        int[] nums = {2, 1, 3, 4};
        int k = 1;
        System.out.println(minimumNumberOperationsMakeArrayXOREqualK.minOperations(nums, k));
    }
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int xorSum = nums[0];
        for (int i= 1; i < n; i++) {
            xorSum ^= nums[i];
        }
        return countDifferentBits(xorSum, k);
    }

    private int countDifferentBits(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((x >> i) & 1) != ((y >> i) & 1)) {
                count++;
            }
        }
        return count;
    }
}
