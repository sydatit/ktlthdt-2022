package laptrinhcoban;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Ex75_TN01007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        scanner.nextLine();
        while (repeat --> 0){
            String lineNumber = scanner.nextLine();
            String[] numbers = lineNumber.split(" ");
            System.out.println(solveMod(numbers));
        }
    }

    private static String solveMod(String[] numbers) {
        BigInteger firstNum = new BigInteger(numbers[0]);
        BigInteger secondNum = new BigInteger(numbers[1]);

        if( firstNum.compareTo( secondNum) >= 0){
            if( firstNum.mod(secondNum).equals(BigInteger.ZERO)) {
                return "YES";
            }
            else return "NO";
        }else {
            if( secondNum.mod(firstNum).equals(BigInteger.ZERO)) {
                return "YES";
            }
            else {
                return "NO";
            }
        }
    }
}
