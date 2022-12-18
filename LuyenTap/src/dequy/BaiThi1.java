package dequy;

import java.util.Scanner;

public class BaiThi1{
    static int m;
    static int n;
    static int k;
    static int[] result;
    static int count;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        m = scanner.nextInt();
        result = new int[k + 1];
        Try(1);
    }

    private static void Try(int i) {
        for (int j = i; j <= n -k + i; j++) {
            result[i] = j;
            if( i == k){
                count++;
                if( count % k == 0){
                    printResult();
                }
            }else Try(i + 1);
        }
    }

    private static void printResult() {
        for (int i = 1; i <= k; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
