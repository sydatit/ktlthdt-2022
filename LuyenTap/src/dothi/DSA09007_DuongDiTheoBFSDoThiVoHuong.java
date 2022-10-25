package dothi;

import java.util.*;

public class DSA09007_DuongDiTheoBFSDoThiVoHuong {
    private static ArrayList<Integer> besideList[];
    private static boolean[] mark;
    private static int previous[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while ( test --> 0){
            int amountPoint = scanner.nextInt();
            int amountEdge = scanner.nextInt();
            int sourceP = scanner.nextInt();
            int destinationP = scanner.nextInt();
            besideList = new ArrayList[amountPoint + 1];
            mark = new boolean[amountPoint + 1];
            previous = new int[amountPoint + 1];
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
            algorithmBFS(sourceP);
            if( previous[destinationP] != 0){
                ArrayList<Integer> result = new ArrayList<>();
                result.add(destinationP);
                int previousP = destinationP;
                while (previousP != sourceP){
                    previousP = previous[previousP];
                    result.add(previousP);
                }
                Collections.reverse(result);
                result.forEach(item -> System.out.print(item + " "));
                System.out.println();
            }else System.out.println(-1);
        }
    }

    private static void algorithmBFS(int sourceP) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceP);
        mark[sourceP] = false;
        while ( !queue.isEmpty()){
            Integer head = queue.poll();
            for (Integer item :besideList[head]) {
                if( mark[item]){
                    queue.add(item);
                    mark[item] = false;
                    previous[item] = head;
                }
            }
        }
    }
}
