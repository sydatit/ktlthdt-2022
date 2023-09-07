package codelearn.leetcode.Checkpoint;

import java.util.Scanner;

public class MANAGING_NCC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[] projects = new long[n];
        for (int i = 0; i < n; i++) {
            projects[i] = scanner.nextInt();
        }
        long[] dp = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            long temp = 0;
            for (int j = i; j >= 0 && i - j + 1 <= k; j--) {
                temp += projects[j];
                long prevProfit = j >= 2 ? dp[j - 2] : 0;
                dp[i] = Math.max(dp[i], temp + prevProfit);
            }
            if (i >= k) {
                dp[i] = Math.max(dp[i], dp[i - k]);
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
    // improve time complexity to O(nlogn)
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     int n = scanner.nextInt();
    //     int k = scanner.nextInt();
    //     long[] projects = new long[n];
    //     for (int i = 0; i < n; i++) {
    //         projects[i] = scanner.nextInt();
    //     }
    //     // create a prefix sum array
    //     long[] prefix = new long[n];
    //     prefix[0] = projects[0];
    //     for (int i = 1; i < n; i++) {
    //         prefix[i] = prefix[i - 1] + projects[i];
    //     }
    //     // initialize dp array and max variable
    //     long[] dp = new long[n];
    //     long max = 0;
    //     for (int i = 0; i < n; i++) {
    //         long temp = 0;
    //         for (int j = i; j >= 0 && i - j + 1 <= k; j--) {
    //             temp += projects[j];
    //             long prevProfit = j >= 2 ? dp[j - 2] : 0;
    //             dp[i] = Math.max(dp[i], temp + prevProfit);
    //         }
    //         if (i >= k) {
    //             dp[i] = Math.max(dp[i], dp[i - k]);
    //         }
    //         max = Math.max(max, dp[i]);
    //     }
    //     System.out.println(max);
    // }



}

/*
5 2
8 6 2 5 7

5 1
1 1 1 1 1

5 2
-1 2 -3 4 5

7 2
1 8 6 2 5 7 3
 */

/*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[] projects = new long[n];
        for (int i = 0; i < n; i++) {
            projects[i] = scanner.nextInt();
        }
        // create a prefix sum array
        long[] prefix = new long[n];
        prefix[0] = projects[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + projects[i];
        }
        // initialize dp array and max variable
        long[] dp = new long[n];
        long max = 0;
        // loop over each element
        for (int i = 0; i < n; i++) {
            // find the sum of the current window of size k or less
            long windowSum = prefix[i] - (i >= k ? prefix[i - k] : 0);
            // find the previous profit by looking at dp[i - k - 1] if it exists
            long prevProfit = i >= k + 1 ? dp[i - k - 1] : 0;
            // update dp[i] with the maximum of windowSum + prevProfit or dp[i - 1]
            dp[i] = Math.max(windowSum + prevProfit, i > 0 ? dp[i - 1] : 0);
            // update max with dp[i]
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
 */