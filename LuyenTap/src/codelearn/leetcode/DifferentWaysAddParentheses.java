package codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysAddParentheses {
    public static void main(String[] args) {
        DifferentWaysAddParentheses differentWaysAddParentheses = new DifferentWaysAddParentheses();
        String expression = "2*3-4*5";
        List<Integer> res = differentWaysAddParentheses.diffWaysToCompute(expression);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char op = expression.charAt(i);
            if (op == '+' || op == '-' || op == '*') {
                List<Integer> b1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> b2 = diffWaysToCompute(expression.substring(i + 1));
                for (int a :b1) {
                    for (int b :b2) {
                        if (op == '+') {
                            res.add(a + b);
                        } else if (op == '-') {
                            res.add(a - b);
                        } else {
                            res.add(a * b);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}
