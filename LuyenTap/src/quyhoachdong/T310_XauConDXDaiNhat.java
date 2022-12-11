package quyhoachdong;

import java.util.Scanner;

public class T310_XauConDXDaiNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t --> 0){
            String inputStr = scanner.nextLine();
            System.out.println(solve(inputStr));
        }
    }

    private static int solve(String inputStr) {
        int size = inputStr.length();
        int max = 0;
        boolean[][] F = new boolean[size+1][size + 1];
        for (int i = 0; i <= size; i++) {
            F[i][i] = true;
        }
        for (int i = 0; i < size; i++) {
            F[i+1][i] = true;
        }
        for (int k = 1; k < size; k++) {
            for (int i = 1; i < size - k; i++) {
                int j = i + k;
                F[i][j] = F[ i + 1][j - 1] && ( inputStr.charAt(i) == inputStr.charAt(j));
                if( F[i][j]){
                    max = Math.max( max, j - i + 1);
                }
            }
        }
        return max;
    }
}
