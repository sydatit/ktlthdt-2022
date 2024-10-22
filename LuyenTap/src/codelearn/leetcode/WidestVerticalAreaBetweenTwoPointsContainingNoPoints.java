package codelearn.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public static void main(String[] args) {
        System.out.println(maxWidthOfVerticalArea((new int[][]{
                {3,1}, {9,0}, {1,0}, {1,4}, {5, 3}, {8, 8}
        })));
    }
    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int result = 0;
        for (int i = 1; i < points.length; i++) {
            int[] currentPoint = points[i];
            int[] previousPoint = points[i - 1];
            result = Math.max(result, currentPoint[0] - previousPoint[0]);
        }
        return result;
    }
}
