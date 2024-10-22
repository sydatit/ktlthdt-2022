package codelearn.leetcode;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        String num = "9";
        int k = 1;
        System.out.println(removeKDigits.removeKdigits(num, k));
    }
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();

        int index = 0;
        while (k != 0 && index < num.length()) {
            int digit = num.charAt(index) - '0';
            while (!stack.isEmpty() && stack.peek() > digit && k != 0) {
                stack.pop();
                k--;
            }
            stack.push(digit);
            index++;
        }
        while (k != 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : stack) {
            sb.append(i.toString());
        }
        sb.append(num.substring(index));
        index = 0;
        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }
        String result = sb.substring(index);
        return result.isEmpty() ? "0" : result;
    }
}
