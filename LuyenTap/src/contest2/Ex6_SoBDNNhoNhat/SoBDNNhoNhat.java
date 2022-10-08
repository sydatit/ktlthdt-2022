package contest2.Ex6_SoBDNNhoNhat;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SoBDNNhoNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = Integer.parseInt(scanner.nextLine());
        while (repeat--> 0){
            String input = scanner.nextLine();
            System.out.println(solve(input));
        }
    }

    private static String solve(String input) {
        if( input.equals("0") || input.equals("1"))
            return input;
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        BigInteger bigInput = new BigInteger(input);
        while (true){
            String head = queue.poll();
            BigInteger bigHead = new BigInteger(head);
            if( bigHead.mod(bigInput).intValue() == 0)
                return head;
            else {
                queue.add(head + "0");
                queue.add(head + "1");
            }
        }
    }
}
