package laptrinhcoban;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Ex3_DSA06025 {
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
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if( i == 0){
                linkedList.add(arr[i]);
                showList(i, linkedList);
            }else {
                int length = linkedList.size();
                int indexMin = length;
                for (int j = length - 1; j >= 0 ; j--) {
                    if( arr[i] >= linkedList.get(j) && j != i){
                        indexMin = j + 1;
                        break;
                    } else if( j == 0) indexMin = 0;
                }
                if( indexMin > linkedList.size()) linkedList.addLast(arr[i]);
                else linkedList.add(indexMin, arr[i]);
                showList( i, linkedList);
            }
        }
    }

    private static void showList(int i, LinkedList<Integer> linkedList) {
        System.out.print("Buoc " + i +":");
        linkedList.forEach( integer -> System.out.print(" " + integer));
        System.out.println();
    }
}
