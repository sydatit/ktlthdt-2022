package codelearn.leetcode;

import java.util.Arrays;

public class MinimumDeletionsMakeCharacterFrequenciesUnique {
    public static void main(String[] args) {
        MinimumDeletionsMakeCharacterFrequenciesUnique minimumDeletionsMakeCharacterFrequenciesUnique = new MinimumDeletionsMakeCharacterFrequenciesUnique();
        System.out.println(minimumDeletionsMakeCharacterFrequenciesUnique.minDeletions("abbcccdddeeeefffffggggg"));
    }
    public int minDeletions(String s) {
        int res = 0;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Arrays.sort(count);
        for (int i = count.length - 2; i >= 0; i--) {
            if (count[i] == 0)
                break;
            if (count[i] >= count[i + 1]) {
                res += count[i + 1] == 0 ?
                        count[i] : count[i] - count[i + 1] + 1;
                count[i] = count[i + 1] == 0 ?
                        0 : count[i + 1] - 1;
            }
        }
        return res;
    }
}
/*
abbcccdddeeeefffffggggg
1 2 3 3 4 5 5
1 2 3 3 4 4 5 | 1
1 2 3 3 3 4 5 | 2
1 2 3 2 3 4 5 | 3
1 2 1 2 3 4 5 | 5
1 0 1 2 3 4 5 | 7
0 0 1 2 3 4 5 | 8
 */

