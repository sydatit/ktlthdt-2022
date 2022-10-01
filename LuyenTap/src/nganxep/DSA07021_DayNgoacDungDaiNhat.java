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
            Stack<Character> stack = new Stack<>();
            int res = 0;
            for (int i = 0; i < input.length(); i++) {
                if( !stack.isEmpty()){
                    char previous = stack.pop();
                    if( previous == '(' && input.charAt(i) == ')')
                        res += 2;
                    else {
                        stack.push(previous);
                        stack.push(input.charAt(i));
                    }
                }else stack.push(input.charAt(i));
            }
            System.out.println(res);
        }
    }
}
