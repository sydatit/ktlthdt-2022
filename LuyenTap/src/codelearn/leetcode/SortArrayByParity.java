package codelearn.leetcode;

public class SortArrayByParity {
    public static void main(String[] args) {

    }
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (nums[i] % 2 == 0) {
                i++;
            } else if (nums[j] % 2 != 0) {
                j--;
            } else {
                nums[i] = nums[i] + nums[j];
                nums[j] = nums[i] - nums[j];
                nums[i] = nums[i] - nums[j];
            }
        }
        return nums;
    }
}
