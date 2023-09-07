package codelearn.io;

import java.math.BigInteger;

public class GreatestCommonDivisor {
    public static void main(String[] args) {

    }
    public String gcdOfStrings(String str1, String str2) {
        if( !(str1 + str2).equals(str2 + str1))
            return "";
        else {
            BigInteger num1 = new BigInteger(str1.length() + "");
            BigInteger num2 = new BigInteger(str2.length() + "");
            int index = num1.gcd(num2).intValue();
            return str1.substring(0, index);
        }
    }
}
