package contest.endyear2023;

import java.util.Arrays;
import java.util.Scanner;

public class Flower {
    private static final int[][] FLOWER_RULES = new int[][]{
            {1, 2, 4},
            {0, 2},
            {1, 3},
            {2},
            {2, 3}
    };
    private static final int MOD = (int) (1e9 + 7);
    private static int[][] dp;
    private static int NUMBER_OF_FOLWERS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        dp = new int[NUMBER_OF_FOLWERS][n + 1];
        for (int i = 0; i < NUMBER_OF_FOLWERS; i++) {
            count = (count + findPath(i, n - 1)) % MOD;
        }
        System.out.println(count);
    }

    private static int findPath(int flower, int remained_step) {
        if (remained_step == 0) return 1;
        if (dp[flower][remained_step] != 0)
            return dp[flower][remained_step];
        int count = 0;
        for (int i = 0; i < FLOWER_RULES[flower].length; i++) {
            count = (count + findPath(FLOWER_RULES[flower][i], remained_step - 1)) % MOD;
        }
        dp[flower][remained_step] = count;

        return count;
    }


}
