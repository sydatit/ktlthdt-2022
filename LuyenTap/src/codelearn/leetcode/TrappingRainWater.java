package codelearn.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = {4,2,0,3,2,5};
        System.out.println(trappingRainWater.trap(height));
    }
    public int trap(int[] height) {
        int n = height.length;
        int sum = 0;
        Deque<int[]> stack = new LinkedList<>();
        int[] prefixSum = new int[n];
        prefixSum[0] = height[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = height[i] + prefixSum[i - 1];
        }
        int currentMaxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] == 0) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek()[0] != currentMaxIndex
                    && height[stack.peek()[0]] < height[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(new int[]{i, 0});
            } else {
                int[] top = stack.peek();
                int water = 0;
                if (i - top[0] >= 2) {
                    water = computeNumberWaters(i, top[0], height[i], height[top[0]], prefixSum);
                }
                stack.push(new int[]{i, water});
            }
            if (height[i] >= height[currentMaxIndex]) {
                currentMaxIndex = i;
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pop()[1];
        }
        return sum;
    }

    private int computeNumberWaters(int current, int previous, int currentH, int previousH, int[] prefixSum) {
        int min = Math.min(currentH, previousH);
        int area = (current - previous + 1) * min;
        if (currentH > previousH) {
            int redundant = currentH - min;
            return area - (prefixSum[current] - prefixSum[previous] - redundant) - min;
        }
        return area - (prefixSum[current] - prefixSum[previous]) - min;
    }
}
