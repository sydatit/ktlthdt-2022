package codelearn.leetcode;

public class FindIndexFirstOccurrenceString {
    public static void main(String[] args) {
        String haystack = "Hello";
        String needle = "ll";
        System.out.println((new FindIndexFirstOccurrenceString()).strStr(haystack, needle));
    }
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
