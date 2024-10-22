package contest.endyear2023;

import java.util.Scanner;
import java.util.Stack;

public class AREA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] lands = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lands[i][j] = scanner.nextInt();
            }
        }
        System.out.println(findMax(n, m, lands));

//        System.out.println(getMaxRectangle(new int[] {6, 2, 5, 4, 5, 1, 6}, 7));
    }

    private static int findMax(int n, int m, int[][] lands) {
        int result = getMaxRectangle(lands[0], m);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lands[i][j] == 1) lands[i][j] += lands[i - 1][j];
            }
            result = Math.max(result, getMaxRectangle(lands[i], m));
        }
        return result;
    }

    public static int getMaxRectangle(int[] hist, int n)
    {
        Stack<Integer> stash = new Stack<>();
        int result = 0;
        int prev;
        int i = 0;
        while (i < n) {
            if (stash.isEmpty() || hist[stash.peek()] <= hist[i])
                stash.push(i++);
            else {
                prev = stash.pop();
                int area = hist[prev] * ( stash.isEmpty() ? i : i - stash.peek() - 1);
                result = Math.max(area, result);
            }
        }
        while (!stash.isEmpty()) {
            prev = stash.pop();
            int area = hist[prev] * ( stash.isEmpty() ? i : i - stash.peek() - 1);
            result = Math.max(area, result);
        }

        return result;
    }
}
/*
4 5
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
 */