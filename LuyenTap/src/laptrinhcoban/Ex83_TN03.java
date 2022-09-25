package laptrinhcoban;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Ex83_TN03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        scanner.nextLine();
        while ( repeat --> 0){
            String inputStr = scanner.nextLine();
            System.out.println(solveTotalNum( inputStr));
        }
    }

    private static String solveTotalNum(String inputStr) {
        StringBuilder res = new StringBuilder();
        int sum = 0;
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < inputStr.length(); i++) {
            Character character = inputStr.charAt(i);
            if(  'A' <= character && character <= 'Z'){
                list.add(character);
            }else sum += character - '0';
        }
        Collections.sort(list);
        for (Character item: list   ) {
            res.append(item);
        }
        return res.append(sum).toString();
    }
}
