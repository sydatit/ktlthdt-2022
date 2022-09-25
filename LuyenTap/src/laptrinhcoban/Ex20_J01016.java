package laptrinhcoban;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex20_J01016 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        System.out.println(solve(inputStr));
    }

    private static String solve(String inputStr) {

        int sumInt = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            if( inputStr.charAt(i) == '4' || inputStr.charAt(i) == '7'){
                sumInt ++;
            }
        }
        if( sumInt == 4 || sumInt == 7) return "YES";
        return "NO";
    }
}
