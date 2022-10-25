package a_duyetdothi;

import java.util.ArrayList;
import java.util.Scanner;

public class DuyetDoThi {
    private static ArrayList<Integer> dske[];
    private static boolean[] chuaxet;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            int amountP = scanner.nextInt();
            int amountE = scanner.nextInt();
            int startP = scanner.nextInt();
            dske = new ArrayList[amountP + 1];
            chuaxet = new boolean[amountP + 1];
            for (int i = 1; i <= amountP; i++) {
                dske[i] = new ArrayList<>();
                chuaxet[i] = true;
            }
            for (int i = 0; i < amountE; i++) {
                int headP = scanner.nextInt();
                int lastP = scanner.nextInt();
                dske[headP].add(lastP);
                dske[lastP].add(headP);
            }
            System.out.print("DFS(" + startP + ") = ");
            algorithmDFS(startP);
            System.out.println();
        }
    }

    private static void algorithmDFS(int startP) {
        System.out.print(startP + " ");
        chuaxet[startP] = false;
        for (Integer item : dske[startP]) {
            if( chuaxet[item]){
                chuaxet[item] = false;
                algorithmDFS(item);
            }
        }
    }
}
