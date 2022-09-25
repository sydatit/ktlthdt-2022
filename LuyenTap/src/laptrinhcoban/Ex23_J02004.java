package laptrinhcoban;

import java.util.Scanner;

public class Ex23_J02004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            int length = scanner.nextInt();
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println(testSymmetrical(length, array));
        }
    }

    private static String testSymmetrical(int length, int[] array) {
        int i = 0, j = length - 1;
        while ( i <= j){
            if( array[i++] != array[j--]){
                return "NO";
            }
        }
        return "YES";
    }
}
