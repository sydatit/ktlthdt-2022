package laptrinhcoban;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex28_J03015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger firstNum = new BigInteger( scanner.nextLine());
        BigInteger secondNum = new BigInteger( scanner.nextLine());
        System.out.println(firstNum.subtract(secondNum));
    }
}
