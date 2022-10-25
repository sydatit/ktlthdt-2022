package dothi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TN05004_DuongDiTheoDFS {
    static ArrayList<Integer> dske[];
    static boolean[] chuaxet;
    static int[] previous;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
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
            for (int i = 1; i <= amountPoint ; i++) {
                if( i != startPoint){
                    if( previous[i] != 0){
                        ArrayList<Integer> result = new ArrayList<>();
                        result.add(i);
                        int previousP = i;
                        while (previousP != startPoint){
                            previousP = previous[previousP];
                            result.add(previousP);
                        }
                        Collections.reverse(result);
                        result.stream()
                                .forEach(item -> System.out.print(item + " "));
                        System.out.println();
                    }else System.out.println("No path");
                }
            }
        }
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
