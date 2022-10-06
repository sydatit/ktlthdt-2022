package nganxep;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class T212_KiemTraBieuThucSoHoc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();
        sc.nextLine();
        while (repeat --> 0){
            String expression = sc.nextLine();
            System.out.println(testValid(expression) ? "NO": "YES");
        }
    }

    private static boolean testValid(String expression) {
        Stack<Character> stack = new Stack<>();
        HashSet<Character> operator = new HashSet<>();
        operator.add('+');
        operator.add('-');
        operator.add('*');
        operator.add('/');
        for (int i = 0; i < expression.length(); i++) {
            char charCurrent = expression.charAt(i);
            if( stack.isEmpty()){
                stack.push(charCurrent);
            }else {
                char headStack = stack.peek();
                if( charCurrent == '('){
                    stack.push(charCurrent);
                } else if (operator.contains(charCurrent)) {
                    if( !operator.contains(headStack)){
                        stack.push(charCurrent);
                    }
                } else if ( charCurrent == ')') {
                    if( operator.contains(headStack)){
                        while (stack.peek() != '(') stack.pop();
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
