package Ex2_KiemTraChiaHet;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private static final BigInteger BIG_7 = new BigInteger("7");
    private static final BigInteger BIG_13 = new BigInteger("13");
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("DATA1.in"));
        int repeat = Integer.parseInt( scanner.nextLine());
        while (repeat --> 0){
            String lineNum = scanner.nextLine();
            BigInteger bigInteger = new BigInteger(lineNum);
            if( bigInteger.mod(BIG_7).intValue() == 0 && bigInteger.mod(BIG_13).intValue() == 0){
                System.out.println("Both");
            } else if (bigInteger.mod(BIG_7).intValue() == 0) {
                System.out.println("Div 7");
            } else if (bigInteger.mod(BIG_13).intValue() == 0) {
                System.out.println("Div 13");
            }else System.out.println("None");
        }
    }
}
