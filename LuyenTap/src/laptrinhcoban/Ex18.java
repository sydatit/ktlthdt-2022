package laptrinhcoban;

import java.util.Scanner;

public class Ex18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soN = scanner.nextInt();
        System.out.println(tongGiaiThua( soN));
    }

    private static long tongGiaiThua( int soN) {
        long sum = 0;
        for (int i = 1; i <= soN; i++) {
            long mul = 1;
            for (int j =  1; j <= i; j++) {
                mul *= j;
            }
            sum += mul;
        }
        return sum;
    }


}
