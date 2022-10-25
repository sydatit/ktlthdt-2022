package dothi;

import java.util.ArrayList;
import java.util.Scanner;

public class DSA09018_LietKeDinhTru {
    private static ArrayList<Integer> dske[];
    private static ArrayList<Integer> result;
    private static boolean[] chuaxet;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            int amountP = scanner.nextInt();
            int amountE = scanner.nextInt();
            dske = new ArrayList[amountP + 1];
            chuaxet = new boolean[amountP + 1];
            result = new ArrayList<>();
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
            int count = 0;
            for (int i = 1; i <= amountP; i++) {
                if( chuaxet[i]){
                    count++;
                    algorithmDFS(i);
                }
            }
            resetChuaxet();
            for (int i = 1; i <= amountP ; i++) {
                chuaxet[i] = false;
                int countAfter = 0;
                for (int j = 1; j <= amountP ; j++) {
                    if( chuaxet[j]){
                        countAfter++;
                        algorithmDFS(j);
                    }
                }
                resetChuaxet();
                if( countAfter > count) result.add(i);
            }
            result.forEach(item -> System.out.print(item + " "));
            System.out.println();
        }
    }

    private static void resetChuaxet() {
        for (int i = 0; i < chuaxet.length; i++) {
            chuaxet[i] = true;
        }
    }

    private static void algorithmDFS(int startP) {
        chuaxet[startP] = false;
        for (Integer item : dske[startP]) {
            if( chuaxet[item]){
                algorithmDFS(item);
            }
        }
    }
}
