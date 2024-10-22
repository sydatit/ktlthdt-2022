package codelearn.leetcode;

public class MinimumTimeMakeRopeColorful {
    public static void main(String[] args) {
        System.out.println(minCost("aabaa", new int[] {1,2,3,4,1}));
    }
    public static int minCost(String colors, int[] neededTime) {
        int max = neededTime[0];
        char[] colorsCharArray = colors.toCharArray();
        int sum = neededTime[0];
        int result = 0;
        for (int i = 1; i < neededTime.length; i++) {
            if (colorsCharArray[i - 1] == colorsCharArray[i]) {
                sum += neededTime[i];
                max = Math.max(max, neededTime[i]);
            } else {
                result += sum - max;
                max = neededTime[i];
                sum = neededTime[i];
            }
        }
        result += sum - max;
        return result;
    }
}
