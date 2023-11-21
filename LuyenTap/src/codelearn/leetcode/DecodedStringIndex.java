package codelearn.leetcode;

import java.time.LocalDate;

public class DecodedStringIndex {
    public static void main(String[] args) {
        DecodedStringIndex i = new DecodedStringIndex();
        System.out.println(i.decodeAtIndex("leet2code3", 10));
    }
    public String decodeAtIndex(String S, int K) {
        long curLength = 0;
        char c = 0;

        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            if (Character.isDigit(c)) {
                curLength *= c - '0';
            }
            else {
                curLength++;
            }
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            c = S.charAt(i);
            if (Character.isDigit(c)) {
                curLength /= c - '0';
                K %= curLength;
            }
            else {
                if (K == 0 || K == curLength) {
                    return "" + c;
                }
                curLength--;
            }
        }

        throw null;
    }

    private void decodeString(StringBuilder sb, int repeat) {
        String temp = sb.toString();
        repeat--;
        while (repeat-->0) sb.append(temp);
    }
}
/*
k 21
pattern 10
21 % 10 1
how to get pattern?
get the
 */
