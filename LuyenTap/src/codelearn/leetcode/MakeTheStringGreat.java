package codelearn.leetcode;

import java.util.Stack;

public class MakeTheStringGreat {
    public static void main(String[] args) {
        MakeTheStringGreat makeTheStringGreat = new MakeTheStringGreat();
        String s = "leEeetcode";
        System.out.println(makeTheStringGreat.makeGood(s));
    }
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int constant = 'a' - 'A';
        for (char c :s.toCharArray()) {
            if (stack.isEmpty() || Math.abs(stack.peek() - c) != constant) {
                stack.add(c);
            } else {
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
