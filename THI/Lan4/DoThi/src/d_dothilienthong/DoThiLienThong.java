package d_dothilienthong;

import java.util.ArrayList;
import java.util.Scanner;

public class DoThiLienThong {
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
            for (int i = 1; i <= amountP ; i++) {
                int startP = i != amountP ? i + 1 : 1;
                chuaxet[i] = false;
                algorithmDFS(startP);
                boolean ok = true;
                for (int j = 1; j <= amountP; j++) {
                    if( chuaxet[j]){
                        ok = false;
                        break;
                    }
                }
                resetChuaxet();
                if( !ok) result.add(i);
            }
            System.out.println(result.size());
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
