package laptrinhcoban;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex27_J03011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        scanner.nextLine();
        while ( repeat --> 0){
            BigInteger firstNum = new BigInteger( scanner.nextLine());
            BigInteger secondNum = new BigInteger( scanner.nextLine());
            System.out.println(firstNum.gcd(secondNum));
        }
    }
}
