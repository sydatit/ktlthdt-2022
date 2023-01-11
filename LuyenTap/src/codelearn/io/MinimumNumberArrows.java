package codelearn.io;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberArrows {
    public static void main(String[] args) {
        System.out.println(findMinArrowShots( new int[][]{
                {10, 16},
                {2,8},
                {1,6},
                {7,12}
        }));
    }
    public static int findMinArrowShots(int[][] points) {
        int result = 1;
        Arrays.sort( points, Comparator.comparingInt(a -> a[1]));
        int previous = 0;
        for (int i = 1; i < points.length; i++) {
            if( points[i][0] > points[previous][1]){
                result++;
                previous = i;
            }
        }
        return result;
    }
}
