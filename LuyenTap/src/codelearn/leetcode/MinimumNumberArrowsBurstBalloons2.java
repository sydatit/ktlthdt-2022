package codelearn.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberArrowsBurstBalloons2 {
    public static void main(String[] args) {
        int[][] points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(new MinimumNumberArrowsBurstBalloons2().findMinArrowShots(points));
    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int preFirst = points[0][0];
        int preSecond = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= preSecond && preFirst <= points[i][1]) {
                preFirst = Math.max(preFirst, points[i][0]);
                preSecond = Math.min(preSecond, points[i][1]);
            } else {
                count++;
                preFirst = points[i][0];
                preSecond = points[i][1];
            }
        }
        return count;
    }
}
