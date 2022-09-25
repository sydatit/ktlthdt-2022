package laptrinhcoban;

import java.util.Scanner;

public class Ex74_TN01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        long[] fiboArr = fiboGenerate();
        while (repeat --> 0){
            int n = scanner.nextInt();
            System.out.println(fiboArr[n]);
        }
    }

    private static long[] fiboGenerate() {
        long[] res = new long[93];
        res[1] = res[2] = 1;
        for (int i = 3; i < res.length; i++) {
            res[i] = res[i - 2] + res[i - 1];
        }
        return res;
    }
}
