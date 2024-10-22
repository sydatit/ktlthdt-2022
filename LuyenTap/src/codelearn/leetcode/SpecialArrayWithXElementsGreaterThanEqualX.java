package codelearn.leetcode;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanEqualX {
    public static void main(String[] args) {
SpecialArrayWithXElementsGreaterThanEqualX specialArrayWithXElementsGreaterThanEqualX = new SpecialArrayWithXElementsGreaterThanEqualX();
        int[] nums = {3,6,7,7,0};
        System.out.println(specialArrayWithXElementsGreaterThanEqualX.specialArray(nums));
    }

    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int result = -1;
        for (int i = 0; i < n; i++) {
            int numberOfElements = n - i;
            if (numberOfElements <= nums[i] && (i - 1 < 0 || nums[i - 1] < numberOfElements)) {
                result = numberOfElements;
                break;
            }
        }
        return result;
    }
}
