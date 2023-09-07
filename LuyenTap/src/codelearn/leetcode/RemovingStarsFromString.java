package codelearn.leetcode;

import java.util.Stack;

public class RemovingStarsFromString {
    public static void main(String[] args) {
        String s = "ab**c*d";
        RemovingStarsFromString removingStarsFromString = new RemovingStarsFromString();
        System.out.println(removingStarsFromString.removeStars(s));
    }
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
