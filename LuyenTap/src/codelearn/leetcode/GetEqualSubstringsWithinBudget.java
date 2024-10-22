package codelearn.leetcode;

public class GetEqualSubstringsWithinBudget {
    public static void main(String[] args) {
        GetEqualSubstringsWithinBudget getEqualSubstringsWithinBudget = new GetEqualSubstringsWithinBudget();
//        System.out.println(getEqualSubstringsWithinBudget.equalSubstring("abcd", "bcdf", 3));
        System.out.println(getEqualSubstringsWithinBudget.equalSubstring("abcd", "cdef", 3));
        System.out.println(getEqualSubstringsWithinBudget.equalSubstring("abcd", "acde", 0));
        System.out.println(getEqualSubstringsWithinBudget.equalSubstring("abcd", "cdef", 1));
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        for (int i = 1; i < n; i++) {
            costs[i] += costs[i - 1];
        }
        int result = 0;
        int currentTotal = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                currentTotal -= costs[i - 1];
            }
            int distance;
            int j = result + i - 1;
            if (j >= n)
                break;
            for (; j < n; j++) {
                if (maxCost < currentTotal + costs[j]) {
                    break;
                }
                currentTotal += costs[j];
            }
            distance = currentTotal > maxCost ? 0 : j - i - result;
            result = Math.max(result, distance);
        }

        return result;
    }
}
