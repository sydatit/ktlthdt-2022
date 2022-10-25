package dothi;

import java.util.*;

public class TN06002_DemThanhPhanLienThong {
    private static ArrayList<Integer> besideList[];
    private static boolean[] mark;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountPoint = scanner.nextInt();
        int amountEdge = scanner.nextInt();
        besideList = new ArrayList[amountPoint + 1];
        mark = new boolean[amountPoint + 1];
        for (int i = 0; i <= amountPoint; i++) {
            besideList[i] = new ArrayList<>();
            mark[i] = true;
        }
        for (int i = 0; i < amountEdge; i++) {
            int headP = scanner.nextInt();
            int lastP = scanner.nextInt();
            besideList[headP].add(lastP);
            besideList[lastP].add(headP);
        }
        for (int i = 1; i <= amountPoint; i++) {
            mark[i] = false;
            int count = 0;
            for (int j = 1; j <= amountPoint; j++) {
                if( mark[j]){
                    count++;
                    algorithimBFS(j);
                }
            }
            System.out.println(count);
            resetMark();
        }
    }

    private static void resetMark() {
        for (int i = 0; i < mark.length; i++) {
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
