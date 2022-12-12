package ncc.contest;

import java.util.Scanner;

public class Garden {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] matrix = new int[a + 1][ b + 1];
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println(maxPerimeter(a, b, matrix));
    }

    private static int maxPerimeter(int a, int b, int[][] matrix) {
        int maxSumP = Integer.MIN_VALUE;
        int[][] row = new int[a + 1][ b + 1];
        int[][] column = new int[a + 1][ b + 1];
        preCalculate(a, b, matrix, row, column);
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                int maxHeight = a - i;
                int maxWeight = b - j;
                int perimeter = 0;
                for (int k = 1; k <= maxHeight; k++) {
                    for (int l = 1; l <= maxWeight; l++) {
//                        System.out.println( maxHeight + " " + maxWeight);
                        perimeter = calculatePerimeter(matrix, row, column, i, j, k, l);
                        maxSumP = Math.max( maxSumP, perimeter);
                    }
                }
            }
        }
        return maxSumP;
    }

    private static int calculatePerimeter(int[][] matrix, int[][] row, int[][] column, int i, int j, int height, int weight) {
        int upperEdge = row[i][j + weight] - row[i][j - 1] ;
        int bottomEdge = row[i + height][j + weight] - row[i + height][j - 1];
        int leftEdge = column[i + height][j] - column[i - 1][j];
        int rightEdge = column[i + height][j + weight] - column[i - 1][ j + weight];
        int sum = upperEdge + bottomEdge + leftEdge + rightEdge;
        sum = sum - matrix[i][j] - matrix[i][j + weight] - matrix[i + height][j] - matrix[i + height][j + weight];
        return sum;
    }

    private static void preCalculate(int a, int b, int[][] matrix, int[][] row, int[][] column) {
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b ; j++) {
                row[i][j] = row[i][j - 1] + matrix[i][j];
            }
        }
        for (int i = 1; i <= b; i++) {
            for (int j = 1; j <= a ; j++) {
                column[j][i] = column[j - 1][i] + matrix[j][i];
            }
        }
    }
}
/*
3 3
-5 -9 9
-8 -6 7
-10 7 5
3 4
1 1 1 1
1 -5 -5 1
1 1 1 1
 */
