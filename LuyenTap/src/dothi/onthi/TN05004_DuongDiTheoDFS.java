package dothi.onthi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TN05004_DuongDiTheoDFS {
    private static ArrayList<Integer> dske[];
    private static boolean[] chuaxet;
    static int[] truoc;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            int soDinh = scanner.nextInt();
            int soCanh = scanner.nextInt();
            int dinhBD = scanner.nextInt();
            dske = new ArrayList[soDinh + 1];
            chuaxet = new boolean[soDinh + 1];
            truoc = new int[soDinh + 1];
            for (int i = 1; i <= soDinh; i++) {
                dske[i] = new ArrayList<>();
                chuaxet[i] = true;
            }
            for (int i = 0; i < soCanh; i++) {
                int dau = scanner.nextInt();
                int cuoi = scanner.nextInt();
                dske[dau].add(cuoi);
                dske[cuoi].add(dau);
            }
            duyetDFS(dinhBD);
            for (int i = 1; i <= soDinh; i++) {
                if( i == dinhBD) continue;
                if( truoc[i] != 0){
                    List<Integer> resultList = new ArrayList<>();
                    resultList.add(i);
                    int dinhDuyet = i;
                    while (dinhDuyet != dinhBD){
                        dinhDuyet = truoc[dinhDuyet];
                        resultList.add(dinhDuyet);
                    }
                    Collections.reverse(resultList);
                    resultList.forEach( item -> System.out.print(item + " "));
                    System.out.println();
                }else System.out.println("No path");
            }
        }
    }

    private static void duyetDFS(int dinhDuyet) {
        chuaxet[dinhDuyet] = false;
        for (Integer item :dske[dinhDuyet]) {
            if( chuaxet[item]){
                truoc[item] = dinhDuyet;
                duyetDFS(item);
            }
        }
    }
}
