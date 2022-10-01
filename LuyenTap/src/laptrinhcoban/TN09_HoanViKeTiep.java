package laptrinhcoban;

import java.util.Arrays;
import java.util.Scanner;

public class TN09_HoanViKeTiep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            int size = scanner.nextInt();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }
            nextHV(array, size);
        }
    }

    private static void nextHV(int[] array, int size) {
        int index = size - 2;
        boolean changed = false;
        while ( index >= 0){
            if( array[index] < array[index + 1]){
                changed = true;
                break;
            }
            index--;
        }
        if( changed){
            //swap number
            for (int i = size - 1; i > index ; i--) {
                if( array[index] < array[i]){
                    array[index] = array[index] * array[i];
                    array[i] = array[index] / array[i];
                    array[index] = array[index] / array[i];
                    break;
                }
            }
            //sort remain
            for (int i = index + 1; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (array[i] > array[ j]) {
                        array[i] = array[i] * array[ j];
                        array[ j] = array[i] / array[ j];
                        array[i] = array[i] / array[ j];
                    }
                }
            }
            Arrays.stream(array).forEach( num -> System.out.printf(num + " "));
            System.out.println();
        }else {
            for (int i = size - 1; i >= 0 ; i--) {
                System.out.printf(array[i] + " ");
            }
            System.out.println();
        }
    }
}
/*
2
12
2 7 9 1 3 4 3 9 9 7 4 2
 */
