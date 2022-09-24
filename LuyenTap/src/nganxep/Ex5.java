package nganxep;

import java.util.Scanner;
import java.util.Stack;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lap = scanner.nextInt();
        scanner.nextLine();
        while ( lap --> 0){
            String strTest = scanner.nextLine();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < strTest.length(); i++) {
                if( strTest.charAt(i) == ' '){
                    while (!stack.empty()){
                        System.out.printf(stack.pop() + "");
                    }
                    System.out.printf(" ");
                }else {
                    stack.push(strTest.charAt(i));
                }
            }
            while (!stack.empty()){
                System.out.printf(stack.pop() + "");
            }
            System.out.println();
        }
    }
}
