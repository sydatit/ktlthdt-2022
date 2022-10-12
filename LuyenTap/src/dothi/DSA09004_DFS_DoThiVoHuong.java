package dothi;

import java.util.ArrayList;
import java.util.Scanner;

public class DSA09004_DFS_DoThiVoHuong {
    private static ArrayList<Integer> dske[];
    private static boolean[] chuaXet;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lap = scanner.nextInt();
        while (lap --> 0){
            int soDinh = scanner.nextInt(), soCanh = scanner.nextInt(), batDau = scanner.nextInt();
            dske = new ArrayList[soDinh+1];
            chuaXet = new boolean[soDinh + 1];
            for (int i = 1; i <= soDinh; i++) {
                dske[i] = new ArrayList<>();
                chuaXet[i] = true;
            }
            for (int i = 0; i < soCanh; i++) {
                int dinhDau = scanner.nextInt(), dinhCuoi = scanner.nextInt();
                dske[dinhDau].add(dinhCuoi);
                dske[dinhCuoi].add(dinhDau);
            }
            duyetDFS(batDau);
            System.out.println();
        }
    }

    private static void duyetDFS(int dinhDuyet) {
        System.out.print( dinhDuyet + " ");
        chuaXet[dinhDuyet] = false;
        for (Integer v :dske[dinhDuyet]) {
            if( chuaXet[v])
                duyetDFS(v);
        }
    }
}
