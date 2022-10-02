package dequy;

import java.util.Scanner;

public class T208_SoFiboThuN {
    private static final long MOD = (long) 1e9 + 7;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            int n = scanner.nextInt();
            int[][] maxtrix = { {0 ,1}, {1, 1}};



        }
    }

    private long[][] multiMatrix(long[][] matrixA, long[][] matrixB){

        long[][] matrixRes = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    matrixRes[i][j] = (matrixRes[i][j] + (matrixA[i][k] * matrixB[k][i]) % MOD) % MOD;
                }
            }
        }
        return matrixRes;
    }
}
