package codelearn.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()"));
        System.out.println(validParentheses.isValid("()[]{}"));
        System.out.println(validParentheses.isValid("(]"));
        System.out.println(validParentheses.isValid("([)]"));
        System.out.println(validParentheses.isValid("{[]}"));
    }
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char charI = s.charAt(i);
            if(charI == '(' || charI == '{' || charI == '['){
                characters.push(charI);
            }else {
                if(characters.isEmpty()){
                    return false;
                }else {
                    char head = characters.pop();
                    if( !((head == '(' && charI == ')') ||
                            (head == '{' && charI == '}') ||
                            (head == '[' && charI == ']'))
                    ){
                        return false;
                    }
                }
            }
        }
        return characters.isEmpty();
    }
}
