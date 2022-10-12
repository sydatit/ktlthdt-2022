package B_HauTo;

import java.util.Scanner;
import java.util.Stack;

public class HauTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while ( repeat --> 0){
            int size = scanner.nextInt();
            String[] array = new String[size];
            for (int i = 0; i < size; i++) {
                array[i] = scanner.next();
            }
            System.out.println(solve( array, size));
        }
    }

    private static long solve(String[] array, int size) {

        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
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
                return secondNum + firstNum;
            case '-':
                return secondNum - firstNum;
            case '*':
                return secondNum * firstNum;
            case '/':
                return secondNum / firstNum;
            case '^':
                return secondNum ^ firstNum;
            case '%':
                return secondNum % firstNum;
        }
        return 0L;
    }
}
