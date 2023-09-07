package codelearn.leetcode;

public class SolvingQuestionsWithBrainpower {
    public static void main(String[] args) {
        SolvingQuestionsWithBrainpower solvingQuestionsWithBrainpower = new SolvingQuestionsWithBrainpower();
        int[][] questions = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(solvingQuestionsWithBrainpower.mostPoints(questions));
    }
    long dp[];

    public long mostPoints(int[][] questions) {
        dp = new long[questions.length];
        return dfs(questions, 0);
    }
    private long dfs(int[][] questions, int index) {
        if (index >= questions.length) {
            return 0;
        }
        if (dp[index] != 0) {
            return dp[index];
        }
        int points = questions[index][0];
        int brainpower = questions[index][1];
        return Math.max(dfs(questions, index + 1), points + dfs(questions, index + brainpower + 1));
    }
}
