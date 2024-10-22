package codelearn.leetcode;

import java.math.BigInteger;

public class Number1Bits {
    public static void main(String[] args) {
        Number1Bits n1 = new Number1Bits();
    }
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (char c: s.toCharArray()) {
            if (c == '1') count++;
        }
        return count;
    }

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger res = new BigInteger(n + "");
        for (int i = n - 1; i > 0; i--) {
            res = res.multiply(new BigInteger(i + ""));
        }
        System.out.println(res.toString());
    }

}
