package laptrinhcoban;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3 {
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
        for (int i = 0; i < soPhanTu; i++) {
            int minIndex = i + 1;
            int j = i;
            while ( j > 0){
                if( arr[minIndex] < arr[j])
                j--;
            }
            //swap 2 number
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            System.out.print("Buoc " + i + ":");
            Arrays.stream(arr).forEach(value -> System.out.printf(" " + value));
            System.out.println();
        }
    }
}
