package laptrinhcoban;

import java.util.Scanner;

public class Ex22_J01018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        scanner.nextLine();
        while (repeat --> 0){
            String inputStr = scanner.nextLine();
            System.out.println(solve(inputStr));
        }
    }

    private static String solve(String inputStr) {
        int sumInt = 0;
        sumInt += inputStr.charAt(0) - '0';
        for (int i = 1; i < inputStr.length(); i++) {
            sumInt += inputStr.charAt(i) - '0';
            if( Math.abs( inputStr.charAt(i) - inputStr.charAt(i-1) ) != 2){
                return "NO";
            }
        }
        if( sumInt % 10 != 0) return "NO";
        return "YES";
    }
}
