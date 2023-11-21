package codelearn.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {
    public static void main(String[] args) {
        FindUniqueBinaryString f = new FindUniqueBinaryString();
        System.out.println(f.findDifferentBinaryString(new String[]{
                "00", "10"
        }));
    }
    public String findDifferentBinaryString(String[] nums) {
        int[] values = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            values[i] = Integer.parseInt(nums[i], 2);
        }
        int n = (int) Math.pow(2, nums[0].length());
        Set<Integer> set = new HashSet<>();
        for (int item : values) {
            set.add(item);
        }
        int foundNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(values[i] + 1) && values[i] + 1 < n) {
                foundNum = values[i] + 1;
                break;
            }
            if (!set.contains(values[i] - 1) && values[i] - 1 >= 0) {
                foundNum = values[i] - 1;
                break;
            }
        }
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(foundNum));
        sb.reverse();
        while (sb.length() < nums[0].length()) sb.append('0');
        return sb.reverse().toString();
    }
//    public String findDifferentBinaryString(String[] nums) {
//        StringBuilder sb = new StringBuilder();
//        int n = nums.length;
//
//        char[] res = getChars(nums, sb, n, '1');
//        String temp = new String(res);
//
//        for (int i = 0; i < n; i++) {
//            if (!nums[i].equals(temp)) {
//                sb.setLength(0);
//                return new String(getChars(nums, sb, n, '0'));
//            }
//        }
//        return temp;
//    }

    private char[] getChars(String[] nums, StringBuilder sb, int n, char bit) {
        while (sb.length() < n) sb.append(bit);
        char[] res = sb.toString().toCharArray();
        for (String num : nums) {
            xorString(res, num);
        }
        return res;
    }

    private void xorString(char[] res, String num) {
        for (int i = 0; i < res.length; i++) {
            if (num.charAt(i) == res[i])
                res[i] = '0';
            else res[i] = '1';
        }
    }
}
