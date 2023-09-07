package codelearn.leetcode;

public class SpiralMatrixII {
    public static void main(String[] args) {
        SpiralMatrixII test = new SpiralMatrixII();
        int[][] result = test.generateMatrix(3);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }
    }
    public int[][] generateMatrix(int n) {
        int up = 0, down = n - 1;
        int left = 0, right = n - 1;
        int[][] result = new int[n][n];
        int count = 1;
        while (count <= n*n){
            for (int i = left; i <= right ; i++) {
                result[up][i] = count++;
                System.out.println(up + " " + i);
            }
            for (int i = up + 1; i <= down ; i++) {
                result[i][right] = count++;
                System.out.println(i + " " + right);
            }
            if (up != down) {
                for (int i = right - 1; i >= left; i--) {
                    result[down][i] = count++;
                    System.out.println(down + " " + i);
                }
            }
            if (left != right) {
                for (int i = down - 1; i > up; i--) {
                    result[i][left] = count++;
                    System.out.println(i + " " + left);
                }
            }
            up++;
            down--;
            left++;
            right--;
        }


        return result;
    }
}
