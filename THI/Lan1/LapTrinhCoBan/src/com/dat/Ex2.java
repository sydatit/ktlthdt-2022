package com.dat;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = -1;
        do{
            N = scanner.nextInt();
            if( N != 0){
                scanner.nextLine();
                String[] arrayStr = new String[N];
                for (int i = 0; i < N; i++) {
                    arrayStr[i] = scanner.nextLine();
                }
                System.out.println(solveMinMaxStr( arrayStr, N));
            }
        }while (N != 0);
    }

    private static String solveMinMaxStr(String[] arrayStr, int n) {
        BigInteger min = new BigInteger(arrayStr[0]);
        BigInteger max = new BigInteger(arrayStr[0]);
        for (int i = 1; i < n; i++) {
            BigInteger bigIntegerI = new BigInteger( arrayStr[i]);
            min = min.min( bigIntegerI);
            max = max.max( bigIntegerI);
        }
        if( min.compareTo(max) == 0) return "BANG NHAU";
        else return min + " " + max;
    }
}
