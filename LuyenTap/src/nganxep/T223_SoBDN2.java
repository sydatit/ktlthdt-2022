package nganxep;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class T223_SoBDN2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = Integer.parseInt(scanner.nextLine());
        while (repeat-->0){
            String input = scanner.next();
            System.out.println(solve(input));
        }
    }

    private static String solve(String input) {
        if( input.equals("1") || input.equals("0")) return input;
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        while (true){
            String head = queue.poll();
            BigInteger bigInteger = new BigInteger(head);
            if(bigInteger.mod( new BigInteger(input)).intValue() == 0){
                return head;
            }else {
                queue.add( head + "0");
                queue.add( head + "1");
            }
        }
    }
}
