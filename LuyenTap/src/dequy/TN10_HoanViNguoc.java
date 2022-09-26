package dequy;

import java.util.Arrays;
import java.util.Scanner;

public class TN10_HoanViNguoc {
    private static int n;
    private static boolean[] marked;
    private static int[] res;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            n = scanner.nextInt();
            marked = new boolean[n+1];
            res = new int[n+1];
            Try(1);
            System.out.println();
        }
    }

    private static void Try(int i) {
        for (int j = n; j >= 1 ; j--) {
            if( !marked[j]){
                res[i] = j;
                marked[j] = true;
                if( i == n){
                    // show
                    for (int k = 1; k < n + 1; k++) {
                        System.out.printf( res[k] + "");
                    }
                    System.out.printf(" ");
                }else Try( i + 1);
                marked[j] = false;
            }
        }
    }
}
