package dothi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TN06003_LienThong {
    static ArrayList<Integer> dske[];
    static boolean[] chuaxet;
    static int[] previous;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountPoint = scanner.nextInt();
        int amountEdge = scanner.nextInt();
        int startPoint = scanner.nextInt();
        dske = new ArrayList[amountPoint + 1];
        chuaxet = new boolean[amountPoint + 1];
        previous = new int[amountPoint + 1];
        for (int i = 0; i <= amountPoint; i++) {
            dske[i] = new ArrayList<>();
            chuaxet[i] = true;
        }
        for (int i = 0; i < amountEdge; i++) {
            int headP = scanner.nextInt();
            int lastP = scanner.nextInt();
            dske[headP].add(lastP);
            dske[lastP].add(headP);
        }
        algorithmDFS(startPoint);
        boolean allPoint = true;
        for (int i = 1; i <= amountPoint; i++) {
            if( chuaxet[i]){
                allPoint = false;
                System.out.println(i);
            }
        }
        if( allPoint) System.out.println(0);
    }
    private static void algorithmDFS(int startPoint) {
        chuaxet[startPoint] = false;
        for (Integer nextPoint :dske[startPoint]) {
            if( chuaxet[nextPoint]){
                previous[nextPoint] = startPoint;
                chuaxet[nextPoint] = false;
                algorithmDFS(nextPoint);
            }
        }
    }
}
