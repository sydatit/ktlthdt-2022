package dothi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TN05001_DFSTrenDoThiVoHuong {
    private static ArrayList<Integer> dske[];
    private static boolean chuaxet[];
    private static int soDinh;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int repeat = in.nextInt();
        while (repeat-- > 0) {
            soDinh = in.nextInt();
            int soCanh = in.nextInt();
            int batDau = in.nextInt();
            dske = new ArrayList[ soDinh + 1];
            chuaxet = new boolean[soDinh + 1];
            for (int i = 0; i < soDinh + 1; i++) {
                dske[i] = new ArrayList<>();
                chuaxet[i] = true;
            }
            for (int i = 1; i <= soCanh; i++) {
                int u = in.nextInt(), v = in.nextInt();
                dske[u].add(v);
                dske[v].add(u);
            }
            System.out.printf("DFS(" + batDau + ") = ");
            duyetDFS(batDau);
            System.out.println();
        }
    }

    private static void duyetDFS(int dinhDuyet) {
        System.out.print(dinhDuyet);
        chuaxet[dinhDuyet] = false;
        for (Integer item :dske[dinhDuyet]) {
            if( chuaxet[item]){
                System.out.print(" -> ");
                duyetDFS(item);
            }
        }
    }

    private static boolean ketThuc() {
        for (int i = 1; i < chuaxet.length; i++) {
            if( chuaxet[i]){
                return true;
            }
        }
        return false;
    }
}
