package contest.midyear2024;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class THE0SHOW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && (heights[stack.peek()] >= heights[i] || (left[stack.peek()] != -1
                    && stack.peek() != i - 1 && frequencies.getOrDefault(left[stack.peek()], 0) >= frequencies.getOrDefault(stack.peek(), 0)))) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            frequencies.put(left[i], frequencies.getOrDefault(left[i], 0) + 1);
            stack.push(i);
        }
        int maxFre = -1;
        for (Map.Entry<Integer, Integer> item: frequencies.entrySet()) {
            if (item.getKey() != -1) {
                maxFre = Math.max(maxFre, item.getValue());
            }
        }
        System.out.println(maxFre == -1 ? 0 : maxFre);
    }
}
/*
7
8	7	10	6	9	12	11

8
8	7	10	6	9	14	16	15

6
1 3 2 4 3 5

47
1682 63 124 147 897 1210 1585 1744 1764 1945 323 984 1886 346 481 1059 1388 1483 1516 1842 1868 1877 504 1197 785 955 970 1848 1851 398 907 995 1167 1214 1423 1452 1464 1474 1311 1427 1757 1992 57 1625 1260 700 725
725 700 1260 1625 57 1992 1757 1427 1311 1474 1464 1452 1423 1214 1167 995 907 398 1851 1848 970 955 785 1197 504 1877 1868 1842 1516 1483 1388 1059 481 346 1886 984 323 1945 1764 1744 1585 1210 897 147 124 63 1682
 */