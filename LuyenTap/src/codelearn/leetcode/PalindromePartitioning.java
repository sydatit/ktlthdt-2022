package codelearn.io;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioning partitioning = new PalindromePartitioning();
        System.out.println(partitioning.partition("aab").get(0));
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> oneR = new ArrayList<>();
        findAllPalindrome(0, result, oneR, s);
        return result;
    }

    private void findAllPalindrome(int i, List<List<String>> result, List<String> oneR, String s) {

        if( i == s.length()){
            result.add(new ArrayList<>(oneR));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if( isPalindrome(s, i, j)){
                oneR.add(s.substring(i, j+ 1));
                findAllPalindrome(j + 1, result, oneR, s);
                oneR.remove(oneR.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while ( i < j){
            if( s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

}
