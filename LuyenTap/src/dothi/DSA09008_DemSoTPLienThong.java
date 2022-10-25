package dothi;

import java.util.*;

public class DSA09008_DemSoTPLienThong {
    private static ArrayList<Integer> besideList[] = new ArrayList[1001];
    private static boolean[] mark = new boolean[1001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while ( test --> 0){
            int amountPoint = scanner.nextInt();
            int amountEdge = scanner.nextInt();
            for (int i = 0; i <= 1000; i++) {
                besideList[i] = new ArrayList<>();
                mark[i] = true;
            }
            for (int i = 0; i < amountEdge; i++) {
                int headP = scanner.nextInt();
                int lastP = scanner.nextInt();
                besideList[headP].add(lastP);
                besideList[lastP].add(headP);
            }
            int count = 0;
            for (int i = 1; i <= amountPoint; i++) {
                if( mark[i]){
                    count++;
                    algorithmDFS(i);
                }
            }
            System.out.println(count);
        }
    }
    private static void algorithmDFS(int sourceP) {
        mark[sourceP] = false;
        for (Integer item :besideList[sourceP]) {
            if( mark[item]){
                algorithmDFS(item);
            }
        }
    }
}
/*
1
5 6
1 2 1 3 2 3 3 4 3 5 4 5
 */