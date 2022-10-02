package laptrinhcoban;

import java.math.BigInteger;
import java.util.Scanner;

public class TN01010_TachDoiTinhTong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        solve(inputStr);
    }

    private static void solve(String inputStr) {
        while (inputStr.length() != 1){
            int length = inputStr.length();
            String firstNum = inputStr.substring(0, length/2);
            String secondNum = inputStr.substring(length/2);
//            System.out.println(firstNum + " " + secondNum);
            BigInteger firstBig = new BigInteger(firstNum);
            BigInteger secondBig = new BigInteger(secondNum);
            inputStr = firstBig.add(secondBig).toString();
            System.out.println( inputStr);
        }
    }

}
