package codelearn.leetcode;

import java.util.Arrays;

public class BagTokens {
    public static void main(String[] args) {
        BagTokens bagTokens = new BagTokens();
        int[] tokens = {100, 200, 300, 400};
        int power = 200;
        System.out.println(bagTokens.bagOfTokensScore(tokens, power));
    }

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int left = 0;
        int right = tokens.length - 1;
        while( left <= right) {
            if (power >= tokens[left]) {
                score++;
                power-= tokens[left];
                left++;
            }else if (score >= 1) {
                score--;
                power+= tokens[right];
                right--;
            }
        }
        return score;
    }
}
