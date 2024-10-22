package contest.endyear2023;

import java.util.Scanner;

public class TroChoiMario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t --> 0) {
            int n = scanner.nextInt();
            if (n % 4 == 0) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
        }
    }
}
