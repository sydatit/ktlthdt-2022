package dequy;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex43 {
    public static long[] arr = new long[100];
    public static void generateFibo(){
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i < 92; i++) {
            arr[i] = arr[i -2] + arr[i -1];
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        generateFibo();
        while ( repeat --> 0){
            int N = scanner.nextInt();
            long i = scanner.nextLong();
            System.out.println(findResult(i, N));
        }
    }

    private static String findResult(long i, int n) {
        if( n == 1) return "A";
        if( n == 2) return "B";

        if( i <= arr[n - 2]) return findResult( i , n - 2);
        else return findResult( i - arr[n-2], n -1);
    }
}
