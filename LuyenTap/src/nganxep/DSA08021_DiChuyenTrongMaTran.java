package nganxep;

import java.util.Queue;
import java.util.Scanner;

public class DSA08021_DiChuyenTrongMaTran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat-->0){
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[][] matrix = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            System.out.println(solveInMatrix(matrix, N, M));
        }
    }

    private static int solveInMatrix(int[][] matrix, int n, int m) {
        return 0;
    }
}
