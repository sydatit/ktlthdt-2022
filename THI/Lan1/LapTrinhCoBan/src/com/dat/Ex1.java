package com.dat;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        scanner.nextLine();
        while (repeat --> 0){
            String inputStr = scanner.nextLine();
            System.out.println(solveSeperate(inputStr));
        }
    }

    private static String solveSeperate(String inputStr) {
        int length = inputStr.length();
        if( length % 2 != 0) return "INVALID";
        else {
            String strLeft = inputStr.substring(0, length/2);
            String strRight = inputStr.substring( length/2, length);
            BigInteger numberLeft = new BigInteger(  strLeft);
            BigInteger numberRight = new BigInteger(strRight);
            BigInteger gcd = numberLeft.gcd(numberRight);
            BigInteger lcm = ( numberLeft.multiply(numberRight)).divide(gcd);
            return lcm.toString();
        }
    }
}
