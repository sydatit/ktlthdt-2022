package codelearn.leetcode;

public class BuddyStrings {
    public static void main(String[] args) {
        BuddyStrings buddyStrings = new BuddyStrings();
        String a = "ab";
        String b = "babbb";
        boolean result = buddyStrings.buddyStrings(a, b);
        System.out.println(result);
    }

    public boolean buddyStrings(String s, String goal) {
        if( s.length() != goal.length() || s.length() < 2)
            return false;
        char[] sChar = s.toCharArray();
        char[] goalChar = goal.toCharArray();
        int[] sLetter = new int[26];
        int[] goalLetter = new int[26];
        for (int i = 0; i < sChar.length; i++) {
            sLetter[sChar[i] - 'a']++;
            goalLetter[goalChar[i] - 'a']++;
        }
        boolean greaterThanTwo = false;
        for (int i = 0; i < 26; i++) {
            if( sLetter[i] != goalLetter[i])
                return false;
            if( sLetter[i] > 1)
                greaterThanTwo = true;
        }
        int diff = 0;
        for (int i = 0; i < sChar.length; i++) {
            if( sChar[i] != goalChar[i])
                diff++;
        }
        return s.equals(goal) && greaterThanTwo || diff == 2;
    }
}
