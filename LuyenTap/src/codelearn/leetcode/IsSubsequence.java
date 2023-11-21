package codelearn.leetcode;

public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence.isSubsequence(s, t));
    }
    public boolean isSubsequence(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int index = 0;
        for (int i = 0; i < lengthT && index < lengthS; i++) {
            if (sArr[index] == tArr[i]) {
                index++;
            }
        }
        return index == lengthS;
    }
}
