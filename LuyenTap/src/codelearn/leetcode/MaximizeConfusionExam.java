package codelearn.leetcode;

public class MaximizeConfusionExam {
    public static void main(String[] args) {
        MaximizeConfusionExam test = new MaximizeConfusionExam();
        String answerKey = "TTFTTFTT";
        int k = 1;
        System.out.println(test.maxConsecutiveAnswers(answerKey, k));
    }
    public int maxConsecutiveAnswers(String s, int k) {
        int res = 0, maxf = 0, count[] = new int[128];
        for (int i = 0; i < s.length(); ++i) {
            maxf = Math.max(maxf, ++count[s.charAt(i)]);
            if (res - maxf < k)
                res++;
            else
                count[s.charAt(i - res)]--;
        }
        return res;
    }
}
