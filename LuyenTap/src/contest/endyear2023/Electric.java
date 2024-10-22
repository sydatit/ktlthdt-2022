package contest.endyear2023;

import java.util.Scanner;

public class Electric {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(findNumberOfIndexToFit(a, b));
    }

    private static int findNumberOfIndexToFit(String a, String b) {
        char[] alphabetForA = new char[26];
        char[] alphabetForB = new char[26];
        for (char c : b.toCharArray()) {
            alphabetForB[c - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            char c = a.charAt(i);
            alphabetForA[c - 'a']++;
        }
        int count = 0;
        if(isFit(alphabetForA, alphabetForB)) count++;
        int i = 1, j = b.length();
        while (j < a.length()) {
            alphabetForA[a.charAt(i - 1) - 'a']--;
            alphabetForA[a.charAt(j) - 'a']++;
            if(isFit(alphabetForA, alphabetForB)) count++;
            i++;j++;
        }
        return count;
    }

    private static boolean isFit(char[] alphabetForA, char[] alphabetForB) {
        for (int i = 0; i < alphabetForA.length; i++) {
            if (alphabetForA[i] != alphabetForB[i]) return false;
        }
        return true;
    }
}
/*
aabcaba
aab

 */