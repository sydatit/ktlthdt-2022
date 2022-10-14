package dothi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSA09005_BFS_DoThiVoHuong {
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
            duyetBFS(batDau);
            System.out.println();
        }
    }

    private static void duyetBFS(int dinhBD) {
        chuaXet[dinhBD] = false;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(dinhBD);
        while (!queue.isEmpty()){
            Integer dinhDuyet = queue.poll();
            System.out.print(dinhDuyet + " ");
            for (Integer v :dske[dinhDuyet]) {
                if( chuaXet[v]){
                    queue.add(v);
                    chuaXet[v] = false;
                }
            }
        }
    }
}
