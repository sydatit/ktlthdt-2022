package laptrinhcoban;

import java.math.BigInteger;
import java.util.Scanner;

public class TN27_NhamChuSo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineNumber = scanner.nextLine();
        String firstNum = lineNumber.split(" ")[0];
        String secondNum = lineNumber.split(" ")[1];
        System.out.println(minMax( firstNum, secondNum));
    }

    private static String minMax(String firstNum, String secondNum) {
        StringBuilder sb = new StringBuilder();
        BigInteger firstBigI = new BigInteger(firstNum.replace("6", "5"));
        BigInteger secondBigI = new BigInteger(secondNum.replace("6", "5"));
        sb.append(firstBigI.add(secondBigI)).append(" ");

        BigInteger firstBigIMax = new BigInteger(firstNum.replace("5", "6"));
        BigInteger secondBigIMax = new BigInteger(secondNum.replace("5", "6"));
        sb.append(firstBigIMax.add(secondBigIMax));
        return sb.toString();
    }
}
