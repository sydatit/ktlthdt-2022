package codelearn.leetcode;

import java.util.Arrays;

public class IceCreamBar {
    public static void main(String[] args) {
        System.out.println(maxIceCream(new int[]{1,3,2,4,1}, 7));
    }
    public static int maxIceCream(int[] costs, int coins) {
        int count = 0;
        Arrays.sort(costs);
        for (int i = 0; i < costs.length; i++) {
            coins -= costs[i];
            if( coins >= 0) count++;
            else break;
        }
        return count;
    }
}
