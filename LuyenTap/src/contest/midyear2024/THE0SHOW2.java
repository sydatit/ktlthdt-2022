package contest.midyear2024;

import java.util.Stack;

public class THE0SHOW2 {
    public static void main(String[] args) {
        THE0SHOW2 the0SHOW2 = new THE0SHOW2();
        int[] heights = {1682,63,124,147,897,1210,1585,1744,1764,1945,323,984,1886,346,481,1059,1388,1483,1516,1842,1868,1877,504,1197,785,955,970,1848,1851,398,907,995,1167,1214,1423,1452,1464,1474,1311,1427,1757,1992,57,1625,1260,700,725};
        System.out.println(the0SHOW2.totalSteps(heights));
    }

    public int totalSteps(int[] heights) {
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();
        int[] steps = new int[n];
        int maxSteps = 0;

        for (int i = 0; i < n; i++) {
            int currentSteps = 0;
            while (!stack.isEmpty() && stack.peek()[0] <= heights[i]) {
                currentSteps = Math.max(currentSteps, stack.pop()[1]);
            }
            if (!stack.isEmpty()) {
                currentSteps++;
            }
            steps[i] = currentSteps;
            maxSteps = Math.max(maxSteps, currentSteps);
            stack.push(new int[]{heights[i], currentSteps});
        }
        return maxSteps;
    }
}
