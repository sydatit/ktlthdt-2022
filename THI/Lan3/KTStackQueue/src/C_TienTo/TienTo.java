package C_TienTo;

import java.util.Scanner;
import java.util.Stack;

public class TienTo {
    public static void main(String[] args) {

    }

    private static long solve(String[] array, int size) {

        Stack<Long> stack = new Stack<>();
        for (int i =size -1; i >= 0; i--) {
            if( array[i].equals("+") || array[i].equals("-") ||array[i].equals("*") ||array[i].equals("/") ){
                Long firstNum = stack.pop();
                Long secondNum = stack.pop();
                Long computeRes = compute( firstNum, secondNum, array[i]);
                stack.push(computeRes);
            }else stack.push(Long.parseLong( array[i]));
        }
        return stack.peek();
    }

    private static Long compute(Long firstNum, Long secondNum, String s) {
        char operator = s.charAt(0);
        switch (operator){
            case '+':
                return firstNum + secondNum;
            case '-':
                return firstNum - secondNum;
            case '*':
                return firstNum * secondNum;
            case '/':
                return firstNum / secondNum;
            case '^':
                return firstNum ^ secondNum;
            case '%':
                return firstNum % secondNum;
        }
        return 0L;
    }
}
