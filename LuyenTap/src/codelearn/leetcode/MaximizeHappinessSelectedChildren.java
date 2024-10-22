package codelearn.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class MaximizeHappinessSelectedChildren {
    public static void main(String[] args) {
        MaximizeHappinessSelectedChildren maximizeHappinessSelectedChildren = new MaximizeHappinessSelectedChildren();
        int[] happiness = { 1, 2, 3};
        int k = 2;
        System.out.println(maximizeHappinessSelectedChildren.maximumHappinessSum(happiness, k));
    }
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0L;
        int n = happiness.length;
        for (int i = n - 1; i >= 0; i--) {
            happiness[i] = happiness[i] + i + 1 - n;
        }
        for (int i = n - 1; i >= 0 && k-->0; i--) {
            sum += happiness[i];
        }
        return sum;
    }
}
