package codelearn.leetcode;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(intervals));
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    if (o1[1] > o2[1]) {
                        return 1;
                    } else if (o1[1] < o2[1]) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
        });
        int count = 0;
        int[] last = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < last[1]){
                count++;
                if(intervals[i][1] < last[1]){
                    last = intervals[i];
                }
            }else{
                last = intervals[i];
            }
        }
        return count;
    }

}
