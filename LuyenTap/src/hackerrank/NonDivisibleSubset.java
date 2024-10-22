package hackerrank;

import java.util.Arrays;
import java.util.List;

public class NonDivisibleSubset {
    public static void main(String[] args) {
        System.out.println(nonDivisibleSubset(4, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int[] reminders = new int[k+ 1];
        for (Integer item : s) {
            reminders[item % k]++;
        }
        int res = 0;
        if (k % 2 == 0)
            res += Math.min(1, reminders[k/2]);
        res += Math.min(1, reminders[0]);
        for (int i = 1; i <= k/2; i++){
            if (k % 2 == 0 && i == k /2) continue;
            res += Math.max(reminders[i], reminders[k - i]);
        }

        return res;
    }
}
