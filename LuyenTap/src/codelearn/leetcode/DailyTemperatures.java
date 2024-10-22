package codelearn.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[]{30,40,50,60})));
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] temp = new int[temperatures.length];
        for (int i = temp.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i])
                stack.pop();
            if (stack.isEmpty()) {
                temp[i] = 0;
            } else {
                temp[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return temp;
    }
}
