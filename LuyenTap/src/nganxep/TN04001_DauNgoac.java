package nganxep;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TN04001_DauNgoac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = Integer.parseInt(scanner.nextLine());
        while (repeat-->0){
            String inputExp = scanner.nextLine();
            solve(inputExp);
        }
    }

    private static void solve(String inputExp) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < inputExp.length(); i++) {
            char charI = inputExp.charAt(i);
            if( charI == '('){
                stack.push(++count);
                queue.offer(count);
            }else if( charI == ')'){
                int topElement = stack.pop();
                queue.offer(topElement);
            }
        }
        queue.forEach( integer -> System.out.print(integer + " "));
        System.out.println();
    }
}
