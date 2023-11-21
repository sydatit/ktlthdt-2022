package codelearn.leetcode;

import java.util.Arrays;

public class FindTheOriginalArrayPrefixXor {
    public static void main(String[] args) {
        FindTheOriginalArrayPrefixXor xor = new FindTheOriginalArrayPrefixXor();
        int[] array = new int[]{5,2,0,3,1};
        System.out.println(Arrays.toString(xor.findArray(array)));
    }
    public int[] findArray(int[] pref) {
        int previousXor = pref[0];
        for (int i = 1; i < pref.length; i++) {
            pref[i] = previousXor ^ pref[i];
            previousXor ^= pref[i];
        }
        return pref;
    }
}
/*
5,2,0,3,1
5

 */