package codelearn.leetcode;

public class FindMissingObservations {
    public static void main(String[] args) {
        FindMissingObservations findMissingObservations = new FindMissingObservations();
        int[] rolls = {1,5,6};
        int mean = 3;
        int n = 4;
        int[] res = findMissingObservations.missingRolls(rolls, mean, n);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;

        int totalOfObservations = 0;
        for (int roll : rolls) {
            totalOfObservations += roll;
        }
        int sum = (n + m) * mean - totalOfObservations;
        if (sum / n <= 0 || (float) sum/ n > 6f) {
            return new int[]{};
        }
        int number = sum / n;
        int remain = sum % n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = number + (i < remain ? 1 : 0);
        }

        return res;
    }
}
