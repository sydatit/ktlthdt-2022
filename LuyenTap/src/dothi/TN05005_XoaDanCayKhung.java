package dothi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TN05005_XoaDanCayKhung {
    static ArrayList<Integer> dske[];
    static boolean[] chuaxet;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            int amountPoint = scanner.nextInt();
            int M = scanner.nextInt();
            dske = new ArrayList[ amountPoint + 1];
            chuaxet = new boolean[ amountPoint + 1];
            for (int i = 1; i <= amountPoint ; i++) {
                dske[i] = new ArrayList<>();
                chuaxet[i] = true;
            }
            for (int i = 0; i < amountPoint - 1; i++) {
                int headP = scanner.nextInt();
                int lastP = scanner.nextInt();
                dske[headP].add(lastP);
                dske[lastP].add(headP);
            }
            algorithmBFS(amountPoint, M);

        }
    }

    private static void algorithmBFS(int amountP, int m) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= amountP; i++) {
            if( dske[i].size() == 1){
                queue.add(i);
                chuaxet[i] = false;
            }
        }
        while (!queue.isEmpty()){

        }
    }

}
