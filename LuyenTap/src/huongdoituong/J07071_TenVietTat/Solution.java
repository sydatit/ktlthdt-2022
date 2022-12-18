package huongdoituong.J07071_TenVietTat;

import java.util.Scanner;

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char charI = Character.toLowerCase(s.charAt(i));
            if( ('a' <= charI && charI <= 'z') || ( '0' <= charI && charI <= '9')){
                sb.append(charI);
            }
        }
        String result = sb.toString().trim();
        return checkPalindrome(result);
    }

    private boolean checkPalindrome(String result) {
        int i = 0;
        int j = result.length() - 1;
        while (i < j){
            if( result.charAt(i++) != result.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(input));
    }
}