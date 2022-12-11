package dothi;

import java.util.ArrayList;
import java.util.Scanner;

public class DSA09004_DFS_DoThiVoHuong_L2 {
    private static ArrayList<Integer> dske[];
    private static boolean[] chuaxet;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lap = scanner.nextInt();
        while (lap --> 0){
            int soDinh = scanner.nextInt();
            int soCanh = scanner.nextInt();
            int batDau = scanner.nextInt();
            dske = new ArrayList[soDinh + 1];
            chuaxet = new boolean[ soDinh + 1];
            for (int i = 1; i <= soDinh; i++) {
                dske[i] = new ArrayList<>();
                chuaxet[i] = false;
            }
            for (int i = 0; i < soCanh; i++) {
                int dinhDau = scanner.nextInt();
                int dinhCuoi = scanner.nextInt();
                dske[dinhDau].add(dinhCuoi);
                dske[dinhCuoi].add(dinhDau);
            }
            duyetDFS(batDau);
            System.out.println();
        }
    }

    private static void duyetDFS(int a) {
        System.out.print(a + " ");
        chuaxet[a] = true;
        for (Integer item :dske[a]) {
            if( !chuaxet[item]){
                duyetDFS(item);
            }
        }
    }
}
