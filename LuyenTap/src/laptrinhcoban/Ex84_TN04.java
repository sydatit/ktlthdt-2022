package laptrinhcoban;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex84_TN04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        scanner.nextLine();
        while ( repeat --> 0){
            String inputStr = scanner.nextLine();
            System.out.println(testBeatyNum( inputStr));
        }
    }

    private static String testBeatyNum(String inputStr) {
        int length = inputStr.length();
        int i = 0, j = length - 1;
        while ( i <= j){
            char firstChar = inputStr.charAt(i++);
            char secondChar = inputStr.charAt(j--);
            if( firstChar != secondChar || ( firstChar - '0') % 2 != 0 ||( secondChar - '0') % 2 != 0  ){
                return "NO";
            }
        }
        return "YES";
    }
}
