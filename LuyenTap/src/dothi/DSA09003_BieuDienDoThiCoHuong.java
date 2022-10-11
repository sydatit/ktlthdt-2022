package dothi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DSA09003_BieuDienDoThiCoHuong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lap = scanner.nextInt();
        while (lap --> 0){
            int dinh = scanner.nextInt(), canh = scanner.nextInt();
            ArrayList<Integer> dske[] = new ArrayList[dinh+1];
            for (int i = 1; i <= dinh; i++) {
                dske[i] = new ArrayList<>();
            }
            for (int i = 0; i < canh; i++) {
                int dinhDau = scanner.nextInt();
                int dinhCuoi = scanner.nextInt();
                dske[dinhDau].add(dinhCuoi);
            }
            for (int i = 1; i < dske.length; i++) {
                System.out.printf( i + ": ");
                ArrayList<Integer> dskeI = dske[i];
                dskeI.stream()
                        .forEach( integer -> System.out.printf(integer + " "));
                System.out.println();
            }
        }
    }
}
