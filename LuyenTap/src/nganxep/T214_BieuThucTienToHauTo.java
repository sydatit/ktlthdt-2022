package nganxep;

import java.util.Scanner;
import java.util.Stack;

public class T214_BieuThucTienToHauTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = Integer.parseInt(scanner.nextLine());
        while (repeat --> 0){
            String inputExp = scanner.nextLine();
            System.out.println(solve(inputExp));
        }
    }

    private static String solve(String inputExp) {
        Stack<String> stack = new Stack<>();
        for (int i = inputExp.length() -1; i >= 0; i--) {
            char charI = inputExp.charAt(i);
            if( charI == '+' || charI == '*' || charI == '-' || charI == '/' || charI == '%' || charI == '^' ){
                String firstStr = stack.pop();
                String secondStr = stack.pop();
                stack.push(  firstStr + secondStr + charI);
            }else stack.push(charI + "");
        }
        return stack.peek();
    }
}
