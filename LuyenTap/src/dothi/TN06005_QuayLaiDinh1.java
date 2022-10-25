package dothi;

import java.util.*;

public class TN06005_QuayLaiDinh1 {
    static ArrayList<Integer> dske[];
    static ArrayList<Integer> dskeLV[];
    static boolean[] chuaxet;
    static Set<Integer> amountCity;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            int amountP = scanner.nextInt();
            int amountE = scanner.nextInt();
            dske = new ArrayList[amountP + 1];
            dskeLV = new ArrayList[amountP + 1];
            chuaxet = new boolean[amountP + 1];
            amountCity = new HashSet<>();
            for (int i = 1; i <= amountP; i++) {
                dske[i] = new ArrayList<>();
                dskeLV[i] = new ArrayList<>();
                chuaxet[i] = true;
            }
            for (int i = 0; i < amountE; i++) {
                int headP = scanner.nextInt();
                int lastP = scanner.nextInt();
                dske[headP].add(lastP);
                dskeLV[headP].add(lastP);
            }
            algorithmBFS(1, 2);
            dskeLV = dske;
            algorithmBFS(2, 1);
            System.out.println(amountCity.size());
        }
    }

    private static void resetCX() {
        for (int i = 0; i < chuaxet.length; i++) {
            chuaxet[i] = true;
        }
    }

    private static void algorithmBFS(int startP, int endP) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startP);
        while ( !queue.isEmpty()){
            Integer headP = queue.poll();
            amountCity.add(headP);
            if( headP == endP)
                break;
            for (int i = 0; i < dske[headP].size(); i++) {
                Integer item = dske[headP].get(i);
                if (chuaxet[item]) {
                    queue.add(item);
                    dske[headP].remove(item);
                }
            }
        }
    }
}
