package nganxep;

import java.util.Scanner;
import java.util.Stack;

public class T215_BienDoiTienToHauTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = Integer.parseInt(scanner.nextLine());
        while (repeat --> 0){
            String exp = scanner.nextLine();
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < exp.length(); i++) {
                char charI = exp.charAt(i);
                if( 'A' <= charI && charI <= 'Z' ){
                    stack.push(charI + "");
                }else {
                    String firstStr = stack.pop();
                    String secondStr = stack.pop();
                    stack.push( charI + secondStr + firstStr);
                }
            }
            System.out.println(stack.peek());
        }

    }
}
