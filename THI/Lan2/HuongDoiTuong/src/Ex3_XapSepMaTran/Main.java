package Ex3_XapSepMaTran;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("DATA1.in"));
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            int N = scanner.nextInt(), M = scanner.nextInt(), colum = scanner.nextInt();
            List<Integer> integerList = new ArrayList<>();
            int[][] matrix = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if( j == colum -1 ) integerList.add(matrix[i][j]);
                }
            }
            integerList.sort(Integer::compareTo);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if( j == colum -1 ) {
                        System.out.print(integerList.get(i) + " ");
                    }else System.out.printf(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
