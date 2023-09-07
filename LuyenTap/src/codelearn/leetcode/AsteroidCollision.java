package codelearn.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        int[] asteroids = {-2,1,-1,-1};
        int[] result = asteroidCollision.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(result));
    }
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = asteroids.length - 1; i >= 0; i--) {
            if(stack.isEmpty()){
                stack.add(asteroids[i]);
            } else {
                if(asteroids[i] < 0)
                    stack.add(asteroids[i]);
                else {
                    while (!stack.isEmpty() && asteroids[i] > Math.abs(stack.peek()) && stack.peek() < 0) stack.pop();
                    if(stack.isEmpty()) {
                        stack.add(asteroids[i]);
                    } else {
                        if (asteroids[i] == Math.abs(stack.peek()) && stack.peek() < 0) {
                            stack.pop();
                        } else if (stack.peek() > 0)
                            stack.add(asteroids[i]);
                    }
                }
            }
        }
        Collections.reverse(stack);
        int[] result = new int[((List<Integer>) stack).size()];
        for (int i = 0; i < result.length; i++){
            result[i] = ((List<Integer>) stack).get(i);
        }

        return result;
    }
}
