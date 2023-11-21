package codelearn.leetcode;

import java.util.*;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        RemoveDuplicateLetters l = new RemoveDuplicateLetters();
        System.out.println(l.removeDuplicateLetters("mitnlruhznjfyzmtmfnstsxwktxlboxutbic"));
    }
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] arrChars = new int[26];
        int n = s.length();

        for (int i = n - 1; i >= 0 ; i--) {
            char c = s.charAt(i);
            if (stack.isEmpty() || arrChars[c - 'a'] == 0) {
                stack.add(c);
                arrChars[c - 'a']++;
            } else if (stack.peek() > c && arrChars[c - 'a'] == 1) {
                List<Character> list = new LinkedList<>();
                while (!stack.isEmpty()) {
                    char item = stack.pop();
                    if (item != c)
                        list.add(item);
                    else
                        break;
                }
                for (int j = list.size() - 1; j >= 0 ; j--) {
                    stack.add(list.get(j));
                }
                stack.add(c);
            }
        }
        StringBuilder sbRight = new StringBuilder();
        while (!stack.isEmpty()) sbRight.append(stack.pop());
        Arrays.fill(arrChars, 0);

        // left to right
        for (int i = 0; i < n ; i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || arrChars[c - 'a'] == 0) {
                stack.add(c);
                arrChars[c - 'a']++;
            } else if (stack.peek() < c && arrChars[c - 'a'] == 1) {

                List<Character> list = new LinkedList<>();
                while (!stack.isEmpty()) {
                    char item = stack.pop();
                    if (item != c)
                        list.add(item);
                    else
                        break;
                }
                for (int j = list.size() - 1; j >= 0 ; j--) {
                    stack.add(list.get(j));
                }
                stack.add(c);
            }
        }
        StringBuilder sbLeft = new StringBuilder();
        while (!stack.isEmpty()) sbLeft.append(stack.pop());
        sbLeft.reverse();

        System.out.println("sb left: " + sbLeft);
        System.out.println("sb right: " + sbRight);
        return sbLeft.toString().compareTo(sbRight.toString()) < 0 ? sbLeft.toString() : sbRight.toString();
    }
}
/*
bcaedaeb

 */