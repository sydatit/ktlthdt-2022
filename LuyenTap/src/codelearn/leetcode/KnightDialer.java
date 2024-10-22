package codelearn.leetcode;

public class KnightDialer {
    public static void main(String[] args) {
        KnightDialer dialer = new KnightDialer();
        System.out.println(dialer.knightDialer(2));
    }
    int MOD = (int) (1e9 + 7);
    int[][] numberOfPhones;
    int[][] knightSteps = new int[][] {
            {4, 6},
            {6, 8},
            {7, 9},
            {4, 8},
            {0, 3, 9},
            {},
            {0, 1, 7},
            {2, 6},
            {1, 3},
            {2, 4},
    };

    public int knightDialer(int n) {
        numberOfPhones = new int[n][10];
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp(n - 1, i)) % MOD;
        }
        return result;
    }

    private int dp(int step, int square) {
        if (step == 0) return 1;
        if (numberOfPhones[step][square] != 0)
            return numberOfPhones[step][square];
        int countPhones = 0;
        for (int i = 0; i < knightSteps[square].length; i++) {
            countPhones = (countPhones + dp(step - 1, knightSteps[square][i])) % MOD;
        }

        numberOfPhones[step][square] = countPhones;
        return countPhones;
    }
}
