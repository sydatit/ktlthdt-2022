package dothi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TN05002_BFS_DoThiVoHuong_L2 {
    static ArrayList<Integer> dske[];
    static boolean[] chuaxet;
    static int soDinh;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lap = scanner.nextInt();
        while (lap --> 0){
            int soD = scanner.nextInt();
            int soC = scanner.nextInt();
            int dinhBD = scanner.nextInt();
            soDinh = soD;
            dske = new ArrayList[soD + 1];
            chuaxet = new boolean[soD + 1];
            for (int i = 1; i <= soD; i++) {
                dske[i] = new ArrayList<>();
                chuaxet[i] = true;
            }
            for (int i = 0; i < soC; i++) {
                int dinhD = scanner.nextInt();
                int dinhC = scanner.nextInt();
                dske[dinhD].add(dinhC);
                dske[dinhC].add(dinhD);
            }
            System.out.printf("BFS(" + dinhBD+ ") = ");
            duyetBFS(dinhBD);
            System.out.println();
        }
    }

    private static void duyetBFS(int dinhBD) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(dinhBD);
        chuaxet[dinhBD] = false;
        while (!queue.isEmpty()){
            int dinhD = queue.poll();
            System.out.print(dinhD);
            for (Integer item :dske[dinhD]) {
                if( chuaxet[item]){
                    chuaxet[item] = false;
                    queue.add(item);
                }
            }
            if( !queue.isEmpty() )
                System.out.print(" -> ");
        }
    }
}
