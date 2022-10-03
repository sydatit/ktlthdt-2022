package nganxep;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class S213_SoLocPhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();
        while (repeat --> 0){
            int lengthMax = sc.nextInt();
            Queue<String> strings = new LinkedList<>();
            strings.add("6");
            strings.add("8");
            solve(strings, lengthMax);
        }
    }

    private static void solve(Queue<String> strings, int lengthMax) {
        Stack<String> stack = new Stack<>();
        while (!strings.isEmpty() && strings.peek().length() != lengthMax){
            String headElement = strings.poll();
            stack.push(headElement);
            strings.add(headElement + "6");
            strings.add(headElement + "8");
        }
        while (!strings.isEmpty()){
            stack.add(strings.poll());
        }
        // show result
        int size = stack.size();
        System.out.println(size);
        while (!stack.isEmpty()){
            System.out.printf(stack.pop() + " ");
        }
        System.out.println();
    }
}
