package codelearn.leetcode;

public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = "abccccdd";
        System.out.println(longestPalindrome.longestPalindrome(s));
    }
    public int longestPalindrome(String s) {
        int result = 0;
        int[] counts = new int[58];
        for (char c : s.toCharArray()) {
            counts[c - 'A']++;
        }
        boolean existsObb = false;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0)
                continue;
            if (counts[i] % 2 == 0) {
                result += counts[i];
            } else {
                existsObb = true;
                result += counts[i] - 1;
            }
        }
        if (existsObb)
            result += 1;
        return result;
    }
}
