package contest.midyear2024;

import java.util.Scanner;

public class SHIPPER {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] foods = new int[n];
        for (int i = 0; i < n; i++) {
            foods[i] = sc.nextInt();
        }
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (i <= k) {
                count += Math.min(foods[i], foods[k]);
            } else {
                count += Math.min(foods[i], foods[k] - 1);
            }
        }
        System.out.println(count);
    }
}
/*
4 1
1 2 3 4

7 4
9 6 9 2 8 2 3

 */