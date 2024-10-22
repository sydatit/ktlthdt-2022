package codelearn.leetcode;

public class AppendCharactersStringMakeSubsequence {
    public static void main(String[] args) {
        AppendCharactersStringMakeSubsequence appendCharactersStringMakeSubsequence = new AppendCharactersStringMakeSubsequence();
        System.out.println(appendCharactersStringMakeSubsequence.appendCharacters("vrykt", "rkge"));
    }
    public int appendCharacters(String s, String t) {
        int index = 0;
        int indexOfT = 0;
        int maxLength = 0;
        int sLength = s.length();
        int tLength = t.length();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        while (index < sLength && indexOfT < tLength) {
            while (indexOfT < tLength && index < sLength && sChars[index] == tChars[indexOfT]) {
                index++;
                indexOfT++;
            }
            if (indexOfT != 0) {
                maxLength = Math.max(maxLength, indexOfT);
            }
            index++;
        }
        return tLength - maxLength;
    }
}
