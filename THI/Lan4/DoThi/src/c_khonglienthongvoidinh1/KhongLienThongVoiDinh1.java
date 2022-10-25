package c_khonglienthongvoidinh1;

import java.util.ArrayList;
import java.util.Scanner;

public class KhongLienThongVoiDinh1 {
    private static ArrayList<Integer> dske[];
    private static boolean[] chuaxet;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountP = scanner.nextInt();
        int amountE = scanner.nextInt();
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
        algorithmDFS(1);
        boolean allPoint = true;
        for (int i = 1; i <= amountP; i++) {
            if( chuaxet[i]){
                allPoint = false;
                System.out.println(i);
            }
        }
        if( allPoint) System.out.println(0);
        System.out.println();
    }

    private static void algorithmDFS(int startP) {
        chuaxet[startP] = false;
        for (Integer item : dske[startP]) {
            if( chuaxet[item]){
                chuaxet[item] = false;
                algorithmDFS(item);
            }
        }
    }
}
