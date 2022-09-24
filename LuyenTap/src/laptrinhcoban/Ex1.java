package laptrinhcoban;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soPhanTu = scanner.nextInt();
        // nhap phan tu
        int[] arr = new int[soPhanTu];
        for (int i = 0; i < soPhanTu; i++) {
            arr[i] = scanner.nextInt();
        }
        // xu ly
        solve(arr, soPhanTu);
    }
    private static void solve(int[] arr, int soPhanTu) {
        for (int i = 0; i < soPhanTu - 1; i++) {
            for (int j = i + 1; j < soPhanTu; j++) {
                if( arr[i] > arr[j]){
                    arr[i] = arr[i] * arr[j];
                    arr[j] = arr[i] / arr[j];
                    arr[i] = arr[i] / arr[j];
                }
            }
            System.out.print("Buoc " + (i + 1) + ":");
            Arrays.stream(arr).forEach( value -> System.out.printf(" " + value));
            System.out.println();
        }
    }

}
