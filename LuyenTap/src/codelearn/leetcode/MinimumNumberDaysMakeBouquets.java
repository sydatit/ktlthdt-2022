package codelearn.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MinimumNumberDaysMakeBouquets {
    public static void main(String[] args) {
        MinimumNumberDaysMakeBouquets test = new MinimumNumberDaysMakeBouquets();
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        System.out.println(test.minDays(bloomDay, m, k));
    }
    public int minDays(int[] bloomDay, int m, int numberOfAdjBlooms) {
        if ((long) m * numberOfAdjBlooms > bloomDay.length) {
            return -1;
        }
        Set<Integer> set = new TreeSet<>();
        for (int bloom : bloomDay) {
            set.add(bloom);
        }
        int[] days = new int[set.size()];
        int i = 0;
        for (int day : set) {
            days[i++] = day;
        }
        int left = 0;
        int right = days.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(bloomDay, m, numberOfAdjBlooms, days[mid])) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return days[left];
    }

    private boolean check(int[] bloomDay, int m, int numberOfAdjBlooms, int day) {
        int count = 0;
        int adj = 0;
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                adj++;
                if (adj == numberOfAdjBlooms) {
                    count++;
                    adj = 0;
                }
            } else {
                adj = 0;
            }
            if (count >= m) {
                break;
            }
        }
        return count >= m;
    }
}
