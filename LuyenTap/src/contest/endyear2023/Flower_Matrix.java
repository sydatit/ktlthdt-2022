package contest.endyear2023;

import java.util.Arrays;
import java.util.Scanner;

public class Flower_Matrix {
    private static int NUMBER_OF_FOLWERS = 5;

    private static final int MOD = 1000000007;

    private static int findPath(long n) {
        n -= 1;

        long[][] currMove = new long[][]{
                {0	,1	,1	,0	,1},
                {1	,0	,1	,0	,0},
                {0	,1	,0	,1	,0},
                {0	,0	,1	,0	,0},
                {0	,0	,1	,1	,0}
        };
        long[] sumMoves = new long[NUMBER_OF_FOLWERS];
        Arrays.fill(sumMoves, 1);
        while (n > 0) {
            if ((n & 1) == 1) {
                sumMoves = multiplyMatrix(sumMoves, currMove);
            }
            n >>= 1;
            if (n > 0) {
                currMove = multiplyMatrix(currMove, currMove);
            }
        }
        return (int) (Arrays.stream(sumMoves).sum() % MOD);
    }

    private static long[][] multiplyMatrix(long[][] a, long[][] b) {
        int rowA = a.length;
        int colA = a[0].length;
        int colB = b[0].length;
        long[][] result = new long[rowA][colB];

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < colA; k++) {
                    result[i][j] += (a[i][k] * b[k][j])%MOD;
                    result[i][j] %= MOD;
                }
            }
        }

        return result;
    }

    private static long[] multiplyMatrix(long[] a, long[][] b) {
        int colA = a.length;
        int colB = b[0].length;
        long[] result = new long[colB];

        for (int i = 0; i < colB; i++) {
            for (int j = 0; j < colA; j++) {
                result[i] += (a[j] * b[j][i])%MOD;
                result[i] %= MOD;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(findPath(n));
    }
}
