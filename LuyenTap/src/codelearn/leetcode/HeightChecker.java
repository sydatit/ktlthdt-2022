package codelearn.leetcode;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {

    }
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] expected = Arrays.copyOf(heights, n);
        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += heights[i] != expected[i] ? 1 : 0;
        }
        return count;
    }
}
