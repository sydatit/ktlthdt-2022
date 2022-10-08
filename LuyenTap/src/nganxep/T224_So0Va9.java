package nganxep;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class T224_So0Va9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat-->0){
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private static String solve(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("9");
        while (true){
            String head = queue.poll();
            BigInteger big = new BigInteger(head);
            if( big.mod(new BigInteger(n+"")).intValue() == 0)
                return head;
            else {
                queue.add(head + "0");
                queue.add(head + "9");
            }
        }
    }
}
