package laptrinhcoban;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex29_J03033 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        scanner.nextLine();
        while ( repeat --> 0){
            BigInteger firstNum = new BigInteger( scanner.nextLine());
            BigInteger secondNum = new BigInteger( scanner.nextLine());
            BigInteger gcd = firstNum.gcd(secondNum);
            BigInteger lcm = ( firstNum.multiply(secondNum)).divide(gcd);
            System.out.println(lcm);
        }
    }
}
