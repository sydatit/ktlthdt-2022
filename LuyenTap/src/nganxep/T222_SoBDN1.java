package nganxep;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class T222_SoBDN1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = Integer.parseInt(scanner.nextLine());
        while (repeat-->0){
            String input = scanner.next();
            System.out.println(solve(input));
        }
    }

    private static int solve(String input) {
        int count = 0;
        if( input.equals("1")) return 1;
        long numberIn = Long.parseLong(input);
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        while (true){
            String head = queue.poll();
            if( Long.parseLong(head) <= numberIn){
                count++;
                queue.add(head + "0");
                queue.add(head + "1");
            }else break;
        }
        return count;
    }
}
