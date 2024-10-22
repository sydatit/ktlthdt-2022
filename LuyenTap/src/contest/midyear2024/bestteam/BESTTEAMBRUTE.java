package contest.midyear2024.bestteam;

import java.util.Scanner;

public class BESTTEAMBRUTE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] qualities = new int[n];
        for (int i = 0; i < n; i++) {
            qualities[i] = sc.nextInt();
        }

        System.out.println(bruteForce(n, qualities));
    }

    private static int bruteForce(int n, int[] qualities) {
        int[] prefixSum = new int[n];
        prefixSum[0] = qualities[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + qualities[i];
        }
        int a = 0;
        int b = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (sum < calculateSum(qualities, i, j, prefixSum)) {
                    sum = calculateSum(qualities, i, j, prefixSum);
                }
                if (max < sum) {
                    a = i;
                    b = j;
                }
            }
            if (max < sum) {
                max = sum;
            }
        }
        System.out.println("a: " + a + ", b: " + b);
        return max;
    }
    private static int calculateSum(int[] qualities, int i, int j, int[] prefixSum) {
        int sum = 0;
        for (int k = i; k < j; k++) {
            sum += qualities[k] * (prefixSum[j] - prefixSum[k]);
        }
        return sum;
    }
}
/*
7
-7 8 -1 5 4 -6 4
result: 75

4
5 4 -6 4
result: 20

7
-1 2 8 -3 9 -2 5
KQ: 87

8
-3 -5 4 2 -7 -9 -1 9
result: 88
0 -> 7

10
-3 -5 4 2 -7 -9 -1 9 10 2
result: 128
7 -> 9

9
-3 -5 4 2 -7 -9 -1 9 10
result: 90

 */