package nganxep;

import java.util.Scanner;
import java.util.Stack;

public class T213_SuaLaiDayNgoac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = Integer.parseInt(sc.nextLine());
        while (repeat --> 0) {
            String inputStr = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            int amountLeft = 0;
            int amountRight = 0;
            for (int i = 0; i < inputStr.length(); i++) {
                char currentI = inputStr.charAt(i);
                if( stack.isEmpty()){
                    stack.push(currentI);
                }else {
                    char head = stack.peek();
                    if( currentI == ')' && head == '(')
                        stack.pop();
                    else {
                        stack.push(currentI);
                    }
                }
            }
            for (Character item: stack ) {
                if(item == ')') amountLeft++;
                else amountRight++;
            }
            if( amountRight % 2 == 0 || amountLeft % 2 == 0){
                System.out.println((amountRight + amountLeft)/2);
            }else {
                int res = amountRight/2 + amountLeft/2 + 2;
                System.out.println(res);
            }
        }
    }
}
