package laptrinhcoban;

import java.util.Arrays;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soPhanTu = scanner.nextInt();
        // input number
        int[] arr = new int[soPhanTu];
        for (int i = 0; i < soPhanTu; i++) {
            arr[i] = scanner.nextInt();
        }
        // solve problem
        solve(arr, soPhanTu);
    }
    private static void solve(int[] arr, int soPhanTu) {
        int count = 1;
        for (int i = 0; i < soPhanTu; i++) {
            boolean changed = false;
            for (int j = i + 1; j < soPhanTu - i; j++) {
                if( arr[j] < arr[j - 1]){
                    arr[j] = arr[j] * arr[j - 1];
                    arr[j-1] = arr[j] / arr[j - 1];
                    arr[j] = arr[j] / arr[j- 1];
                    changed = true;
                }
            }
            if( changed){
                System.out.print("Buoc " + count++ + ":");
                Arrays.stream(arr).forEach(value -> System.out.printf(" " + value));
                System.out.println();
                i--;
            }
        }
    }
}
