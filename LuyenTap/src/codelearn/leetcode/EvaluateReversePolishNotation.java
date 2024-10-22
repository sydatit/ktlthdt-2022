package codelearn.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
        System.out.println(test.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String arithmetic = "+-*/";
        for ( String token: tokens ) {
            if (arithmetic.contains(token)) {
                if (stack.isEmpty())
                    continue;
                int secondV = stack.pop();
                int firstV = stack.pop();
                int result = calculate(firstV, secondV, token.charAt(0));
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.peek();
    }

    private int calculate(int firstV, int secondV, char arithmetic) {
        switch (arithmetic) {
            case '+': return firstV + secondV;
            case '-': return firstV - secondV;
            case '*': return firstV * secondV;
            case '/': return firstV / secondV;
            default:
                return 0;
        }
    }
}
