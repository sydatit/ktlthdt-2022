package dothi;

import java.util.*;

public class TN05005_XoaDanCayKhung {
    static ArrayList<Integer> dske[];
    static boolean[] chuaxet;
    static boolean[] isDeleted;
    static int result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            int amountPoint = scanner.nextInt();
            int M = scanner.nextInt();
            dske = new ArrayList[ amountPoint + 1];
            chuaxet = new boolean[ amountPoint + 1];
            isDeleted = new boolean[ amountPoint + 1];
            result = amountPoint;
            for (int i = 1; i <= amountPoint ; i++) {
                dske[i] = new ArrayList<>();
                chuaxet[i] = true;
                isDeleted[i] = false;
            }
            for (int i = 0; i < amountPoint - 1; i++) {
                int headP = scanner.nextInt();
                int lastP = scanner.nextInt();
                dske[headP].add(lastP);
                dske[lastP].add(headP);
            }
            algorithmBFS(amountPoint, M);
            System.out.println(result);
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
        while (!queue.isEmpty() && m --> 0){
            int leaf = queue.size();
            for (int i = 0; i < leaf; i++) {
                int head = queue.poll();
                isDeleted[head] = true;
                result--;
                for (Integer item :dske[head]) {
                    if(chuaxet[item]){
                        chuaxet[item] = false;
                        queue.add(item);
                    }
                }

            }
        }
    }

}
