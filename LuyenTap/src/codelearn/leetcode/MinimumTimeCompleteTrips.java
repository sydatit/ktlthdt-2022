package codelearn.leetcode;

import java.util.Arrays;

public class MinimumTimeCompleteTrips {
    public static void main(String[] args) {
        int[] time = {2};
        int totalTrips = 1;
        System.out.println(new MinimumTimeCompleteTrips().minimumTime(time, totalTrips));
    }
    public long minimumTime(int[] time, int totalTrips) {
        long min = Arrays.stream(time).min().getAsInt();
        long left = min;
        long right = totalTrips * min;
        while (left < right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < time.length; i++) {
                count += mid / time[i];
                if( count >= totalTrips) break;
            }
            if (count >= totalTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
