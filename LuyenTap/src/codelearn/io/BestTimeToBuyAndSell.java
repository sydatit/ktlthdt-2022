package codelearn.io;

import java.util.Scanner;
import java.util.Stack;

public class BestTimeToBuyAndSell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int result = 0;
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[i] >= stack.peek()) stack.pop();
            if( !stack.isEmpty()){
                result = Math.max( result, stack.peek() - prices[i]);
            }else {
                stack.push(prices[i]);
            }

//            System.out.println(result);
        }
        return result;
    }
}
/*
6
7 1 5 3 6 4
 */