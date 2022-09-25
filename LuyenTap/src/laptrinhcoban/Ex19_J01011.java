package laptrinhcoban;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex19_J01011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lap = scanner.nextInt();
        while ( lap --> 0){
            BigInteger a = new BigInteger(scanner.nextInt() + "");
            BigInteger b = new BigInteger(scanner.nextInt() + "");
            BigInteger gcd = a.gcd(b);
            BigInteger lcm = ( a.multiply(b)).divide(gcd);
            System.out.println( lcm + " " + gcd);
        }
    }
}
