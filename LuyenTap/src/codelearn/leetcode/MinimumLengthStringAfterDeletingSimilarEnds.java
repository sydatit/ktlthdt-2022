package codelearn.leetcode;

public class MinimumLengthStringAfterDeletingSimilarEnds {
    public static void main(String[] args) {
        MinimumLengthStringAfterDeletingSimilarEnds minimumLengthStringAfterDeletingSimilarEnds = new MinimumLengthStringAfterDeletingSimilarEnds();
        String s = "bbbbbbbbbbbbbbbbbbb";
        System.out.println(minimumLengthStringAfterDeletingSimilarEnds.minimumLength(s));
    }
    public int minimumLength(String s) {
        char[] chars = s.toCharArray();
        int l = -1;
        int r = chars.length;
        while(true) {
            boolean isContinue = false;
            if (l + 1 == r - 1)
                break;
            char firstChar = chars[l + 1];
            char lastChar = chars[r - 1];
            while(l < r - 1 && chars[l + 1] == lastChar ) l++;
            while(r > l + 1 && chars[r - 1] == firstChar) {
                isContinue = true;
                r--;
            }
            if (!isContinue) {
                break;
            }
        }
        return r == l ? 0 : r - l - 1;
    }
}
