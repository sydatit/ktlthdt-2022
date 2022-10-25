package dothi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSA09010_KiemTraTinhLienThongManh {
    private static ArrayList<Integer> besideList[] = new ArrayList[1001];
    private static boolean[] mark = new boolean[1001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while ( test --> 0){
            int amountPoint = scanner.nextInt();
            int amountEdge = scanner.nextInt();
            boolean isStrong = true;
            for (int i = 0; i <= 1000; i++) {
                besideList[i] = new ArrayList<>();
                mark[i] = true;
            }
            for (int i = 0; i < amountEdge; i++) {
                int headP = scanner.nextInt();
                int lastP = scanner.nextInt();
                besideList[headP].add(lastP);
            }

            for (int j = 1; j <= amountPoint; j++) {
                algorithimBFS(j);
                if( !testMark(amountPoint) ){
                    isStrong = false;
                    break;
                }
                resetMark(amountPoint);
            }
            if( isStrong) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean testMark(int n) {
        for (int i = 1; i <= n; i++) {
            if( mark[i])
                return false;
        }
        return true;
    }

    private static void resetMark(int n) {
        for (int i = 0; i <= n; i++) {
            mark[i] = true;
        }
    }
    private static void algorithimBFS(int sourcePoint) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourcePoint);
        mark[sourcePoint] = false;
        while (!queue.isEmpty()){
            Integer head = queue.poll();
            for (Integer item : besideList[head]) {
                if( mark[item]){
                    queue.add(item);
                    mark[item] = false;
                }
            }
        }
    }

}
