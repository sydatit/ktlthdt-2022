package contest.endyear2023;

import java.util.Scanner;

public class SegmentTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        int[][] query = new int[q][3];
        for (int i = 0; i < q; i++) {
            query[i][0] = scanner.nextInt();
            query[i][1] = scanner.nextInt();
            query[i][2] = scanner.nextInt();
        }

    }
}
