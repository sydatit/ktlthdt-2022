package codelearn.leetcode;

import java.util.HashSet;
import java.util.Stack;

public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4,3,5,1,2};
        System.out.println((new ValidateStackSequences()).validateStackSequences(pushed, popped));
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        HashSet<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < popped.length; i++) {
            System.out.println("popped[i] = " + popped[i]);
            if( set.contains(popped[i])){
                if(stack.peek() != popped[i]) {
                    return false;
                } else {
                    stack.pop();
                }
            }else {
                for (int j = 0; j < pushed.length; j++) {
                    System.out.println("pushed[j] = " + pushed[j]);
                    if(pushed[j] == popped[i]) {
                        break;
                    } else {
                        stack.push(pushed[j]);
                    }
                    set.add(pushed[j]);
                }
            }
        }
        return true;
    }
}
