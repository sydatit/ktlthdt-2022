package dequy;

import java.util.Scanner;

public class TN01022_DeQuy {
    private static long mod = 1000000000 + 7;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            long a = 0, b = 0;
            a = scanner.nextLong();
            b = scanner.nextLong();
            if( a == 0 && b == 0)
                break;
            System.out.println(luyThua(a, b));
        }while (true);
    }

    private static long luyThua(long a, long b) {
        if( b == 0) return 1;
        long x = luyThua( a, b/2);
        if( b % 2 == 0)
            return ( x * x)% mod;
        else
            return (a *( ( x * x) % mod)) % mod;
    }
}
