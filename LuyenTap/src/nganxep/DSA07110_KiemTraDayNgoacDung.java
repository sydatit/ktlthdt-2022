package nganxep;

import java.util.Scanner;
import java.util.Stack;

public class DSA07110_KiemTraDayNgoacDung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = Integer.parseInt(sc.nextLine());
        while (repeat --> 0){
            String inputStr = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < inputStr.length(); i++) {
                char charI = inputStr.charAt(i);
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
                        default: stack.push(charI);
                    }
                }
            }
            if( !stack.isEmpty())
                System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
