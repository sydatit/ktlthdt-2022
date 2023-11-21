package codelearn.leetcode;

import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.util.Arrays;

public class UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
//        UniqueLength3PalindromicSubsequences p = new UniqueLength3PalindromicSubsequences();
//        System.out.println(p.countPalindromicSubsequence("tlpjzdmtwderpkpmgoyrcxttiheassztncqvnfjeyxxp"));
        System.out.println(DayOfWeek.SUNDAY.getValue());
    }
    public int countPalindromicSubsequence(String s) {
        int[][] chars = new int[3][26];
        int res = 0;
        for (int[] item :chars) {
            Arrays.fill(item, Integer.MIN_VALUE);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars[0][c - 'a'] == Integer.MIN_VALUE) {
                chars[0][c - 'a'] = i;
                chars[1][c - 'a'] = i;
                chars[2][c - 'a'] = 1;
            } else {
                chars[1][c - 'a'] = i;
                chars[2][c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            int firstOccur = chars[0][i];
            int secondOccur = chars[1][i];
            if (firstOccur == Integer.MIN_VALUE) continue;
            for (int j = i + 1; j < 26; j++) {
                int firstOccurOfOtherChar = chars[0][j];
                int secondOccurOfOtherChar = chars[1][j];
                if (firstOccurOfOtherChar == Integer.MIN_VALUE) continue;
                int temp = countOverlapSubsequences(firstOccur, secondOccur, firstOccurOfOtherChar, secondOccurOfOtherChar);
                res += temp;
                System.out.printf("%d - %d , %d - %d , Result: %d\n", firstOccur, secondOccur, firstOccurOfOtherChar, secondOccurOfOtherChar, temp);
            }
            res += chars[2][i] >= 3 ? 1 : 0;
        }
        return res;
    }

    private int countOverlapSubsequences(int firstOccur, int secondOccur, int firstOccurOfOtherChar, int secondOccurOfOtherChar) {
        if (secondOccur < firstOccurOfOtherChar || secondOccurOfOtherChar < firstOccur) return 0;
        if ((firstOccur < firstOccurOfOtherChar && secondOccurOfOtherChar < secondOccur) || firstOccurOfOtherChar == secondOccurOfOtherChar) {
            return 1;
        }
        if ((firstOccurOfOtherChar < firstOccur && secondOccur < secondOccurOfOtherChar) || firstOccur == secondOccur) {
            return 1;
        }
        if (firstOccur < secondOccurOfOtherChar && secondOccur > firstOccurOfOtherChar) {
            return 2;
        }
        return 0;
    }
}
/*
abacbaaab

 */