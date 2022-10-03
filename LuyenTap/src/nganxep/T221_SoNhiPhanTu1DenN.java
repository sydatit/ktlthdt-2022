package nganxep;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class T221_SoNhiPhanTu1DenN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();
        while (repeat --> 0){
            int amount = sc.nextInt();
            solve(amount);
        }
    }
    private static void solve(int amount) {
        Queue<String> strings = new LinkedList<>();
        strings.add("1");
        for (int i = 0; i < amount; i++) {
            String head = strings.poll();
            System.out.printf(head + " ");
            strings.add(head + "0");
            strings.add(head + "1");
        }
        System.out.println();
    }
}
