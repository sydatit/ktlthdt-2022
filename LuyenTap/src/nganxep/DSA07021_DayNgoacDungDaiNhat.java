package nganxep;

import java.util.Scanner;
import java.util.Stack;

public class DSA07021_DayNgoacDungDaiNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat =scanner.nextInt();
        scanner.nextLine();
        while (repeat --> 0){
            String input = scanner.nextLine();
            Stack<Integer> stack = new Stack<>();
            int result = 0;
            stack.push(-1);
            for (int i = 0; i < input.length(); i++) {
                if( input.charAt(i) == '('){
                    stack.push(i);
                }else {
                    stack.pop();
                    if( stack.isEmpty()){
                        stack.push(i);
                    }else {
                        result = Math.max( result, i - stack.peek());
                    }
                }
            }
            System.out.println(result);
        }
    }
}
