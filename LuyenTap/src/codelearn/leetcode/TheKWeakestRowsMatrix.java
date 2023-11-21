package codelearn.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class TheKWeakestRowsMatrix {
    public static void main(String[] args) {
        TheKWeakestRowsMatrix test = new TheKWeakestRowsMatrix();
        int[][] mat = {{1,1,0,0,0},
                       {1,1,1,1,0},
                       {1,0,0,0,0},
                       {1,1,0,0,0},
                       {1,1,1,1,1}};
        int k = 3;
        int[] result = test.kWeakestRows(mat, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int countSoldier = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    countSoldier++;
            }
            list.add(new int[]{i, countSoldier});
        }
        int[] result = new int[k];
        list.sort((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        for (int i = 0; i < k && !list.isEmpty(); i++) {
            result[i] = list.get(i)[0];
        }
        return result;
    }
}
