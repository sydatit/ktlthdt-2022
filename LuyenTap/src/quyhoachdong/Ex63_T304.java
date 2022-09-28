package quyhoachdong;

import java.util.Scanner;

public class Ex63_T304 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(xuLyQHD( array, N));
    }
    private static int xuLyQHD(int[] array, int n) {
        int[] bangPA = new int[n];
        int ketQua = 0;
        bangPA[0] = 1;
        for (int i = 1; i < n; i++) {
            bangPA[i] = 0;
            for (int j = 0; j < i; j++) {
                if( array[j] < array[i]){
                    bangPA[i] = Math.max( bangPA[j] + 1, bangPA[i]);
                }
            }
            ketQua = Math.max( ketQua, bangPA[i]);
        }
        return ketQua;
    }
}
