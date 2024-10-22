package contest.endyear2023;

import java.util.Scanner;

public class NhanBanTeBaoXY {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t --> 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int currentLength = (int) Math.pow(2, n - 1);
            System.out.println(findSymbol(currentLength, n, k) ? "X" : "Y");
        }
    }

    private static boolean findSymbol(int currentLength,int n, int k) {
        if (k == 1) return true;
        if (k == 2) return false;
        if (k > currentLength/2) {
            if (n % 2 == 0)
                return !findSymbol(currentLength/2, n - 1, currentLength - k + 1);
            else
                return findSymbol(currentLength/2, n - 1, currentLength - k + 1);
        } else
            return findSymbol(currentLength/2, n - 1, k);
    }

}
/*
4
1 1
2 1
2 2
3 4
 */
