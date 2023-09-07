package codelearn.leetcode.Checkpoint;

import java.util.Scanner;
import java.util.Stack;

public class INVESTOR_NCC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] shares = new int[n];
        for (int i = 0; i < n; i++) {
            shares[i] = scanner.nextInt();
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && shares[i] > stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                max = Math.max(max, stack.peek() - shares[i]);
            } else stack.push(shares[i]);

        }
        System.out.println(max);
    }
}
