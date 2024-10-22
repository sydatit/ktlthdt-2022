package hackerrank;

public class AppendDelete {
    private static final String YES_ANSWER = "YES";
    private static final String NO_ANSWER = "NO";
    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        char[] sToChar = s.toCharArray();
        char[] tToChar = t.toCharArray();
        int i = 0, j = 0;
        while (i < sToChar.length && j < tToChar.length && sToChar[i] == tToChar[j]) {
            i++;
            j++;
        }
        int n = sToChar.length - i;
        int m = tToChar.length - j;
        int sum = n + m;
        if (k >= sum) {
            int remainder = k - sum;
            if (remainder >= i * 2 || remainder % 2 == 0) return YES_ANSWER;
            else return NO_ANSWER;
        } else return NO_ANSWER;
    }
}
