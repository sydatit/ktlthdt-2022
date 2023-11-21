package codelearn.leetcode;

public class CountNumberHomogenousSubstrings {
    public static void main(String[] args) {
        CountNumberHomogenousSubstrings count = new CountNumberHomogenousSubstrings();
        System.out.println(count.countHomogenous("zzzzz"));
        System.out.println(count.countNumberOfSameSubstrings(100000));
    }
    private final int MOD = (int) (1e9 + 7);
    public int countHomogenous(String s) {
        long count = 1;
        int result = 0;
        char currentC = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (currentC != s.charAt(i)) {
                result = (result + countNumberOfSameSubstrings(count)) % MOD;
                currentC = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        result = (result + countNumberOfSameSubstrings(count)) % MOD;
        return result;
    }

    private int countNumberOfSameSubstrings(long count) {

        return (int) ((count + 1) % MOD * count % MOD)/2;
    }
}
