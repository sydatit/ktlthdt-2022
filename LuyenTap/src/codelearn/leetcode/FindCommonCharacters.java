package codelearn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public static void main(String[] args) {
        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
        String[] words = {"bella", "label", "roller"};
        List<String> result = findCommonCharacters.commonChars(words);
        for (String s: result) {
            System.out.println(s);
        }
    }
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int numberOfWords = words.length;
        int[][] counts = new int[numberOfWords][26];
        for (int i = 0; i < numberOfWords; i++) {
            String word = words[i];
            for (char c: word.toCharArray()) {
                counts[i][c - 'a']++;
            }
        }
        for (int i = 0; i < counts[0].length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < numberOfWords; j++) {
                if (counts[j][i] < min) {
                    min = counts[j][i];
                }
            }
            if (min != 0) {
                appendToListResult(result, min, i);
            }
        }
        return result;
    }

    private void appendToListResult(List<String> result, int count, int offsetFromA) {
        char c = (char) (offsetFromA + 'a');
        String value = c + "";
        for (int i = 0; i < count; i++) {
            result.add(value);
        }
    }
}
