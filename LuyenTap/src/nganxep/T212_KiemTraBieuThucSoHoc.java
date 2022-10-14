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
        for (int i = 0; i < expression.length(); i++) {
            char charI = expression.charAt(i);
            if( charI == ')'){
                boolean testOk = false;
                char headStack = stack.pop();
                while ( headStack != '('){

                    if( headStack == '+' || headStack == '-'|| headStack == '*'|| headStack == '/'){
                        testOk = true;
                    }
                    headStack = stack.pop();
                }
                if( !testOk) return false;
            }else stack.push(charI);
        }
        return true;
    }
}
