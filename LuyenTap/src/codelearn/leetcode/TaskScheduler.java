package codelearn.leetcode;

import java.util.Arrays;

public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 3;
        System.out.println(taskScheduler.leastInterval(tasks, n));
    }
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        int max = 0;
        int result = 0;
        int idle;
        int sum = 0;
        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i] - 'A']++;
            max = Math.max(max, counts[tasks[i] - 'A']);
        }
        idle = (max - 1) * n + max - 1;
//        Arrays.sort(counts);
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == max) {
                result++;
                counts[i]--;
            }
            sum += counts[i];
        }
        if (sum >= idle) {
            return tasks.length;
        } else {
            return idle + result;
        }
    }
}
