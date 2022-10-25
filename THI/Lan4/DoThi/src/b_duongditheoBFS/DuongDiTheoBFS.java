package b_duongditheoBFS;

import java.util.*;

public class DuongDiTheoBFS {
    static ArrayList<Integer> dske[];
    static boolean[] chuaxet;
    static int[] previous;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            int amountP = scanner.nextInt();
            int amountE = scanner.nextInt();
            int startP = scanner.nextInt();
            dske = new ArrayList[amountP + 1];
            chuaxet = new boolean[amountP + 1];
            previous = new int[amountP + 1];
            for (int i = 1; i <= amountP; i++) {
                dske[i] = new ArrayList<>();
                chuaxet[i] = true;
            }
            for (int i = 0; i < amountE; i++) {
                int headP = scanner.nextInt();
                int lastP = scanner.nextInt();
                dske[headP].add(lastP);
                dske[lastP].add(headP);
            }
            algorithmBFS(startP);
            for (int i = 1; i <= amountP; i++) {
                if( i != startP){
                    if (previous[i] != 0) {
                        ArrayList<Integer> result = new ArrayList<>();
                        result.add(i);
                        int previousP = i;
                        while ( previousP != startP){
                            previousP = previous[previousP];
                            result.add(previousP);
                        }
                        Collections.reverse(result);
                        result.forEach(integer -> System.out.print(integer + " "));

                        System.out.println();
                    } else {
                        System.out.println("No path");
                    }
                }
            }
        }
    }

    private static void algorithmBFS(int startP) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startP);
        chuaxet[startP] = false;
        while ( !queue.isEmpty()){
            Integer headP = queue.poll();
            for (Integer item : dske[headP]) {
                if( chuaxet[item]){
                    queue.add(item);
                    chuaxet[item] = false;
                    previous[item] = headP;
                }
            }
        }
    }
}
