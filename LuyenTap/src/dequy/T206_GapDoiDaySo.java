package dequy;

import java.util.Scanner;

public class T206_GapDoiDaySo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            long n = scanner.nextLong(), k = scanner.nextLong();
            long length = (long) Math.pow(2, n -1);
            System.out.println(solve(length, n, k));
        }
    }

    private static long solve(long length, long n, long k) {
        if( length == k)
            return n;
        if( n == 1)
            return 1;
        return solve( length/2, n -1, k > length ? length - ( k - length) : k);
    }
}
