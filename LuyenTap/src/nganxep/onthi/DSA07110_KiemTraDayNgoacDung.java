package nganxep.onthi;

import java.util.Scanner;
import java.util.Stack;

public class DSA07110_KiemTraDayNgoacDung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = Integer.parseInt(scanner.nextLine());
        while (repeat --> 0){
            String input = scanner.nextLine();
            System.out.println(checkRight(input));
        }
    }

    private static String checkRight(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char charI = input.charAt(i);
            if( charI == '(' || charI == '[' || charI == '{' || stack.isEmpty()){
                stack.push(charI);
            }else {
                switch (stack.peek()){
                    case '(':
                        if( charI == ')') stack.pop();
                        break;
                    case '[':
                        if( charI == ']') stack.pop();
                        break;
                    case '{':
                        if( charI == '}') stack.pop();
                        break;
                    default:
                        stack.push(charI);
                }
            }
        }
        if( !stack.isEmpty())
            return  "NO";
        return "YES";
    }
}
