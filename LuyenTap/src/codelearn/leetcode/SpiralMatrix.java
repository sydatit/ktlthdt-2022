package codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},
                {9,10,11,12}};
        SpiralMatrix test = new SpiralMatrix();
        List<Integer> result = test.spiralOrder(matrix);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int up = 0, down = n - 1;
        int left = 0, right = m - 1;
        List<Integer> result = new ArrayList<>();
        while (result.size() < n * m) {
            for (int i = left; i <= right ; i++) {
                result.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down ; i++) {
                result.add(matrix[i][right]);
            }
            if (up != down) {
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
            }
            if (left != right) {
                for (int i = down - 1; i > up; i--) {
                    result.add(matrix[i][left]);
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
