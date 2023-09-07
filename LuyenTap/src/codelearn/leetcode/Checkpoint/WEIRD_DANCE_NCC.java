package codelearn.leetcode.Checkpoint;

import java.util.Scanner;

public class WEIRD_DANCE_NCC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println((int)Math.sqrt(n));
    }

}
/*
1, 2, 3, 5, 6, 9, 10, 15, 18, 30, 45, 90

1, 3, 5, 9, 15, 45
1, 2, 3, 5, 6, 10, 15, 30
1, 2, 3, 6, 9, 18

1, 2, 3, 5, 6, 9, 10, 15, 18, 30, 45, 90
 */